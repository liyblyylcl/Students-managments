package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Txiugaigongwu extends JFrame implements ActionListener {
	JLabel JL = new JLabel("公物报修情况修改", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLRsubmit = new JLabel("请输入日期:");// 使用文本创建一个标签对象
	JTextField JTRsubmit = new JTextField();// 创建一个文本框对象

	JLabel JLDno = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField();

	JLabel JLPno = new JLabel("物品号:"); // 使用文本创建一个标签对象
	JTextField JTPno = new JTextField();

	JLabel JLRsolvedate = new JLabel("解决日期:"); // 使用文本创建一个标签对象
	JTextField JTRsolvedate = new JTextField();

	JLabel JLRepareState = new JLabel("是否已修:"); // 使用文本创建一个标签对象
	JTextField JTRepareState = new JTextField();

	JLabel JLPname = new JLabel("物品名:"); // 使用文本创建一个标签对象
	JTextField JTPname = new JTextField();

	JLabel JLReason = new JLabel("原因:"); // 使用文本创建一个标签对象
	JTextArea JTReason = new JTextArea();

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton JBxiugai = new JButton("修改");
	JButton jb = new JButton("返回");

	public Txiugaigongwu() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—公物报修情况修改");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLRsubmit.setBounds(100, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLRsubmit);// 将学号标签添加到容器
		JTRsubmit.setBounds(200, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTRsubmit);// 将文本框添加到容器

		JLDno.setBounds(100, 170, 80, 20); // 设置班级标签的初始位置
		this.add(JLDno); // 将班级标签添加到容器
		JTDno.setBounds(200, 170, 100, 20); // 设置文本框的初始位置
		this.add(JTDno); // 将文本框添加到容器
		JTDno.setEditable(false);

		JLPno.setBounds(100, 195, 80, 20); // 设置班级标签的初始位置
		this.add(JLPno); // 将班级标签添加到容器
		JTPno.setBounds(200, 195, 100, 20); // 设置文本框的初始位置
		this.add(JTPno); // 将文本框添加到容器
		JTPno.setEditable(false);

		JLPname.setBounds(100, 220, 80, 20); // 设置班级标签的初始位置
		this.add(JLPname); // 将班级标签添加到容器
		JTPname.setBounds(200, 220, 100, 20); // 设置文本框的初始位置
		this.add(JTPname); // 将文本框添加到容器
		JTPname.setEditable(false);

		JLRsolvedate.setBounds(100, 245, 80, 20); // 设置班级标签的初始位置
		this.add(JLRsolvedate); // 将班级标签添加到容器
		JTRsolvedate.setBounds(200, 245, 100, 20); // 设置文本框的初始位置
		this.add(JTRsolvedate); // 将文本框添加到容器

		JLRepareState.setBounds(100, 270, 80, 20); // 设置班级标签的初始位置
		this.add(JLRepareState); // 将班级标签添加到容器
		JTRepareState.setBounds(200, 270, 100, 20); // 设置文本框的初始位置
		this.add(JTRepareState); // 将文本框添加到容器

		JLReason.setBounds(100, 300, 80, 45); // 设置班级标签的初始位置
		this.add(JLReason); // 将班级标签添加到容器
		JTReason.setBounds(200, 300, 100, 45); // 设置文本框的初始位置
		this.add(JTReason); // 将文本框添加到容器
		JTReason.setEditable(false);

		JBSet.setBounds(110, 110, 80, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器

		JBNext.setBounds(210, 110, 80, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		JBxiugai.setBounds(110, 140, 80, 20);// 设置重置按钮的初始位置
		this.add(JBxiugai);// 将重置按钮添加到容器
		JBxiugai.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(210, 140, 80, 20);// 设置重置按钮的初始位置
		this.add(jb);// 将重置按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 300, 400, 400);// 设置窗口尺寸大小
		this.setVisible(true);// 设置窗口的可见性
		this.setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // 处理"查询"事件
		{
			String sRsubmit = JTRsubmit.getText();// 将文本框中包含的文本传给字符串sRsubmit
			String sql = "select * from RepareInformation where Rsubmit = '"
					+ sRsubmit + "'";// 检索出Id等于sRsubmit的学生的所有信息
			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称

				Statement stm = cot.createStatement();// 提交查询
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				if (rs.next()) // 判断结果是否存在
				{

					JTDno.setText(rs.getString("Dno"));
					JTPno.setText(rs.getString("Pno"));
					JTRsubmit.setText(rs.getString("Rsubmit"));
					JTRsolvedate.setText(rs.getString("Rsolvedate"));
					JTRepareState.setText(rs.getString("RepareState"));
					JTPname.setText(rs.getString("Pname"));
					JTReason.setText(rs.getString("Reason"));

					int n = stm.executeUpdate(sql);// 对数据库进行更新
					if (n > 0)
						JOptionPane.showMessageDialog(this, "查询成功!");// 通过showMessageDialog()方法打印信息
					else
						JOptionPane.showMessageDialog(this, "查询失败!");
				} else {
					JOptionPane.showMessageDialog(this, "此用户不存在!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBxiugai) // 处理"修改"事件
		{

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称

				Statement stm = cot.createStatement();// 提交查询

				String sRsubmit = JTRsubmit.getText();

				String Rsolvedate = JTRsolvedate.getText();
				String RepareState = JTRepareState.getText();

				String sql4 = " update RepareInformation set Rsolvedate = '"
						+ Rsolvedate + "'  where Rsubmit = '" + sRsubmit + "' ";
				String sql5 = " update RepareInformation set RepareState = '"
						+ RepareState + "'  where Rsubmit = '" + sRsubmit
						+ "' ";

				int n = JOptionPane.showConfirmDialog(this, "您要确认修改吗?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql4);
					stm.executeUpdate(sql5);

					if (n1 > 0)
						JOptionPane.showMessageDialog(this, "修改成功!");// 通过showMessageDialog()方法打印信息
					else
						JOptionPane.showMessageDialog(this, "修改失败!");
				} else {
					if (n == JOptionPane.NO_OPTION)
						JOptionPane.showMessageDialog(this, "未执行修改!");
				}

			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTRsubmit.setText(null);// 设置文本的text值为null

		}
		if (e.getSource() == jb)// 处理"返回"事件
		{

			new Tgongwubaoxiu();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Txiugaigongwu();// 实例化一个对象
	}
}
