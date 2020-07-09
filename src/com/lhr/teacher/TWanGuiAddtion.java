package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TWanGuiAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添加学生晚归信息", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLDno = new JLabel("学号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField(); // 创建一个文本框对象

	JLabel JLName = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTName = new JTextField(); // 创建一个文本框对象

	JLabel JLno = new JLabel("晚归时间:"); // 使用文本创建一个标签对象
	JTextField JTno = new JTextField(); // 创建一个文本框对象

	JLabel JLcause = new JLabel("晚归原因:"); // 使用文本创建一个标签对象
	TextArea JTcause = new TextArea(); // 创建一个文本框对象

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	String sql = ""; // 定义一个字符串

	public TWanGuiAddtion() // 创建AddStudent构造函数
	{
		this.setTitle("管理员—晚归记录"); // 设置窗口标题
		this.setLayout(null); // 设置窗口布局管理器

		JL.setBounds(100, 30, 200, 40); // 设置标签的初始位置
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体

		this.add(JL); // 将标签添加到容器
		JLDno.setBounds(100, 80, 100, 20); // 设置学号标签的初始位置
		this.add(JLDno); // 将学号标签添加到容器
		JTDno.setBounds(200, 80, 100, 20); // 设置文本框的初始位置
		this.add(JTDno); // 将文本框添加到容器
		JLName.setBounds(100, 105, 60, 20); // 设置姓名标签的初始位置
		this.add(JLName); // 将姓名标签添加到容器
		JTName.setBounds(200, 105, 100, 20); // 设置文本框的初始位置
		this.add(JTName); // 将文本框添加到容器

		JLno.setBounds(100, 130, 60, 20); // 设置班级标签的初始位置
		this.add(JLno); // 将班级标签添加到容器
		JTno.setBounds(200, 130, 100, 20); // 设置文本框的初始位置
		this.add(JTno); // 将文本框添加到容器

		this.add(JLcause);
		JLcause.setBounds(100, 160, 80, 20);
		this.add(JTcause);
		JTcause.setBounds(200, 160, 100, 75);

		JBAdd.setBounds(80, 280, 70, 20); // 设置添加按钮的初始位置
		this.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(180, 280, 70, 20); // 设置重置按钮的初始位置
		this.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jb.setBounds(280, 280, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 330, 450, 400); // 设置窗口尺寸大小
		this.setVisible(true); // 设置窗口的可见性
		this.setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// 处理"添加"事件
		{
			String Dno = JTDno.getText();// 将文本框中包含的文本传给字符串snumber
			String Name = JTName.getText();// 将文本框中包含的文本传给字符串sname
			String no = JTno.getText();// 将文本框中包含的文本传给字符串sclass
			String cause = JTcause.getText();

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				System.out.println("驱动加载正确！");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，SDMS为数据源名称
				System.out.println("数据库连接正确！" + cot);
				Statement stm = cot.createStatement();// 提交查询
				System.out.println("提交OK！" + stm);

				sql = "insert into WanGui (Sno,Dno,Btime,Breason)values('"
						+ Dno + "'," + "'" + Name + "','" + no + "','" + cause
						+ "')";// 插入一组数据
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				System.out.println("执行语句为：" + sql);
				int i = stm.executeUpdate(sql); // 对数据库进行更新
				JOptionPane.showMessageDialog(null, "添加成功!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TWanGuiJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTDno.setText(null);// 设置文本的text值为null
			JTName.setText(null); // 设置文本的text值为null
			JTno.setText(null);// 设置文本的text值为null
			JTcause.setText(null);// 设置文本的text值为null
		}
	}

	public static void main(String args[]) {
		new TWanGuiAddtion();
	}
}
