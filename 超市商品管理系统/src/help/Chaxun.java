package help;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Chaxun extends muban{
	public Chaxun(){
		muban.chaxun.setVisible(true);
		muban.bianhao.setText("����Ų�ѯ");
		muban.mingcheng.setText("�����Ʋ�ѯ");
		muban.leixing.setText("�����Ͳ�ѯ");
		muban.jiage.setVisible(false);
		muban.t4.setVisible(false);
		muban.shuliang.setVisible(false);
		muban.t5.setVisible(false);
		setTitle("��ѯ��Ʒ");
		muban.chaxun.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				select();
			}			
		});
	}
	public void select(){//��ѯ����

	}
}
