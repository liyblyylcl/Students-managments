package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class Tgongwubaoxiu extends JFrame implements ActionListener {
	JLabel JL = new JLabel("公物报修查询", JLabel.CENTER);// 使用文本创建一个标签对象
	JLabel JLNumber = new JLabel("请输入日期:");// 使用文本创建一个标签对象
	JTextField JTNumber = new JTextField();// 创建一个文本框对象

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");
	JButton jb1 = new JButton("修改");

	TextArea resultarea = new TextArea();
	String sql = ""; // 定义一个字符串

	public Tgongwubaoxiu() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—公物报修查询");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(150, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLNumber.setBounds(140, 80, 120, 20);// 设置学号标签的初始位置
		this.add(JLNumber);// 将学号标签添加到容器
		JTNumber.setBounds(230, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTNumber);// 将文本框添加到容器

		JBSet.setBounds(80, 120, 60, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器
		JBNext.setBounds(170, 120, 60, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(260, 120, 60, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		jb1.setBounds(350, 120, 60, 20);// 设置返回按钮的初始位置
		this.add(jb1);// 将返回按钮添加到容器
		jb1.addActionListener(this);// 给按钮添加监听器

		this.add(resultarea);
		resultarea.setBounds(60, 170, 375, 120);
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
			String snumber = JTNumber.getText();// 将文本框中包含的文本传给字符串snumber

			sql = "select * from  RepareInformation  where Rsubmit='" + snumber
					+ "'";// 检索出Id等于snumber的学生的所有信息

			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称
				Statement stm = cot.createStatement();// 提交查询
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);

				int i = 0;
				if (!rs.next())
					JOptionPane.showMessageDialog(null, "没有查找到!");
				else {
					do {

						resultarea.setText("宿舍号：");
						resultarea.append(rs.getString("Dno") + "\n" + "物品号 ：");
						resultarea
								.append(rs.getString("Pno") + "\n" + "物品名称 ：");
						resultarea.append(rs.getString("Pname") + "\n"
								+ "提交日期 ：");
						resultarea.append(rs.getString("Rsubmit") + "\n"
								+ "报修原因  ：");
						resultarea.append(rs.getString("Reason") + "\n"
								+ "是否已修  ： ");
						resultarea.append(rs.getString("RepareState") + "\n"
								+ "解决日期 ：");
						resultarea.append(rs.getString("Rsolvedate") + "\n");
						JOptionPane.showMessageDialog(null, "查出第" + ++i
								+ "条记录!");

					} while (rs.next());
				}
			} catch (Exception ex) {
				resultarea.append(ex.getMessage() + "\n");
			}
		}
		if (e.getSource() == jb) {
			try {
				new TeacherJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == jb1) {

			new Txiugaigongwu();
			this.dispose();

		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTNumber.setText(null);// 设置文本的text值为null
			resultarea.setText(null);
		}
	}

	public static void main(String args[]) {
		new Tgongwubaoxiu();// 实例化一个对象
	}
}
