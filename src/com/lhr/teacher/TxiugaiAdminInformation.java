package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.SDMSlogin;

import java.sql.*;
import java.util.Vector;

class TxiugaiAdminInformation extends JFrame implements ActionListener {

	JLabel JL = new JLabel("����Ա�����޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLUser = new JLabel("�������û���:");// ʹ���ı�����һ����ǩ����
	JTextField JTUser = new JTextField();// ����һ���ı������

	JLabel JLusername1 = new JLabel("���û���:"); // ʹ���ı�����һ����ǩ����
	JTextField JTusername1 = new JTextField();

	JLabel JLPassword = new JLabel("ԭ����:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTPassword = new JPasswordField();

	JLabel JLPassword1 = new JLabel("������:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTPassword1 = new JPasswordField();

	JLabel JLRPassword1 = new JLabel("ȷ������:"); // ʹ���ı�����һ����ǩ����
	JPasswordField JTRPassword1 = new JPasswordField();

	JButton JBSet = new JButton("�޸�");// ������ť����
	JButton JBNext = new JButton("����");

	JButton jb = new JButton("����");

	public TxiugaiAdminInformation() // ����SetGrade���캯��
	{
		this.setTitle("����Ա������Ա��Ϣ�޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLUser.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLUser);// ��ѧ�ű�ǩ��ӵ�����
		JTUser.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTUser);// ���ı�����ӵ�����

		JLusername1.setBounds(100, 170, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLusername1);// ��ѧ�ű�ǩ��ӵ�����
		JTusername1.setBounds(200, 170, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTusername1);// ���ı�����ӵ�����

		JLPassword.setBounds(100, 195, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPassword); // ���༶��ǩ��ӵ�����
		JTPassword.setBounds(200, 195, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPassword); // ���ı�����ӵ�����

		JLPassword1.setBounds(100, 220, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPassword1); // ���༶��ǩ��ӵ�����
		JTPassword1.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPassword1); // ���ı�����ӵ�����

		JLRPassword1.setBounds(100, 245, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLRPassword1); // ���༶��ǩ��ӵ�����
		JTRPassword1.setBounds(200, 245, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTRPassword1); // ���ı�����ӵ�����

		JBSet.setBounds(65, 120, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����

		JBNext.setBounds(155, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(245, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
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
			String User = JTUser.getText();// ���ı����а������ı������ַ���sUser
			String sql = "select * from AdminInformation where username = '"
					+ User + "' ";
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
					String username1 = JTusername1.getText();
					String Password = JTPassword.getText();
					String Password1 = JTPassword1.getText();
					String RPassword1 = JTRPassword1.getText();

					String sql1 = " update AdminInformation set username = '"
							+ username1 + "'  where username = '" + User + "' ";

					String sql2 = " update AdminInformation set Password = '"
							+ Password1 + "'  where username = '" + username1
							+ "' ";

					if (password.equals(Password)
							&& (Password1.equals(RPassword1))) {

						int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

						if (n == JOptionPane.YES_OPTION) {

							int n1 = stm.executeUpdate(sql1);// �����ݿ���и���
							stm.executeUpdate(sql2);

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
			JTUser.setText(null);// �����ı���textֵΪnull
			JTPassword.setText(null);

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			try {
				new TeacherJieMian();
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			dispose();

		}

	}

	public static void main(String args[]) {
		new TxiugaiAdminInformation();// ʵ����һ������
	}
}
