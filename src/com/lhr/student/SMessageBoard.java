package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class SMessageBoard extends JFrame implements ActionListener {

	JLabel JL = new JLabel("留言板", JLabel.CENTER);// 使用文本创建一个标签对象
	JLabel jl = new JLabel("请输入留言时间：");// 使用文本创建一个标签对象

	TextArea JTMessage = new TextArea(); // 创建一个文本框对象
	JTextField JTMtime = new JTextField(); // 创建一个文本框对象

	JButton JBAdd = new JButton("留言"); // 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	String sql = ""; // 定义一个字符串

	public SMessageBoard() // 创建AddStudent构造函数
	{
		this.setTitle("学生—留言板信息记录"); // 设置窗口标题
		this.setLayout(null); // 设置窗口布局管理器

		JL.setBounds(150, 30, 200, 40); // 设置标签的初始位置
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		this.add(JL); // 将标签添加到容器

		this.add(jl);
		jl.setBounds(120, 100, 200, 20);
		JTMtime.setBounds(240, 100, 140, 20);
		add(JTMtime);

		this.add(JTMessage);
		JTMessage.setBounds(100, 150, 300, 180);

		JBAdd.setBounds(120, 350, 70, 20); // 设置添加按钮的初始位置
		this.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(220, 350, 70, 20); // 设置重置按钮的初始位置
		this.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jb.setBounds(320, 350, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 330, 500, 450); // 设置窗口尺寸大小
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

			String Message = JTMessage.getText();
			String Mtime = JTMtime.getText();

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				System.out.println("驱动加载正确！");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，SDMS为数据源名称
				System.out.println("数据库连接正确！" + cot);
				Statement stm = cot.createStatement();// 提交查询
				// System.out.println("提交OK！" + stm);

				sql = "insert into SMessageBoard (Message,Mtime)values('"
						+ Message + "','" + Mtime + "')";// 插入一组数据
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				// System.out.println("取得结果OK！" + rs);
				JOptionPane.showMessageDialog(null, "添加成功!");
				System.out.println("执行语句为：" + sql);
				// stm.executeUpdate(sql); // 对数据库进行更新

				cot.close();
				stm.close();
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
		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTMessage.setText(null);// 设置文本的text值为null
			JTMtime.setText(null);

		}
	}

	public static void main(String args[]) {
		new SMessageBoard();
	}
}
