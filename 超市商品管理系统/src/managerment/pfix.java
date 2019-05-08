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
			this.addWindowListener(new WindowAdapter() {//监听退出事件
				public void windowClosing(WindowEvent e) {
				dispose();//释放当前窗口资源，并且设置为不可见
				}
			});
			setTitle("编辑供应商");
			setBounds(100,100,500,500);
			bianhao=new JLabel("供应商编号");
			leixing=new JLabel("供应商类型");
			mingcheng=new JLabel("供应商名称");
			lianxi=new JLabel("供应商联系方式");
			bianji=new JButton("编辑");
			chongzhi=new JButton("重置");
			fanhui=new JButton("返回");

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
			
			t2.addItem("日用品");
			t2.addItem("饮品");
			t2.addItem("零食");
			t2.addItem("衣服");
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
				JOptionPane.showMessageDialog(this,"不能为空请重新输入","确定",JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(this,"该供应商编号已存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
			}
			 if(ok!=0){
				 JOptionPane.showMessageDialog(this,"添加成功","确定",JOptionPane.INFORMATION_MESSAGE);		 
			 }
		}
		}
}
