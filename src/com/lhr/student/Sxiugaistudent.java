package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Sxiugaistudent extends JFrame implements ActionListener {
	JLabel JL = new JLabel("������Ϣ�޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLNumber = new JLabel("������ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JLabel JLName = new JLabel("����:");// ʹ���ı�����һ����ǩ����
	JTextField JTName = new JTextField();// ����һ���ı������

	JLabel JLSname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSname = new JTextField(); // ����һ���ı������

	JLabel JLSbirthday = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("��ͥסַ:"); // ʹ���ı�����һ����ǩ����
	JTextArea JTSaddress = new JTextArea();

	JLabel JLSdept = new JLabel("רҵ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSdept = new JTextField();

	JLabel JLSmphone = new JLabel("�ֻ���:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("ѧԺ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("�༶:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSclass = new JTextField();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("����");

	public Sxiugaistudent() // ����SetGrade���캯��
	{
		this.setTitle("ѧ����������Ϣ�޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JTNumber.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTNumber);// ���ı�����ӵ�����

		JLName.setBounds(100, 140, 60, 20);// ����������ǩ�ĳ�ʼλ��
		this.add(JLName);// ��������ǩ��ӵ�����
		JTName.setBounds(200, 140, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTName);// ���ı�����ӵ�����

		JLSbirthday.setBounds(100, 165, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSbirthday); // ���༶��ǩ��ӵ�����
		JTSbirthday.setBounds(200, 165, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSbirthday); // ���ı�����ӵ�����

		JLSmphone.setBounds(100, 190, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSmphone); // ���༶��ǩ��ӵ�����
		JTSmphone.setBounds(200, 190, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSmphone);

		JLSqq.setBounds(100, 215, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSqq); // ���༶��ǩ��ӵ�����
		JTSqq.setBounds(200, 215, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSqq);

		JLSmailbox.setBounds(100, 240, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSmailbox); // ���༶��ǩ��ӵ�����
		JTSmailbox.setBounds(200, 240, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSmailbox);

		JLSschool.setBounds(100, 265, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSschool); // ���༶��ǩ��ӵ�����
		JTSschool.setBounds(200, 265, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSschool);

		JLSdept.setBounds(100, 290, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSdept); // ���༶��ǩ��ӵ�����
		JTSdept.setBounds(200, 290, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSdept);

		JLSclass.setBounds(100, 315, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSclass); // ���༶��ǩ��ӵ�����
		JTSclass.setBounds(200, 315, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSclass);

		JLSaddress.setBounds(100, 340, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSaddress); // ���༶��ǩ��ӵ�����
		JTSaddress.setBounds(200, 340, 100, 45); // �����ı���ĳ�ʼλ��
		this.add(JTSaddress);
		JTSaddress.setLineWrap(true);

		JBSet.setBounds(48, 110, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����

		JBNext.setBounds(140, 110, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		JBxiugai.setBounds(230, 110, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBxiugai);// �����ð�ť��ӵ�����
		JBxiugai.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(320, 110, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(jb);// �����ð�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 300, 450, 500);// ���ô��ڳߴ��С
		this.setVisible(true);// ���ô��ڵĿɼ���
		this.setResizable(false);
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
			String sql = "select * from student where Sno='" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					JTName.setText(rs.getString("Sname"));// ���ַ���name��ʾ���ı�����
					JTSbirthday.setText(rs.getString("Sbirthday"));
					JTSmphone.setText(rs.getString("Smphone"));
					JTSqq.setText(rs.getString("Sqq"));
					JTSmailbox.setText(rs.getString("Smailbox"));
					JTSschool.setText(rs.getString("Sschool"));
					JTSdept.setText(rs.getString("Sdept"));
					JTSclass.setText(rs.getString("Sclass"));
					JTSaddress.setText(rs.getString("Saddress"));

					int n = stm.executeUpdate(sql);// �����ݿ���и���
					if (n > 0)
						JOptionPane.showMessageDialog(null, "��ѯ�ɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
					else
						JOptionPane.showMessageDialog(null, "��ѯʧ��!");
				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBxiugai) // ����"�޸�"�¼�
		{

			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ

				String snumber = JTNumber.getText();
				String Sname = JTName.getText();
				String Sbirthday = JTSbirthday.getText();
				String Smphone = JTSmphone.getText();
				String Sqq = JTSqq.getText();
				String Smailbox = JTSmailbox.getText();
				String Sschool = JTSschool.getText();
				String Sdept = JTSdept.getText();
				String Sclass = JTSclass.getText();
				String Saddress = JTSaddress.getText();

				String sql1 = " update student set Sname = '" + Sname
						+ "'  where Sno = '" + snumber + "' ";

				String sql2 = " update student set Sbirthday = '" + Sbirthday
						+ "'  where Sno = '" + snumber + "' ";

				String sql3 = " update student set Smphone = '" + Smphone
						+ "'  where Sno = '" + snumber + "' ";
				String sql4 = " update student set Sqq = '" + Sqq
						+ "'  where Sno = '" + snumber + "' ";
				String sql5 = " update student set Smailbox = '" + Smailbox
						+ "'  where Sno = '" + snumber + "' ";
				String sql6 = " update student set Sschool = '" + Sschool
						+ "'  where Sno = '" + snumber + "' ";
				String sql7 = " update student set Sdept = '" + Sdept
						+ "'  where Sno = '" + snumber + "' ";
				String sql8 = " update student set Sclass = '" + Sclass
						+ "'  where Sno = '" + snumber + "' ";
				String sql9 = " update student set Saddress = '" + Saddress
						+ "'  where Sno = '" + snumber + "' ";

				int n = stm.executeUpdate(sql1);// �����ݿ���и�
				stm.executeUpdate(sql2);// �����ݿ���и���
				stm.executeUpdate(sql3);
				stm.executeUpdate(sql4);
				stm.executeUpdate(sql5);
				stm.executeUpdate(sql6);
				stm.executeUpdate(sql7);
				stm.executeUpdate(sql8);
				stm.executeUpdate(sql9);

				if (n > 0)
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
				else
					JOptionPane.showMessageDialog(null, "�޸�ʧ��!");

			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			JTName.setText(null);// �����ı���textֵΪnull

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			new SSelectStudent();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Sxiugaistudent();// ʵ����һ������
	}
}
