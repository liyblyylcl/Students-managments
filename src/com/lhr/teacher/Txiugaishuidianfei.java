package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Vector;

class Txiugaishuidianfei extends JFrame implements ActionListener {
	JLabel JL = new JLabel("ˮ�������޸�", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLDno = new JLabel("�����������:");// ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField();// ����һ���ı������

	JLabel JLSWDegree = new JLabel("��ʼˮ����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSWDegree = new JTextField();

	JLabel JLEWDegree = new JLabel("��ֹˮ����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTEWDegree = new JTextField();

	JLabel JLSEDegree = new JLabel("��ʼ�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSEDegree = new JTextField();

	JLabel JLEEDegree = new JLabel("��ֹ�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTEEDegree = new JTextField();

	JLabel JLWaterFee = new JLabel("ˮ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTWaterFee = new JTextField();

	JLabel JLPowerFee = new JLabel("���:"); // ʹ���ı�����һ����ǩ����
	JTextField JTPowerFee = new JTextField();

	JLabel JLTotalSum = new JLabel("�ܽ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTTotalSum = new JTextField();

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton JBxiugai = new JButton("�޸�");
	JButton jb = new JButton("����");

	public Txiugaishuidianfei() // ����SetGrade���캯��
	{
		this.setTitle("����Ա��ˮ�������޸�");// ���ô��ڱ���
		this.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		this.add(JL);// ����ǩ��ӵ�����

		JLDno.setBounds(100, 80, 100, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		this.add(JLDno);// ��ѧ�ű�ǩ��ӵ�����
		JTDno.setBounds(200, 80, 100, 20);// �����ı���ĳ�ʼλ��
		this.add(JTDno);// ���ı�����ӵ�����

		JLSWDegree.setBounds(100, 170, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSWDegree); // ���༶��ǩ��ӵ�����
		JTSWDegree.setBounds(200, 170, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSWDegree); // ���ı�����ӵ�����
		JTSWDegree.setEditable(false);

		JLEWDegree.setBounds(100, 195, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLEWDegree); // ���༶��ǩ��ӵ�����
		JTEWDegree.setBounds(200, 195, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTEWDegree); // ���ı�����ӵ�����

		JLSEDegree.setBounds(100, 220, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLSEDegree); // ���༶��ǩ��ӵ�����
		JTSEDegree.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTSEDegree); // ���ı�����ӵ�����
		JTSEDegree.setEditable(false);

		JLEEDegree.setBounds(100, 245, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLEEDegree); // ���༶��ǩ��ӵ�����
		JTEEDegree.setBounds(200, 245, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTEEDegree); // ���ı�����ӵ�����

		JLWaterFee.setBounds(100, 270, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLWaterFee); // ���༶��ǩ��ӵ�����
		JTWaterFee.setBounds(200, 270, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTWaterFee); // ���ı�����ӵ�����

		JLPowerFee.setBounds(100, 295, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLPowerFee); // ���༶��ǩ��ӵ�����
		JTPowerFee.setBounds(200, 295, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTPowerFee); // ���ı�����ӵ�����

		JLTotalSum.setBounds(100, 320, 80, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		this.add(JLTotalSum); // ���༶��ǩ��ӵ�����
		JTTotalSum.setBounds(200, 320, 100, 20); // �����ı���ĳ�ʼλ��
		this.add(JTTotalSum); // ���ı�����ӵ�����

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
			String sDno = JTDno.getText();// ���ı����а������ı������ַ���sDno
			String sql = "select * from WEfee where Dno = '" + sDno + "'";// ������Id����sDno��ѧ����������Ϣ
			try // �쳣����
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
				Connection cot = DriverManager
						.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����

				Statement stm = cot.createStatement();// �ύ��ѯ
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				if (rs.next()) // �жϽ���Ƿ����
				{

					JTSWDegree.setText(rs.getString("SWDegree"));
					JTEWDegree.setText(rs.getString("EWDegree"));
					JTSEDegree.setText(rs.getString("SEDegree"));
					JTEEDegree.setText(rs.getString("EEDegree"));
					JTWaterFee.setText(rs.getString("WaterFee"));
					JTPowerFee.setText(rs.getString("PowerFee"));
					JTTotalSum.setText(rs.getString("TotalSum"));

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

				String sDno = JTDno.getText();

				String SWDegree = JTSWDegree.getText();
				String EWDegree = JTEWDegree.getText();
				String SEDegree = JTSEDegree.getText();
				String EEDegree = JTEEDegree.getText();
				String WaterFee = JTWaterFee.getText();
				String PowerFee = JTPowerFee.getText();
				String TotalSum = JTTotalSum.getText();

				String sql1 = " update WEfee set SWDegree = '" + SWDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql2 = " update WEfee set EWDegree = '" + EWDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql3 = " update WEfee set SEDegree = '" + SEDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql4 = " update WEfee set EEDegree = '" + EEDegree
						+ "'  where Dno = '" + sDno + "' ";
				String sql5 = " update WEfee set WaterFee = '" + WaterFee
						+ "'  where Dno = '" + sDno + "' ";
				String sql6 = " update WEfee set PowerFee = '" + PowerFee
						+ "'  where Dno = '" + sDno + "' ";
				String sql7 = " update WEfee set TotalSum = '" + TotalSum
						+ "'  where Dno = '" + sDno + "' ";

				int n = JOptionPane.showConfirmDialog(this, "��Ҫȷ���޸���?");

				if (n == JOptionPane.YES_OPTION) {

					int n1 = stm.executeUpdate(sql1);// �����ݿ���и���
					stm.executeUpdate(sql2);
					stm.executeUpdate(sql3);
					stm.executeUpdate(sql4);
					stm.executeUpdate(sql5);
					stm.executeUpdate(sql6);
					stm.executeUpdate(sql7);

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
			JTDno.setText(null);// �����ı���textֵΪnull

		}
		if (e.getSource() == jb)// ����"����"�¼�
		{

			new Tshuidianfeichaxun();

			dispose();

		}

	}

	public static void main(String args[]) {
		new Txiugaishuidianfei();// ʵ����һ������
	}
}
