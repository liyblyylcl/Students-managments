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

		// ���ñ���ͼƬ
		imgBackground = new ImageIcon("images\\background.jpg");// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		background = new JLabel(imgBackground); // �ѱ���ͼƬ���ڱ�ǩjil��
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) this.getContentPane();// �����ݴ���ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		// ע�����,����Mainpage��9����ť
		jb1 = new JButton(new ImageIcon("images\\T����Ա.gif"));
		jb1.setOpaque(false);
		jb1.setToolTipText("��������޸Ĺ���Ա�����룡");
		jb1.addActionListener(this);
		jb1.setBounds(670, 70, 130, 35);

		jb2 = new JButton(new ImageIcon("images\\T���ﱨ��.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("������Բ�ѯ���ﱨ�޵������");
		jb2.addActionListener(this);
		jb2.setBounds(670, 20, 130, 35);

		jb3 = new JButton(new ImageIcon("images\\T��������.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("������Բ鿴�й��������ȵĽ����");
		jb3.addActionListener(this);
		jb3.setBounds(380, 70, 130, 35);

		jb5 = new JButton(new ImageIcon("images\\ˮ�ѵ��.gif"));
		jb5.setOpaque(false);
		jb5.setToolTipText("������Բ鿴ˮ��ѵ�ʹ�������");
		jb5.addActionListener(this);
		jb5.setBounds(525, 20, 130, 35);

		jb6 = new JButton(new ImageIcon("images\\����¼.gif"));
		jb6.setOpaque(false);
		jb6.setToolTipText("������Բ鿴���ļ�¼�����");
		jb6.addActionListener(this);
		jb6.setBounds(90, 70, 130, 35);

		jb7 = new JButton(new ImageIcon("images\\������Ա.gif"));
		jb7.setOpaque(false);
		jb7.setToolTipText("������Բ鿴������Ա��������¥�������");
		jb7.addActionListener(this);
		jb7.setBounds(380, 20, 130, 35);

		jb8 = new JButton(new ImageIcon("images\\������Ʒ.gif"));
		jb8.setOpaque(false);
		jb8.setToolTipText("������Բ鿴��¼������Ʒ��������¥�������");
		jb8.addActionListener(this);
		jb8.setBounds(235, 20, 130, 35);

		jb9 = new JButton(new ImageIcon("images\\��У��У.gif"));
		jb9.setOpaque(false);
		jb9.setToolTipText("������Բ鿴ѧ���뷵У�������");
		jb9.addActionListener(this);
		jb9.setBounds(235, 70, 130, 35);

		jb10 = new JButton(new ImageIcon("images\\ѧ������.gif"));
		jb10.setOpaque(false);
		jb10.setToolTipText("������Բ鿴���޸�ѧ���Ļ�����Ϣ�����");
		jb10.addActionListener(this);
		jb10.setBounds(90, 20, 130, 35);

		jb12 = new JButton(new ImageIcon("images\\T���԰�.gif"));
		jb12.setOpaque(false);
		jb12.setToolTipText("������Բ鿴���԰���Ϣ��");
		jb12.addActionListener(this);
		jb12.setBounds(525, 70, 130, 35);

		jb4 = new JButton(new ImageIcon("images\\T���ص�½.gif"));
		jb4.setFont(new Font("΢���ź�", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("������ص���½���棡");
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

		im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setTitle("����Ա����");
		this.setSize(900, 700);
		this.setResizable(false);// ���ƴ����С
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
