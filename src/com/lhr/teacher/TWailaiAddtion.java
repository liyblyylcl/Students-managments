package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TWailaiAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("���������Ա��Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLOname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOname = new JTextField(); // ����һ���ı������

	JLabel JLOsex = new JLabel("�Ա�:"); // ʹ���ı�����һ����ǩ����
	ButtonGroup BG = new ButtonGroup(); // ����һ��ButtonGroup�������
	JRadioButton JRb1 = new JRadioButton("��");
	JRadioButton JRb2 = new JRadioButton("Ů");

	JLabel JLOIDtype = new JLabel("֤������:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOIDtype = new JTextField(); // ����һ���ı������

	JLabel JLOIDno = new JLabel("֤����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOIDno = new JTextField(); // ����һ���ı������

	JLabel JLOINtime = new JLabel("����ʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOINtime = new JTextField(); // ����һ���ı������

	JLabel JLOOUTtime = new JLabel("��ȥʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOOUTtime = new JTextField(); // ����һ���ı������

	JLabel JLOcause = new JLabel("����ԭ��:"); // ʹ���ı�����һ����ǩ����
	TextArea JTOcause = new TextArea(); // ����һ���ı������

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public TWailaiAddtion() // ����AddStudent���캯��
	{
		this.setTitle("����Ա��������Ա��Ϣ��¼"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����

		JL.setBounds(100, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		this.add(JL); // ����ǩ��ӵ�����

		JLOname.setBounds(100, 80, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLOname); // ��ѧ�ű�ǩ��ӵ�����
		JTOname.setBounds(200, 80, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTOname); // ���ı�����ӵ�����

		JLOsex.setBounds(100, 105, 100, 20); // �����Ա��ǩ�ĳ�ʼλ��
		this.add(JLOsex); // ���Ա��ǩ��ӵ�����
		JRb1.setBounds(200, 105, 40, 20);
		JRb2.setBounds(260, 105, 40, 20);
		add(JRb1);
		add(JRb2);
		BG.add(JRb1);
		BG.add(JRb2);

		JLOIDtype.setBounds(100, 130, 60, 20); // ����������ǩ�ĳ�ʼλ��
		this.add(JLOIDtype); // ��������ǩ��ӵ�����
		JTOIDtype.setBounds(200, 130, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTOIDtype); // ���ı�����ӵ�����

		JLOIDno.setBounds(100, 155, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLOIDno); // ���༶��ǩ��ӵ�����
		JTOIDno.setBounds(200, 155, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTOIDno); // ���ı�����ӵ�����

		this.add(JLOcause);
		JLOcause.setBounds(100, 180, 80, 20);
		this.add(JTOcause);
		JTOcause.setBounds(200, 180, 100, 70);

		this.add(JLOINtime);
		JLOINtime.setBounds(100, 265, 80, 20);
		this.add(JTOINtime);
		JTOINtime.setBounds(200, 265, 100, 20);

		this.add(JLOOUTtime);
		JLOOUTtime.setBounds(100, 290, 80, 20);
		this.add(JTOOUTtime);
		JTOOUTtime.setBounds(200, 290, 100, 20);

		JBAdd.setBounds(80, 330, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(180, 330, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(280, 330, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 330, 450, 450); // ���ô��ڳߴ��С
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
			String Oname = JTOname.getText();// ���ı����а������ı������ַ���snumber
			String OIDtype = JTOIDtype.getText();// ���ı����а������ı������ַ���sname
			String OIDno = JTOIDno.getText();// ���ı����а������ı������ַ���sclass
			String Ocause = JTOcause.getText();
			String OINtime = JTOINtime.getText();
			String OOUTtime = JTOOUTtime.getText();

			String Osex = "Ů";// ���ص�ѡ��ť��ֵ
			if (JRb1.isSelected())
				Osex = "��";

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("�ύOK��" + stm);

				sql = "insert into OutsideMen (Oname,Osex,Ocause,OIDno,OIDtype,OINtime,OOUTtime)"
						+ "values('"
						+ Oname
						+ "',"
						+ "'"
						+ Osex
						+ "','"
						+ Ocause
						+ "','"
						+ OIDno
						+ "','"
						+ OIDtype
						+ "','"
						+ OINtime + "','" + OOUTtime + "')";// ����һ������

				int i = stm.executeUpdate(sql); // �����ݿ���и���
				if (i > 0)
					JOptionPane.showMessageDialog(null, "��ӳɹ�!");
				else
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TWailaiJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			JTOname.setText(null);// �����ı���textֵΪnull
			JTOIDtype.setText(null); // �����ı���textֵΪnull
			JTOIDno.setText(null);// �����ı���textֵΪnull
			JTOcause.setText(null);// �����ı���textֵΪnull
			JTOINtime.setText(null);
			JTOcause.setText(null);
			JTOOUTtime.setText(null);
		}
	}

	public static void main(String args[]) {
		new TWailaiAddtion();
	}
}
