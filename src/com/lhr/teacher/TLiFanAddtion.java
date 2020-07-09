package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TLiFanAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添加学生离返校信息", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLSno = new JLabel("学号:"); // 使用文本创建一个标签对象
	JTextField JTSno = new JTextField(); // 创建一个文本框对象

	JLabel JLSname = new JLabel("姓名:"); // 使用文本创建一个标签对象
	JTextField JTSname = new JTextField(); // 创建一个文本框对象

	JLabel JLDno = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField(); // 创建一个文本框对象

	JLabel JLLeavetime = new JLabel("离校时间:"); // 使用文本创建一个标签对象
	JTextField JTLeavetime = new JTextField(); // 创建一个文本框对象

	JLabel JLBacktime = new JLabel("归校时间:"); // 使用文本创建一个标签对象
	JTextField JTBacktime = new JTextField(); // 创建一个文本框对象

	JLabel JLLBcause = new JLabel("原因:"); // 使用文本创建一个标签对象
	JTextField JTLBcause = new JTextField(); // 创建一个文本框对象

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	String sql = ""; // 定义一个字符串

	public TLiFanAddtion() // 创建AddStudent构造函数
	{
		this.setTitle("管理员—贵重物品信息记录"); // 设置窗口标题
		this.setLayout(null); // 设置窗口布局管理器

		JL.setBounds(60, 30, 300, 40); // 设置标签的初始位置
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		this.add(JL); // 将标签添加到容器

		JLSno.setBounds(100, 80, 100, 20); // 设置学号标签的初始位置
		this.add(JLSno); // 将学号标签添加到容器
		JTSno.setBounds(200, 80, 100, 20); // 设置文本框的初始位置
		this.add(JTSno); // 将文本框添加到容器

		JLSname.setBounds(100, 105, 60, 20); // 设置姓名标签的初始位置
		this.add(JLSname); // 将姓名标签添加到容器
		JTSname.setBounds(200, 105, 100, 20); // 设置文本框的初始位置
		this.add(JTSname); // 将文本框添加到容器

		JLDno.setBounds(100, 130, 60, 20); // 设置班级标签的初始位置
		this.add(JLDno); // 将班级标签添加到容器
		JTDno.setBounds(200, 130, 100, 20); // 设置文本框的初始位置
		this.add(JTDno); // 将文本框添加到容器

		this.add(JLLeavetime);
		JLLeavetime.setBounds(100, 155, 80, 20);
		this.add(JTLeavetime);
		JTLeavetime.setBounds(200, 155, 100, 20);

		this.add(JLBacktime);
		JLBacktime.setBounds(100, 180, 80, 20);
		this.add(JTBacktime);
		JTBacktime.setBounds(200, 180, 100, 20);

		this.add(JLLBcause);
		JLLBcause.setBounds(100, 205, 80, 20);
		this.add(JTLBcause);
		JTLBcause.setBounds(200, 205, 100, 20);

		JBAdd.setBounds(80, 240, 70, 20); // 设置添加按钮的初始位置
		this.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(180, 240, 70, 20); // 设置重置按钮的初始位置
		this.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jb.setBounds(280, 240, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 330, 450, 380); // 设置窗口尺寸大小
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
			String Sname = JTSname.getText();// 将文本框中包含的文本传给字符串snumber
			String Sno = JTSno.getText();// 将文本框中包含的文本传给字符串sname
			String Dno = JTDno.getText();// 将文本框中包含的文本传给字符串sclass
			String Leavetime = JTLeavetime.getText();
			String Backtime = JTBacktime.getText();
			String LBcause = JTLBcause.getText();

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				System.out.println("驱动加载正确！");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，SDMS为数据源名称
				System.out.println("数据库连接正确！" + cot);
				Statement stm = cot.createStatement();// 提交查询
				System.out.println("提交OK！" + stm);

				sql = "insert into LeaveBackSchool (Sno,Sname,Dno,Leavetime,Backtime,LBcause)"
						+ "values('"
						+ Sno
						+ "',"
						+ "'"
						+ Sname
						+ "','"
						+ Dno
						+ "','"
						+ Leavetime
						+ "','"
						+ Backtime
						+ "','"
						+ LBcause + "')";// 插入一组数据
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				System.out.println("执行语句为：" + sql);
				stm.executeUpdate(sql); // 对数据库进行更新

				JOptionPane.showMessageDialog(null, "添加成功!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TLiFanJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{

			JTSname.setText(null);// 设置文本的text值为null
			JTSno.setText(null); // 设置文本的text值为null
			JTDno.setText(null);// 设置文本的text值为null
			JTLeavetime.setText(null);// 设置文本的text值为null
			JTBacktime.setText(null);
			JTLBcause.setText(null);
		}
	}

//	public static void main(String args[]) {
//		new TLiFanAddtion();
//	}
}
