package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Txiugaistudent extends JFrame implements ActionListener {
	JLabel JL = new JLabel("学生信息修改", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLNumber = new JLabel("请输入学号:");// 使用文本创建一个标签对象
	JTextField JTNumber = new JTextField();// 创建一个文本框对象

	JLabel JLDno = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField();

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton JBxiugai = new JButton("修改");
	JButton jb = new JButton("返回");

	public Txiugaistudent() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—学生信息修改");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLNumber.setBounds(100, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLNumber);// 将学号标签添加到容器
		JTNumber.setBounds(200, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTNumber);// 将文本框添加到容器

		JLDno.setBounds(100, 170, 60, 20); // 设置班级标签的初始位置
		this.add(JLDno); // 将班级标签添加到容器
		JTDno.setBounds(200, 170, 100, 20); // 设置文本框的初始位置
		this.add(JTDno); // 将文本框添加到容器

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

		this.setBounds(500, 300, 400, 300);// 设置窗口尺寸大小
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
			String snumber = JTNumber.getText();// 将文本框中包含的文本传给字符串snumber
			String sql = "select * from student where Sno='" + snumber + "'";// 检索出Id等于snumber的学生的所有信息
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

					int n = stm.executeUpdate(sql);// 对数据库进行更新
					if (n > 0)
						JOptionPane.showMessageDialog(null, "查询成功!");// 通过showMessageDialog()方法打印信息
					else
						JOptionPane.showMessageDialog(null, "查询失败!");
				} else {
					JOptionPane.showMessageDialog(null, "此用户不存在!");
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
				String snumber = JTNumber.getText();
				String Dno = JTDno.getText();

				String sql2 = " update student set Dno = '" + Dno
						+ "'  where Sno = '" + snumber + "' ";

				int n = JOptionPane.showConfirmDialog(this, "您要确认修改吗?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql2);// 对数据库进行更新

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
			JTNumber.setText(null);// 设置文本的text值为null
			JTDno.setText(null);

		}
		if (e.getSource() == jb)// 处理"返回"事件
		{

			new TSelectStudent();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Txiugaistudent();// 实例化一个对象
	}
}
