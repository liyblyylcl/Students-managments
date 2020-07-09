package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class TLiFanchaxun extends JFrame implements ActionListener {
	JLabel JL = new JLabel("ѧ���뷵У��Ϣ��ѯ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel JLSno = new JLabel("������ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField();// ����һ���ı������

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	JTextArea resultarea = new JTextArea();
	String sql = ""; // ����һ���ַ���

	public TLiFanchaxun() // ����SetGrade���캯��
	{
		this.setTitle("����Ա��ѧ���뷵У��Ϣ��ѯ");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(130, 30, 240, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLSno.setBounds(130, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLSno);// ��ѧ�ű�ǩ��ӵ�����
		JTSno.setBounds(230, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTSno);// ���ı�����ӵ�����

		JBSet.setBounds(100, 120, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����
		JBNext.setBounds(205, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(310, 120, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		this.add(resultarea);
		resultarea.setBounds(60, 170, 380, 150);
		resultarea.setFont(new Font("����", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		// resultarea.setLineWrap(true);

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(10, 10, 500, 400);// ���ô��ڳߴ��С
		this.setLocation(500, 300);
		this.setResizable(false);
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
			String Sno = JTSno.getText();// ���ı����а������ı������ַ���snumber

			sql = "select * from  LeaveBackSchool where Sno='" + Sno + "'";// ������Id����snumber��ѧ����������Ϣ

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
				System.out.println("�������ݿ�ɹ���");
				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				if (rs.next()) // �жϽ���Ƿ����
				{
					resultarea.setText(" ��  �� ��");
					resultarea.append(rs.getString("Sname") + "\n" + " ѧ  �� ��");
					resultarea.append(rs.getString("Sno") + "\n" + " ����� ��");
					resultarea.append(rs.getString("Dno") + "\n" + " ��Уʱ�� ��");
					resultarea.append(rs.getString("Leavetime") + "\n"
							+ " ��Уʱ�� ��");
					resultarea.append(rs.getString("Backtime") + "\n"
							+ " ԭ  �� ��");
					resultarea.append(rs.getString("LBcause"));

				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
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
			JTSno.setText(null);// �����ı���textֵΪnull
			resultarea.setText(null);
		}
	}

	public static void main(String args[]) {
		new TLiFanchaxun();// ʵ����һ������
	}
}
