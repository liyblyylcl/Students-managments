package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class Sgongwubaoxiu extends JFrame implements ActionListener {

	JLabel JL = new JLabel("���ﱨ��", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLDno = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField(); // ����һ���ı������

	JLabel JLName = new JLabel("������Ʒ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTName = new JTextField(); // ����һ���ı������

	JLabel JLno = new JLabel("��Ʒ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTno = new JTextField(); // ����һ���ı������

	JLabel JLSdate = new JLabel("�ύ����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSdate = new JTextField(); // ����һ���ı������

	JLabel JLcause = new JLabel("����ԭ��:"); // ʹ���ı�����һ����ǩ����
	TextArea JTcause = new TextArea(); // ����һ���ı������

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public Sgongwubaoxiu() // ����AddStudent���캯��
	{
		this.setTitle("ѧ������Ʒ����"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����

		JL.setBounds(100, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������

		this.add(JL); // ����ǩ��ӵ�����
		JLDno.setBounds(100, 80, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLDno); // ��ѧ�ű�ǩ��ӵ�����
		JTDno.setBounds(200, 80, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDno); // ���ı�����ӵ�����

		JLSdate.setBounds(100, 105, 60, 20); // ����ѧԺ��ǩ�ĳ�ʼλ��
		this.add(JLSdate); // ��ѧԺ��ǩ��ӵ�����
		JTSdate.setBounds(200, 105, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSdate); // ���ı�����ӵ�����

		JLName.setBounds(100, 130, 60, 20); // ����������ǩ�ĳ�ʼλ��
		this.add(JLName); // ��������ǩ��ӵ�����
		JTName.setBounds(200, 130, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTName); // ���ı�����ӵ�����

		JLno.setBounds(100, 155, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLno); // ���༶��ǩ��ӵ�����
		JTno.setBounds(200, 155, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTno); // ���ı�����ӵ�����

		this.add(JLcause);
		JLcause.setBounds(100, 180, 80, 20);
		this.add(JTcause);
		JTcause.setBounds(200, 180, 100, 75);

		JBAdd.setBounds(70, 300, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(170, 300, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(270, 300, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 330, 430, 430); // ���ô��ڳߴ��С
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
			String Dno = JTDno.getText();// ���ı����а������ı������ַ���snumber
			String Sdate = JTSdate.getText();
			String Name = JTName.getText();// ���ı����а������ı������ַ���sname
			String no = JTno.getText();// ���ı����а������ı������ַ���sclass
			String cause = JTcause.getText();

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("�ύOK��" + stm);
				sql = "insert into RepareInformation (Dno,Rsubmit,Pname,Pno,Reason)values('"
						+ Dno
						+ "',"
						+ "'"
						+ Sdate
						+ "','"
						+ Name
						+ "','"
						+ no
						+ "','" + cause + "')";// ����һ������
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				System.out.println("ִ�����Ϊ��" + sql);
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
				new StudentJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTDno.setText(null);// �����ı���textֵΪnull
			JTName.setText(null); // �����ı���textֵΪnull
			JTno.setText(null);// �����ı���textֵΪnull
			JTSdate.setText(null);// �����ı���textֵΪnull
			JTcause.setText(null);// �����ı���textֵΪnull
		}
	}

	public static void main(String args[]) {
		new Sgongwubaoxiu();
	}
}
