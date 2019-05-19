package clases;

import java.awt.*;

import javax.swing.*;

public class VentanaBarco {
	
	private Barco barco;
	
	//componentes ventana
	
	public VentanaBarco(Barco barco) {
		this.barco = barco;
		JFrame ventana = new JFrame(this.barco.getCodigo()+" "+this.barco.getNombre());
		Container cp = ventana.getContentPane();
		this.montarVentana(cp);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setPreferredSize(new Dimension(800,350));
		ventana.setVisible(true);
		ventana.pack();
		ventana.setResizable(false);
		
	}
	
	private void montarVentana(Container c) {
		JPanel norte = new JPanel(new GridLayout(1,3));
		JLabel norte1 = new JLabel("Cod: "+this.barco.getCodigo());
		norte1.setHorizontalAlignment(JLabel.CENTER);
		JLabel norte2 = new JLabel("Nombre: "+this.barco.getNombre());
		norte2.setHorizontalAlignment(JLabel.CENTER);
		JLabel norte3 = new JLabel("Clase: "+this.barco.getClase());
		norte3.setHorizontalAlignment(JLabel.CENTER);
		norte.setBorder(BorderFactory.createTitledBorder("Barco"));
		c.add(norte, BorderLayout.NORTH);
			norte.add(norte1);
			norte.add(norte2);
			norte.add(norte3);
		JPanel sur = new JPanel(new GridLayout(1,2));
		JLabel sur1 = new JLabel("Armadura: "+this.barco.getTipo().getTipoArmor());
		sur1.setHorizontalAlignment(JLabel.CENTER);
		JLabel sur3 = new JLabel("Faccion: "+this.barco.getFaccion());
		sur3.setHorizontalAlignment(JLabel.CENTER);
		JLabel sur2 = new JLabel("Tipo: "+this.barco.getTipo().getNombre());
		sur2.setHorizontalAlignment(JLabel.CENTER);
		sur.setBorder(BorderFactory.createTitledBorder(""));
		c.add(sur, BorderLayout.SOUTH);
			sur.add(sur1);
			sur.add(sur2);
			sur.add(sur3);
		JPanel izq = new JPanel(new GridLayout(7,1));
		izq.setBorder(BorderFactory.createTitledBorder("Stats"));
		izq.setPreferredSize(new Dimension(70,izq.getHeight()));
		c.add(izq, BorderLayout.WEST);
			izq.add(new JLabel("HP: "+this.barco.getStats()[0]));
			izq.add(new JLabel("FP: "+this.barco.getStats()[1]));
			izq.add(new JLabel("AA: "+this.barco.getStats()[2]));
			izq.add(new JLabel("TRP: "+this.barco.getStats()[3]));
			izq.add(new JLabel("AVI: "+this.barco.getStats()[4]));
			izq.add(new JLabel("RLD: "+this.barco.getStats()[5]));
			izq.add(new JLabel("EVA: "+this.barco.getStats()[6]));
		JPanel der = new JPanel(new GridLayout(10,1));
		der.setBorder(BorderFactory.createTitledBorder("Equipamiento"));
		der.setPreferredSize(new Dimension(150,der.getHeight()));
		c.add(der, BorderLayout.EAST);
			der.add(new JLabel("Slot1: "));
			JLabel der1 = new JLabel((this.barco.getSlot()[0]!=null)?this.barco.getSlot()[0].getNombre():this.barco.getTipoSlot()[0]+"");
			der1.setHorizontalAlignment(JLabel.RIGHT);
			der.add(der1);
			der.add(new JLabel("Slot2: "));
			JLabel der2 = new JLabel((this.barco.getSlot()[1]!=null)?this.barco.getSlot()[1].getNombre():this.barco.getTipoSlot()[1]+"");
			der2.setHorizontalAlignment(JLabel.RIGHT);
			der.add(der2);
			der.add(new JLabel("Slot3: "));
			JLabel der3 = new JLabel((this.barco.getSlot()[2]!=null)?this.barco.getSlot()[2].getNombre():this.barco.getTipoSlot()[2]+"");
			der3.setHorizontalAlignment(JLabel.RIGHT);
			der.add(der3);
			der.add(new JLabel("Slot4: "));
			JLabel der4 = new JLabel((this.barco.getSlot()[3]!=null)?this.barco.getSlot()[3].getNombre():this.barco.getTipoSlot()[3]+"");
			der4.setHorizontalAlignment(JLabel.RIGHT);
			der.add(der4);
			der.add(new JLabel("Slot5: "));
			JLabel der5 = new JLabel((this.barco.getSlot()[4]!=null)?this.barco.getSlot()[4].getNombre():this.barco.getTipoSlot()[4]+"");
			der5.setHorizontalAlignment(JLabel.RIGHT);
			der.add(der5);
		JPanel centro = new JPanel();
		ImageIcon imagen = new ImageIcon("./res/barcos/"+this.barco.getCodigo()+".png");
		if(imagen.getImageLoadStatus()==MediaTracker.ERRORED) {
			centro.add(new JLabel(new ImageIcon("./res/default.png")));
		}
		else {
			centro.add(new JLabel(imagen));
		}
		c.add(centro, BorderLayout.CENTER);
		
	}

}
