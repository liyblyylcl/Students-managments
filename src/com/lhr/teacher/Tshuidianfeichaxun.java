package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;
import java.util.Vector;

class Tshuidianfeichaxun extends JFrame implements ActionListener {
	JLabel JL = new JLabel("��ѯˮ���", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel JLNumber = new JLabel("�����������:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton jb1 = new JButton("�޸�");
	JButton jb = new JButton("����");
	JTextArea resultarea = new JTextArea();
	String sql = ""; // ����һ���ַ���

	public Tshuidianfeichaxun() // ����SetGrade���캯��
	{
		this.setTitle("����Ա����ѯˮ���");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(150, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����
		JLNumber.setBounds(130, 80, 100, 20);// ��������ű�ǩ�ĳ�ʼλ��
		this.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JTNumber.setBounds(230, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTNumber);// ���ı�����ӵ�����

		JBSet.setBounds(80, 120, 60, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����
		JBNext.setBounds(180, 120, 60, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(280, 120, 60, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		jb1.setBounds(380, 120, 60, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb1);// �����ذ�ť��ӵ�����
		jb1.addActionListener(this);// ����ť��Ӽ�����

		this.add(resultarea);
		resultarea.setBounds(60, 170, 400, 100);
		resultarea.setFont(new Font("����", Font.PLAIN, 12));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		resultarea.setLineWrap(true);

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(10, 10, 540, 400);// ���ô��ڳߴ��С
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

			sql = "select * from WEfee where Dno='" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{
					resultarea
							.setText("�����    ��ʼ����       ��ֹ����     ˮ��(Ԫ) ���(Ԫ)  �ܼ�(Ԫ) "
									+ "\n");
					resultarea.append(rs.getString("Dno") + "     ");
					resultarea.append(rs.getString("StartDate") + "    ");
					resultarea.append(rs.getString("EndDate") + "     ");
					resultarea.append(rs.getString("WaterFee") + "     ");
					resultarea.append(rs.getString("PowerFee") + "     ");
					resultarea.append(rs.getString("TotalSum") + "\n");

				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TeacherJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			resultarea.setText(null);
		}
		if (e.getSource() == jb1)// ����"����"�¼�
		{
			new Txiugaishuidianfei();
			dispose();
		}
	}

	public static void main(String args[]) {
		new Tshuidianfeichaxun();// ʵ����һ������
	}
}
