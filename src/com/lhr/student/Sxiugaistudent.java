package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Sxiugaistudent extends JFrame implements ActionListener {
	JLabel JL = new JLabel("个人信息修改", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLNumber = new JLabel("请输入学号:");// 使用文本创建一个标签对象
	JTextField JTNumber = new JTextField();// 创建一个文本框对象

	JLabel JLName = new JLabel("姓名:");// 使用文本创建一个标签对象
	JTextField JTName = new JTextField();// 创建一个文本框对象

	JLabel JLSname = new JLabel("姓名:"); // 使用文本创建一个标签对象
	JTextField JTSname = new JTextField(); // 创建一个文本框对象

	JLabel JLSbirthday = new JLabel("生日:"); // 使用文本创建一个标签对象
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // 使用文本创建一个标签对象
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("邮箱:"); // 使用文本创建一个标签对象
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("家庭住址:"); // 使用文本创建一个标签对象
	JTextArea JTSaddress = new JTextArea();

	JLabel JLSdept = new JLabel("专业:"); // 使用文本创建一个标签对象
	JTextField JTSdept = new JTextField();

	JLabel JLSmphone = new JLabel("手机号:"); // 使用文本创建一个标签对象
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("学院:"); // 使用文本创建一个标签对象
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("班级:"); // 使用文本创建一个标签对象
	JTextField JTSclass = new JTextField();

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton JBxiugai = new JButton("修改");
	JButton jb = new JButton("返回");

	public Sxiugaistudent() // 创建SetGrade构造函数
	{
		this.setTitle("学生—个人信息修改");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLNumber.setBounds(100, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLNumber);// 将学号标签添加到容器
		JTNumber.setBounds(200, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTNumber);// 将文本框添加到容器

		JLName.setBounds(100, 140, 60, 20);// 设置姓名标签的初始位置
		this.add(JLName);// 将姓名标签添加到容器
		JTName.setBounds(200, 140, 100, 20);// 设置文本框的初始位置
		this.add(JTName);// 将文本框添加到容器

		JLSbirthday.setBounds(100, 165, 60, 20); // 设置班级标签的初始位置
		this.add(JLSbirthday); // 将班级标签添加到容器
		JTSbirthday.setBounds(200, 165, 100, 20); // 设置文本框的初始位置
		this.add(JTSbirthday); // 将文本框添加到容器

		JLSmphone.setBounds(100, 190, 60, 20); // 设置班级标签的初始位置
		this.add(JLSmphone); // 将班级标签添加到容器
		JTSmphone.setBounds(200, 190, 100, 20); // 设置文本框的初始位置
		this.add(JTSmphone);

		JLSqq.setBounds(100, 215, 60, 20); // 设置班级标签的初始位置
		this.add(JLSqq); // 将班级标签添加到容器
		JTSqq.setBounds(200, 215, 100, 20); // 设置文本框的初始位置
		this.add(JTSqq);

		JLSmailbox.setBounds(100, 240, 60, 20); // 设置班级标签的初始位置
		this.add(JLSmailbox); // 将班级标签添加到容器
		JTSmailbox.setBounds(200, 240, 100, 20); // 设置文本框的初始位置
		this.add(JTSmailbox);

		JLSschool.setBounds(100, 265, 60, 20); // 设置班级标签的初始位置
		this.add(JLSschool); // 将班级标签添加到容器
		JTSschool.setBounds(200, 265, 100, 20); // 设置文本框的初始位置
		this.add(JTSschool);

		JLSdept.setBounds(100, 290, 60, 20); // 设置班级标签的初始位置
		this.add(JLSdept); // 将班级标签添加到容器
		JTSdept.setBounds(200, 290, 100, 20); // 设置文本框的初始位置
		this.add(JTSdept);

		JLSclass.setBounds(100, 315, 60, 20); // 设置班级标签的初始位置
		this.add(JLSclass); // 将班级标签添加到容器
		JTSclass.setBounds(200, 315, 100, 20); // 设置文本框的初始位置
		this.add(JTSclass);

		JLSaddress.setBounds(100, 340, 60, 20); // 设置班级标签的初始位置
		this.add(JLSaddress); // 将班级标签添加到容器
		JTSaddress.setBounds(200, 340, 100, 45); // 设置文本框的初始位置
		this.add(JTSaddress);
		JTSaddress.setLineWrap(true);

		JBSet.setBounds(48, 110, 70, 20);// //设置查询按钮的初始位置
		this.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器

		JBNext.setBounds(140, 110, 70, 20);// 设置重置按钮的初始位置
		this.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		JBxiugai.setBounds(230, 110, 70, 20);// 设置重置按钮的初始位置
		this.add(JBxiugai);// 将重置按钮添加到容器
		JBxiugai.addActionListener(this);// 给按钮添加监听器

		jb.setBounds(320, 110, 70, 20);// 设置重置按钮的初始位置
		this.add(jb);// 将重置按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setBounds(500, 300, 450, 500);// 设置窗口尺寸大小
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

					JTName.setText(rs.getString("Sname"));// 将字符串name显示在文本框中
					JTSbirthday.setText(rs.getString("Sbirthday"));
					JTSmphone.setText(rs.getString("Smphone"));
					JTSqq.setText(rs.getString("Sqq"));
					JTSmailbox.setText(rs.getString("Smailbox"));
					JTSschool.setText(rs.getString("Sschool"));
					JTSdept.setText(rs.getString("Sdept"));
					JTSclass.setText(rs.getString("Sclass"));
					JTSaddress.setText(rs.getString("Saddress"));

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
				String Sname = JTName.getText();
				String Sbirthday = JTSbirthday.getText();
				String Smphone = JTSmphone.getText();
				String Sqq = JTSqq.getText();
				String Smailbox = JTSmailbox.getText();
				String Sschool = JTSschool.getText();
				String Sdept = JTSdept.getText();
				String Sclass = JTSclass.getText();
				String Saddress = JTSaddress.getText();

				String sql1 = " update student set Sname = '" + Sname
						+ "'  where Sno = '" + snumber + "' ";

				String sql2 = " update student set Sbirthday = '" + Sbirthday
						+ "'  where Sno = '" + snumber + "' ";

				String sql3 = " update student set Smphone = '" + Smphone
						+ "'  where Sno = '" + snumber + "' ";
				String sql4 = " update student set Sqq = '" + Sqq
						+ "'  where Sno = '" + snumber + "' ";
				String sql5 = " update student set Smailbox = '" + Smailbox
						+ "'  where Sno = '" + snumber + "' ";
				String sql6 = " update student set Sschool = '" + Sschool
						+ "'  where Sno = '" + snumber + "' ";
				String sql7 = " update student set Sdept = '" + Sdept
						+ "'  where Sno = '" + snumber + "' ";
				String sql8 = " update student set Sclass = '" + Sclass
						+ "'  where Sno = '" + snumber + "' ";
				String sql9 = " update student set Saddress = '" + Saddress
						+ "'  where Sno = '" + snumber + "' ";

				int n = stm.executeUpdate(sql1);// 对数据库进行更
				stm.executeUpdate(sql2);// 对数据库进行更新
				stm.executeUpdate(sql3);
				stm.executeUpdate(sql4);
				stm.executeUpdate(sql5);
				stm.executeUpdate(sql6);
				stm.executeUpdate(sql7);
				stm.executeUpdate(sql8);
				stm.executeUpdate(sql9);

				if (n > 0)
					JOptionPane.showMessageDialog(null, "修改成功!");// 通过showMessageDialog()方法打印信息
				else
					JOptionPane.showMessageDialog(null, "修改失败!");

			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTNumber.setText(null);// 设置文本的text值为null
			JTName.setText(null);// 设置文本的text值为null

		}
		if (e.getSource() == jb)// 处理"返回"事件
		{

			new SSelectStudent();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Sxiugaistudent();// 实例化一个对象
	}
}
