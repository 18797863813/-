package help;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Chaxun extends muban{
	public Chaxun(){
		muban.chaxun.setVisible(true);
		muban.bianhao.setText("按编号查询");
		muban.mingcheng.setText("按名称查询");
		muban.leixing.setText("按类型查询");
		muban.jiage.setVisible(false);
		muban.t4.setVisible(false);
		muban.shuliang.setVisible(false);
		muban.t5.setVisible(false);
		setTitle("查询商品");
		muban.chaxun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				select();
			}			
		});
	}
	public void select(){//查询数据

	}
}
