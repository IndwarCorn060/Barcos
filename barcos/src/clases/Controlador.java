package clases;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.*;


public class Controlador extends WindowAdapter implements ActionListener, ItemListener {
	
	private Vista v;
	private Modelo m;
	
	//variables adicionales para sortear la lista de barcos
	private String ultimoBtnPulsado;
	private boolean cambioBtnPulsado;
	
	public Controlador(Vista v) {
		this.v = v;
		
		try {
			// Crear el modelo
			m = new Modelo();
		}
		catch (SQLException e) {
		//	miModelo.printSQLException(e);
			JOptionPane.showMessageDialog(v, "Problema SQL");
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(v, "Problema al cargar la BD");
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(v, "El programa se debe reiniciar");
		}
	}
	
	public void windowClosing(WindowEvent e) {
		
		try {
			this.m.cierraStatements();
			this.m.cierraConexion();
			System.out.println("Conexxion cerrada");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
	
	//Panel barcos
	
	private void llenarListaBarcos(String n) {
		if(n.equals(ultimoBtnPulsado)) {
			if(cambioBtnPulsado) cambioBtnPulsado=false;
			else cambioBtnPulsado=true;
		}
		else {
			ultimoBtnPulsado=n;
			cambioBtnPulsado=false;
		}
		try {
			ResultSet rs = this.m.getListaOrderBy(n,cambioBtnPulsado);
			this.ultimoBtnPulsado=n;
			this.v.getListaBarcos().removeAllElements();
			while(rs.next()) {
				this.v.getListaBarcos().addElement(rs.getString(1)+"---"+rs.getString(2));
			}
		}catch(SQLException e) {
			this.m.printSQLException(e);
		}
	}

	private String[] sacarNombresDeLaLista() {
		List<String> lista = this.v.getpBarcos_centro_lstBarcos().getSelectedValuesList();
		String[] nombres = new String[lista.size()];
		Iterator<String> i = lista.iterator();
		int cont=0;
		while(i.hasNext()) {
			StringTokenizer t = new StringTokenizer(i.next(),"-");
			t.nextToken();
			nombres[cont]=t.nextToken();
			cont++;
		}
		return nombres;
	}
	
	private void eliminarBarcos() {
		String[] nombres = this.sacarNombresDeLaLista();
		//mensaje de confirmacion
		for(int i=0; i<nombres.length; i++) {
			if (JOptionPane.showConfirmDialog(null, "Va a eliminar el barco "+nombres[i]+"\n¿Desea proseguir?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.m.desEquiparTodo(nombres[i]);
				this.m.eliminarBarco(nombres[i]);
			} 
		}
		
		if(cambioBtnPulsado) cambioBtnPulsado=false;
		else cambioBtnPulsado=true;
		this.llenarListaBarcos(ultimoBtnPulsado);
	}
	
	private void examinarBarco() {
		String[] nombres = this.sacarNombresDeLaLista();
		for(int i=0; i<nombres.length; i++) {
			Barco barco = this.m.getBarco(nombres[i]);
			VentanaBarco ventana = new VentanaBarco(barco);
			ventana.toString();
		}
	}
	
	//panel Equipar
	private void actualizarBoxBarcos(int n) {
		Barco[] barcos = this.m.getTodosLosBarcos();
		this.v.getpEquipar_boxBarco().removeItemListener(this);
		this.v.getpEquipar_boxBarco().removeAllItems();
		for(int i=0; i<barcos.length; i++) {
			this.v.getpEquipar_boxBarco().addItem(barcos[i]);
		}
		if(n>0) {
			this.v.getpEquipar_boxBarco().setSelectedIndex(n);
		}
		this.v.getpEquipar_boxBarco().addItemListener(this);
		this.actualizarBoxBarcosEquipo();
	}
	
	private void actualizarBoxBarcosEquipo() {
		this.v.getpEquipar_boxBarcoEquipo().removeItemListener(this);
		this.v.getpEquipar_boxBarcoEquipo().removeAllItems();
		Barco barco = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		for(int i=0; i<barco.getSlot().length; i++) {
			if(barco.getSlot()[i]!=null) {
				this.v.getpEquipar_boxBarcoEquipo().addItem(barco.getSlot()[i].toString());
			}
			else {
				this.v.getpEquipar_boxBarcoEquipo().addItem("Slot "+(i+1));
			}
		}
		this.actualizarPanelEquiparBarcoEquipo();
		this.actualizarBoxEquipamiento();
		this.actualizarPanelEquiparEquipamiento();
		this.v.getpEquipar_boxBarcoEquipo().addItemListener(this);
	}
	
	private void actualizarBoxEquipamiento() {
		this.v.getpEquipar_boxEquipamiento().removeItemListener(this);
		this.v.getpEquipar_boxEquipamiento().removeAllItems();
		Barco barco = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		Equipamiento[] equipamientos = this.m.getTodosLosEquipamientos(this.v.getpEquipar_p2_p2_ChckMostrarPosibles().isSelected(),
				barco.getTipoSlot()[this.v.getpEquipar_boxBarcoEquipo().getSelectedIndex()].toString(),
				!this.v.getpEquipar_p2_p2_ChckMostrarEquipados().isSelected());
		for(int i=0; i<equipamientos.length; i++) {
			this.v.getpEquipar_boxEquipamiento().addItem(equipamientos[i]);
		}
		this.v.getpEquipar_boxEquipamiento().addItemListener(this);
	}
	
	private void actualizarPanelEquiparBarco() {
		Barco b = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		this.v.getpEq_1etqtNombre().setText("Nombre: "+b.getNombre());
		this.v.getpEq_1etqtHP().setText("HP: "+b.getStats()[0]);
		this.v.getpEq_1etqtFP().setText("FP: "+b.getStats()[1]);
		this.v.getpEq_1etqtAA().setText("AA: "+b.getStats()[2]);
		this.v.getpEq_1etqtTRP().setText("TRP: "+b.getStats()[3]);
		this.v.getpEq_1etqtAVI().setText("AVI: "+b.getStats()[4]);
		this.v.getpEq_1etqtRLD().setText("RLD: "+b.getStats()[5]);
		this.v.getpEq_1etqtEVA().setText("EVA: "+b.getStats()[6]);
	}
	
	private void actualizarPanelEquiparBarcoEquipo() {
		Barco b = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		Equipamiento e = b.getSlot()[this.v.getpEquipar_boxBarcoEquipo().getSelectedIndex()];
		this.v.getpEq_2etqtTipoSlot().setText("Tipo de Slot:"+b.getTipoSlot()[this.v.getpEquipar_boxBarcoEquipo().getSelectedIndex()]);
		if(e!=null) {
			this.v.getpEq_2etqtNombre().setText("Nombre: "+e.getNombre());
			this.v.getpEq_2etqtHP().setText("HP: +"+e.getStats()[0]);
			this.v.getpEq_2etqtFP().setText("FP: +"+e.getStats()[1]);
			this.v.getpEq_2etqtAA().setText("AA: +"+e.getStats()[2]);
			this.v.getpEq_2etqtTRP().setText("TRP: +"+e.getStats()[3]);
			this.v.getpEq_2etqtAVI().setText("AVI: +"+e.getStats()[4]);
			this.v.getpEq_2etqtRLD().setText("RLD: +"+e.getStats()[5]);
			this.v.getpEq_2etqtEVA().setText("EVA: +"+e.getStats()[6]);
			this.v.getpEq_2etqtDMG().setText("DMG: "+e.getDmg());
			this.v.getpEq_2etqtCD().setText("CD: "+e.getCd());
			this.v.getpEq_2etqtTipoAmmo().setText("Ammo: "+e.getAmmo());
		}
		else {
			this.v.getpEq_2etqtNombre().setText("Nombre: ");
			this.v.getpEq_2etqtHP().setText("HP: ");
			this.v.getpEq_2etqtFP().setText("FP: ");
			this.v.getpEq_2etqtAA().setText("AA: ");
			this.v.getpEq_2etqtTRP().setText("TRP: ");
			this.v.getpEq_2etqtAVI().setText("AVI: ");
			this.v.getpEq_2etqtRLD().setText("RLD: ");
			this.v.getpEq_2etqtEVA().setText("EVA: ");
			this.v.getpEq_2etqtDMG().setText("DMG: ");
			this.v.getpEq_2etqtCD().setText("CD: ");
			this.v.getpEq_2etqtTipoAmmo().setText("Ammo: ");
		}
	}
	
	private void actualizarPanelEquiparEquipamiento() {
		Equipamiento e = (Equipamiento) this.v.getpEquipar_boxEquipamiento().getSelectedItem();
		if(e!=null) {
			this.v.getpEq_3etqtTipoSlot().setText("Tipo de Slot:"+e.getTipo());
			this.v.getpEq_3etqtNombre().setText("Nombre: "+e.getNombre());
			this.v.getpEq_3etqtHP().setText("HP: +"+e.getStats()[0]);
			this.v.getpEq_3etqtFP().setText("FP: +"+e.getStats()[1]);
			this.v.getpEq_3etqtAA().setText("AA: +"+e.getStats()[2]);
			this.v.getpEq_3etqtTRP().setText("TRP: +"+e.getStats()[3]);
			this.v.getpEq_3etqtAVI().setText("AVI: +"+e.getStats()[4]);
			this.v.getpEq_3etqtRLD().setText("RLD: +"+e.getStats()[5]);
			this.v.getpEq_3etqtEVA().setText("EVA: +"+e.getStats()[6]);
			this.v.getpEq_3etqtDMG().setText("DMG: "+e.getDmg());
			this.v.getpEq_3etqtCD().setText("CD: "+e.getCd());
			this.v.getpEq_3etqtTipoAmmo().setText("Ammo: "+e.getAmmo());
		}
		else {
			this.v.getpEq_3etqtTipoSlot().setText("Tipo de Slot:");
			this.v.getpEq_3etqtNombre().setText("Nombre: ");
			this.v.getpEq_3etqtHP().setText("HP: ");
			this.v.getpEq_3etqtFP().setText("FP: ");
			this.v.getpEq_3etqtAA().setText("AA: ");
			this.v.getpEq_3etqtTRP().setText("TRP: ");
			this.v.getpEq_3etqtAVI().setText("AVI: ");
			this.v.getpEq_3etqtRLD().setText("RLD: ");
			this.v.getpEq_3etqtEVA().setText("EVA: ");
			this.v.getpEq_3etqtDMG().setText("DMG: ");
			this.v.getpEq_3etqtCD().setText("CD: ");
			this.v.getpEq_3etqtTipoAmmo().setText("Ammo: ");
		}
	}
	
	private void equipar() {
		Barco b = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		int slot = this.v.getpEquipar_boxBarcoEquipo().getSelectedIndex();
		Equipamiento e = (Equipamiento) this.v.getpEquipar_boxEquipamiento().getSelectedItem();
		boolean f = true;
		if(e!=null&&b.getTipoSlot()[slot].equals(e.getTipo())) {//es del mismo tipo
			//esta ocupado ese espacio?
			if(b.getSlot()[slot]!=null) {
				//si
				if(JOptionPane.showConfirmDialog(null, "Ese Slot ya esta ocupado por "+b.getSlot()[slot].getNombre()+"\nDesea desequiparlo?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					this.m.desEquipar(b.getNombre(), slot+1);
				}
				else {
					f=false;
				}
			}
			//esta ese equipmiento ya equipado en otro barco?
			if(f&&e.getBarco()!=null) {
				//si
				Barco auxB = this.m.getBarco(e.getBarco());
				int auxS=0;
				for(int i=0; i<auxB.getSlot().length; i++) {
					if(auxB.getSlot()[i]!=null&&auxB.getSlot()[i].getCod().equals(e.getCod())) {
						auxS=i;
					}
				}
				if(JOptionPane.showConfirmDialog(null, "El Equipamiento seleccionado\nya se encuentra equipado en "+auxB.getNombre()+"\nDesea desequiparlo de dicho barco?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					this.m.desEquipar(auxB.getNombre(), auxS+1);
				}
				else {
					f=false;
				}
			}
			if(f) {
				this.m.equipar(b.getCodigo(), slot+1, e.getCod());
			}
			else {
				System.out.println("cancelado");
			}
		}
		else {
			JOptionPane.showMessageDialog(null,"No puedes equipar ese Equipamiento en ese Slot", "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.actualizarBoxBarcos(this.v.getpEquipar_boxBarco().getSelectedIndex());
		this.actualizarBoxEquipamiento();
	}
	
	private void desEquipar() {
		Barco b = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		int slot = this.v.getpEquipar_boxBarcoEquipo().getSelectedIndex();
		if(b.getSlot()[slot]!=null) {
			this.m.desEquipar(b.getNombre(), slot+1);
			this.actualizarBoxBarcos(this.v.getpEquipar_boxBarco().getSelectedIndex());
			this.actualizarBoxEquipamiento();
		}
		else {
			JOptionPane.showMessageDialog(null,"No hay nada que desequipar en ese Slot", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void desEquiparTodo() {
		Barco b = (Barco)this.v.getpEquipar_boxBarco().getSelectedItem();
		this.m.desEquiparTodo(b.getNombre());
		this.actualizarBoxBarcos(this.v.getpEquipar_boxBarco().getSelectedIndex());
		this.actualizarBoxEquipamiento();
	}

	//panel crear
	
	private void crearBarco() {
		if(this.v.getpC_pB_pNtxtfNombre().getText().equals("")||this.v.getpC_pB_pCtxtfClase().getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Nombre o Clase vacias", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			try {
				//cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
				Barco b = new Barco("0", 
									this.v.getpC_pB_pNtxtfNombre().getText(), 
									this.v.getpC_pB_pCtxtfClase().getText(), 
									Faccion.valueOf(this.v.getpC_pB_pFboxFaccion().getSelectedItem().toString()), 
									TipoBarco.valueOf(this.v.getpC_pB_pTboxTipoBarco().getSelectedItem().toString()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfHP().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfFP().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfAA().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfTRP().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfAVI().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfRLD().getText()), 
									Integer.parseInt(this.v.getpC_pB_pStxtfEVA().getText()), 
									TipoEquipamiento.valueOf(this.v.getpC_pB_pSboxSlot1().getSelectedItem().toString()), 
									TipoEquipamiento.valueOf(this.v.getpC_pB_pSboxSlot2().getSelectedItem().toString()), 
									TipoEquipamiento.valueOf(this.v.getpC_pB_pSboxSlot3().getSelectedItem().toString()));
				if(!this.m.anadirBarco(b)) {
					JOptionPane.showMessageDialog(null,"Error al introducir el barco en la base de datos\nQuizas ese nombre ya este pillado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Error en los datos introducidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void crearEquipamiento() {
		if(this.v.getpC_pE_pNtxtfNombre().getText().equals("")) {
			JOptionPane.showMessageDialog(null,"El nombre esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			try {
				//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
				Equipamiento e = new Equipamiento("0",
												this.v.getpC_pE_pNtxtfNombre().getText(), 
												TipoEquipamiento.valueOf(this.v.getpC_pE_pTboxTipo().getSelectedItem().toString()), 
												Integer.parseInt(this.v.getpC_pE_pDtxtfDmg().getText()), 
												Float.parseFloat(this.v.getpC_pE_pDtxtfCd().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfHP().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfFP().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfAA().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfTRP().getText()),
												Integer.parseInt(this.v.getpC_pE_pStxtfAVI().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfRLD().getText()), 
												Integer.parseInt(this.v.getpC_pE_pStxtfEVA().getText()), 
												TipoAmmo.valueOf(this.v.getpC_pE_pAboxAmmo().getSelectedItem().toString()));
				if(!this.m.anadirEquipamiento(e)) {
					JOptionPane.showMessageDialog(null,"Error al introducir el barco en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null,"Error en los datos introducidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void cargarBoxEquipamiento() {
		this.v.getpC_p2_pEboxEq().removeAllItems();
		Equipamiento[] equipamientos = this.m.getTodosLosEquipamientos(false, null, false);
		for (int i=0; i<equipamientos.length; i++) {
			this.v.getpC_p2_pEboxEq().addItem(equipamientos[i]);
		}
	}
	
	private void duplicarEquipamiento() {
		Equipamiento e = (Equipamiento) this.v.getpC_p2_pEboxEq().getSelectedItem();
		this.m.anadirEquipamiento(e);
	}
	
	private void eliminarEquipamiento() {
		Equipamiento e = (Equipamiento) this.v.getpC_p2_pEboxEq().getSelectedItem();
		this.m.eliminarEquipamiento(e.getCod());
	}
	
	
	private void limpiarCreacionBarco() {
		this.v.getpC_pB_pNtxtfNombre().setText(null);
		this.v.getpC_pB_pCtxtfClase().setText(null);
		this.v.getpC_pB_pFboxFaccion().setSelectedIndex(0);
		this.v.getpC_pB_pTboxTipoBarco().setSelectedIndex(0);
		this.v.getpC_pB_pStxtfHP().setText("0");
		this.v.getpC_pB_pStxtfFP().setText("0");
		this.v.getpC_pB_pStxtfAA().setText("0");
		this.v.getpC_pB_pStxtfTRP().setText("0");
		this.v.getpC_pB_pStxtfAVI().setText("0");
		this.v.getpC_pB_pStxtfRLD().setText("0");
		this.v.getpC_pB_pStxtfEVA().setText("0");
		this.v.getpC_pB_pSboxSlot1().setSelectedIndex(0);
		this.v.getpC_pB_pSboxSlot2().setSelectedIndex(0);
		this.v.getpC_pB_pSboxSlot3().setSelectedIndex(0);
	}
	
	
	private void limpiarCreacionEquipamiento() {
		this.v.getpC_pE_pNtxtfNombre().setText(null);
		this.v.getpC_pE_pTboxTipo().setSelectedIndex(0);
		this.v.getpC_pE_pDtxtfDmg().setText("0");
		this.v.getpC_pE_pDtxtfCd().setText("0.0");
		this.v.getpC_pE_pStxtfHP().setText("0");
		this.v.getpC_pE_pStxtfFP().setText("0");
		this.v.getpC_pE_pStxtfAA().setText("0");
		this.v.getpC_pE_pStxtfTRP().setText("0");
		this.v.getpC_pE_pStxtfAVI().setText("0");
		this.v.getpC_pE_pStxtfRLD().setText("0");
		this.v.getpC_pE_pStxtfEVA().setText("0");
		this.v.getpC_pE_pAboxAmmo().setSelectedIndex(0);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("BackToPP")) {//todos los volver
			this.v.getP1().setVisible(false);
			this.v.getpBarcos().setVisible(false);
			this.v.getpEquipar().setVisible(false);
			this.v.getpCrear().setVisible(false);
			this.v.getPprincipal().setVisible(true);
			System.out.println("Volver a pantalla principal");
		}
		else if(e.getSource()==this.v.getPp_btnGoP1()) {//ir a panel 1
			this.v.getPprincipal().setVisible(false);
			this.v.getP1().setVisible(true);
			System.out.println("Ir a pantalla 1");
		}
		else if(e.getSource()==this.v.getPp_btnGoPBarcos()) {//ir a panel barcos
			this.v.getPprincipal().setVisible(false);
			this.v.getpBarcos().setVisible(true);
			this.ultimoBtnPulsado="Codigo";
			this.cambioBtnPulsado=true;
			this.llenarListaBarcos(this.ultimoBtnPulsado);
			System.out.println("Ir a pantalla Barcos");
		}
		else if(e.getSource()==this.v.getPp_btnGoPEquipar()) {//ir a panel equipar
			this.v.getPprincipal().setVisible(false);
			this.v.getpEquipar().setVisible(true);
			this.actualizarBoxBarcos(-1);
			this.actualizarPanelEquiparBarco();
			this.actualizarBoxEquipamiento();
			this.actualizarPanelEquiparEquipamiento();
			System.out.println("Ir a pantalla Equipar");
		}
		else if(e.getSource()==this.v.getPp_btnGoPCreacion()) {//ir a panel crear
			this.v.getPprincipal().setVisible(false);
			this.v.getpCrear().setVisible(true);
			this.cargarBoxEquipamiento();
			System.out.println("Ir a pantalla Creacion");
		}
		else if(e.getActionCommand().equals("sort")) {//botones de ordenacion
			JButton aux = (JButton)e.getSource();
			this.llenarListaBarcos(aux.getText());
		}
		else if(e.getSource()==this.v.getpBarcos_btnEliminar()) {//boton barco eliminar
			this.eliminarBarcos();
		}
		else if(e.getSource()==this.v.getpBarcos_btnExaminar()) {//boton barco examinar
			this.examinarBarco();
		}
		else if(e.getSource()==this.v.getpEquipar_p2_p2_ChckMostrarEquipados()) {//check equipar para mostrar equipados
			this.actualizarBoxEquipamiento();
			this.actualizarPanelEquiparEquipamiento();
		}
		else if(e.getSource()==this.v.getpEquipar_p2_p2_ChckMostrarPosibles()) {//check equipar para mostrar equipados
			this.actualizarBoxEquipamiento();
			this.actualizarPanelEquiparEquipamiento();
		}
		else if(e.getSource()==this.v.getpEquipar_btnEquipar()) {//boton equipar
			this.equipar();
		}
		else if(e.getSource()==this.v.getpEquipar_btnDesequipar()) {//boton desequipar
			this.desEquipar();
		}
		else if(e.getSource()==this.v.getpEquipar_btnDesequiparTodo()) {//boton desequipar todo
			this.desEquiparTodo();
		}
		else if(e.getSource()==this.v.getpC_pBbtnCrear()) {//boton crear barco
			this.crearBarco();
			this.limpiarCreacionBarco();
		}
		else if(e.getSource()==this.v.getpC_pBbtnCancelar()) {//boton cancelar barco
			this.limpiarCreacionBarco();
		}
		else if(e.getSource()==this.v.getpC_pE_pBbtnCrear()) {//boton crear equipamiento
			this.crearEquipamiento();
			this.limpiarCreacionEquipamiento();
			this.cargarBoxEquipamiento();
		}
		else if(e.getSource()==this.v.getpC_pE_pBbtnCancelar()) {//boton cancelar equipamiento
			this.limpiarCreacionEquipamiento();
		}
		else if(e.getSource()==this.v.getpC_p2_pDbtnDuplicar()) {//boton duplicar equipamiento
			this.duplicarEquipamiento();
			this.cargarBoxEquipamiento();
		}
		else if(e.getSource()==this.v.getpC_p2_pDbtnEliminar()) {//boton eliminar equipamiento
			this.eliminarEquipamiento();
			this.cargarBoxEquipamiento();
		}
		
	}
	


	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(e.getSource()==this.v.getpEquipar_boxBarco()) {
				this.actualizarPanelEquiparBarco();
				this.actualizarBoxBarcosEquipo();
			}
			else if(e.getSource()==this.v.getpEquipar_boxBarcoEquipo()) {
				this.actualizarBoxEquipamiento();
				this.actualizarPanelEquiparEquipamiento();
				this.actualizarPanelEquiparBarcoEquipo();
			}
			else if(e.getSource()==this.v.getpEquipar_boxEquipamiento()) {
				this.actualizarPanelEquiparEquipamiento();
			}
		}
	}

}
