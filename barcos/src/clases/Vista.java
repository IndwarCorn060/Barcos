package clases;

import java.awt.*;

import javax.swing.*;

public class Vista extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//panel Principal
	private JPanel pprincipal;
	private JButton pp_btnGoP1, pp_btnGoPBarcos;
	
	//panel 1
	private JPanel p1;
	private JButton p1_btnBack;
	private JLabel hola;
	
	//panel Barcos
	private JPanel pBarcos, pBarcos_pSur;
	private JButton pBarcos_btnBack, pBarcos_btnEliminar, pBarcos_btnExaminar;
	private JScrollPane pBarcos_centro;
	private JList<Barco> pBarcos_centro_lstBarcos;
	//poner modo de ordenacion
	
	//panel Equipar
	private JPanel pEquipar;
	private JComboBox<Barco> pEquipar_boxBarco;
	private JComboBox<Equipamiento> pEquipar_boxBarcoEquipo, pEquipar_boxEquipamiento;
	
	private void crearComponentesPanelPrincipal() {
		this.pp_btnGoP1 = new JButton("Go Panel 1");
		this.pp_btnGoPBarcos = new JButton("Go Panel Barcos");
		
		this.pprincipal = new JPanel();
	}
	
	private void montarComponentesPanelPrincipal() {
		this.add(this.pprincipal);
			this.pprincipal.add(this.pp_btnGoP1);
			this.pprincipal.add(this.pp_btnGoPBarcos);
	}
	
	private void crearComponentesPanel1(){
		this.p1_btnBack = new JButton("Volver");
		this.p1_btnBack.setActionCommand("BackToPP");
		this.hola = new JLabel("hola");
		
		this.p1 = new JPanel(new BorderLayout());
	}
	
	private void montarComponentesPanel1() {
		this.add(this.p1);
			this.p1.add(hola, BorderLayout.NORTH);
			this.p1.add(p1_btnBack, BorderLayout.NORTH);
			this.p1.add(new JLabel(new ImageIcon("./res/moze.png")), BorderLayout.CENTER);
	}
	
	private void crearComponentesPanelBarcos() {
		this.pBarcos_btnBack = new JButton("Volver");
		this.pBarcos_btnBack.setActionCommand("BackToPP");
		this.pBarcos_btnEliminar = new JButton("Eliminar");
		this.pBarcos_btnExaminar = new JButton("Examinar");
		this.pBarcos_centro_lstBarcos = new JList<Barco>();
		
		this.pBarcos = new JPanel(new BorderLayout());
		this.pBarcos_pSur = new JPanel();
		this.pBarcos_centro = new JScrollPane(this.pBarcos_centro_lstBarcos);
		this.pBarcos_centro.setPreferredSize(new Dimension(800,450));
	}
	
	private void montarComponentesPanelBarcos() {
		this.add(this.pBarcos);
			this.pBarcos.add(this.pBarcos_centro, BorderLayout.CENTER);
			this.pBarcos.add(this.pBarcos_pSur, BorderLayout.SOUTH);
				this.pBarcos_pSur.add(this.pBarcos_btnBack);
				this.pBarcos_pSur.add(this.pBarcos_btnEliminar);
				this.pBarcos_pSur.add(this.pBarcos_btnExaminar);
	}
	
	private void crearComponentesPanelEquipamiento() {
		
	}
	
	private void crearTodo() {
		this.crearComponentesPanelPrincipal();
		this.montarComponentesPanelPrincipal();
		this.crearComponentesPanel1();
		this.montarComponentesPanel1();
		this.p1.setVisible(false);
		this.crearComponentesPanelBarcos();
		this.montarComponentesPanelBarcos();
		this.pBarcos.setVisible(false);
	}
	
	public Vista() {
		this.crearTodo();
	}
	
	public void control(Controlador c) {
		this.pp_btnGoP1.addActionListener(c);
		this.pp_btnGoPBarcos.addActionListener(c);
		this.p1_btnBack.addActionListener(c);
		this.pBarcos_btnBack.addActionListener(c);
	}

	public JPanel getPprincipal() {
		return pprincipal;
	}

	public JButton getPp_btnGoP1() {
		return pp_btnGoP1;
	}

	public JButton getPp_btnGoPBarcos() {
		return pp_btnGoPBarcos;
	}

	public JPanel getP1() {
		return p1;
	}

	public JButton getP1_btnBack() {
		return p1_btnBack;
	}

	public JPanel getpBarcos() {
		return pBarcos;
	}

	public JButton getpBarcos_btnBack() {
		return pBarcos_btnBack;
	}

	public JButton getpBarcos_btnEliminar() {
		return pBarcos_btnEliminar;
	}

	public JButton getpBarcos_btnExaminar() {
		return pBarcos_btnExaminar;
	}

	public JList<Barco> getpBarcos_centro_lstBarcos() {
		return pBarcos_centro_lstBarcos;
	}

	
	
	

}
