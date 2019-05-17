package clases;

import java.awt.event.*;

public class Controlador implements ActionListener{
	
	private Vista v;
	
	public Controlador(Vista v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("BackToPP")) {
			this.v.getP1().setVisible(false);
			this.v.getpBarcos().setVisible(false);
			this.v.getPprincipal().setVisible(true);
			System.out.println("Volver a pantalla principal");
		}
		else if(e.getSource()==this.v.getPp_btnGoP1()) {
			this.v.getPprincipal().setVisible(false);
			this.v.getP1().setVisible(true);
			System.out.println("Ir a pantalla 1");
		}
		else if(e.getSource()==this.v.getPp_btnGoPBarcos()) {
			this.v.getPprincipal().setVisible(false);
			this.v.getpBarcos().setVisible(true);
			System.out.println("Ir a pantalla Barcos");
		}
		
	}

}
