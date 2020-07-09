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

		// ���ñ���ͼƬ
		imgBackground = new ImageIcon("images\\StudentJieMian.jpg");// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		background = new JLabel(imgBackground); // �ѱ���ͼƬ���ڱ�ǩjil��
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) this.getContentPane();// �����ݴ���ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		// ע�����,����Mainpage���ĸ���ť
		jb1 = new JButton(new ImageIcon("images\\������Ϣ.gif"));
		jb1.setOpaque(false);
		jb1.setToolTipText("������Բ�ѯ���޸ĸ��˵���Ϣ��");
		// jb1.setBorderPainted(false);
		jb1.addActionListener(this);
		jb1.setBounds(90, 20, 140, 38);

		jb2 = new JButton(new ImageIcon("images\\���ﱨ��.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("�����ѯ���ﱨ�޵������");
		jb2.addActionListener(this);
		jb2.setBounds(235, 20, 140, 38);

		jb3 = new JButton(new ImageIcon("images\\��������.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("������Բ鿴�й��������ȵĽ����");
		jb3.addActionListener(this);
		jb3.setBounds(380, 20, 140, 38);

		jb5 = new JButton(new ImageIcon("images\\ˮ���.gif"));
		jb5.setOpaque(false);
		jb5.setToolTipText("������Բ鿴ˮ��ѵ�ʹ�������");
		jb5.addActionListener(this);
		jb5.setBounds(525, 20, 140, 38);

		jb6 = new JButton(new ImageIcon("images\\���԰�.gif"));
		jb6.setOpaque(false);
		jb6.setToolTipText("������Ը�����Ա�������ԣ�");
		jb6.addActionListener(this);
		jb6.setBounds(670, 20, 140, 38);

		jb4 = new JButton(new ImageIcon("images\\���ص�½.gif"));
		jb4.setFont(new Font("΢���ź�", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("������ص���½���棡");
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

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setTitle("ѧ������");
		this.setSize(900, 700);
		this.setResizable(false);// ���ƴ����С
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
