package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import java.sql.*;

class TAddStudent extends JFrame implements ActionListener {

	JLabel JL = new JLabel("�� �� ѧ�� �� Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLSno = new JLabel("ѧ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField(); // ����һ���ı������

	JLabel JLDno = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField(); // ����һ���ı������

	JLabel JLSname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSname = new JTextField(); // ����һ���ı������

	JLabel JLSsex = new JLabel("�Ա�:"); // ʹ���ı�����һ����ǩ����
	ButtonGroup BG = new ButtonGroup(); // ����һ��ButtonGroup�������
	JRadioButton JRb1 = new JRadioButton("��");
	JRadioButton JRb2 = new JRadioButton("Ů");

	JLabel JLSbirthday = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("��ͥסַ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSaddress = new JTextField();

	JLabel JLSdept = new JLabel("רҵ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSdept = new JTextField();

	JLabel JLScheckin = new JLabel("��סʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTScheckin = new JTextField();

	JLabel JLSmphone = new JLabel("�ֻ���:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("ѧԺ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("�༶:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSclass = new JTextField();

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");
	JButton jb = new JButton("����");

	String sql = ""; // ����һ���ַ���

	public TAddStudent() // ����AddStudent���캯��
	{
		this.setTitle("����Ա�����ѧ����Ϣ"); // ���ô��ڱ���
		this.setLayout(null); // ���ô��ڲ��ֹ�����
		JL.setBounds(100, 30, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL); // ����ǩ��ӵ�����

		JLSno.setBounds(100, 80, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLSno); // ��ѧ�ű�ǩ��ӵ�����
		JTSno.setBounds(200, 80, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSno); // ���ı�����ӵ�����

		JLSname.setBounds(100, 100, 60, 20); // ����������ǩ�ĳ�ʼλ��
		this.add(JLSname); // ��������ǩ��ӵ�����
		JTSname.setBounds(200, 100, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSname); // ���ı�����ӵ�����

		JLSsex.setBounds(100, 120, 100, 20); // �����Ա��ǩ�ĳ�ʼλ��
		this.add(JLSsex); // ���Ա��ǩ��ӵ�����
		JRb1.setBounds(200, 120, 40, 20);
		JRb2.setBounds(260, 120, 40, 20);
		add(JRb1);
		add(JRb2);
		BG.add(JRb1);
		BG.add(JRb2);

		JLSbirthday.setBounds(100, 140, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSbirthday); // ���༶��ǩ��ӵ�����
		JTSbirthday.setBounds(200, 140, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSbirthday); // ���ı�����ӵ�����

		JLSmphone.setBounds(100, 160, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSmphone); // ���༶��ǩ��ӵ�����
		JTSmphone.setBounds(200, 160, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSmphone);

		JLSqq.setBounds(100, 180, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSqq); // ���༶��ǩ��ӵ�����
		JTSqq.setBounds(200, 180, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSqq);

		JLSmailbox.setBounds(100, 200, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSmailbox); // ���༶��ǩ��ӵ�����
		JTSmailbox.setBounds(200, 200, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSmailbox);

		JLSschool.setBounds(100, 220, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSschool); // ���༶��ǩ��ӵ�����
		JTSschool.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSschool);

		JLSdept.setBounds(100, 240, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSdept); // ���༶��ǩ��ӵ�����
		JTSdept.setBounds(200, 240, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSdept);

		JLSclass.setBounds(100, 260, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSclass); // ���༶��ǩ��ӵ�����
		JTSclass.setBounds(200, 260, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSclass);

		JLDno.setBounds(100, 280, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDno); // ���༶��ǩ��ӵ�����
		JTDno.setBounds(200, 280, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDno);

		JLScheckin.setBounds(100, 300, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLScheckin); // ���༶��ǩ��ӵ�����
		JTScheckin.setBounds(200, 300, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTScheckin);

		JLSaddress.setBounds(100, 320, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSaddress); // ���༶��ǩ��ӵ�����
		JTSaddress.setBounds(200, 320, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSaddress);

		JBAdd.setBounds(80, 350, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		this.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(180, 350, 70, 20); // �������ð�ť�ĳ�ʼλ��
		this.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jb.setBounds(280, 350, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		this.add(jb);// �����ذ�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��
		this.setBounds(500, 330, 420, 450); // ���ô��ڳߴ��С
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
			String Sno = JTSno.getText().trim();// ���ı����а������ı������ַ���snumber
			String Sname = JTSname.getText().trim();// ���ı����а������ı������ַ���sname
			String Sclass = JTSclass.getText().trim();// ���ı����а������ı������ַ���sclass
			String Sqq = JTSqq.getText().trim();
			String Sbirthday = JTSbirthday.getText().trim();
			String Smailbox = JTSmailbox.getText().trim();
			String Saddress = JTSaddress.getText().trim();
			String Sdept = JTSdept.getText().trim();
			String Dno = JTDno.getText().trim();
			String Sschool = JTSschool.getText().trim();
			String Scheckin = JTScheckin.getText().trim();
			String Smphone = JTSmphone.getText().trim();
			String Ssex = "Ů";// ���ص�ѡ��ť��ֵ
			if (JRb1.isSelected())
				Ssex = "��";

			sql = "select Sno from student where Sno='" + Sno + "'";
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				System.out.println("����������ȷ��");
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�SDMSΪ����Դ����
				System.out.println("���ݿ�������ȷ��" + cot);
				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("�ύOK��" + stm);
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);

				if (rs.next())// �жϽ���Ƿ����
					JOptionPane.showMessageDialog(this, "��ѧ���Ѿ�����,�����ظ����!");// ͨ��showMessageDialog()������ӡ��Ϣ
				else {
					sql = "insert into student (" + "Sno,Sname,Sqq,Sclass,"
							+ "Ssex,Sbirthday,Smailbox,"
							+ "Saddress,Sdept,Scheckin,"
							+ "Smphone,Dno,Sschool)" + "values('"
							+ Sno
							+ "','"
							+ Sname
							+ "','"
							+ Sqq
							+ "','"
							+ Sclass
							+ "','"
							+ Ssex
							+ "','"
							+ Sbirthday
							+ "','"
							+ Smailbox
							+ "','"
							+ Saddress
							+ "','"
							+ Sdept
							+ "','"
							+ Scheckin
							+ "','"
							+ Smphone
							+ "','"
							+ Dno
							+ "','" + Sschool + "')";// ����һ������

					int i = stm.executeUpdate(sql); // �����ݿ���и���
					if (i > 0)
						JOptionPane.showMessageDialog(null, "��ӳɹ�!");
					else
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");
				}

				cot.close();
				stm.close();
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == jb) {
			try {
				new TStudent();
				this.dispose();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			JTSno.setText(null);// �����ı���textֵΪnull
			JTSname.setText(null); // �����ı���textֵΪnull
			JTSclass.setText(null);// �����ı���textֵΪnull
			JTSbirthday.setText(null);
			JTSmailbox.setText(null);
			JTSaddress.setText(null);
			JTSdept.setText(null);
			JTScheckin.setText(null);
			JTSmphone.setText(null);
			JTSschool.setText(null);
			JTDno.setText(null);

		}
	}

	public static void main(String args[]) {
		new TAddStudent();
	}
}
