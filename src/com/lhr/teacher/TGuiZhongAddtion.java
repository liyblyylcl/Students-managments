package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TGuiZhongAddtion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("��ӹ�����Ʒ��Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLSno = new JLabel("ѧ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField(); // ����һ���ı������

	JLabel JLSname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSname = new JTextField(); // ����һ���ı������

	JLabel JLGoods = new JLabel("��Ʒ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTGoods = new JTextField(); // ����һ���ı������

	JLabel JLOtime = new JLabel("����ʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTOtime = new JTextField(); // ����һ���ı������

	JLabel JLIntime = new JLabel("����ʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTIntime = new JTextField(); // ����һ���ı������

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public TGuiZhongAddtion() // ����AddStudent���캯��
	{
		this.setTitle("����Ա��������Ʒ��Ϣ��¼"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����

		JL.setBounds(100, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
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

		JLGoods.setBounds(100, 130, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLGoods); // ���༶��ǩ��ӵ�����
		JTGoods.setBounds(200, 130, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTGoods); // ���ı�����ӵ�����

		this.add(JLOtime);
		JLOtime.setBounds(100, 155, 80, 20);
		this.add(JTOtime);
		JTOtime.setBounds(200, 155, 100, 20);

		this.add(JLIntime);
		JLIntime.setBounds(100, 180, 80, 20);
		this.add(JTIntime);
		JTIntime.setBounds(200, 180, 100, 20);

		JBAdd.setBounds(80, 220, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(180, 220, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(280, 220, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 330, 400, 350); // ���ô��ڳߴ��С
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
			String Goods = JTGoods.getText();// ���ı����а������ı������ַ���sclass
			String Otime = JTOtime.getText();
			String Intime = JTIntime.getText();

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("�ύOK��" + stm);

				sql = "insert into ValuablesIOInformation (Sno,Sname,Goods,Otime,Intime)"
						+ "values('"
						+ Sno
						+ "',"
						+ "'"
						+ Sname
						+ "','"
						+ Goods
						+ "','" + Otime + "','" + Intime + "')";// ����һ������
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				System.out.println("ִ�����Ϊ��" + sql);
				int i = stm.executeUpdate(sql); // �����ݿ���и���

				JOptionPane.showMessageDialog(null, "��ӳɹ�!");

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TGuiZhongJieMian();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			JTSname.setText(null);// �����ı���textֵΪnull
			JTSno.setText(null); // �����ı���textֵΪnull
			JTGoods.setText(null);// �����ı���textֵΪnull
			JTOtime.setText(null);// �����ı���textֵΪnull
			JTIntime.setText(null);
		}
	}

	public static void main(String args[]) {
		new TGuiZhongAddtion();
	}
}
