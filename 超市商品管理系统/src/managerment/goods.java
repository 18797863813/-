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
		this.addWindowListener(new WindowAdapter() {//监听退出事件
			public void windowClosing(WindowEvent e) {
			dispose();//释放当前窗口资源，并且设置为不可见
			}
		});
		setResizable(false);
		setTitle("商品信息管理");
		setBounds(50,85,800,800);
		this.setVisible(true);
		m1=new JPanel();
		m2=new JPanel();
		m3=new JPanel();
		i1=new JButton("添加");
		i2=new JButton("查询");
		i3=new JButton("显示");
		i4=new JButton("编辑");
		i5=new JButton("删除");
		i6=new JButton("统计");
		i7=new JButton("重置");
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
		fangsi=new JLabel("查询方式");
		neirong=new JLabel("请输入要查询的内容");

		t1=new JTextField();
		b1=new JComboBox();
		b1.addItem("按编号");
		b1.addItem("按类型");
		b1.addItem("按名称");
		m2.add(fangsi);m2.add(b1);
		m2.add(neirong);m2.add(t1);

		fangsi.setVisible(false);
		b1.setVisible(false);
		neirong.setVisible(false);
		t1.setVisible(false);
			
		String sql = "select * from goods";
		query(sql);	

		i1.addActionListener(new ActionListener(){//添加
			public void actionPerformed(ActionEvent arg0) {	
				new Tianjia();				
			}			
		});
		i2.addActionListener(new ActionListener(){//查询

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
		i3.addActionListener(new ActionListener(){//显示

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
		i4.addActionListener(new ActionListener(){//编辑

			public void actionPerformed(ActionEvent arg0) {
				fangsi.setVisible(false);
				b1.setVisible(false);
				neirong.setVisible(false);
				t1.setVisible(false);
				new bianji();
			}		
		});
		i5.addActionListener(new ActionListener(){//删除

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				String sql = "select * from goods";
				query(sql);
				fangsi.setVisible(true);
				b1.setVisible(true);
				neirong.setVisible(true);
				t1.setVisible(true);
				fangsi.setText("删除方式");
				neirong.setText("请输入要删除的内容");
				delete();
				t1.setText("");
			}		
		});
		i6.addActionListener(new ActionListener(){//统计

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

	public void delete(){//删除按钮	
		DBConnection cn=new DBConnection();
		String sqlstr;
		if(b1.getSelectedItem().equals("按编号")){
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
				 JOptionPane.showMessageDialog(this,"删除成功","确定",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
		if(b1.getSelectedItem().equals("按类型")){
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
				 JOptionPane.showMessageDialog(this,"删除成功","确定",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
		if(b1.getSelectedItem().equals("按名称")){
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
				 JOptionPane.showMessageDialog(this,"删除成功","确定",JOptionPane.INFORMATION_MESSAGE);
				 t1.setText("");
			 }
		}
	}
	public void select(){//查询按钮
		if(b1.getSelectedItem().equals("按编号")){
			String sql="select * from goods where id="+t1.getText();
			query(sql);
		}
		if(b1.getSelectedItem().equals("按类型")){
			String sql="select * from goods where class="+t1.getText();
			query(sql);
		}
		if(b1.getSelectedItem().equals("按名称")){
			String sql="select * from goods where name="+t1.getText();
			query(sql);
		}
	}
	public void query(String sql){//显示按钮
		try{
			// 获得连接
			DBConnection cn=new DBConnection();
			// 建立查询条件
			//String sql = "select * from goods"; 
			//String sql = "";
			PreparedStatement pstm = cn.conn.prepareStatement(sql);
			// 执行查询
			cn.rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while(cn.rs.next()){
			count++;
			}
			cn.rs = pstm.executeQuery();
			// 将查询获得的记录数据,转换成适合生成JTable的数据形式
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
			// 定义表头
			String[] title = {"编号","类型","名称","价格","数量","供应商名称"};
			// 创建JTable
			tabDemo = new JTable(info,title);
			// 显示表头
			jth = tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			scpDemo.getViewport().add(tabDemo);
			
			if(count==0){
				JOptionPane.showMessageDialog(this,"该商品不存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
				//cn.con.close();
			}
			}catch(SQLException e){				
				//JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
	}
	public void count(){
		try{
			// 获得连接
			DBConnection cn=new DBConnection();
			// 建立查询条件
			String sql = "select sum(num),count(distinct class),sum(num*price) from goods"; 
			//String sql = "";
			PreparedStatement pstm = cn.conn.prepareStatement(sql);
			// 执行查询
			cn.rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while(cn.rs.next()){
			count++;
			}
			cn.rs = pstm.executeQuery();
			// 将查询获得的记录数据,转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][3];
			count = 0;
			while(cn.rs.next()){
			info[count][0] = Integer.valueOf(cn. rs.getInt("sum(num)"));
			info[count][1] = Integer.valueOf(cn. rs.getInt("count(distinct class)"));
			info[count][2] = Integer.valueOf(cn.rs.getInt("sum(num*price)") );
			
			count++;
			}
			// 定义表头
			String[] title = {"商品数量","商品种类","商品总价值"};
			// 创建JTable
			tabDemo = new JTable(info,title);
			// 显示表头
			jth = tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			scpDemo.getViewport().add(tabDemo);
			
			if(count==0){
				JOptionPane.showMessageDialog(this,"该商品不存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
				t1.setText("");
				cn.con.close();
			}
			}catch(SQLException e){		
				JOptionPane.showMessageDialog(this,"该商品不存在请重新输入","确定",JOptionPane.WARNING_MESSAGE);
				//JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
	}
}
