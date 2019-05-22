package Dprotaziuk.com;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {
		public static final int MAX_V=50;//максимальная скорость
		public static final int MAX_TOP=20;//максимальная координата по верху
		public static final int MAX_BOTTON=300;//минимальная внизу
	Image img = new ImageIcon("Resyrses/1.png").getImage();
	
	public Rectangle getRect(){
		return new Rectangle(x,y,100,110);
	}
	
	int v = 0;//скорость
	int dv = 0;//ускорение
	int s = 0;//путь
	
	//координаты игрока
	int x = 30;
	int y = 40;
	int dy = 0;
	
	int layer1 = 0;//координата первого слоя
	int layer2 = 1200;//координата 2 слоя
	
	//метод движение игрока
	public void move(){
		s +=v;//отметка что мы проехали
		v+=dv;//контроль ускорения
		if(v<=0) v=0;//если скорость отрицательна , стоим на месте
		if(v>=MAX_V)v=MAX_V;//если скорость максимальна, то не ускоряемся более
		y-=dy;
		if(y<=MAX_TOP) y = MAX_TOP;//если координата высоты выше , то максимальная высота
		if(y>=MAX_BOTTON) y = MAX_BOTTON;//если координата ниже , то минимальная координата
		if(layer2 -v <= 0){//зацыклировали два слоя
			layer1 = 0;
			layer2 = 1200;
		}  
		else{
		layer1 -=v;//илюзия движени
		layer2 -=v;
		}
	}
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();//получение кода клавиши
		if(key == KeyEvent.     VK_RIGHT){//клавиша вправо
			dv = 5;
		}
		if(key == KeyEvent.VK_LEFT){//нажатие лево
			dv = -5;
		}
		if(key == KeyEvent.VK_UP){//нажатие вверх
			dy = 15;
		}
		if(key == KeyEvent.VK_DOWN){//нажатие вниз
			dy = -15;
		}
		
		}


		public void keyReleased(KeyEvent e){
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_RIGHT || key== KeyEvent.VK_LEFT){
			dv = 0;
		}
			if(key == KeyEvent.VK_UP || key== KeyEvent.VK_DOWN){
			dy = 0;
		}		
	}	
}

