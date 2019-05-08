package managerment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
public class goods extends JFrame{
	JPanel contentPane;
	int windowwidth=850;
	int windowheight=680;
	JMenuBar bar;
	JMenu mu;
	JPanel m1,m2,m3;
	JMenuItem mi1;
	JComboBox b1;
	JButton i1,i2,i3,i4,i5,i6,i7;
	JLabel fangsi,neirong;
	JTextField t1;
	//JScrollPane jScrollPane;
	private Component jTable;
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	public static int count;
	goods(){
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {//�����˳��¼�
			public void windowClosing(WindowEvent e) {
			dispose();//�ͷŵ�ǰ������Դ����������Ϊ���ɼ�
			}
		});
		setResizable(false);
		setTitle("��Ʒ��Ϣ����");
		setBounds(50,85,800,800);
		this.setVisible(true);
		m1=new JPanel();
		m2=new JPanel();
		m3=new JPanel();
		i1=new JButton("���");
		i2=new JButton("��ѯ");
		i3=new JButton("��ʾ");
		i4=new JButton("�༭");
		i5=new JButton("ɾ��");
		i6=new JButton("ͳ��");
		i7=new JButton("����");
		m1.add(i1);
		m1.add(i2);
		m1.add(i3);
		m1.add(i4);
		m1.add(i5);
		m1.add(i6);
		m1.add(i7);
		m1.setLayout(new GridLayout(1, 8));
		add(m1,BorderLayout.NORTH);
		scpDemo = new JScrollPane(jTable);
		m3=new JPanel(new GridLayout(1,1));
		m3.add(scpDemo);
		add(m3,BorderLayout.CENTER);
				
		m2=new JPanel(new GridLayout(3, 2));
		add(m2,BorderLayout.SOUTH);
		fangsi=new JLabel("��ѯ��ʽ");
		neirong=new JLabel("������Ҫ��ѯ������");

		t1=new JTextField();
		b1=new JComboBox();
		b1.addItem("�����");
		b1.addItem("������");
		b1.addItem("������");
		m2.add(fangsi);m2.add(b1);
		m2.add(neirong);m2.add(t1);

		fangsi.setVisible(false);
		b1.setVisible(false);
		neirong.setVisible(false);
		t1.setVisible(false);
			
		String sql = "select * from goods";
		query(sql);	

		i1.addActionListener(new ActionListener(){//���
			public void actionPerformed(ActionEvent arg0) {	
				new Tianjia();				
			}			
		});
		i2.addActionListener(new ActionListener(){//��ѯ

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fangsi.setVisible(true);
				b1.setVisible(true);
				neirong.setVisible(true);
				t1.setVisible(true);
				select();
				t1.setText("");
			}		
		});
		i3.addActionListener(new ActionListener(){//��ʾ

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				fangsi.setVisible(false);
				b1.setVisible(false);
				neirong.setVisible(false);
				t1.setVisible(false);
				String sql = "select * from goods";
				query(sql);
			}		
		});
		i4.addActionListener(new ActionListener(){//�༭

			public void actionPerformed(ActionEvent arg0) {
				fangsi.setVisible(false);
				b1.setVisible(false);
				neirong.setVisible(false);
				t1.setVisible(false);
				new bianji();
			}		
		});
		i5.addActionListener(new ActionListener(){//ɾ��

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				String sql = "select * from goods";
				query(sql);
				fangsi.setVisible(true);
				b1.setVisible(true);
				neirong.setVisible(true);
				t1.setVisible(true);
				fangsi.setText("ɾ����ʽ");
				neirong.setText("������Ҫɾ��������");
				delete();
				t1.setText("");
			}		
		});
		i6.addActionListener(new ActionListener(){//ͳ��

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				fangsi.setVisible(false);
				b1.setVisible(false);
				neirong.setVisible(false);
				t1.setVisible(false);
				count();
			}		
		});
		i7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				t1.setText("");
			}
			
		});
	}

	public void delete(){//ɾ����ť	
		DBConnection cn=new DBConnection();
		String sqlstr;
		if(b1.getSelectedItem().equals("�����")){
			sqlstr="delete from goods where id=?";
			int ok=0;
			 try{
				 cn.presql=cn.conn.prepareStatement(sqlstr);
				 cn.presql.setString(1, t1.getText());
				 ok=cn.presql.executeUpdate();			 
				 cn.conn.close();
				 }
			catch(SQLException e){
				
			}
			 if(ok!=0){
				 JOptionPane.showMessageDialog(this,"ɾ���ɹ�","ȷ��",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
		if(b1.getSelectedItem().equals("������")){
			sqlstr="delete from goods where class=?";
			int ok=0;
			 try{
				 cn.presql=cn.conn.prepareStatement(sqlstr);
				 cn.presql.setString(1, t1.getText());
				 ok=cn.presql.executeUpdate();			 
				 cn.conn.close();
				 }
			catch(SQLException e){
				
			}
			 if(ok!=0){
				 JOptionPane.showMessageDialog(this,"ɾ���ɹ�","ȷ��",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
		if(b1.getSelectedItem().equals("������")){
			sqlstr="delete from goods where name=?";
			int ok=0;
			 try{
				 cn.presql=cn.conn.prepareStatement(sqlstr);
				 cn.presql.setString(1, t1.getText());
				 ok=cn.presql.executeUpdate();			 
				 cn.conn.close();
				 }
			catch(SQLException e){
				
			}
			 if(ok!=0){
				 JOptionPane.showMessageDialog(this,"ɾ���ɹ�","ȷ��",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
	}
	public void select(){//��ѯ��ť
		if(b1.getSelectedItem().equals("�����")){
			String sql="select * from goods where id="+t1.getText();
			query(sql);
		}
		if(b1.getSelectedItem().equals("������")){
			String sql="select * from goods where class="+t1.getText();
			query(sql);
		}
		if(b1.getSelectedItem().equals("������")){
			String sql="select * from goods where name="+t1.getText();
			query(sql);
		}
	}
	public void query(String sql){//��ʾ��ť
		try{
			// �������
			DBConnection cn=new DBConnection();
			// ������ѯ����
			//String sql = "select * from goods"; 
			//String sql = "";
			PreparedStatement pstm = cn.conn.prepareStatement(sql);
			// ִ�в�ѯ
			cn.rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while(cn.rs.next()){
			count++;
			}
			cn.rs = pstm.executeQuery();
			// ����ѯ��õļ�¼����,ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][6];
			count = 0;
			while(cn.rs.next()){
			info[count][0] = Integer.valueOf(cn. rs.getInt("id"));
			info[count][1] = cn.rs.getString("class");
			info[count][2] = cn.rs.getString("name");
			info[count][3] = cn.rs.getString("price");
			info[count][4] = Integer.valueOf(cn.rs.getInt("num") );
			info[count][5] = cn.rs.getString("pname");
			count++;
			}
			// �����ͷ
			String[] title = {"���","����","����","�۸�","����","��Ӧ������"};
			// ����JTable
			tabDemo = new JTable(info,title);
			// ��ʾ��ͷ
			jth = tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			scpDemo.getViewport().add(tabDemo);
			
			if(count==0){
				JOptionPane.showMessageDialog(this,"����Ʒ����������������","ȷ��",JOptionPane.WARNING_MESSAGE);
				//cn.con.close();
			}
			}catch(SQLException e){				
				//JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
	}
	public void count(){
		try{
			// �������
			DBConnection cn=new DBConnection();
			// ������ѯ����
			String sql = "select sum(num),count(distinct class),sum(num*price) from goods"; 
			//String sql = "";
			PreparedStatement pstm = cn.conn.prepareStatement(sql);
			// ִ�в�ѯ
			cn.rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while(cn.rs.next()){
			count++;
			}
			cn.rs = pstm.executeQuery();
			// ����ѯ��õļ�¼����,ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][3];
			count = 0;
			while(cn.rs.next()){
			info[count][0] = Integer.valueOf(cn. rs.getInt("sum(num)"));
			info[count][1] = Integer.valueOf(cn. rs.getInt("count(distinct class)"));
			info[count][2] = Integer.valueOf(cn.rs.getInt("sum(num*price)") );
			
			count++;
			}
			// �����ͷ
			String[] title = {"��Ʒ����","��Ʒ����","��Ʒ�ܼ�ֵ"};
			// ����JTable
			tabDemo = new JTable(info,title);
			// ��ʾ��ͷ
			jth = tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			scpDemo.getViewport().add(tabDemo);
			
			if(count==0){
				JOptionPane.showMessageDialog(this,"����Ʒ����������������","ȷ��",JOptionPane.WARNING_MESSAGE);
				t1.setText("");
				cn.con.close();
			}
			}catch(SQLException e){		
				JOptionPane.showMessageDialog(this,"����Ʒ����������������","ȷ��",JOptionPane.WARNING_MESSAGE);
				//JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
	}
}
