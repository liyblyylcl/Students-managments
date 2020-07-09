package com.lhr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhr.student.StudentJieMian;
import com.lhr.teacher.TeacherJieMian;

public class SDMSlogin extends JFrame implements ActionListener {

	JPanel  jp, jp1, jp2;
	JLabel jil, jl1, jl2, jl3, jl4;
	JButton jb1, jb2;
	ImageIcon background, im1;
	JTextField jtf;
	JPasswordField jpf;
	JComboBox jc; // ����һ����Ͽ����

	public SDMSlogin() {
		

		jl1 = new JLabel("�û�����");
		jl1.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl1.setForeground(Color.red);
		jl1.setBounds(80, 120, 110, 40);

		jl2 = new JLabel("��   �룺");
		jl2.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl2.setForeground(Color.red);
		jl2.setBounds(80, 160, 110, 40);

		jl4 = new JLabel("��   �ݣ�");
		jl4.setFont(new Font("���Ĳ���", Font.BOLD, 18));
		jl4.setForeground(Color.red);
		jl4.setBounds(80, 200, 110, 40);

		jtf = new JTextField();
		jtf.setBounds(160, 128, 120, 25);
		jpf = new JPasswordField();
		jpf.setBounds(160, 168, 120, 25);
		jc = new JComboBox(); // ����һ����Ͽ����
		jc.setBounds(160, 208, 120, 25); // ������Ͽ�ĳ�ʼλ��

		

		Background.setBackgroundPhoto(this, "images\\�˹��ٲ�.jpg");
		// ע�����,jb1Ϊ��½
		jb1 = new JButton(new ImageIcon("images\\��½.gif"));
		jb1.addActionListener(this);
		jb1.setBounds(100, 245, 65, 33);

		// ע�������jb2Ϊȡ��
		jb2 = new JButton(new ImageIcon("images\\ȡ��.gif"));
		jb2.setOpaque(false);
		jb2.addActionListener(this);
		jb2.setBounds(190, 245, 65, 33);

		
		jp=(JPanel) this.getContentPane();
		jp.add(jl1);
		jp.add(jtf);
		jp.add(jl2);
		jp.add(jpf);
		jp.add(jl4);
		
		jc.addItem(new String("ѧ��")); // ����Ͽ��������
		jc.addItem(new String("����Ա"));
		jp.add(jc); // ����Ͽ������ӵ�����
		
		
		jl3 = new JLabel();
		jl3.add(jb1);
		jl3.add(jb2);
		jp.add(jl3);

		
		im1 = new ImageIcon("images\\tou.jpg");
		this.setIconImage(im1.getImage());
		this.setTitle("22��ѧ���������ϵͳ(SDMS)");
		this.setSize(605, 450);
		this.setResizable(false);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public void actionPerformed(ActionEvent e) {

		String username = jtf.getText();
		String password = jpf.getText();

		if (e.getSource() == jb1) {

			String box = (String) jc.getSelectedItem();// ����ǰ��ѡ����ַ���box

			if (box.equals("����Ա")) {

				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
					Statement stm = cot.createStatement();// �ύ��ѯ
					System.out.println("��������OK�������������ݿ�OK������������������");
					String sql = "select * from AdminInformation  where username= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���

					while (rs.next()) {
						String u = rs.getString("username");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new TeacherJieMian();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "�û������������벻��ȷ��");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�/SDMS.mdb");// �����ݿ����ӣ�student1Ϊ����Դ����
					Statement stm = cot.createStatement();// �ύ��ѯ
					System.out.println("��������OK�������������ݿ�OK������������������");
					String sql = "select * from  student  where Sno= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���

					while (rs.next()) {
						String u = rs.getString("Sno");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new StudentJieMian();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "�û������������벻��ȷ��");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		if (e.getSource() == jb2) {
			try {
				new Homepage();
				this.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		new SDMSlogin();
	}
}
