package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.SDMSlogin;

import java.sql.*;
import java.util.Vector;

class SxiugaiPassword extends JFrame implements ActionListener {

	JLabel JL = new JLabel("ѧ�������޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLSno = new JLabel("������ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField();// ����һ���ı������

	JLabel JLPassword = new JLabel("ԭ����:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTPassword = new JPasswordField();

	JLabel JLPassword1 = new JLabel("������:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTPassword1 = new JPasswordField();

	JLabel JLRPassword1 = new JLabel("ȷ������:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTRPassword1 = new JPasswordField();

	JButton JBSet = new JButton("�޸�");// ������ť����
	JButton JBNext = new JButton("����");

	JButton jb = new JButton("����");

	public SxiugaiPassword() // ����SetGrade���캯��
	{
		this.setTitle("ѧ����ѧ�������޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLSno.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLSno);// ��ѧ�ű�ǩ��ӵ�����
		JTSno.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTSno);// ���ı�����ӵ�����

		JLPassword.setBounds(100, 150, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPassword); // ���༶��ǩ��ӵ�����
		JTPassword.setBounds(200, 150, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPassword); // ���ı�����ӵ�����

		JLPassword1.setBounds(100, 175, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPassword1); // ���༶��ǩ��ӵ�����
		JTPassword1.setBounds(200, 175, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPassword1); // ���ı�����ӵ�����

		JLRPassword1.setBounds(100, 200, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLRPassword1); // ���༶��ǩ��ӵ�����
		JTRPassword1.setBounds(200, 200, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTRPassword1); // ���ı�����ӵ�����

		JBSet.setBounds(70, 110, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����

		JBNext.setBounds(160, 110, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(249, 110, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(jb);// �����ð�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 300, 400, 350);// ���ô��ڳߴ��С
		this.setVisible(true);// ���ô��ڵĿɼ���
		this.setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // ����"�޸�"�¼�
		{
			String Sno = JTSno.getText();// ���ı����а������ı������ַ���sSno
			String sql = "select * from student where Sno = '" + Sno + "' ";
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ
				System.out.println("��������OK���������ݿ�OK���ύOK��" + cot + stm);
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				if (rs.next()) // �жϽ���Ƿ����
				{

					// System.out.println("���û����ڣ�");
					String password = rs.getString("Password");
					String Password = JTPassword.getText();
					String Password1 = JTPassword1.getText();
					String RPassword1 = JTRPassword1.getText();

					String sql1 = " update student set Password = '"
							+ Password1 + "'  where Sno = '" + Sno + "' ";

					if (password.equals(Password)
							&& (Password1.equals(RPassword1))) {

						int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

						if (n == JOptionPane.YES_OPTION) {

							int n1 = stm.executeUpdate(sql1);

							if (n1 > 0) {
								JOptionPane.showMessageDialog(this,
										"�޸ĳɹ�,������ص���½����!");// ͨ��showMessageDialog()������ӡ��Ϣ
								new SDMSlogin();
							} else
								JOptionPane.showMessageDialog(this, "�޸�ʧ��!");
						} else {
							if (n == JOptionPane.NO_OPTION)
								JOptionPane.showMessageDialog(this, "δִ���޸�!");
						}
					} else {
						if (!(password.equals(Password)))
							JOptionPane.showMessageDialog(this, "ԭ�������벻��ȷ��");
						if (!((Password1.equals(RPassword1))))
							JOptionPane.showMessageDialog(this, "�������������벻ƥ�䣡");
					}

				} else {
					JOptionPane.showMessageDialog(this, "���û�������!");
				}
			} catch (Exception ee) {
			}
		}

		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTSno.setText(null);// �����ı���textֵΪnull
			JTPassword.setText(null);

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			new SSelectStudent();
			dispose();

		}

	}

	public static void main(String args[]) {
		new SxiugaiPassword();// ʵ����һ������
	}
}
