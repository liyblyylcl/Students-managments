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

		//���ñ���ͼƬ
		Background.setBackgroundPhoto(this, "images\\���ʸ���.jpg");
		
		// ���ñ�ǩ
		jl = new JLabel("��ӭ����22��ѧ���������ϵͳ");
		jl.setBounds(200, 330, 600, 50);
		jl.setForeground(Color.YELLOW);		
		jl.setFont(new Font("����", Font.BOLD, 40));

		jl1 = new JLabel(
				"Welcome to the student's dormitory management system of the 22nd building"
						+ "!");
		jl1.setFont(new Font("Arial", Font.BOLD, 16));
		jl1.setForeground(Color.red);
		jl1.setBounds(200, 200, 600, 400);

		// ע�����
		im = new ImageIcon("images\\�������.gif");
		jb = new JButton(im);
		jb.setSize(im.getIconWidth() - 10, im.getIconHeight());
		jb.setLocation(835, 670);
//		jb.setOpaque(true);
		jb.setBorderPainted(false);//ȥ����ť�߿�
		jb.addActionListener(this);

		// �����ı���
		textarea = new JTextArea();
		textarea.setForeground(new Color(10, 150, 50));// �����ı���������ɫ
		Font font1 = new Font("����", Font.BOLD, 14);
		textarea.setFont(font1);
		textarea.setBounds(0, 0, 1006, 600);
		BufferedReader fis = new BufferedReader(new FileReader(
				"Informations\\Homepage.txt")); // ��ȡ�ļ�
		String s = fis.readLine();
		while (s != null) {

			textarea.append(s + "\n");
			s = fis.readLine();
		}
		textarea.setOpaque(false);
		textarea.setEditable(false); // �����ı�������

		jp = (JPanel) this.getContentPane();
		jp.setLayout(null);

		jp.add(jl1);
		jp.add(textarea);
		jp.add(jb);
		jp.add(jl);

		im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setTitle("22��ѧ���������ϵͳ(SDMS)");
		this.setSize(1006, 782);
		this.setResizable(false);// ���ƴ����С
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
