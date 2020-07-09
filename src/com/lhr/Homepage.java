package com.lhr;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import javax.swing.*;

public class Homepage extends JFrame implements ActionListener {

	JLabel jl, jl1;
	JButton jb;
	JPanel jp, jp1;
	ImageIcon  im, im1;
	JTextArea textarea;

	public Homepage() throws IOException {

		//设置背景图片
		Background.setBackgroundPhoto(this, "images\\重邮更名.jpg");
		
		// 设置标签
		jl = new JLabel("欢迎来到22栋学生宿舍管理系统");
		jl.setBounds(200, 330, 600, 50);
		jl.setForeground(Color.YELLOW);		
		jl.setFont(new Font("黑体", Font.BOLD, 40));

		jl1 = new JLabel(
				"Welcome to the student's dormitory management system of the 22nd building"
						+ "!");
		jl1.setFont(new Font("Arial", Font.BOLD, 16));
		jl1.setForeground(Color.red);
		jl1.setBounds(200, 200, 600, 400);

		// 注册监听
		im = new ImageIcon("images\\点击进入.gif");
		jb = new JButton(im);
		jb.setSize(im.getIconWidth() - 10, im.getIconHeight());
		jb.setLocation(835, 670);
//		jb.setOpaque(true);
		jb.setBorderPainted(false);//去掉按钮边框
		jb.addActionListener(this);

		// 设置文本域
		textarea = new JTextArea();
		textarea.setForeground(new Color(10, 150, 50));// 设置文本域字体颜色
		Font font1 = new Font("宋体", Font.BOLD, 14);
		textarea.setFont(font1);
		textarea.setBounds(0, 0, 1006, 600);
		BufferedReader fis = new BufferedReader(new FileReader(
				"Informations\\Homepage.txt")); // 读取文件
		String s = fis.readLine();
		while (s != null) {

			textarea.append(s + "\n");
			s = fis.readLine();
		}
		textarea.setOpaque(false);
		textarea.setEditable(false); // 控制文本域内容

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jl1);
		jp.add(textarea);
		jp.add(jb);
		jp.add(jl);

		im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setTitle("22栋学生宿舍管理系统(SDMS)");
		this.setSize(1006, 782);
		this.setResizable(false);// 控制窗体大小
		this.setLocation(280, 50);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {

		new Homepage();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb) {

			new SDMSlogin();
			this.dispose();
		}

	}

}
