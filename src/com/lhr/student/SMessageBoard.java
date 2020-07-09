package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class SMessageBoard extends JFrame implements ActionListener {

	JLabel JL = new JLabel("���԰�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel jl = new JLabel("����������ʱ�䣺");// ʹ���ı�����һ����ǩ����

	TextArea JTMessage = new TextArea(); // ����һ���ı������
	JTextField JTMtime = new JTextField(); // ����һ���ı������

	JButton JBAdd = new JButton("����"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public SMessageBoard() // ����AddStudent���캯��
	{
		this.setTitle("ѧ�������԰���Ϣ��¼"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����

		JL.setBounds(150, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		this.add(JL); // ����ǩ��ӵ�����

		this.add(jl);
		jl.setBounds(120, 100, 200, 20);
		JTMtime.setBounds(240, 100, 140, 20);
		add(JTMtime);

		this.add(JTMessage);
		JTMessage.setBounds(100, 150, 300, 180);

		JBAdd.setBounds(120, 350, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(220, 350, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(320, 350, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 330, 500, 450); // ���ô��ڳߴ��С
		this.setResizable(false);
		this.setVisible(true); // ���ô��ڵĿɼ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// ����"���"�¼�
		{

			String Message = JTMessage.getText();
			String Mtime = JTMtime.getText();

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				// System.out.println("�ύOK��" + stm);

				sql = "insert into SMessageBoard (Message,Mtime)values('"
						+ Message + "','" + Mtime + "')";// ����һ������
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				// System.out.println("ȡ�ý��OK��" + rs);
				JOptionPane.showMessageDialog(null, "��ӳɹ�!");
				System.out.println("ִ�����Ϊ��" + sql);
				// stm.executeUpdate(sql); // �����ݿ���и���

				cot.close();
				stm.close();
			} catch (Exception ee) {

			}
		}
		if (e.getSource() == jb) {
			try {
				new StudentJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTMessage.setText(null);// �����ı���textֵΪnull
			JTMtime.setText(null);

		}
	}

	public static void main(String args[]) {
		new SMessageBoard();
	}
}
