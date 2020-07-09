package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import com.lhr.SDMSlogin;

public class TWailaiJieMian extends JFrame implements ActionListener {

	JLabel background, jl1, jl2, jl3, jl4;
	JButton jb2, jb3, jb4;
	JPanel jp, imagePanel;
	ImageIcon imgBackground, im, im1;
	JTextArea textarea;

	public TWailaiJieMian() throws IOException {

		// 设置背景图片
		imgBackground = new ImageIcon("images\\外来JieMian.jpg");// 背景图片,
		// 这里是用源图片构造一个ImageIcon对象来实例化标签
		background = new JLabel(imgBackground); // 把背景图片放在标签jil里
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// 把标签的大小位置设置为图片的格式，使之刚好填充整个面板
		imagePanel = (JPanel) this.getContentPane();// 把内容窗格转化为JPanel,否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);// 用方法setOpaque()来使内容窗格透明
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// 把背景图片添加到分层窗格的最底层作为背景

		jb2 = new JButton(new ImageIcon("images\\外来记录.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("点击可以插入外来人员的情况！");
		jb2.addActionListener(this);
		jb2.setBounds(200, 450, 120, 30);

		jb3 = new JButton(new ImageIcon("images\\外来查询.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("点击可以查询外来人员的信息！");
		jb3.addActionListener(this);
		jb3.setBounds(360, 450, 120, 30);

		jb4 = new JButton(new ImageIcon("images\\返回2.gif"));
		jb4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("点击返回到选择界面！");
		jb4.addActionListener(this);
		jb4.setBounds(600, 460, 80, 25);

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);

		im1 = new ImageIcon("images\\校徽.jpg");
		this.setIconImage(im1.getImage()); // 设置标题图标

		this.setTitle("管理员—外来人员界面");
		this.setSize(700, 530);
		this.setResizable(false);// 控制窗体大小
		this.setLocation(450, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb3) {

			new TWailaichaxun();
		}
		if (e.getSource() == jb2) {

			new TWailaiAddtion();
		}
		if (e.getSource() == jb4) {

			try {
				new TeacherJieMian();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		this.dispose();
	}

	public static void main(String args[]) throws IOException {
		new TWailaiJieMian();
	}
}
