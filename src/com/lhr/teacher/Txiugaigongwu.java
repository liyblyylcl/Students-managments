package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Txiugaigongwu extends JFrame implements ActionListener {
	JLabel JL = new JLabel("���ﱨ������޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLRsubmit = new JLabel("����������:");// ʹ���ı�����һ����ǩ����
	JTextField JTRsubmit = new JTextField();// ����һ���ı������

	JLabel JLDno = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField();

	JLabel JLPno = new JLabel("��Ʒ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTPno = new JTextField();

	JLabel JLRsolvedate = new JLabel("�������:"); // ʹ���ı�����һ����ǩ����
	JTextField JTRsolvedate = new JTextField();

	JLabel JLRepareState = new JLabel("�Ƿ�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTRepareState = new JTextField();

	JLabel JLPname = new JLabel("��Ʒ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTPname = new JTextField();

	JLabel JLReason = new JLabel("ԭ��:"); // ʹ���ı�����һ����ǩ����
	JTextArea JTReason = new JTextArea();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("����");

	public Txiugaigongwu() // ����SetGrade���캯��
	{
		this.setTitle("����Ա�����ﱨ������޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLRsubmit.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLRsubmit);// ��ѧ�ű�ǩ��ӵ�����
		JTRsubmit.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTRsubmit);// ���ı�����ӵ�����

		JLDno.setBounds(100, 170, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDno); // ���༶��ǩ��ӵ�����
		JTDno.setBounds(200, 170, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDno); // ���ı�����ӵ�����
		JTDno.setEditable(false);

		JLPno.setBounds(100, 195, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPno); // ���༶��ǩ��ӵ�����
		JTPno.setBounds(200, 195, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPno); // ���ı�����ӵ�����
		JTPno.setEditable(false);

		JLPname.setBounds(100, 220, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPname); // ���༶��ǩ��ӵ�����
		JTPname.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPname); // ���ı�����ӵ�����
		JTPname.setEditable(false);

		JLRsolvedate.setBounds(100, 245, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLRsolvedate); // ���༶��ǩ��ӵ�����
		JTRsolvedate.setBounds(200, 245, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTRsolvedate); // ���ı�����ӵ�����

		JLRepareState.setBounds(100, 270, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLRepareState); // ���༶��ǩ��ӵ�����
		JTRepareState.setBounds(200, 270, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTRepareState); // ���ı�����ӵ�����

		JLReason.setBounds(100, 300, 80, 45); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLReason); // ���༶��ǩ��ӵ�����
		JTReason.setBounds(200, 300, 100, 45); // �����ı���ĳ�ʼλ��
		this.add(JTReason); // ���ı�����ӵ�����
		JTReason.setEditable(false);

		JBSet.setBounds(110, 110, 80, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		this.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����

		JBNext.setBounds(210, 110, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		JBxiugai.setBounds(110, 140, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(JBxiugai);// �����ð�ť��ӵ�����
		JBxiugai.addActionListener(this);// ����ť��Ӽ�����

		jb.setBounds(210, 140, 80, 20);// �������ð�ť�ĳ�ʼλ��
		this.add(jb);// �����ð�ť��ӵ�����
		jb.addActionListener(this);// ����ť��Ӽ�����

		ImageIcon im1 = new ImageIcon("images\\У��.jpg");
		this.setIconImage(im1.getImage()); // ���ñ���ͼ��

		this.setBounds(500, 300, 400, 400);// ���ô��ڳߴ��С
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
			String sRsubmit = JTRsubmit.getText();// ���ı����а������ı������ַ���sRsubmit
			String sql = "select * from RepareInformation where Rsubmit = '"
					+ sRsubmit + "'";// ������Id����sRsubmit��ѧ����������Ϣ
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					JTDno.setText(rs.getString("Dno"));
					JTPno.setText(rs.getString("Pno"));
					JTRsubmit.setText(rs.getString("Rsubmit"));
					JTRsolvedate.setText(rs.getString("Rsolvedate"));
					JTRepareState.setText(rs.getString("RepareState"));
					JTPname.setText(rs.getString("Pname"));
					JTReason.setText(rs.getString("Reason"));

					int n = stm.executeUpdate(sql);// �����ݿ���и���
					if (n > 0)
						JOptionPane.showMessageDialog(this, "��ѯ�ɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
					else
						JOptionPane.showMessageDialog(this, "��ѯʧ��!");
				} else {
					JOptionPane.showMessageDialog(this, "���û�������!");
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

				String sRsubmit = JTRsubmit.getText();

				String Rsolvedate = JTRsolvedate.getText();
				String RepareState = JTRepareState.getText();

				String sql4 = " update RepareInformation set Rsolvedate = '"
						+ Rsolvedate + "'  where Rsubmit = '" + sRsubmit + "' ";
				String sql5 = " update RepareInformation set RepareState = '"
						+ RepareState + "'  where Rsubmit = '" + sRsubmit
						+ "' ";

				int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql4);
					stm.executeUpdate(sql5);

					if (n1 > 0)
						JOptionPane.showMessageDialog(this, "�޸ĳɹ�!");// ͨ��showMessageDialog()������ӡ��Ϣ
					else
						JOptionPane.showMessageDialog(this, "�޸�ʧ��!");
				} else {
					if (n == JOptionPane.NO_OPTION)
						JOptionPane.showMessageDialog(this, "δִ���޸�!");
				}

			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTRsubmit.setText(null);// �����ı���textֵΪnull

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			new Tgongwubaoxiu();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Txiugaigongwu();// ʵ����һ������
	}
}
