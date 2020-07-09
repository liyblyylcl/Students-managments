package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import com.lhr.SDMSlogin;

public class TeacherJieMian extends JFrame implements ActionListener {

	JLabel background, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11,
			jl12;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12;
	JPanel jp, imagePanel;
	ImageIcon imgBackground, im, im1;
	JTextArea textarea;

	public TeacherJieMian() throws IOException {

		// 设置背景图片
		imgBackground = new ImageIcon("images\\background.jpg");// 背景图片,
		// 这里是用源图片构造一个ImageIcon对象来实例化标签
		background = new JLabel(imgBackground); // 把背景图片放在标签jil里
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// 把标签的大小位置设置为图片的格式，使之刚好填充整个面板
		imagePanel = (JPanel) this.getContentPane();// 把内容窗格转化为JPanel,否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);// 用方法setOpaque()来使内容窗格透明
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 把背景图片添加到分层窗格的最底层作为背景

		// 注册监听,设置Mainpage的9个按钮
		jb1 = new JButton(new ImageIcon("images\\T管理员.gif"));
		jb1.setOpaque(false);
		jb1.setToolTipText("点击可以修改管理员的密码！");
		jb1.addActionListener(this);
		jb1.setBounds(670, 70, 130, 35);

		jb2 = new JButton(new ImageIcon("images\\T公物报修.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("点击可以查询公物报修的情况！");
		jb2.addActionListener(this);
		jb2.setBounds(670, 20, 130, 35);

		jb3 = new JButton(new ImageIcon("images\\T卫生评比.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("点击可以查看有关卫生评比的结果！");
		jb3.addActionListener(this);
		jb3.setBounds(380, 70, 130, 35);

		jb5 = new JButton(new ImageIcon("images\\水费电费.gif"));
		jb5.setOpaque(false);
		jb5.setToolTipText("点击可以查看水电费的使用情况！");
		jb5.addActionListener(this);
		jb5.setBounds(525, 20, 130, 35);

		jb6 = new JButton(new ImageIcon("images\\晚归记录.gif"));
		jb6.setOpaque(false);
		jb6.setToolTipText("点击可以查看晚归的记录情况！");
		jb6.addActionListener(this);
		jb6.setBounds(90, 70, 130, 35);

		jb7 = new JButton(new ImageIcon("images\\外来人员.gif"));
		jb7.setOpaque(false);
		jb7.setToolTipText("点击可以查看外来人员进入宿舍楼的情况！");
		jb7.addActionListener(this);
		jb7.setBounds(380, 20, 130, 35);

		jb8 = new JButton(new ImageIcon("images\\贵重物品.gif"));
		jb8.setOpaque(false);
		jb8.setToolTipText("点击可以查看记录贵重物品出入宿舍楼的情况！");
		jb8.addActionListener(this);
		jb8.setBounds(235, 20, 130, 35);

		jb9 = new JButton(new ImageIcon("images\\离校返校.gif"));
		jb9.setOpaque(false);
		jb9.setToolTipText("点击可以查看学生离返校的情况！");
		jb9.addActionListener(this);
		jb9.setBounds(235, 70, 130, 35);

		jb10 = new JButton(new ImageIcon("images\\学生管理.gif"));
		jb10.setOpaque(false);
		jb10.setToolTipText("点击可以查看与修改学生的基本信息情况！");
		jb10.addActionListener(this);
		jb10.setBounds(90, 20, 130, 35);

		jb12 = new JButton(new ImageIcon("images\\T留言板.gif"));
		jb12.setOpaque(false);
		jb12.setToolTipText("点击可以查看留言板信息！");
		jb12.addActionListener(this);
		jb12.setBounds(525, 70, 130, 35);

		jb4 = new JButton(new ImageIcon("images\\T返回登陆.gif"));
		jb4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("点击返回到登陆界面！");
		jb4.addActionListener(this);
		jb4.setBounds(400, 610, 130, 35);

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		jp.add(jb5);
		jp.add(jb6);
		jp.add(jb7);
		jp.add(jb8);
		jp.add(jb9);
		jp.add(jb10);
		jp.add(jb12);

		im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setTitle("管理员界面");
		this.setSize(900, 700);
		this.setResizable(false);// 控制窗体大小
		this.setLocation(350, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb5) {

			new Tshuidianfeichaxun();
		}
		if (e.getSource() == jb3) {

			new Tweishengchaxun();
		}
		if (e.getSource() == jb1) {
			new TxiugaiAdminInformation();

		}
		if (e.getSource() == jb4) {

			new SDMSlogin();
		}
		if (e.getSource() == jb2) {

			new Tgongwubaoxiu();
		}
		if (e.getSource() == jb6) {

			try {
				new TWanGuiJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb7) {

			try {
				new TWailaiJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb8) {

			try {
				new TGuiZhongJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb9) {

			try {
				new TLiFanJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb10) {

			try {
				new TStudent();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == jb12) {

			new TMessagechaxun();
		}

		this.dispose();
	}

	public static void main(String args[]) throws IOException {
		new TeacherJieMian();
	}
}
