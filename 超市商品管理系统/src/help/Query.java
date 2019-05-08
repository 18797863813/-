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
			// 获得连接
			DBConnection cn=new DBConnection();
			// 建立查询条件
			String sql = "select * from goods"; 
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
			// 定义表头
			String[] title = {"编号","类型","名称","价格","数量"};
			// 创建JTable
			tabDemo = new JTable(info,title);
			// 显示表头
			jth = tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			scpDemo.getViewport().add(tabDemo); 
			}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
	}
}