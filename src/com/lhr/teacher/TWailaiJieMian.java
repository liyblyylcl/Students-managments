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

		// ���ñ���ͼƬ
		imgBackground = new ImageIcon("images\\����JieMian.jpg");// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		background = new JLabel(imgBackground); // �ѱ���ͼƬ���ڱ�ǩjil��
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) this.getContentPane();// �����ݴ���ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		jb2 = new JButton(new ImageIcon("images\\������¼.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("������Բ���������Ա�������");
		jb2.addActionListener(this);
		jb2.setBounds(200, 450, 120, 30);

		jb3 = new JButton(new ImageIcon("images\\������ѯ.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("������Բ�ѯ������Ա����Ϣ��");
		jb3.addActionListener(this);
		jb3.setBounds(360, 450, 120, 30);

		jb4 = new JButton(new ImageIcon("images\\����2.gif"));
		jb4.setFont(new Font("΢���ź�", Font.BOLD, 15));
		jb4.setForeground(Color.blue);
		jb4.setOpaque(false);
		jb4.setToolTipText("������ص�ѡ����棡");
		jb4.addActionListener(this);
		jb4.setBounds(600, 460, 80, 25);

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);

		im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setTitle("����Ա��������Ա����");
		this.setSize(700, 530);
		this.setResizable(false);// ���ƴ����С
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
