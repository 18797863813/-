package managerment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class zhuce extends JFrame{
	public zhuce(){
		setResizable(false);
		setTitle("注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 15, 834, 642);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(50,100, 200, 401);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel label = new JLabel("用户名:");
		label.setBounds(50, 100, 71, 21);
		panel_1.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("密码:");
		label_1.setBounds(50, 130,71, 21);
		panel_1.add(label_1);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		final JTextField yonghu = new JTextField();
		yonghu.setBounds(120, 100, 90, 21);
		panel_1.add(yonghu);
		yonghu.setColumns(10);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(120, 130, 90, 21);
		panel_1.add(passwordField);
		
		JLabel label_11 = new JLabel("再一次:");
		label_11.setBounds(50, 160, 91, 21);
		panel_1.add(label_11);
		label_11.setFont(new Font("宋体", Font.PLAIN, 18));
		
		final JPasswordField passwordField1 = new JPasswordField();
		passwordField1.setBounds(120, 160, 90, 21);
		panel_1.add(passwordField1);
		
		JButton queding=new JButton("确定");
		panel_1.add(queding);
		queding.setBounds(70,190,60,30);
		JButton quxiao=new JButton("取消");
		panel_1.add(quxiao);
		quxiao.setBounds(140,190,60, 30);
		quxiao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}		
		});
		queding.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name = yonghu.getText();
				String pwd=passwordField.getText();
				Connection con;
				PreparedStatement presql;
				ResultSet rs = null;
				DBConnection cn=new DBConnection();
				String sqlstr="INSERT INTO user values(?,?)";
				int ok=0;
				if(!pwd.equals(passwordField1.getText()))
					JOptionPane.showMessageDialog(panel_1,"请重新输入","确定",JOptionPane.WARNING_MESSAGE);
				else{
				 try{
					 presql=cn.conn.prepareStatement(sqlstr);
					 presql.setString(1, name);
					 presql.setString(2, pwd);
					 ok=presql.executeUpdate(); 
					 cn.conn.close();
					 }
				catch(SQLException e){
					JOptionPane.showMessageDialog(panel_1,"该用户已存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
				}
				 if(ok!=0){
					 JOptionPane.showMessageDialog(panel_1,"恭喜"+name+"注册成功","确定",JOptionPane.INFORMATION_MESSAGE);
					 dispose();			 
				 }
				}
			}
		});
	}
}
