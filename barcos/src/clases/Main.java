package clases;

import java.awt.*;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vista miVista = new Vista();
		
		Controlador c = new Controlador(miVista);
		
		miVista.control(c);
		
		JFrame ventana = new JFrame("Barcos");
		
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setPreferredSize(new Dimension(700,500));
		ventana.setVisible(true);
		ventana.pack();

	}

}
