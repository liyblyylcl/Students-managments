package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class SSelectStudent extends JFrame implements ActionListener {
	JLabel JL = new JLabel("学生查询", JLabel.CENTER);// 使用文本创建一个标签对象
	JLabel JLNumber = new JLabel("请输入学号:");// 使用文本创建一个标签对象
	JTextField JTNumber = new JTextField();// 创建一个文本框对象

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");
	JButton jb1 = new JButton("修改");
	JButton jb2 = new JButton("密码修改");

	TextArea resultarea = new TextArea();
	String sql = ""; // 定义一个字符串

	public SSelectStudent() // 创建SetGrade构造函数
	{
		this.setTitle("学生—个人信息查询");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(120, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLNumber.setBounds(120, 80, 120, 20);// 设置学号标签的初始位置
		this.add(JLNumber);// 将学号标签添加到容器
		JTNumber.setBounds(200, 80, 90, 20);// 设置文本框的初始位置
		this.add(JTNumber);// 将文本框添加到容器

		JBSet.setBounds(80, 120, 70, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器
		JBNext.setBounds(190, 120, 70, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(300, 120, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		jb1.setBounds(120, 150, 90, 20);// 设置返回按钮的初始位置
		this.add(jb1);// 将返回按钮添加到容器
		jb1.addActionListener(this);// 给按钮添加监听器

		jb2.setBounds(245, 150, 90, 20);// 设置返回按钮的初始位置
		this.add(jb2);// 将返回按钮添加到容器
		jb2.addActionListener(this);// 给按钮添加监听器

		this.add(resultarea);
		resultarea.setFont(new Font("宋体", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setBounds(45, 190, 380, 150);
		resultarea.setEditable(false);
		// resultarea.setLineWrap(true);

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(10, 10, 480, 420);// 设置窗口尺寸大小
		this.setResizable(false);
		this.setLocation(500, 300);
		this.setVisible(true);// 设置窗口的可见性
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // 处理"查询"事件
		{
			String snumber = JTNumber.getText();// 将文本框中包含的文本传给字符串snumber

			sql = "select * from  student  where Sno='" + snumber + "'";// 检索出Id等于snumber的学生的所有信息

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称
				Statement stm = cot.createStatement();// 提交查询
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				if (rs.next()) // 判断结果是否存在
				{
					resultarea.setText(" 学号：");
					resultarea.append(rs.getString("Sno") + "\n" + " 姓名：");
					resultarea.append(rs.getString("Sname") + "\n" + " 性别：");
					resultarea.append(rs.getString("Ssex") + "\n" + " 生日：");
					resultarea.append(rs.getString("Sbirthday") + "\n"
							+ " QQ  ： ");
					resultarea.append(rs.getString("Sqq") + "\n" + " 手机号：");
					resultarea.append(rs.getString("Smphone") + "\n" + " 邮箱：");
					resultarea.append(rs.getString("Smailbox") + "\n"
							+ " 家庭住址：");
					resultarea.append(rs.getString("Saddress") + "\n" + " 学院：");
					resultarea.append(rs.getString("Sschool") + "\n" + " 专业：");
					resultarea.append(rs.getString("Sdept") + "\n" + " 班级：");
					resultarea.append(rs.getString("Sclass") + "\n" + " 宿舍号：");
					resultarea.append(rs.getString("Dno") + "\n" + " 入住时间：");
					resultarea.append(rs.getString("Scheckin"));

				} else {
					JOptionPane.showMessageDialog(null, "此用户不存在!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new StudentJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb1) {

			new Sxiugaistudent();
			this.dispose();

		}
		if (e.getSource() == jb2) {

			new SxiugaiPassword();
			this.dispose();

		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTNumber.setText(null);// 设置文本的text值为null
			resultarea.setText(null);
		}
	}

	public static void main(String args[]) {
		new SSelectStudent();// 实例化一个对象
	}
}
