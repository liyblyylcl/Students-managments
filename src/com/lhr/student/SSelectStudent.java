package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class SSelectStudent extends JFrame implements ActionListener {
	JLabel JL = new JLabel("ѧ����ѯ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel JLNumber = new JLabel("������ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");
	JButton jb1 = new JButton("�޸�");
	JButton jb2 = new JButton("�����޸�");

	TextArea resultarea = new TextArea();
	String sql = ""; // ����һ���ַ���

	public SSelectStudent() // ����SetGrade���캯��
	{
		this.setTitle("ѧ����������Ϣ��ѯ");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(120, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(120, 80, 120, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JTNumber.setBounds(200, 80, 90, 20);// �����ı���ĳ�ʼλ��
		this.add(JTNumber);// ���ı�����ӵ�����

		JBSet.setBounds(80, 120, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����
		JBNext.setBounds(190, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(300, 120, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		jb1.setBounds(120, 150, 90, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb1);// �����ذ�ť��ӵ�����
		jb1.addActionListener(this);// ����ť��Ӽ�����

		jb2.setBounds(245, 150, 90, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb2);// �����ذ�ť��ӵ�����
		jb2.addActionListener(this);// ����ť��Ӽ�����

		this.add(resultarea);
		resultarea.setFont(new Font("����", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setBounds(45, 190, 380, 150);
		resultarea.setEditable(false);
		// resultarea.setLineWrap(true);

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(10, 10, 480, 420);// ���ô��ڳߴ��С
		this.setResizable(false);
		this.setLocation(500, 300);
		this.setVisible(true);// ���ô��ڵĿɼ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // ����"��ѯ"�¼�
		{
			String snumber = JTNumber.getText();// ���ı����а������ı������ַ���snumber

			sql = "select * from  student  where Sno='" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				if (rs.next()) // �жϽ���Ƿ����
				{
					resultarea.setText(" ѧ�ţ�");
					resultarea.append(rs.getString("Sno") + "\n" + " ������");
					resultarea.append(rs.getString("Sname") + "\n" + " �Ա�");
					resultarea.append(rs.getString("Ssex") + "\n" + " ���գ�");
					resultarea.append(rs.getString("Sbirthday") + "\n"
							+ " QQ  �� ");
					resultarea.append(rs.getString("Sqq") + "\n" + " �ֻ��ţ�");
					resultarea.append(rs.getString("Smphone") + "\n" + " ���䣺");
					resultarea.append(rs.getString("Smailbox") + "\n"
							+ " ��ͥסַ��");
					resultarea.append(rs.getString("Saddress") + "\n" + " ѧԺ��");
					resultarea.append(rs.getString("Sschool") + "\n" + " רҵ��");
					resultarea.append(rs.getString("Sdept") + "\n" + " �༶��");
					resultarea.append(rs.getString("Sclass") + "\n" + " ����ţ�");
					resultarea.append(rs.getString("Dno") + "\n" + " ��סʱ�䣺");
					resultarea.append(rs.getString("Scheckin"));

				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
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
		if (e.getSource() == jb1) {

			new Sxiugaistudent();
			this.dispose();

		}
		if (e.getSource() == jb2) {

			new SxiugaiPassword();
			this.dispose();

		}

		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			resultarea.setText(null);
		}
	}

	public static void main(String args[]) {
		new SSelectStudent();// ʵ����һ������
	}
}
