package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class TxiugaiWeisheng extends JFrame implements ActionListener {
	JLabel JL = new JLabel("������������޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLNumber = new JLabel("�����������:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JLabel JLTotalPoints = new JLabel("�ܷ�:"); // ʹ���ı�����һ����ǩ����
	JTextField JTTotalPoints = new JTextField();

	JLabel JLDeduction = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDeduction = new JTextField();

	JLabel JLRanking = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTRanking = new JTextField();

	JLabel JLDCause = new JLabel("����ԭ��:"); // ʹ���ı�����һ����ǩ����
	JTextArea JTDCause = new JTextArea();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("����");

	public TxiugaiWeisheng() // ����SetGrade���캯��
	{
		this.setTitle("����Ա��������������޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JTNumber.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTNumber);// ���ı�����ӵ�����

		JLTotalPoints.setBounds(100, 170, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLTotalPoints); // ���༶��ǩ��ӵ�����
		JTTotalPoints.setBounds(200, 170, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTTotalPoints); // ���ı�����ӵ�����

		JLDeduction.setBounds(100, 195, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDeduction); // ���༶��ǩ��ӵ�����
		JTDeduction.setBounds(200, 195, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTDeduction); // ���ı�����ӵ�����

		JLRanking.setBounds(100, 220, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLRanking); // ���༶��ǩ��ӵ�����
		JTRanking.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTRanking); //

		JLDCause.setBounds(100, 245, 60, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLDCause); // ���༶��ǩ��ӵ�����
		JTDCause.setBounds(200, 245, 100, 50); // �����ı���ĳ�ʼλ��
		this.add(JTDCause); // ���ı�����ӵ�����
		JTDCause.setLineWrap(true);
		JTDCause.setEditable(false);

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
			String snumber = JTNumber.getText();// ���ı����а������ı������ַ���snumber
			String sql = "select * from health where Dno = '" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					JTTotalPoints.setText(rs.getString("TotalPoints"));
					JTDeduction.setText(rs.getString("Deduction"));
					JTRanking.setText(rs.getString("Ranking"));
					JTDCause.setText(rs.getString("DCause"));

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

				String snumber = JTNumber.getText();

				String TotalPoints = JTTotalPoints.getText();
				String Deduction = JTDeduction.getText();
				String Ranking = JTRanking.getText();
				String DCause = JTDCause.getText();

				String sql1 = " update health set TotalPoints = '"
						+ TotalPoints + "'  where Dno = '" + snumber + "' ";
				String sql2 = " update health set Deduction = '" + Deduction
						+ "'  where Dno = '" + snumber + "' ";
				String sql3 = " update health set DCause = '" + DCause
						+ "'  where Dno = '" + snumber + "' ";
				String sql4 = " update health set Ranking = '" + Ranking
						+ "'  where Dno = '" + snumber + "' ";

				int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql1);// �����ݿ���и���
					stm.executeUpdate(sql2);
					stm.executeUpdate(sql3);
					stm.executeUpdate(sql4);

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
			JTNumber.setText(null);// �����ı���textֵΪnull

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			new Tweishengchaxun();

			dispose();

		}

	}

	public static void main(String args[]) {
		new TxiugaiWeisheng();// ʵ����һ������
	}
}
