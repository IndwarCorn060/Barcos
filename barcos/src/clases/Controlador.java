package clases;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Controlador implements ActionListener, ItemListener {
	
	private Vista v;
	
	public Controlador(Vista v) {
		this.v = v;
	}
	
	private void sort(String n) {
		if(n.equals("Codigo")) {
			
		}
		else if(n.equals("Nombre")) {
			
		}
		else if(n.equals("Clase")) {
			
		}
		else if(n.equals("Tipo")) {
			
		}
		else if(n.equals("Faccion")) {
			
		}
		else if(n.equals("HP")) {
			
		}
		else if(n.equals("FP")) {
			
		}
		else if(n.equals("AA")) {
			
		}
		else if(n.equals("TRP")) {
			
		}
		else if(n.equals("AVI")) {
			
		}
		else if(n.equals("RLD")) {
			
		}
		else if(n.equals("EVA")) {
			
		}
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
	
	private void actualizarPanelEquiparBarco(Barco b) {
		this.v.getpEq_1etqtNombre().setText("Nombre: "+b.getNombre());
		this.v.getpEq_1etqtHP().setText("HP: "+b.getStats()[0]);
		this.v.getpEq_1etqtFP().setText("FP: "+b.getStats()[1]);
		this.v.getpEq_1etqtAA().setText("AA: "+b.getStats()[2]);
		this.v.getpEq_1etqtTRP().setText("TRP: "+b.getStats()[3]);
		this.v.getpEq_1etqtAVI().setText("AVI: "+b.getStats()[4]);
		this.v.getpEq_1etqtRLD().setText("RLD: "+b.getStats()[5]);
		this.v.getpEq_1etqtEVA().setText("EVA: "+b.getStats()[6]);
	}
	
	private void actualizarPanelEquiparBarcoEquipo(Equipamiento e) {
		this.v.getpEq_2etqtTipoSlot().setText("Tipo de Slot: "+e.getTipo());
		this.v.getpEq_2etqtNombre().setText("Nombre: "+e.getNombre());
		this.v.getpEq_2etqtHP().setText("HP: "+e.getStats()[0]);
		this.v.getpEq_2etqtFP().setText("FP: "+e.getStats()[1]);
		this.v.getpEq_2etqtAA().setText("AA: "+e.getStats()[2]);
		this.v.getpEq_2etqtTRP().setText("TRP: "+e.getStats()[3]);
		this.v.getpEq_2etqtAVI().setText("AVI: "+e.getStats()[4]);
		this.v.getpEq_2etqtRLD().setText("RLD: "+e.getStats()[5]);
		this.v.getpEq_2etqtEVA().setText("EVA: "+e.getStats()[6]);
		this.v.getpEq_2etqtDMG().setText("DMG: "+e.getDmg());
		this.v.getpEq_2etqtCD().setText("CD: "+e.getCd());
		this.v.getpEq_2etqtTipoAmmo().setText("Ammo: "+e.getAmmo());
	}
	
	private void actualizarPanelEquiparEquipamiento(Equipamiento e) {
		this.v.getpEq_3etqtTipoSlot().setText("Tipo de Slot: "+e.getTipo());
		this.v.getpEq_3etqtNombre().setText("Nombre: "+e.getNombre());
		this.v.getpEq_3etqtHP().setText("HP: "+e.getStats()[0]);
		this.v.getpEq_3etqtFP().setText("FP: "+e.getStats()[1]);
		this.v.getpEq_3etqtAA().setText("AA: "+e.getStats()[2]);
		this.v.getpEq_3etqtTRP().setText("TRP: "+e.getStats()[3]);
		this.v.getpEq_3etqtAVI().setText("AVI: "+e.getStats()[4]);
		this.v.getpEq_3etqtRLD().setText("RLD: "+e.getStats()[5]);
		this.v.getpEq_3etqtEVA().setText("EVA: "+e.getStats()[6]);
		this.v.getpEq_3etqtDMG().setText("DMG: "+e.getDmg());
		this.v.getpEq_3etqtCD().setText("CD: "+e.getCd());
		this.v.getpEq_3etqtTipoAmmo().setText("Ammo: "+e.getAmmo());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
			System.out.println("Ir a pantalla Barcos");
		}
		else if(e.getSource()==this.v.getPp_btnGoPEquipar()) {//ir a panel equipar
			this.v.getPprincipal().setVisible(false);
			this.v.getpEquipar().setVisible(true);
			System.out.println("Ir a pantalla Equipar");
		}
		else if(e.getSource()==this.v.getPp_btnGoPCreacion()) {//ir a panel crear
			this.v.getPprincipal().setVisible(false);
			this.v.getpCrear().setVisible(true);
			System.out.println("Ir a pantalla Creacion");
		}
		else if(e.getActionCommand().equals("sort")) {//botones de ordenacion
			JButton aux = (JButton)e.getSource();
			this.sort(aux.getText());
		}
		else if(e.getSource()==this.v.getpBarcos_btnEliminar()) {//boton barco eliminar
			
		}
		else if(e.getSource()==this.v.getpBarcos_btnExaminar()) {//boton barco examinar
			
		}
		else if(e.getSource()==this.v.getpEquipar_p2_p2_ChckMostrarEquipados()) {//check equipar para mostrar equipados
			JCheckBox aux = (JCheckBox)e.getSource();
			if(aux.isSelected()) {
				
			}
			else {
				
			}
		}
		else if(e.getSource()==this.v.getpEquipar_p2_p2_ChckMostrarPosibles()) {//check equipar para mostrar equipados
			JCheckBox aux = (JCheckBox)e.getSource();
			if(aux.isSelected()) {
				
			}
			else {
				
			}
		}
		else if(e.getSource()==this.v.getpEquipar_btnEquipar()) {//boton equipar
			
		}
		else if(e.getSource()==this.v.getpEquipar_btnDesequipar()) {//boton desequipar
			
		}
		else if(e.getSource()==this.v.getpEquipar_btnDesequiparTodo()) {//boton desequipar todo
			
		}
		else if(e.getSource()==this.v.getpC_pBbtnCrear()) {//boton crear barco
			
		}
		else if(e.getSource()==this.v.getpC_pBbtnCancelar()) {//boton cancelar barco
			this.limpiarCreacionBarco();
		}
		else if(e.getSource()==this.v.getpC_pE_pBbtnCrear()) {//boton crear equipamiento
			
		}
		else if(e.getSource()==this.v.getpC_pE_pBbtnCancelar()) {//boton cancelar equipamiento
			this.limpiarCreacionEquipamiento();
		}
		else if(e.getSource()==this.v.getpC_p2_pDbtnDuplicar()) {//boton duplicar equipamiento
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange()==ItemEvent.SELECTED) {
			if(e.getSource()==this.v.getpEquipar_boxBarco()) {
				this.actualizarPanelEquiparBarco((Barco)this.v.getpEquipar_boxBarco().getSelectedItem());
			}
			else if(e.getSource()==this.v.getpEquipar_boxBarcoEquipo()) {
				this.actualizarPanelEquiparBarcoEquipo((Equipamiento)this.v.getpEquipar_boxBarcoEquipo().getSelectedItem());
			}
			else if(e.getSource()==this.v.getpEquipar_boxEquipamiento()) {
				this.actualizarPanelEquiparEquipamiento((Equipamiento)this.v.getpEquipar_boxEquipamiento().getSelectedItem());
			}
		}
	}

}
