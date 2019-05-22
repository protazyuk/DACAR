package Dprotaziuk.com;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Vrag {
	
	//координаты соперника
			int x;
			int y;
			int v;
			Image img = new ImageIcon("Resyrses/2.png").getImage();
			Doroga Doroga;//поле дорога
		
		public Rectangle getRect(){
			return new Rectangle(x,y,130,110);
		}
		
		
			//конструктор для класса
		public Vrag(int x,int y, int v, Doroga Doroga) {
			this.x=x;
			this.y=y;
			this.v=v;
			this.Doroga=Doroga;
		}
		
		//метод движения
		public void move(){
			x=x-Doroga.p.v+v;
		}
	}





