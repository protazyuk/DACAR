package Dprotaziuk.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//����������� ������ �� ���� �����
public class Doroga extends JPanel implements ActionListener, Runnable{
	
	
	Timer mainTimer = new Timer(20,this);//������ ����� ��������� ������� ������ 20 ��/���
	Image img = new ImageIcon("Resyrses/doroga.jpg").getImage();//����� ����������� � ������ � ���������� ����� , ������� ���������� �����������
		
	Player p = new Player();//����� ��� �� ������ ���� �����
	
	Thread enemiesFactore = new Thread(this);
	ArrayList<Vrag> enemies = new ArrayList<Vrag>();
	
	
	
	//������� ������������ � ������� ��������� ������
	public Doroga() {
		mainTimer.start();
		enemiesFactore.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	} 
	//����� ��� ���������� �������
		private class MyKeyAdapter extends KeyAdapter{
			//��� ������� �������
			public void keyPressed(KeyEvent e){
				p.keyPressed(e);//�����
			}
			//��� ���������� �������
			public void keyReleased(KeyEvent e){
				p.keyReleased(e);//�����
			}
		}
	
	
	//������������ ����� � ���������� ����� ����� ������������ ������
	public void paint (Graphics g){
		g = (Graphics2D) g;
		g.drawImage(img, p.layer1, 0, null);//���� ������ ����������
		g.drawImage(img, p.layer2, 0, null);//���� ������ ����������
		g.drawImage(p.img,p.x, p.y, null);//���������� ������ �� ������
		
		//��������� ����������
		double v = (50/Player.MAX_V) *p.v;
		g.setColor(Color.BLUE);
		Font font = new Font("Arial", Font.ITALIC, 90);
		g.drawString("Speed:" + v + "km/���",100,20);
		//��������� ����� 
		Iterator<Vrag> i= enemies.iterator();
		while(i.hasNext()){
				Vrag e=i.next();
			if(e.x>=2400 || e.x<=-2400 ){
				i.remove();
			}else{
				e.move();
				g.drawImage(e.img, e.x, e.y, null);
			}
        }
	}

		
	
	
	public void actionPerformed(ActionEvent e){
		p.move();//������� �����
		repaint();
		testCollisionWithVrag();
		}//�����������
		
	//����� ������ ��� ��� ������������
	private void testCollisionWithVrag(){
		Iterator<Vrag> i= enemies.iterator();
		while (i.hasNext()){
			Vrag e = i.next();
			if(p.getRect().intersects(e.getRect())){
				JOptionPane.showMessageDialog(null, "EROR)))");
			System.exit(1);
		}}
		}
		
	//�������� ������ ����������, ��������
	@Override
	public void run() {
		while(true){
			Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(2000));
			enemies.add(new Vrag(1200,
			rand.nextInt(600),
			rand.nextInt(40),
			this)	);
			} 
		catch (InterruptedException e) {
			e.printStackTrace();
			}
			
		} 
		
	}
}
