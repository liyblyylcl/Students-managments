package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import com.lhr.SDMSlogin;

public class StudentJieMian extends JFrame implements ActionListener {

	JLabel background, jl1, jl2, jl3, jl4, jl6;
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JPanel jp, imagePanel;
	ImageIcon imgBackground, im, im1;

	public StudentJieMian() throws IOException {

		// 设置背景图片
		imgBackground = new ImageIcon("images\\StudentJieMian.jpg");// 背景图片,
		// 这里是用源图片构造一个ImageIcon对象来实例化标签
		background = new JLabel(imgBackground); // 把背景图片放在标签jil里
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// 把标签的大小位置设置为图片的格式，使之刚好填充整个面板
		imagePanel = (JPanel) this.getContentPane();// 把内容窗格转化为JPanel,否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);// 用方法setOpaque()来使内容窗格透明
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 把背景图片添加到分层窗格的最底层作为背景

		// 注册监听,设置Mainpage的四个按钮
		jb1 = new JButton(new ImageIcon("images\\个人信息.gif"));
		jb1.setOpaque(false);
		jb1.setToolTipText("点击可以查询与修改个人的信息！");
		// jb1.setBorderPainted(false);
		jb1.addActionListener(this);
		jb1.setBounds(90, 20, 140, 38);

		jb2 = new JButton(new ImageIcon("images\\公物报修.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("点击查询公物报修的情况！");
		jb2.addActionListener(this);
		jb2.setBounds(235, 20, 140, 38);

		jb3 = new JButton(new ImageIcon("images\\卫生评比.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("点击可以查看有关卫生评比的结果！");
		jb3.addActionListener(this);
		jb3.setBounds(380, 20, 140, 38);

		jb5 = new JButton(new ImageIcon("images\\水电费.gif"));
		jb5.setOpaque(false);
		jb5.setToolTipText("点击可以查看水电费的使用情况！");
		jb5.addActionListener(this);
		jb5.setBounds(525, 20, 140, 38);

		jb6 = new JButton(new ImageIcon("images\\留言板.gif"));
		jb6.setOpaque(false);
		jb6.setToolTipText("点击可以给管理员进行留言！");
		jb6.addActionListener(this);
		jb6.setBounds(670, 20, 140, 38);

		jb4 = new JButton(new ImageIcon("images\\返回登陆.gif"));
		jb4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("点击返回到登陆界面！");
		jb4.addActionListener(this);
		jb4.setBounds(400, 625, 140, 35);

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);
		jp.add(jb6);

		ImageIcon im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setTitle("学生界面");
		this.setSize(900, 700);
		this.setResizable(false);// 控制窗体大小
		this.setLocation(350, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb5) {

			new Sshuidianfeichaxun();
		}
		if (e.getSource() == jb3) {

			new Sweishengchaxun();
		}
		if (e.getSource() == jb1) {
			new SSelectStudent();

		}
		if (e.getSource() == jb4) {

			new SDMSlogin();
		}
		if (e.getSource() == jb2) {

			new Sgongwubaoxiu();
		}
		if (e.getSource() == jb6) {

			new SMessageBoard();
		}
		this.dispose();
	}

	public static void main(String args[]) throws IOException {
		new StudentJieMian();
	}
}
