package managerment;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class MainFrame extends JFrame{
	JPanel contentPane;
	JMenuBar bar;
	JMenu m1,m2,m3;
	JMenuItem i1,i2;
	MainFrame(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("������Ʒ����ϵͳ");
		setBounds(75,55,1000,1000);
		bar=new JMenuBar();
		m1=new JMenu("������Ϣ����");
		m2=new JMenu("������Ա");
		m3=new JMenu("�˳�");
		i1=new JMenuItem("��Ʒ��Ϣ����");
		i2=new JMenuItem("��Ӧ����Ϣ����");
		contentPane=new JPanel();
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		m1.add(i1);
		m1.add(i2);
		JPanel p=new JPanel();
		JLabel l=new JLabel();
		p.add(l);
		l.setText("    ��ӭʹ�ó�����Ʒ����ϵͳ");
		l.setFont(new Font("����", Font.PLAIN, 50));
		p.setLayout(new GridLayout(1,1));
		setJMenuBar(bar);
		add(p);
		i1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new goods();
				
			}			
		});
		i2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new provider();
			}		
		});

		m2.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String s="������";
				JOptionPane.showMessageDialog(contentPane,s,"������Ա",JOptionPane.INFORMATION_MESSAGE);
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		});
		m3.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
