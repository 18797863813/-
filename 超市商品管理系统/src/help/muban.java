package help;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public  class muban extends JFrame{
	public static JLabel bianhao,leixing,mingcheng,jiage,shuliang;
	public static JTextField t1,t2,t3,t4,t5;
	public static JButton tianjia,chongzhi,xianshi,bianji,chaxun,tongji,shanchu,fanhui;
	muban(){
		//setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {//监听退出事件
			public void windowClosing(WindowEvent e) {
			dispose();//释放当前窗口资源，并且设置为不可见
			}
		});
		setTitle("添加商品");
		setBounds(50,50,500,500);
		bianhao=new JLabel("编号");
		leixing=new JLabel("类型");
		mingcheng=new JLabel("名称");
		jiage=new JLabel("价格");
		shuliang=new JLabel("数量");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		tianjia=new JButton("添加");
		bianji=new JButton("编辑");
		chongzhi=new JButton("重置");
		xianshi=new JButton("显示");
		chaxun=new JButton("查询");
		tongji=new JButton("统计");
		shanchu=new JButton("删除");
		fanhui=new JButton("返回");
		add(bianhao);
		add(leixing);
		add(mingcheng);
		add(jiage);
		add(shuliang);
		setLayout(null);

		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		
		add(tianjia);
		add(chongzhi);
		add(bianji);
		add(chaxun);
		add(xianshi);
		add(shanchu);
		add(tongji);
		add(fanhui);
		
		bianhao.setBounds(10, 50, 100, 20);
		leixing.setBounds(10,80,100,20);
		mingcheng.setBounds(10,110,100,20);
		jiage.setBounds(10,140,50,20);
		shuliang.setBounds(10,170,50,20);
		t1.setBounds(100,50,100,20);
		t2.setBounds(100,80,100,20);
		t3.setBounds(100,110,100,20);
		t4.setBounds(100,140,100,20);
		t5.setBounds(100,170,100,20);
		
		tianjia.setBounds(50,200,60,30);
		chongzhi.setBounds(120,200,60,30);
		chaxun.setBounds(190,200,60,30);
		fanhui.setBounds(260,200,60,30);
		xianshi.setBounds(50,250,60,30);
		bianji.setBounds(120, 250, 60, 30);
		shanchu.setBounds(190,250,60,30);
		tongji.setBounds(260, 250, 60, 30);		
		
		chaxun.setVisible(false);
		tianjia.setVisible(false);
		xianshi.setVisible(false);
		shanchu.setVisible(false);
		tongji.setVisible(false);
		bianji.setVisible(false);	
		
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
	}
}
