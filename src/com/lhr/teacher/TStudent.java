package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import com.lhr.SDMSlogin;

public class TStudent extends JFrame implements ActionListener {

	JLabel background, jl1, jl2, jl3, jl4;
	JButton jb2, jb3, jb4;
	JPanel jp, imagePanel;
	ImageIcon imgBackground, im, im1;
	JTextArea textarea;

	public TStudent() throws IOException {

		// ���ñ���ͼƬ
		imgBackground = new ImageIcon("images\\002.jpg");// ����ͼƬ,
		// ��������ԴͼƬ����һ��ImageIcon������ʵ������ǩ
		background = new JLabel(imgBackground); // �ѱ���ͼƬ���ڱ�ǩjil��
		background.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground
				.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�ĸ�ʽ��ʹ֮�պ�����������
		imagePanel = (JPanel) this.getContentPane();// �����ݴ���ת��ΪJPanel,�������÷���setOpaque()��ʹ���ݴ���͸��
		imagePanel.setOpaque(false);// �÷���setOpaque()��ʹ���ݴ���͸��
		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����

		jb2 = new JButton(new ImageIcon("images\\������ס.gif"));
		jb2.setOpaque(false);
		jb2.setToolTipText("������Բ�������סѧ����");
		jb2.addActionListener(this);
		jb2.setBounds(200, 420, 120, 33);

		jb3 = new JButton(new ImageIcon("images\\ѧ����ѯ.gif"));
		jb3.setOpaque(false);
		jb3.setToolTipText("������Բ�ѯ���޸�ѧ������Ϣ��");
		jb3.addActionListener(this);
		jb3.setBounds(380, 420, 120, 33);

		jb4 = new JButton(new ImageIcon("images\\����.gif"));
		jb4.setOpaque(false);
		jb4.setToolTipText("������ص�ѡ����棡");
		jb4.addActionListener(this);
		jb4.setBounds(600, 425, 70, 30);

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setTitle("����Ա��ѧ������");
		this.setSize(700, 500);
		this.setResizable(false);// ���ƴ����С
		this.setLocation(380, 260);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb3) {

			new TSelectStudent();
		}
		if (e.getSource() == jb2) {

			new TAddStudent();
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
		new TStudent();
	}
}
