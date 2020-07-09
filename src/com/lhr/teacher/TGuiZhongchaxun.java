package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class TGuiZhongchaxun extends JFrame implements ActionListener {
	JLabel JL = new JLabel("贵重物品查询", JLabel.CENTER);// 使用文本创建一个标签对象
	JLabel JLSno = new JLabel("请输入学号:");// 使用文本创建一个标签对象
	JTextField JTSno = new JTextField();// 创建一个文本框对象

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	JTextArea resultarea = new JTextArea();
	String sql = ""; // 定义一个字符串

	public TGuiZhongchaxun() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—贵重物品信息查询");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(130, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLSno.setBounds(130, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLSno);// 将学号标签添加到容器
		JTSno.setBounds(230, 80, 80, 20);// 设置文本框的初始位置
		this.add(JTSno);// 将文本框添加到容器

		JBSet.setBounds(85, 120, 70, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器
		JBNext.setBounds(195, 120, 70, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(305, 120, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		this.add(resultarea);
		resultarea.setBounds(60, 170, 360, 150);
		resultarea.setFont(new Font("宋体", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		// resultarea.setLineWrap(true);

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(10, 10, 500, 400);// 设置窗口尺寸大小
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
			String Sno = JTSno.getText();// 将文本框中包含的文本传给字符串snumber

			sql = "select * from  ValuablesIOInformation  where Sno='" + Sno
					+ "'";// 检索出Id等于snumber的学生的所有信息

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称
				System.out.println("连接数据库成功：");
				Statement stm = cot.createStatement();// 提交查询
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				if (rs.next()) // 判断结果是否存在
				{
					resultarea.setText(" 姓  名 ：");
					resultarea.append(rs.getString("Sname") + "\n" + " 学  号 ：");
					resultarea.append(rs.getString("Sno") + "\n" + " 物品名 ：");
					resultarea.append(rs.getString("Goods") + "\n" + " 带出时间 ：");
					resultarea.append(rs.getString("Otime") + "\n" + " 带入时间 ：");
					resultarea.append(rs.getString("Intime"));

				} else {
					JOptionPane.showMessageDialog(null, "此用户不存在!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TGuiZhongJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTSno.setText(null);// 设置文本的text值为null
			resultarea.setText(null);
		}
	}

	public static void main(String args[]) {
		new TGuiZhongchaxun();// 实例化一个对象
	}
}
