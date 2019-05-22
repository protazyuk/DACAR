package Dprotaziuk.com;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Java DAKAR");//название окна
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//действие по закрытию окна
		f.setSize(1200, 597);//размер окна
		f.add(new Doroga());//нарисовка дороги
		f.setVisible(true);//включение видимости окна
			
	}

}
