package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Txiugaishuidianfei extends JFrame implements ActionListener {
	JLabel JL = new JLabel("水电费情况修改", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLDno = new JLabel("请输入宿舍号:");// 使用文本创建一个标签对象
	JTextField JTDno = new JTextField();// 创建一个文本框对象

	JLabel JLSWDegree = new JLabel("起始水度数:"); // 使用文本创建一个标签对象
	JTextField JTSWDegree = new JTextField();

	JLabel JLEWDegree = new JLabel("终止水度数:"); // 使用文本创建一个标签对象
	JTextField JTEWDegree = new JTextField();

	JLabel JLSEDegree = new JLabel("起始电度数:"); // 使用文本创建一个标签对象
	JTextField JTSEDegree = new JTextField();

	JLabel JLEEDegree = new JLabel("终止电度数:"); // 使用文本创建一个标签对象
	JTextField JTEEDegree = new JTextField();

	JLabel JLWaterFee = new JLabel("水费:"); // 使用文本创建一个标签对象
	JTextField JTWaterFee = new JTextField();

	JLabel JLPowerFee = new JLabel("电费:"); // 使用文本创建一个标签对象
	JTextField JTPowerFee = new JTextField();

	JLabel JLTotalSum = new JLabel("总金额:"); // 使用文本创建一个标签对象
	JTextField JTTotalSum = new JTextField();

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton JBxiugai = new JButton("修改");
	JButton jb = new JButton("返回");

	public Txiugaishuidianfei() // 创建SetGrade构造函数
	{
		this.setTitle("管理员—水电费情况修改");// 设置窗口标题
		this.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		this.add(JL);// 将标签添加到容器

		JLDno.setBounds(100, 80, 100, 20);// 设置学号标签的初始位置
		this.add(JLDno);// 将学号标签添加到容器
		JTDno.setBounds(200, 80, 100, 20);// 设置文本框的初始位置
		this.add(JTDno);// 将文本框添加到容器

		JLSWDegree.setBounds(100, 170, 80, 20); // 设置班级标签的初始位置
		this.add(JLSWDegree); // 将班级标签添加到容器
		JTSWDegree.setBounds(200, 170, 100, 20); // 设置文本框的初始位置
		this.add(JTSWDegree); // 将文本框添加到容器
		JTSWDegree.setEditable(false);

		JLEWDegree.setBounds(100, 195, 80, 20); // 设置班级标签的初始位置
		this.add(JLEWDegree); // 将班级标签添加到容器
		JTEWDegree.setBounds(200, 195, 100, 20); // 设置文本框的初始位置
		this.add(JTEWDegree); // 将文本框添加到容器

		JLSEDegree.setBounds(100, 220, 80, 20); // 设置班级标签的初始位置
		this.add(JLSEDegree); // 将班级标签添加到容器
		JTSEDegree.setBounds(200, 220, 100, 20); // 设置文本框的初始位置
		this.add(JTSEDegree); // 将文本框添加到容器
		JTSEDegree.setEditable(false);

		JLEEDegree.setBounds(100, 245, 80, 20); // 设置班级标签的初始位置
		this.add(JLEEDegree); // 将班级标签添加到容器
		JTEEDegree.setBounds(200, 245, 100, 20); // 设置文本框的初始位置
		this.add(JTEEDegree); // 将文本框添加到容器

		JLWaterFee.setBounds(100, 270, 80, 20); // 设置班级标签的初始位置
		this.add(JLWaterFee); // 将班级标签添加到容器
		JTWaterFee.setBounds(200, 270, 100, 20); // 设置文本框的初始位置
		this.add(JTWaterFee); // 将文本框添加到容器

		JLPowerFee.setBounds(100, 295, 80, 20); // 设置班级标签的初始位置
		this.add(JLPowerFee); // 将班级标签添加到容器
		JTPowerFee.setBounds(200, 295, 100, 20); // 设置文本框的初始位置
		this.add(JTPowerFee); // 将文本框添加到容器

		JLTotalSum.setBounds(100, 320, 80, 20); // 设置班级标签的初始位置
		this.add(JLTotalSum); // 将班级标签添加到容器
		JTTotalSum.setBounds(200, 320, 100, 20); // 设置文本框的初始位置
		this.add(JTTotalSum); // 将文本框添加到容器

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
			String sDno = JTDno.getText();// 将文本框中包含的文本传给字符串sDno
			String sql = "select * from WEfee where Dno = '" + sDno + "'";// 检索出Id等于sDno的学生的所有信息
			try // 异常处理
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\SDMS.mdb");// 打开数据库连接，student1为数据源名称

				Statement stm = cot.createStatement();// 提交查询
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				if (rs.next()) // 判断结果是否存在
				{

					JTSWDegree.setText(rs.getString("SWDegree"));
					JTEWDegree.setText(rs.getString("EWDegree"));
					JTSEDegree.setText(rs.getString("SEDegree"));
					JTEEDegree.setText(rs.getString("EEDegree"));
					JTWaterFee.setText(rs.getString("WaterFee"));
					JTPowerFee.setText(rs.getString("PowerFee"));
					JTTotalSum.setText(rs.getString("TotalSum"));

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

				String sDno = JTDno.getText();

				String SWDegree = JTSWDegree.getText();
				String EWDegree = JTEWDegree.getText();
				String SEDegree = JTSEDegree.getText();
				String EEDegree = JTEEDegree.getText();
				String WaterFee = JTWaterFee.getText();
				String PowerFee = JTPowerFee.getText();
				String TotalSum = JTTotalSum.getText();

				String sql1 = " update WEfee set SWDegree = '" + SWDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql2 = " update WEfee set EWDegree = '" + EWDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql3 = " update WEfee set SEDegree = '" + SEDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql4 = " update WEfee set EEDegree = '" + EEDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql5 = " update WEfee set WaterFee = '" + WaterFee
						+ "'  where Dno = '" + sDno + "' ";
				String sql6 = " update WEfee set PowerFee = '" + PowerFee
						+ "'  where Dno = '" + sDno + "' ";
				String sql7 = " update WEfee set TotalSum = '" + TotalSum
						+ "'  where Dno = '" + sDno + "' ";

				int n = JOptionPane.showConfirmDialog(this, "您要确认修改吗?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql1);// 对数据库进行更新
					stm.executeUpdate(sql2);
					stm.executeUpdate(sql3);
					stm.executeUpdate(sql4);
					stm.executeUpdate(sql5);
					stm.executeUpdate(sql6);
					stm.executeUpdate(sql7);

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
			JTDno.setText(null);// 设置文本的text值为null

		}
		if (e.getSource() == jb)// 处理"返回"事件
		{

			new Tshuidianfeichaxun();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Txiugaishuidianfei();// 实例化一个对象
	}
}
