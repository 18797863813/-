package managerment;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
public class Login extends JFrame{
	private JPanel contentPanel;
	public static JTextField yonghu,passwordField;
	//public static JPasswordField passwordField;
	public static JButton denglu,zhuce;
	public Login(){
		setResizable(false);
		setTitle("��¼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(85,50,1000,1000);
		contentPanel=new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 642);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(217, 229, 454, 241);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel label = new JLabel("�û���:");
		label.setBounds(81, 71, 72, 21);
		panel_1.add(label);
		label.setFont(new Font("����", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("����:");
		label_1.setBounds(95, 120, 54, 21);
		panel_1.add(label_1);
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		
		yonghu = new JTextField();
		yonghu.setBounds(159, 73, 144, 21);
		panel_1.add(yonghu);
		yonghu.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 122, 144, 21);
		panel_1.add(passwordField);
		
		denglu = new JButton("��¼");
		denglu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				String name = yonghu.getText();
				String pwd=passwordField.getText();
				Connection con;
				Statement sql;
				ResultSet rs;
				DBConnection cn=new DBConnection();			
				String sqlstr="SELECT username,passwd FROM `user` where 'passwd=pwd'&'username=name' ";
				 try{
					 sql=cn.conn.createStatement();
					 rs=sql.executeQuery(sqlstr);
					 while(true){					
						 JOptionPane.showMessageDialog(panel_1,"��ϲ"+name+"��½�ɹ�","ȷ��",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							MainFrame frame=new MainFrame();
							frame.setVisible(true);						
							cn.conn.close();
							break;
					 }
					 
				 }catch(SQLException e){
					 JOptionPane.showMessageDialog(panel_1,"�˺Ż����벻������������","ȷ��",JOptionPane.WARNING_MESSAGE);
				 }		
			}				
			
		});
		//denglu.addActionListener(new Test());
		denglu.setFont(new Font("����", Font.PLAIN, 18));
		denglu.setBounds(77, 184, 73, 29);
		panel_1.add(denglu);
		
		JButton chongzhi = new JButton("����");
		panel_1.add(chongzhi);
		chongzhi.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				yonghu.setText("");
				passwordField.setText("");
			}
		});
		chongzhi.setFont(new Font("����", Font.PLAIN, 18));
		chongzhi.setBounds(155, 184, 73, 29);
		
		zhuce=new JButton("ע��");
		//zhuce.addActionListener(new chuangjian());
		zhuce.setFont(new Font("����", Font.PLAIN, 18));
		zhuce.setBounds(235, 184, 73, 29);
		panel_1.add(zhuce);
		zhuce.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				zhuce z=new zhuce();
				z.setVisible(true);
			}			
		});
		}
	}

