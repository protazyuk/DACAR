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
//изображение дороги на весь экран
public class Doroga extends JPanel implements ActionListener, Runnable{
	
	
	Timer mainTimer = new Timer(20,this);//таймер будет запускать функцию каждые 20 мл/сек
	Image img = new ImageIcon("Resyrses/doroga.jpg").getImage();//берем изображение в обьект и вызывается метод , который возвращает изображение
		
	Player p = new Player();//показ что на дороге есть игрок
	
	Thread enemiesFactore = new Thread(this);
	ArrayList<Vrag> enemies = new ArrayList<Vrag>();
	
	
	
	//содание конструктора в котором запускаем таймер
	public Doroga() {
		mainTimer.start();
		enemiesFactore.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	} 
	//класс для управление игроком
		private class MyKeyAdapter extends KeyAdapter{
			//при нажатии клавиши
			public void keyPressed(KeyEvent e){
				p.keyPressed(e);//метод
			}
			//при отпускании клавиши
			public void keyReleased(KeyEvent e){
				p.keyReleased(e);//метод
			}
		}
	
	
	//переписывает метод и вызывается когда нужно перерисовать панель
	public void paint (Graphics g){
		g = (Graphics2D) g;
		g.drawImage(img, p.layer1, 0, null);//слой меняет координаты
		g.drawImage(img, p.layer2, 0, null);//слой меняет координаты
		g.drawImage(p.img,p.x, p.y, null);//координаты игрока на дороге
		
		//нарисовка спидометра
		double v = (50/Player.MAX_V) *p.v;
		g.setColor(Color.BLUE);
		Font font = new Font("Arial", Font.ITALIC, 90);
		g.drawString("Speed:" + v + "km/час",100,20);
		//нарисовка врага 
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
		p.move();//функция ехать
		repaint();
		testCollisionWithVrag();
		}//перерисовка
		
	//метод вывода смс при столкновении
	private void testCollisionWithVrag(){
		Iterator<Vrag> i= enemies.iterator();
		while (i.hasNext()){
			Vrag e = i.next();
			if(p.getRect().intersects(e.getRect())){
				JOptionPane.showMessageDialog(null, "EROR)))");
			System.exit(1);
		}}
		}
		
	//создание врагов бесконечно, рандомно
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
