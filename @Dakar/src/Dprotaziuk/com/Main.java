package Dprotaziuk.com;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Java DAKAR");//�������� ����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�������� �� �������� ����
		f.setSize(1200, 597);//������ ����
		f.add(new Doroga());//��������� ������
		f.setVisible(true);//��������� ��������� ����
			
	}

}
