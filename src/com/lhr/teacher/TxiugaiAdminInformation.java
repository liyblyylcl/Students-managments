package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.SDMSlogin;

import java.sql.*;
import java.util.Vector;

class TxiugaiAdminInformation extends JFrame implements ActionListener {

	JLabel JL = new JLabel("管理员密码修改", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLUser = new JLabel("请输入用户名:");// 使用文本创建一个标签对象
	JTextField JTUser = new JTextField();// 创建一个文本框对象

	JLabel JLusername1 = new JLabel("新用户名:"); // 使用文本创建一个标签对象
	JTextField JTusername1 = new JTextField();

	JLabel JLPassword = new JLabel("原密码:"); // 使用文本创建一个标签对象
	JPasswordField JTPassword = new JPasswordField();

	JLabel JLPassword1 = new JLabel("新密码:"); // 使用文本创建一个标签对象
	JPasswordField JTPassword1 = new JPasswordField();

	JLabel JLRPassword1 = new JLabel("确认密码:"); // 使用文本创建一个标签对象
	JPasswordField JTRPassword1 = new JPasswordField();

	JButton JBSet = new JButton("修改");// 创建按钮对象
	JButton JBNext = new JButton("重置");

	JButton jb = new JButton("返回");

	public TxiugaiAdminInformation() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—管理员信息修改");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLUser.setBounds(100, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLUser);// 将学号标签添加到容器
		JTUser.setBounds(200, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTUser);// 将文本框添加到容器

		JLusername1.setBounds(100, 170, 100, 20);// 设置学号标签的初始位置
		this.add(JLusername1);// 将学号标签添加到容器
		JTusername1.setBounds(200, 170, 100, 20);// 设置文本框的初始位置
		this.add(JTusername1);// 将文本框添加到容器

		JLPassword.setBounds(100, 195, 60, 20); // 设置班级标签的初始位置
		this.add(JLPassword); // 将班级标签添加到容器
		JTPassword.setBounds(200, 195, 100, 20); // 设置文本框的初始位置
		this.add(JTPassword); // 将文本框添加到容器

		JLPassword1.setBounds(100, 220, 60, 20); // 设置班级标签的初始位置
		this.add(JLPassword1); // 将班级标签添加到容器
		JTPassword1.setBounds(200, 220, 100, 20); // 设置文本框的初始位置
		this.add(JTPassword1); // 将文本框添加到容器

		JLRPassword1.setBounds(100, 245, 60, 20); // 设置班级标签的初始位置
		this.add(JLRPassword1); // 将班级标签添加到容器
		JTRPassword1.setBounds(200, 245, 100, 20); // 设置文本框的初始位置
		this.add(JTRPassword1); // 将文本框添加到容器

		JBSet.setBounds(65, 120, 70, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器

		JBNext.setBounds(155, 120, 70, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(245, 120, 70, 20);// 设置重置按钮的初始位置
		this.add(jb);// 将重置按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 300, 400, 350);// 设置窗口尺寸大小
		this.setVisible(true);// 设置窗口的可见性
		this.setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // 处理"修改"事件
		{
			String User = JTUser.getText();// 将文本框中包含的文本传给字符串sUser
			String sql = "select * from AdminInformation where username = '"
					+ User + "' ";
			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称

				Statement stm = cot.createStatement();// 提交查询
				System.out.println("加载驱动OK！连接数据库OK！提交OK！" + cot + stm);
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				if (rs.next()) // 判断结果是否存在
				{

					// System.out.println("此用户存在！");
					String password = rs.getString("Password");
					String username1 = JTusername1.getText();
					String Password = JTPassword.getText();
					String Password1 = JTPassword1.getText();
					String RPassword1 = JTRPassword1.getText();

					String sql1 = " update AdminInformation set username = '"
							+ username1 + "'  where username = '" + User + "' ";

					String sql2 = " update AdminInformation set Password = '"
							+ Password1 + "'  where username = '" + username1
							+ "' ";

					if (password.equals(Password)
							&& (Password1.equals(RPassword1))) {

						int n = JOptionPane.showConfirmDialog(this, "您要确认修改吗?");

						if (n == JOptionPane.YES_OPTION) {

							int n1 = stm.executeUpdate(sql1);// 对数据库进行更新
							stm.executeUpdate(sql2);

							if (n1 > 0) {
								JOptionPane.showMessageDialog(this,
										"修改成功,点击返回到登陆界面!");// 通过showMessageDialog()方法打印信息
								new SDMSlogin();
							} else
								JOptionPane.showMessageDialog(this, "修改失败!");
						} else {
							if (n == JOptionPane.NO_OPTION)
								JOptionPane.showMessageDialog(this, "未执行修改!");
						}
					} else {
						if (!(password.equals(Password)))
							JOptionPane.showMessageDialog(this, "原密码输入不正确！");
						if (!((Password1.equals(RPassword1))))
							JOptionPane.showMessageDialog(this, "两次输入新密码不匹配！");
					}

				} else {
					JOptionPane.showMessageDialog(this, "此用户不存在!");
				}
			} catch (Exception ee) {
			}
		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTUser.setText(null);// 设置文本的text值为null
			JTPassword.setText(null);

		}
		if (e.getSource() == jb)// 处理"返回"事件
		{

			try {
				new TeacherJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			dispose();

		}

	}

	public static void main(String args[]) {
		new TxiugaiAdminInformation();// 实例化一个对象
	}
}
