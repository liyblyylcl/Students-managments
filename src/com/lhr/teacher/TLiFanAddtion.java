package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TLiFanAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("���ѧ���뷵У��Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLSno = new JLabel("ѧ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField(); // ����һ���ı������

	JLabel JLSname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSname = new JTextField(); // ����һ���ı������

	JLabel JLDno = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField(); // ����һ���ı������

	JLabel JLLeavetime = new JLabel("��Уʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTLeavetime = new JTextField(); // ����һ���ı������

	JLabel JLBacktime = new JLabel("��Уʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTBacktime = new JTextField(); // ����һ���ı������

	JLabel JLLBcause = new JLabel("ԭ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTLBcause = new JTextField(); // ����һ���ı������

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public TLiFanAddtion() // ����AddStudent���캯��
	{
		this.setTitle("����Ա��������Ʒ��Ϣ��¼"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����

		JL.setBounds(60, 30, 300, 40); // ���ñ�ǩ�ĳ�ʼλ��
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		this.add(JL); // ����ǩ��ӵ�����

		JLSno.setBounds(100, 80, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLSno); // ��ѧ�ű�ǩ��ӵ�����
		JTSno.setBounds(200, 80, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSno); // ���ı�����ӵ�����

		JLSname.setBounds(100, 105, 60, 20); // ����������ǩ�ĳ�ʼλ��
		this.add(JLSname); // ��������ǩ��ӵ�����
		JTSname.setBounds(200, 105, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSname); // ���ı�����ӵ�����

		JLDno.setBounds(100, 130, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDno); // ���༶��ǩ��ӵ�����
		JTDno.setBounds(200, 130, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDno); // ���ı�����ӵ�����

		this.add(JLLeavetime);
		JLLeavetime.setBounds(100, 155, 80, 20);
		this.add(JTLeavetime);
		JTLeavetime.setBounds(200, 155, 100, 20);

		this.add(JLBacktime);
		JLBacktime.setBounds(100, 180, 80, 20);
		this.add(JTBacktime);
		JTBacktime.setBounds(200, 180, 100, 20);

		this.add(JLLBcause);
		JLLBcause.setBounds(100, 205, 80, 20);
		this.add(JTLBcause);
		JTLBcause.setBounds(200, 205, 100, 20);

		JBAdd.setBounds(80, 240, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(180, 240, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(280, 240, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 330, 450, 380); // ���ô��ڳߴ��С
		this.setVisible(true); // ���ô��ڵĿɼ���
		this.setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// ����"���"�¼�
		{
			String Sname = JTSname.getText();// ���ı����а������ı������ַ���snumber
			String Sno = JTSno.getText();// ���ı����а������ı������ַ���sname
			String Dno = JTDno.getText();// ���ı����а������ı������ַ���sclass
			String Leavetime = JTLeavetime.getText();
			String Backtime = JTBacktime.getText();
			String LBcause = JTLBcause.getText();

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("�ύOK��" + stm);

				sql = "insert into LeaveBackSchool (Sno,Sname,Dno,Leavetime,Backtime,LBcause)"
						+ "values('"
						+ Sno
						+ "',"
						+ "'"
						+ Sname
						+ "','"
						+ Dno
						+ "','"
						+ Leavetime
						+ "','"
						+ Backtime
						+ "','"
						+ LBcause + "')";// ����һ������
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				System.out.println("ִ�����Ϊ��" + sql);
				stm.executeUpdate(sql); // �����ݿ���и���

				JOptionPane.showMessageDialog(null, "��ӳɹ�!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TLiFanJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			JTSname.setText(null);// �����ı���textֵΪnull
			JTSno.setText(null); // �����ı���textֵΪnull
			JTDno.setText(null);// �����ı���textֵΪnull
			JTLeavetime.setText(null);// �����ı���textֵΪnull
			JTBacktime.setText(null);
			JTLBcause.setText(null);
		}
	}

//	public static void main(String args[]) {
//		new TLiFanAddtion();
//	}
}
