package managerment;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
public class pfix extends JFrame{
		JLabel bianhao,leixing,mingcheng,lianxi;
		JComboBox t2;
		JTextField t1,t3,t4;
		JButton bianji,chongzhi,fanhui;
		public pfix(){
			setVisible(true);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {//�����˳��¼�
				public void windowClosing(WindowEvent e) {
				dispose();//�ͷŵ�ǰ������Դ����������Ϊ���ɼ�
				}
			});
			setTitle("�༭��Ӧ��");
			setBounds(100,100,500,500);
			bianhao=new JLabel("��Ӧ�̱��");
			leixing=new JLabel("��Ӧ������");
			mingcheng=new JLabel("��Ӧ������");
			lianxi=new JLabel("��Ӧ����ϵ��ʽ");
			bianji=new JButton("�༭");
			chongzhi=new JButton("����");
			fanhui=new JButton("����");

			t1=new JTextField();
			t2=new JComboBox();
			t3=new JTextField();
			t4=new JTextField();
			bianhao.setBounds(10, 50, 150, 20);
			leixing.setBounds(10,80,150,20);
			mingcheng.setBounds(10,110,150,20);
			lianxi.setBounds(10,140,150,20);

			t1.setBounds(200,50,100,20);
			t2.setBounds(200,80,100,20);
			t3.setBounds(200,110,100,20);
			t4.setBounds(200,140,100,20);
			
			bianji.setBounds(20,200,60,30);
			chongzhi.setBounds(120,200,60,30);
			fanhui.setBounds(190,200,60,30);
			
			add(bianhao);
			add(leixing);
			add(mingcheng);
			add(lianxi);
			setLayout(null);
			
			t2.addItem("����Ʒ");
			t2.addItem("��Ʒ");
			t2.addItem("��ʳ");
			t2.addItem("�·�");
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			
			add(bianji);
			add(chongzhi);
			add(fanhui);
			
			chongzhi.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					t1.setText("");
					t3.setText("");
					t4.setText("");
				}
				
			});
			
			fanhui.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}		
			});
			bianji.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					update();
				}
				});
		}
		public void update(){
			DBConnection cn=new DBConnection();
			if(t1.getText().equals("")||t3.getText().equals("")||t4.getText().equals(""))
				JOptionPane.showMessageDialog(this,"����Ϊ������������","ȷ��",JOptionPane.WARNING_MESSAGE);
			else{
			String sqlstr="update provider set pclass=?,pname=?,pphone=? where pid=?";
			int ok=0;
			 try{
				 cn.presql=cn.conn.prepareStatement(sqlstr);
				 cn.presql.setString(4, t1.getText());
				 cn.presql.setString(1, t2.getSelectedItem().toString());
				 cn.presql.setString(2, t3.getText());
				 cn.presql.setString(3, t4.getText());
				 ok=cn.presql.executeUpdate(); 
				 cn.conn.close();
				 }
			catch(SQLException e){
				JOptionPane.showMessageDialog(this,"�ù�Ӧ�̱���Ѵ�������������","ȷ��",JOptionPane.WARNING_MESSAGE);
			}
			 if(ok!=0){
				 JOptionPane.showMessageDialog(this,"��ӳɹ�","ȷ��",JOptionPane.INFORMATION_MESSAGE);		 
			 }
		}
		}
}
