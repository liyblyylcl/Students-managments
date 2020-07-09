package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TAddStudent extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添 加 学生 信 息", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLSno = new JLabel("学号:"); // 使用文本创建一个标签对象
	JTextField JTSno = new JTextField(); // 创建一个文本框对象

	JLabel JLDno = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField(); // 创建一个文本框对象

	JLabel JLSname = new JLabel("姓名:"); // 使用文本创建一个标签对象
	JTextField JTSname = new JTextField(); // 创建一个文本框对象

	JLabel JLSsex = new JLabel("性别:"); // 使用文本创建一个标签对象
	ButtonGroup BG = new ButtonGroup(); // 创建一个ButtonGroup组件对象
	JRadioButton JRb1 = new JRadioButton("男");
	JRadioButton JRb2 = new JRadioButton("女");

	JLabel JLSbirthday = new JLabel("生日:"); // 使用文本创建一个标签对象
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // 使用文本创建一个标签对象
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("邮箱:"); // 使用文本创建一个标签对象
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("家庭住址:"); // 使用文本创建一个标签对象
	JTextField JTSaddress = new JTextField();

	JLabel JLSdept = new JLabel("专业:"); // 使用文本创建一个标签对象
	JTextField JTSdept = new JTextField();

	JLabel JLScheckin = new JLabel("入住时间:"); // 使用文本创建一个标签对象
	JTextField JTScheckin = new JTextField();

	JLabel JLSmphone = new JLabel("手机号:"); // 使用文本创建一个标签对象
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("学院:"); // 使用文本创建一个标签对象
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("班级:"); // 使用文本创建一个标签对象
	JTextField JTSclass = new JTextField();

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb = new JButton("返回");

	String sql = ""; // 定义一个字符串

	public TAddStudent() // 创建AddStudent构造函数
	{
		this.setTitle("管理员—添加学生信息"); // 设置窗口标题
		this.setLayout(null); // 设置窗口布局管理器
		JL.setBounds(100, 30, 200, 40); // 设置标签的初始位置
		this.add(JL); // 将标签添加到容器

		JLSno.setBounds(100, 80, 100, 20); // 设置学号标签的初始位置
		this.add(JLSno); // 将学号标签添加到容器
		JTSno.setBounds(200, 80, 100, 20); // 设置文本框的初始位置
		this.add(JTSno); // 将文本框添加到容器

		JLSname.setBounds(100, 100, 60, 20); // 设置姓名标签的初始位置
		this.add(JLSname); // 将姓名标签添加到容器
		JTSname.setBounds(200, 100, 100, 20); // 设置文本框的初始位置
		this.add(JTSname); // 将文本框添加到容器

		JLSsex.setBounds(100, 120, 100, 20); // 设置性别标签的初始位置
		this.add(JLSsex); // 将性别标签添加到容器
		JRb1.setBounds(200, 120, 40, 20);
		JRb2.setBounds(260, 120, 40, 20);
		add(JRb1);
		add(JRb2);
		BG.add(JRb1);
		BG.add(JRb2);

		JLSbirthday.setBounds(100, 140, 60, 20); // 设置班级标签的初始位置
		this.add(JLSbirthday); // 将班级标签添加到容器
		JTSbirthday.setBounds(200, 140, 100, 20); // 设置文本框的初始位置
		this.add(JTSbirthday); // 将文本框添加到容器

		JLSmphone.setBounds(100, 160, 60, 20); // 设置班级标签的初始位置
		this.add(JLSmphone); // 将班级标签添加到容器
		JTSmphone.setBounds(200, 160, 100, 20); // 设置文本框的初始位置
		this.add(JTSmphone);

		JLSqq.setBounds(100, 180, 60, 20); // 设置班级标签的初始位置
		this.add(JLSqq); // 将班级标签添加到容器
		JTSqq.setBounds(200, 180, 100, 20); // 设置文本框的初始位置
		this.add(JTSqq);

		JLSmailbox.setBounds(100, 200, 60, 20); // 设置班级标签的初始位置
		this.add(JLSmailbox); // 将班级标签添加到容器
		JTSmailbox.setBounds(200, 200, 100, 20); // 设置文本框的初始位置
		this.add(JTSmailbox);

		JLSschool.setBounds(100, 220, 60, 20); // 设置班级标签的初始位置
		this.add(JLSschool); // 将班级标签添加到容器
		JTSschool.setBounds(200, 220, 100, 20); // 设置文本框的初始位置
		this.add(JTSschool);

		JLSdept.setBounds(100, 240, 60, 20); // 设置班级标签的初始位置
		this.add(JLSdept); // 将班级标签添加到容器
		JTSdept.setBounds(200, 240, 100, 20); // 设置文本框的初始位置
		this.add(JTSdept);

		JLSclass.setBounds(100, 260, 60, 20); // 设置班级标签的初始位置
		this.add(JLSclass); // 将班级标签添加到容器
		JTSclass.setBounds(200, 260, 100, 20); // 设置文本框的初始位置
		this.add(JTSclass);

		JLDno.setBounds(100, 280, 60, 20); // 设置班级标签的初始位置
		this.add(JLDno); // 将班级标签添加到容器
		JTDno.setBounds(200, 280, 100, 20); // 设置文本框的初始位置
		this.add(JTDno);

		JLScheckin.setBounds(100, 300, 60, 20); // 设置班级标签的初始位置
		this.add(JLScheckin); // 将班级标签添加到容器
		JTScheckin.setBounds(200, 300, 100, 20); // 设置文本框的初始位置
		this.add(JTScheckin);

		JLSaddress.setBounds(100, 320, 60, 20); // 设置班级标签的初始位置
		this.add(JLSaddress); // 将班级标签添加到容器
		JTSaddress.setBounds(200, 320, 100, 20); // 设置文本框的初始位置
		this.add(JTSaddress);

		JBAdd.setBounds(80, 350, 70, 20); // 设置添加按钮的初始位置
		this.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(180, 350, 70, 20); // 设置重置按钮的初始位置
		this.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jb.setBounds(280, 350, 70, 20);// 设置返回按钮的初始位置
		this.add(jb);// 将返回按钮添加到容器
		jb.addActionListener(this);// 给按钮添加监听器

		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标
		this.setBounds(500, 330, 420, 450); // 设置窗口尺寸大小
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
			String Sno = JTSno.getText().trim();// 将文本框中包含的文本传给字符串snumber
			String Sname = JTSname.getText().trim();// 将文本框中包含的文本传给字符串sname
			String Sclass = JTSclass.getText().trim();// 将文本框中包含的文本传给字符串sclass
			String Sqq = JTSqq.getText().trim();
			String Sbirthday = JTSbirthday.getText().trim();
			String Smailbox = JTSmailbox.getText().trim();
			String Saddress = JTSaddress.getText().trim();
			String Sdept = JTSdept.getText().trim();
			String Dno = JTDno.getText().trim();
			String Sschool = JTSschool.getText().trim();
			String Scheckin = JTScheckin.getText().trim();
			String Smphone = JTSmphone.getText().trim();
			String Ssex = "女";// 返回单选按钮的值
			if (JRb1.isSelected())
				Ssex = "男";

			sql = "select Sno from student where Sno='" + Sno + "'";
			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				System.out.println("驱动加载正确！");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，SDMS为数据源名称
				System.out.println("数据库连接正确！" + cot);
				Statement stm = cot.createStatement();// 提交查询
				System.out.println("提交OK！" + stm);
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);

				if (rs.next())// 判断结果是否存在
					JOptionPane.showMessageDialog(this, "该学号已经存在,不能重复添加!");// 通过showMessageDialog()方法打印信息
				else {
					sql = "insert into student (" + "Sno,Sname,Sqq,Sclass,"
							+ "Ssex,Sbirthday,Smailbox,"
							+ "Saddress,Sdept,Scheckin,"
							+ "Smphone,Dno,Sschool)" + "values('"
							+ Sno
							+ "','"
							+ Sname
							+ "','"
							+ Sqq
							+ "','"
							+ Sclass
							+ "','"
							+ Ssex
							+ "','"
							+ Sbirthday
							+ "','"
							+ Smailbox
							+ "','"
							+ Saddress
							+ "','"
							+ Sdept
							+ "','"
							+ Scheckin
							+ "','"
							+ Smphone
							+ "','"
							+ Dno
							+ "','" + Sschool + "')";// 插入一组数据

					int i = stm.executeUpdate(sql); // 对数据库进行更新
					if (i > 0)
						JOptionPane.showMessageDialog(null, "添加成功!");
					else
						JOptionPane.showMessageDialog(null, "删除失败!");
				}

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TStudent();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{

			JTSno.setText(null);// 设置文本的text值为null
			JTSname.setText(null); // 设置文本的text值为null
			JTSclass.setText(null);// 设置文本的text值为null
			JTSbirthday.setText(null);
			JTSmailbox.setText(null);
			JTSaddress.setText(null);
			JTSdept.setText(null);
			JTScheckin.setText(null);
			JTSmphone.setText(null);
			JTSschool.setText(null);
			JTDno.setText(null);

		}
	}

	public static void main(String args[]) {
		new TAddStudent();
	}
}
