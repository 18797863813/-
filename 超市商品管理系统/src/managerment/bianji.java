package managerment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class bianji extends JFrame{
	public static JLabel bianhao,leixing,mingcheng,jiage,shuliang,pmingcheng;
	public static JTextField t1,t2,t3,t4,t5,t6;
	public static JButton bianji,chongzhi,fanhui;
	bianji(){
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {//监听退出事件
			public void windowClosing(WindowEvent e) {
			dispose();//释放当前窗口资源，并且设置为不可见
			}
		});
		setTitle("编辑商品");
		setBounds(100,100,500,500);
		bianhao=new JLabel("编号");
		leixing=new JLabel("类型");
		mingcheng=new JLabel("名称");
		jiage=new JLabel("价格");
		shuliang=new JLabel("数量");
		pmingcheng=new JLabel("供应商名称");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		bianji=new JButton("编辑");
		chongzhi=new JButton("重置");
		fanhui=new JButton("返回");

		add(bianhao);
		add(leixing);
		add(mingcheng);
		add(jiage);
		add(shuliang);
		add(pmingcheng);
		setLayout(null);

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);

		add(chongzhi);
		add(bianji);
		add(fanhui);
		
		bianhao.setBounds(10, 50, 100, 20);
		leixing.setBounds(10,80,100,20);
		mingcheng.setBounds(10,110,100,20);
		jiage.setBounds(10,140,50,20);
		shuliang.setBounds(10,170,50,20);
		pmingcheng.setBounds(10,200,70,20);
		t1.setBounds(100,50,100,20);
		t2.setBounds(100,80,100,20);
		t3.setBounds(100,110,100,20);
		t4.setBounds(100,140,100,20);
		t5.setBounds(100,170,100,20);
		t6.setBounds(100,200,100,20);
		
		bianji.setBounds(50,250,60,30);
		chongzhi.setBounds(120,250,60,30);
		fanhui.setBounds(190,250,60,30);
	
			
		
		chongzhi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
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
		if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals(""))
			JOptionPane.showMessageDialog(this,"不能为空请重新输入","确定",JOptionPane.WARNING_MESSAGE);
		else{
		String sqlstr="update goods set class=?,name=?,price=?,num=? ,pname=? where id=?";
		int ok=0;
		 try{
			 cn.presql=cn.conn.prepareStatement(sqlstr);
			 cn.presql.setString(6, t1.getText());
			 cn.presql.setString(1, t2.getText());
			 cn.presql.setString(2, t3.getText());
			 cn.presql.setString(3, t4.getText());
			 cn.presql.setString(4, t5.getText());
			 cn.presql.setString(5, t6.getText());
			 ok=cn.presql.executeUpdate(); 
			 cn.conn.close();
			 }
		catch(SQLException e){
			JOptionPane.showMessageDialog(this,"该供应商编号已存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
		}
		 if(ok!=0){
			 JOptionPane.showMessageDialog(this,"编辑成功","确定",JOptionPane.INFORMATION_MESSAGE);		 
		 }
	}
	}
}