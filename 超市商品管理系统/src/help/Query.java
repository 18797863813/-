package help;

import java.awt.Component;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import managerment.DBConnection;
public class Query{
	public static Component jTable;
	public static JScrollPane scpDemo;
	public static  JTableHeader jth;
	public static  JTable tabDemo;
	public void toTable(){
		try{
			// �������
			DBConnection cn=new DBConnection();
			// ������ѯ����
			String sql = "select * from goods"; 
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
			Object[][] info = new Object[count][5];
			count = 0;
			while(cn.rs.next()){
			info[count][0] = Integer.valueOf(cn. rs.getInt("id"));
			info[count][1] = cn.rs.getString("class");
			info[count][2] = cn.rs.getString("name");
			info[count][3] = cn.rs.getString("price");
			info[count][4] = Integer.valueOf(cn.rs.getInt("num") );
			
			count++;
			}
			// �����ͷ
			String[] title = {"���","����","����","�۸�","����"};
			// ����JTable
			tabDemo = new JTable(info,title);
			// ��ʾ��ͷ
			jth = tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			scpDemo.getViewport().add(tabDemo); 
			}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
			}
	}
}