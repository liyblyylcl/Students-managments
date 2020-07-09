package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TWailaiAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添加外来人员信息", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLOname = new JLabel("姓名:"); // 使用文本创建一个标签对象
	JTextField JTOname = new JTextField(); // 创建一个文本框对象

	JLabel JLOsex = new JLabel("性别:"); // 使用文本创建一个标签对象
	ButtonGroup BG = new ButtonGroup(); // 创建一个ButtonGroup组件对象
	JRadioButton JRb1 = new JRadioButton("男");
	JRadioButton JRb2 = new JRadioButton("女");

	JLabel JLOIDtype = new JLabel("证件类型:"); // 使用文本创建一个标签对象
	JTextField JTOIDtype = new JTextField(); // 创建一个文本框对象

	JLabel JLOIDno = new JLabel("证件号:"); // 使用文本创建一个标签对象
	JTextField JTOIDno = new JTextField(); // 创建一个文本框对象

	JLabel JLOINtime = new JLabel("进入时间:"); // 使用文本创建一个标签对象
	JTextField JTOINtime = new JTextField(); // 创建一个文本框对象

	JLabel JLOOUTtime = new JLabel("出去时间:"); // 使用文本创建一个标签对象
	JTextField JTOOUTtime = new JTextField(); // 创建一个文本框对象

	JLabel JLOcause = new JLabel("进入原因:"); // 使用文本创建一个标签对象
	TextArea JTOcause = new TextArea(); // 创建一个文本框对象

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	String sql = ""; // 定义一个字符串

	public TWailaiAddtion() // 创建AddStudent构造函数
	{
		this.setTitle("管理员—外来人员信息记录"); // 设置窗口标题
		this.setLayout(null); // 设置窗口布局管理器

		JL.setBounds(100, 30, 200, 40); // 设置标签的初始位置
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		this.add(JL); // 将标签添加到容器

		JLOname.setBounds(100, 80, 100, 20); // 设置学号标签的初始位置
		this.add(JLOname); // 将学号标签添加到容器
		JTOname.setBounds(200, 80, 100, 20); // 设置文本框的初始位置
		this.add(JTOname); // 将文本框添加到容器

		JLOsex.setBounds(100, 105, 100, 20); // 设置性别标签的初始位置
		this.add(JLOsex); // 将性别标签添加到容器
		JRb1.setBounds(200, 105, 40, 20);
		JRb2.setBounds(260, 105, 40, 20);
		add(JRb1);
		add(JRb2);
		BG.add(JRb1);
		BG.add(JRb2);

		JLOIDtype.setBounds(100, 130, 60, 20); // 设置姓名标签的初始位置
		this.add(JLOIDtype); // 将姓名标签添加到容器
		JTOIDtype.setBounds(200, 130, 100, 20); // 设置文本框的初始位置
		this.add(JTOIDtype); // 将文本框添加到容器

		JLOIDno.setBounds(100, 155, 60, 20); // 设置班级标签的初始位置
		this.add(JLOIDno); // 将班级标签添加到容器
		JTOIDno.setBounds(200, 155, 100, 20); // 设置文本框的初始位置
		this.add(JTOIDno); // 将文本框添加到容器

		this.add(JLOcause);
		JLOcause.setBounds(100, 180, 80, 20);
		this.add(JTOcause);
		JTOcause.setBounds(200, 180, 100, 70);

		this.add(JLOINtime);
		JLOINtime.setBounds(100, 265, 80, 20);
		this.add(JTOINtime);
		JTOINtime.setBounds(200, 265, 100, 20);

		this.add(JLOOUTtime);
		JLOOUTtime.setBounds(100, 290, 80, 20);
		this.add(JTOOUTtime);
		JTOOUTtime.setBounds(200, 290, 100, 20);

		JBAdd.setBounds(80, 330, 70, 20); // 设置添加按钮的初始位置
		this.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(180, 330, 70, 20); // 设置重置按钮的初始位置
		this.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jb.setBounds(280, 330, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 330, 450, 450); // 设置窗口尺寸大小
		this.setResizable(false);
		this.setVisible(true); // 设置窗口的可见性
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// 处理"添加"事件
		{
			String Oname = JTOname.getText();// 将文本框中包含的文本传给字符串snumber
			String OIDtype = JTOIDtype.getText();// 将文本框中包含的文本传给字符串sname
			String OIDno = JTOIDno.getText();// 将文本框中包含的文本传给字符串sclass
			String Ocause = JTOcause.getText();
			String OINtime = JTOINtime.getText();
			String OOUTtime = JTOOUTtime.getText();

			String Osex = "女";// 返回单选按钮的值
			if (JRb1.isSelected())
				Osex = "男";

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				System.out.println("驱动加载正确！");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，SDMS为数据源名称
				System.out.println("数据库连接正确！" + cot);
				Statement stm = cot.createStatement();// 提交查询
				System.out.println("提交OK！" + stm);

				sql = "insert into OutsideMen (Oname,Osex,Ocause,OIDno,OIDtype,OINtime,OOUTtime)"
						+ "values('"
						+ Oname
						+ "',"
						+ "'"
						+ Osex
						+ "','"
						+ Ocause
						+ "','"
						+ OIDno
						+ "','"
						+ OIDtype
						+ "','"
						+ OINtime + "','" + OOUTtime + "')";// 插入一组数据

				int i = stm.executeUpdate(sql); // 对数据库进行更新
				if (i > 0)
					JOptionPane.showMessageDialog(null, "添加成功!");
				else
					JOptionPane.showMessageDialog(null, "删除失败!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TWailaiJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{

			JTOname.setText(null);// 设置文本的text值为null
			JTOIDtype.setText(null); // 设置文本的text值为null
			JTOIDno.setText(null);// 设置文本的text值为null
			JTOcause.setText(null);// 设置文本的text值为null
			JTOINtime.setText(null);
			JTOcause.setText(null);
			JTOOUTtime.setText(null);
		}
	}

	public static void main(String args[]) {
		new TWailaiAddtion();
	}
}
