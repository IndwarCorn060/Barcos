package clases;

import java.awt.*;

import javax.swing.*;

public class Vista extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//panel Principal
	private JPanel pprincipal, pp_pNorte, pp_pPortada;
	private JButton pp_btnGoP1, pp_btnGoPBarcos, pp_btnGoPEquipar, pp_btnGoPCreacion;
	private ImageIcon image;
	private JLabel pp_pp_etqtportda, pp_etqutTitulo;
	
	//panel tabla
	private JPanel p1;
	private JButton p1_btnBack;
	private JTable p1_tabla;
	private JScrollPane p1_pTabla;
	
	//panel Barcos
	private JPanel pBarcos, pBarcos_pSur, pB_pIzq, pB_pDer;
	private JButton pBarcos_btnBack, pBarcos_btnEliminar, pBarcos_btnExaminar;
	private JButton pB_pIbtnCod, pB_pIbtnNombre, pB_pIbtnClase, pB_pIbtnTipo, pB_pIbtnFaccion;
	private JButton pB_pDbtnHP, pB_pDbtnFP, pB_pDbtnAA, pB_pDbtnTRP, pB_pDbtnAVI, pB_pDbtnRLD, pB_pDbtnEVA;
	private JScrollPane pBarcos_centro;
	private JList<String> pBarcos_centro_lstBarcos;
	private DefaultListModel<String> listaBarcos;
	//poner modo de ordenacion
	
	//panel Equipar
	private JPanel pEquipar;
	private JComboBox<Barco> pEquipar_boxBarco;
	private JComboBox<String> pEquipar_boxBarcoEquipo;
	private JComboBox<Equipamiento> pEquipar_boxEquipamiento;
	private JLabel pEq_1etqtNombre, pEq_1etqtHP, pEq_1etqtFP, pEq_1etqtAA, pEq_1etqtTRP, pEq_1etqtAVI, pEq_1etqtRLD, pEq_1etqtEVA;
	private JLabel pEq_2etqtNombre, pEq_2etqtHP, pEq_2etqtFP, pEq_2etqtAA, pEq_2etqtTRP, pEq_2etqtAVI, pEq_2etqtRLD, pEq_2etqtEVA;
	private JLabel pEq_2etqtTipoSlot, pEq_2etqtDMG, pEq_2etqtCD, pEq_2etqtTipoAmmo;
	private JLabel pEq_3etqtNombre, pEq_3etqtHP, pEq_3etqtFP, pEq_3etqtAA, pEq_3etqtTRP, pEq_3etqtAVI, pEq_3etqtRLD, pEq_3etqtEVA;
	private JLabel pEq_3etqtTipoSlot, pEq_3etqtDMG, pEq_3etqtCD, pEq_3etqtTipoAmmo;
	private JCheckBox pEquipar_p2_p2_ChckMostrarEquipados, pEquipar_p2_p2_ChckMostrarPosibles;
	private JButton pEquipar_btnEquipar, pEquipar_btnDesequipar, pEquipar_btnDesequiparTodo, pEquipar_btnBack;
	private JPanel pEquipar_p1, pEquipar_p1_p1, pEquipar_p1_p1_p1, pEquipar_p1_p2, pEquipar_p1_p2_p1, pEquipar_p2, pEquipar_p2_p1, pEquipar_p2_p1_p1;
	private JPanel pEquipar_p2_p2, pEquipar_p2_p2_p1, pEquipar_p1_p2_p2, pEquipar_p2_p1_p2;
	private JPanel pE_p1_pNombre, pE_p2_pTipoSlot, pE_p2_pNombre, pE_p3_pTipoSlot, pE_p3_pNombre, pE_p3_pMostrarEquipados, pE_p3_pMostrarPosibles;
	
	//panel Creacion
	private JPanel pCrear, pC_pBarco, pC_pDer, pC_p2, pC_p3, pC_pEquipamiento;
	
	private JPanel pC_pB_pNombre, pC_pB_pClase, pC_pB_pFaccion, pC_pB_pTipo, pC_pB_pStats, pC_pB_pSlot1, pC_pB_pSlot2, pC_pB_pSlot3;
	private JPanel pC_pB_pCrear, pC_pB_pCancelar;
	private JLabel pC_pB_pNetqtNombre, pC_pB_pC_etqtClase, pC_pB_pFetqeFaccion, pC_pB_pTetqtTipoBarco;
	private JLabel pC_pB_pSetqtSlot1, pC_pB_pSetqtSlot2, pC_pB_pSetqtSlot3;
	private JLabel pC_pB_pSetqtHP, pC_pB_pSetqtFP, pC_pB_pSetqtAA, pC_pB_pSetqtTRP, pC_pB_pSetqtAVI, pC_pB_pSetqtRLD, pC_pB_pSetqtEVA;
	private JTextField pC_pB_pNtxtfNombre, pC_pB_pCtxtfClase;
	private JTextField pC_pB_pStxtfHP, pC_pB_pStxtfFP, pC_pB_pStxtfAA, pC_pB_pStxtfTRP, pC_pB_pStxtfAVI, pC_pB_pStxtfRLD, pC_pB_pStxtfEVA;
	private JComboBox<Faccion> pC_pB_pFboxFaccion;
	private JComboBox<TipoBarco> pC_pB_pTboxTipoBarco;
	private JComboBox<TipoEquipamiento> pC_pB_pSboxSlot1, pC_pB_pSboxSlot2, pC_pB_pSboxSlot3;
	private JButton pC_pBbtnCrear, pC_pBbtnCancelar;
	
	private JPanel pC_pE_pNombre, pC_pE_pTipo, pC_pE_pDMGCD, pC_pE_pStats, pC_pE_pAmmo, pC_pE_pButtons;
	private JLabel pC_pE_pNetqtNombre, pC_pE_pTetqtTipo,  pC_pE_pDetqtDmg,  pC_pE_pDetqtCd,  pC_pE_pAetqtAmmo;
	private JLabel pC_pE_pSetqtHP, pC_pE_pSetqtFP, pC_pE_pSetqtAA, pC_pE_pSetqtTRP, pC_pE_pSetqtAVI, pC_pE_pSetqtRLD, pC_pE_pSetqtEVA;
	private JTextField pC_pE_pNtxtfNombre, pC_pE_pDtxtfDmg, pC_pE_pDtxtfCd;
	private JTextField pC_pE_pStxtfHP, pC_pE_pStxtfFP, pC_pE_pStxtfAA, pC_pE_pStxtfTRP, pC_pE_pStxtfAVI, pC_pE_pStxtfRLD, pC_pE_pStxtfEVA;
	private JComboBox<TipoEquipamiento> pC_pE_pTboxTipo;
	private JComboBox<TipoAmmo> pC_pE_pAboxAmmo;
	private JButton pC_pE_pBbtnCrear, pC_pE_pBbtnCancelar;
	
	private JPanel pC_p2_pEq, pC_p2_pDuplicar;
	private JComboBox<Equipamiento> pC_p2_pEboxEq;
	private JButton pC_p2_pDbtnDuplicar, pC_p2_pDbtnEliminar, pC_p3_pDbtnVolver;
	
	
 	private void crearComponentesPanelPrincipal() {
 		
		this.pp_btnGoP1 = new JButton();
		this.pp_btnGoP1.setPreferredSize(new Dimension(144,22));
		this.pp_btnGoP1.setIcon(new ImageIcon("./res/datos.png")); 
		this.pp_btnGoPBarcos = new JButton();
		this.pp_btnGoPBarcos.setPreferredSize(new Dimension(166,22));
		this.pp_btnGoPBarcos.setIcon(new ImageIcon("./res/barcos.png")); 
		this.pp_btnGoPEquipar = new JButton();
		this.pp_btnGoPEquipar.setPreferredSize(new Dimension(186,22));
		this.pp_btnGoPEquipar.setIcon(new ImageIcon("./res/equipar.png")); 
		this.pp_btnGoPCreacion = new JButton();
		this.pp_btnGoPCreacion.setPreferredSize(new Dimension(140,22));
		this.pp_btnGoPCreacion.setIcon(new ImageIcon("./res/crear.png")); 
		
		this.pprincipal = new JPanel();
		this.pprincipal.setLayout(new BoxLayout(this.pprincipal, BoxLayout.PAGE_AXIS));
		this.pp_pNorte = new JPanel();
		this.pp_pPortada = new JPanel();
		
		this.image = new ImageIcon("./res/portada.png");
		this.pp_pp_etqtportda = new JLabel(this.image);
		
		this.pp_etqutTitulo = new JLabel("Battleship 'Roma' in 1940");
	}
	
	private void montarComponentesPanelPrincipal() {
		this.add(this.pprincipal);
			this.pprincipal.add(this.pp_pNorte);
				this.pp_pNorte.add(this.pp_btnGoP1);
				this.pp_pNorte.add(this.pp_btnGoPBarcos);
				this.pp_pNorte.add(this.pp_btnGoPEquipar);
				this.pp_pNorte.add(this.pp_btnGoPCreacion);
			this.pprincipal.add(this.pp_pPortada);
				this.pp_pPortada.add(this.pp_pp_etqtportda);
			this.pprincipal.add(this.pp_etqutTitulo);
	}
	
	private void crearComponentesPanel1(){
		this.p1_btnBack = new JButton("Volver");
		this.p1_btnBack.setActionCommand("BackToPP");
		this.p1_tabla = new JTable(); 
		this.p1_pTabla = new JScrollPane(this.p1_tabla);
		this.p1 = new JPanel(new BorderLayout());
		this.p1.setPreferredSize(new Dimension(600,420));
	}
	
	private void montarComponentesPanel1() {
		this.add(this.p1);
			this.p1.add(this.p1_btnBack, BorderLayout.NORTH);
			this.p1.add(this.p1_pTabla, BorderLayout.CENTER);
	}
	
	private void crearComponentesPanelBarcos() {
		this.pBarcos_btnBack = new JButton("Volver");
		this.pBarcos_btnBack.setActionCommand("BackToPP");
		this.pBarcos_btnEliminar = new JButton("Eliminar");
		this.pBarcos_btnExaminar = new JButton("Examinar");
		this.pBarcos_centro_lstBarcos = new JList<String>();
		
		this.pBarcos = new JPanel(new BorderLayout());
		this.pBarcos_pSur = new JPanel();
		this.pBarcos_centro = new JScrollPane(this.pBarcos_centro_lstBarcos);
		this.pBarcos_centro.setPreferredSize(new Dimension(500,400));
		this.listaBarcos = new DefaultListModel<String>();
		this.pBarcos_centro_lstBarcos.setModel(this.listaBarcos);
		this.pB_pIzq = new JPanel();
		this.pB_pIzq.setLayout(new GridLayout(5,1));
		this.pB_pIzq.setPreferredSize(new Dimension(90,this.pB_pIzq.getHeight()));
		this.pB_pIzq.setBorder(BorderFactory.createTitledBorder("Odenar por:"));
		this.pB_pDer = new JPanel();
		this.pB_pDer.setLayout(new GridLayout(7,1));
		this.pB_pDer.setPreferredSize(new Dimension(90,this.pB_pIzq.getHeight()));
		this.pB_pDer.setBorder(BorderFactory.createTitledBorder("Odenar por:"));
		
		this.pB_pIbtnCod = new JButton("Codigo");
		this.pB_pIbtnNombre = new JButton("Nombre");
		this.pB_pIbtnClase = new JButton("Clase");
		this.pB_pIbtnTipo = new JButton("Tipo");
		this.pB_pIbtnFaccion = new JButton("Faccion");
		this.pB_pDbtnHP = new JButton("HP");
		this.pB_pDbtnFP = new JButton("FP");
		this.pB_pDbtnAA = new JButton("AA");
		this.pB_pDbtnTRP = new JButton("TRP");
		this.pB_pDbtnAVI = new JButton("AVI");
		this.pB_pDbtnRLD = new JButton("RLD");
		this.pB_pDbtnEVA = new JButton("EVA");
		this.pB_pIbtnCod.setActionCommand("sort");
		this.pB_pIbtnNombre.setActionCommand("sort");
		this.pB_pIbtnClase.setActionCommand("sort");
		this.pB_pIbtnTipo.setActionCommand("sort");
		this.pB_pIbtnFaccion.setActionCommand("sort");
		this.pB_pDbtnHP.setActionCommand("sort");
		this.pB_pDbtnFP.setActionCommand("sort");
		this.pB_pDbtnAA.setActionCommand("sort");
		this.pB_pDbtnTRP.setActionCommand("sort");
		this.pB_pDbtnAVI.setActionCommand("sort");
		this.pB_pDbtnRLD.setActionCommand("sort");
		this.pB_pDbtnEVA.setActionCommand("sort");
	}
	
	private void montarComponentesPanelBarcos() {
		this.add(this.pBarcos);
			this.pBarcos.add(this.pBarcos_centro, BorderLayout.CENTER);
			this.pBarcos.add(this.pBarcos_pSur, BorderLayout.SOUTH);
				this.pBarcos_pSur.add(this.pBarcos_btnBack);
				this.pBarcos_pSur.add(this.pBarcos_btnEliminar);
				this.pBarcos_pSur.add(this.pBarcos_btnExaminar);
			this.pBarcos.add(this.pB_pIzq, BorderLayout.WEST);
				this.pB_pIzq.add(this.pB_pIbtnCod);
				this.pB_pIzq.add(this.pB_pIbtnNombre);
				this.pB_pIzq.add(this.pB_pIbtnClase);
				this.pB_pIzq.add(this.pB_pIbtnFaccion);
				this.pB_pIzq.add(this.pB_pIbtnTipo);
			this.pBarcos.add(this.pB_pDer, BorderLayout.EAST);
				this.pB_pDer.add(this.pB_pDbtnHP);
				this.pB_pDer.add(this.pB_pDbtnFP);
				this.pB_pDer.add(this.pB_pDbtnAA);
				this.pB_pDer.add(this.pB_pDbtnTRP);
				this.pB_pDer.add(this.pB_pDbtnAVI);
				this.pB_pDer.add(this.pB_pDbtnRLD);
				this.pB_pDer.add(this.pB_pDbtnEVA);
	}
	
	private void crearComponentesPanelEquipamiento() {
		this.pEquipar = new JPanel();
		this.pEquipar.setLayout(new BoxLayout(this.pEquipar, BoxLayout.LINE_AXIS));
		this.pEquipar.setBorder(BorderFactory.createTitledBorder("Equipar"));
		this.pEquipar_p1 = new JPanel();
		this.pEquipar_p1.setPreferredSize(new Dimension(300, this.pEquipar_p1.getHeight()));
		this.pEquipar_p1.setLayout(new BoxLayout(this.pEquipar_p1, BoxLayout.PAGE_AXIS));
		this.pEquipar_p1_p1 = new JPanel();
		this.pEquipar_p1_p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.pEquipar_p1_p1.setLayout(new BoxLayout(this.pEquipar_p1_p1, BoxLayout.Y_AXIS));
		this.pEquipar_p1_p1_p1 = new JPanel(new GridLayout(2,4));
		this.pEquipar_p1_p2 = new JPanel();
		this.pEquipar_p1_p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.pEquipar_p1_p2.setLayout(new BoxLayout(this.pEquipar_p1_p2, BoxLayout.Y_AXIS));
		this.pEquipar_p1_p2_p1 = new JPanel(new GridLayout(2,4));
		this.pEquipar_p1_p2_p2 = new JPanel(new GridLayout(1,4));
		this.pEquipar_p2 = new JPanel();
		this.pEquipar_p2.setPreferredSize(new Dimension(300,400));
		this.pEquipar_p2.setLayout(new BoxLayout(this.pEquipar_p2, BoxLayout.PAGE_AXIS));
		this.pEquipar_p2_p1 = new JPanel();
		this.pEquipar_p2_p1.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
		this.pEquipar_p2_p1.setLayout(new BoxLayout(this.pEquipar_p2_p1, BoxLayout.Y_AXIS));
		this.pEquipar_p2_p1_p1 = new JPanel(new GridLayout(2,4));
		this.pEquipar_p2_p1_p2 = new JPanel(new GridLayout(1,4));
		this.pEquipar_p2_p2 = new JPanel();
		this.pEquipar_p2_p2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.pEquipar_p2_p2.setLayout(new BoxLayout(this.pEquipar_p2_p2, BoxLayout.Y_AXIS));
		this.pEquipar_p2_p2_p1 = new JPanel(new GridLayout(2,2));
		
		
		this.pEquipar_boxBarco = new JComboBox<Barco>();
		this.pEquipar_boxBarcoEquipo = new JComboBox<String>();
		this.pEquipar_boxEquipamiento = new JComboBox<Equipamiento>();
		
		this.pEquipar_p2_p2_ChckMostrarEquipados = new JCheckBox("Mostrar Equipados");
		this.pEquipar_p2_p2_ChckMostrarPosibles = new JCheckBox("Mostrar solo Posibles");
		this.pEquipar_p2_p2_ChckMostrarPosibles.setSelected(true);
		
		this.pEquipar_btnEquipar = new JButton("Equipar");
		this.pEquipar_btnDesequipar = new JButton("DesEquipar");
		this.pEquipar_btnDesequiparTodo = new JButton("DesEquipar Todo");
		this.pEquipar_btnBack = new JButton("Volver");
		this.pEquipar_btnBack.setActionCommand("BackToPP");
		
		this.pEq_1etqtNombre = new JLabel("Nombre: ");
		this.pEq_1etqtHP = new JLabel("HP: ");
		this.pEq_1etqtFP = new JLabel("FP: ");
		this.pEq_1etqtAA = new JLabel("AA: ");
		this.pEq_1etqtTRP = new JLabel("TRP: ");
		this.pEq_1etqtAVI = new JLabel("AVI: ");
		this.pEq_1etqtRLD = new JLabel("RLD: ");
		this.pEq_1etqtEVA = new JLabel("EVA: ");
		
		this.pEq_2etqtNombre = new JLabel("Nombre: ");
		this.pEq_2etqtTipoSlot = new JLabel("Tipo de Slot: ");
		this.pEq_2etqtHP = new JLabel("HP: ");
		this.pEq_2etqtFP = new JLabel("FP: ");
		this.pEq_2etqtAA = new JLabel("AA: ");
		this.pEq_2etqtTRP = new JLabel("TRP: ");
		this.pEq_2etqtAVI = new JLabel("AVI: ");
		this.pEq_2etqtRLD = new JLabel("RLD: ");
		this.pEq_2etqtEVA = new JLabel("EVA: ");
		this.pEq_2etqtDMG = new JLabel("DMG: ");
		this.pEq_2etqtCD = new JLabel("CD: ");
		this.pEq_2etqtTipoAmmo = new JLabel("AMMO: ");
		
		this.pEq_3etqtNombre = new JLabel("Nombre: ");
		this.pEq_3etqtTipoSlot = new JLabel("Tipo de Slot: ");
		this.pEq_3etqtHP = new JLabel("HP: ");
		this.pEq_3etqtFP = new JLabel("FP: ");
		this.pEq_3etqtAA = new JLabel("AA: ");
		this.pEq_3etqtTRP = new JLabel("TRP: ");
		this.pEq_3etqtAVI = new JLabel("AVI: ");
		this.pEq_3etqtRLD = new JLabel("RLD: ");
		this.pEq_3etqtEVA = new JLabel("EVA: ");
		this.pEq_3etqtDMG = new JLabel("DMG: ");
		this.pEq_3etqtCD = new JLabel("CD: ");
		this.pEq_3etqtTipoAmmo = new JLabel("AMMO: ");
		
		this.pE_p1_pNombre = new JPanel();
		this.pE_p2_pTipoSlot = new JPanel();
		this.pE_p2_pNombre = new JPanel();
		this.pE_p3_pTipoSlot = new JPanel();
		this.pE_p3_pNombre = new JPanel();
		this.pE_p3_pMostrarEquipados = new JPanel();
		this.pE_p3_pMostrarPosibles = new JPanel();
	}
	
	private void montarComponentesPanelEquipamiento() {
		this.add(this.pEquipar);
			this.pEquipar.add(this.pEquipar_p1);
				this.pEquipar_p1.add(this.pEquipar_p1_p1);
					this.pEquipar_p1_p1.add(this.pEquipar_boxBarco);
					this.pEquipar_p1_p1.add(this.pE_p1_pNombre);
						this.pE_p1_pNombre.add(this.pEq_1etqtNombre);
					this.pEquipar_p1_p1.add(this.pEquipar_p1_p1_p1);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtHP);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtFP);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtAA);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtTRP);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtAVI);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtRLD);
						this.pEquipar_p1_p1_p1.add(this.pEq_1etqtEVA);
				this.pEquipar_p1.add(new JSeparator(SwingConstants.HORIZONTAL));
				this.pEquipar_p1.add(this.pEquipar_p1_p2);
					this.pEquipar_p1_p2.add(this.pEquipar_boxBarcoEquipo);
					this.pEquipar_p1_p2.add(this.pE_p2_pTipoSlot);
						this.pE_p2_pTipoSlot.add(this.pEq_2etqtTipoSlot);
					this.pEquipar_p1_p2.add(this.pE_p2_pNombre);
						this.pE_p2_pNombre.add(this.pEq_2etqtNombre);
					this.pEquipar_p1_p2.add(this.pEquipar_p1_p2_p1);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtHP);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtFP);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtAA);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtTRP);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtAVI);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtRLD);
						this.pEquipar_p1_p2_p1.add(this.pEq_2etqtEVA);
					this.pEquipar_p1_p2.add(this.pEquipar_p1_p2_p2);
						this.pEquipar_p1_p2_p2.add(this.pEq_2etqtDMG);
						this.pEquipar_p1_p2_p2.add(this.pEq_2etqtCD);
						this.pEquipar_p1_p2_p2.add(this.pEq_2etqtTipoAmmo);
			this.pEquipar.add(new JSeparator(SwingConstants.VERTICAL));
			this.pEquipar.add(this.pEquipar_p2);
				this.pEquipar_p2.add(this.pEquipar_p2_p1);
					this.pEquipar_p2_p1.add(this.pEquipar_boxEquipamiento);
					this.pEquipar_p2_p1.add(this.pE_p3_pTipoSlot);
						this.pE_p3_pTipoSlot.add(this.pEq_3etqtTipoSlot);
					this.pEquipar_p2_p1.add(this.pE_p3_pNombre);
						this.pE_p3_pNombre.add(this.pEq_3etqtNombre);
					this.pEquipar_p2_p1.add(this.pEquipar_p2_p1_p1);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtHP);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtFP);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtAA);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtTRP);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtAVI);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtRLD);
						this.pEquipar_p2_p1_p1.add(this.pEq_3etqtEVA);
					this.pEquipar_p2_p1.add(this.pEquipar_p2_p1_p2);
						this.pEquipar_p2_p1_p2.add(this.pEq_3etqtDMG);
						this.pEquipar_p2_p1_p2.add(this.pEq_3etqtCD);
						this.pEquipar_p2_p1_p2.add(this.pEq_3etqtTipoAmmo);
					this.pEquipar_p2_p1.add(this.pE_p3_pMostrarEquipados);
						this.pE_p3_pMostrarEquipados.add(this.pEquipar_p2_p2_ChckMostrarEquipados);
					this.pEquipar_p2_p1.add(this.pE_p3_pMostrarPosibles);
						this.pE_p3_pMostrarPosibles.add(this.pEquipar_p2_p2_ChckMostrarPosibles);
				this.pEquipar_p2.add(new JSeparator(SwingConstants.HORIZONTAL));
				this.pEquipar_p2.add(this.pEquipar_p2_p2);
					this.pEquipar_p2_p2.add(this.pEquipar_p2_p2_p1);
						this.pEquipar_p2_p2_p1.add(this.pEquipar_btnEquipar);
						this.pEquipar_p2_p2_p1.add(this.pEquipar_btnDesequipar);
						this.pEquipar_p2_p2_p1.add(this.pEquipar_btnBack);
						this.pEquipar_p2_p2_p1.add(this.pEquipar_btnDesequiparTodo);
					
	}

	private void crearComponentesPanelCreacion() {
		this.pCrear = new JPanel();
		this.pCrear.setLayout(new BoxLayout(this.pCrear, BoxLayout.LINE_AXIS));
		this.pCrear.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		
		this.pC_pBarco = new JPanel();
		this.pC_pBarco.setLayout(new BoxLayout(this.pC_pBarco, BoxLayout.PAGE_AXIS));
		this.pC_pBarco.setBorder(BorderFactory.createTitledBorder("Crear Barco"));
		this.pC_pB_pNombre = new JPanel();
		this.pC_pB_pClase = new JPanel();
		this.pC_pB_pFaccion = new JPanel();
		this.pC_pB_pTipo = new JPanel();
		this.pC_pB_pStats = new JPanel(new GridLayout(2,8));
		this.pC_pB_pSlot1 = new JPanel();
		this.pC_pB_pSlot2 = new JPanel();
		this.pC_pB_pSlot3 = new JPanel();
		this.pC_pB_pCrear = new JPanel();
		this.pC_pB_pCancelar = new JPanel();
		this.pC_pB_pNetqtNombre = new JLabel("Nombre:");
		this.pC_pB_pC_etqtClase = new JLabel("Clase:");
		this.pC_pB_pFetqeFaccion = new JLabel("Faccion:");
		this.pC_pB_pTetqtTipoBarco = new JLabel("Tipo:");
		this.pC_pB_pSetqtSlot1 = new JLabel("Slot 1:");
		this.pC_pB_pSetqtSlot2 = new JLabel("Slot 2:");
		this.pC_pB_pSetqtSlot3 = new JLabel("Slot 3:");
		this.pC_pB_pSetqtHP = new JLabel("HP:");
		this.pC_pB_pSetqtFP = new JLabel("FP:");
		this.pC_pB_pSetqtAA = new JLabel("AA:");
		this.pC_pB_pSetqtTRP = new JLabel("TRP:");
		this.pC_pB_pSetqtAVI = new JLabel("AVI:");
		this.pC_pB_pSetqtRLD = new JLabel("RLD:");
		this.pC_pB_pSetqtEVA = new JLabel("EVA:");
		this.pC_pB_pNtxtfNombre = new JTextField(10);
		this.pC_pB_pCtxtfClase = new JTextField(10);
		this.pC_pB_pStxtfHP = new JTextField("0",3);
		this.pC_pB_pStxtfFP = new JTextField("0",3);
		this.pC_pB_pStxtfAA = new JTextField("0",3);
		this.pC_pB_pStxtfTRP = new JTextField("0",3);
		this.pC_pB_pStxtfAVI = new JTextField("0",3);
		this.pC_pB_pStxtfRLD = new JTextField("0",3);
		this.pC_pB_pStxtfEVA = new JTextField("0",3);
		this.pC_pB_pFboxFaccion = new JComboBox<Faccion>(Faccion.values());
		this.pC_pB_pTboxTipoBarco = new JComboBox<TipoBarco>(TipoBarco.values());
		this.pC_pB_pSboxSlot1 = new JComboBox<TipoEquipamiento>(TipoEquipamiento.values());
		this.pC_pB_pSboxSlot2 = new JComboBox<TipoEquipamiento>(TipoEquipamiento.values());
		this.pC_pB_pSboxSlot3 = new JComboBox<TipoEquipamiento>(TipoEquipamiento.values());
		this.pC_pBbtnCrear = new JButton("Crear");
		this.pC_pBbtnCancelar = new JButton("Cancelar");
		
		this.pC_pDer = new JPanel();
		this.pC_pDer.setLayout(new BoxLayout(this.pC_pDer, BoxLayout.PAGE_AXIS));
		this.pC_p2 = new JPanel();
		this.pC_p2.setLayout(new BoxLayout(this.pC_p2, BoxLayout.PAGE_AXIS));
		this.pC_p2.setBorder(BorderFactory.createTitledBorder("Duplicar o Eliminar"));
		this.pC_p2_pEq = new JPanel();
		this.pC_p2_pEboxEq = new JComboBox<Equipamiento>();
		this.pC_p2_pDuplicar  = new JPanel();
		this.pC_p2_pDbtnDuplicar = new JButton("Duplicar");
		this.pC_p2_pDbtnEliminar = new JButton("Eliminar");
		this.pC_p3 = new JPanel();
		this.pC_p3_pDbtnVolver = new JButton("Volver");
		this.pC_p3_pDbtnVolver.setActionCommand("BackToPP");
		
		this.pC_pEquipamiento = new JPanel();
		this.pC_pEquipamiento.setLayout(new BoxLayout(this.pC_pEquipamiento, BoxLayout.PAGE_AXIS));
		this.pC_pEquipamiento.setBorder(BorderFactory.createTitledBorder("Crear Equipamiento"));
		this.pC_pE_pNombre = new JPanel();
		this.pC_pE_pTipo = new JPanel();
		this.pC_pE_pDMGCD = new JPanel(new GridLayout(1,4));
		this.pC_pE_pStats = new JPanel(new GridLayout(2,8));
		this.pC_pE_pAmmo = new JPanel();
		this.pC_pE_pButtons = new JPanel();
		this.pC_pE_pNetqtNombre = new JLabel("Nombre:");
		this.pC_pE_pTetqtTipo = new JLabel("Tipo:");
		this.pC_pE_pDetqtDmg = new JLabel("DMG:");
		this.pC_pE_pDetqtCd = new JLabel("CD:");
		this.pC_pE_pAetqtAmmo = new JLabel("Municion:");
		this.pC_pE_pSetqtHP = new JLabel("HP:");
		this.pC_pE_pSetqtFP = new JLabel("FP:");
		this.pC_pE_pSetqtAA = new JLabel("AA:");
		this.pC_pE_pSetqtTRP = new JLabel("TRP:");
		this.pC_pE_pSetqtAVI = new JLabel("AVI:");
		this.pC_pE_pSetqtRLD = new JLabel("RLD");
		this.pC_pE_pSetqtEVA = new JLabel("EVA");
		this.pC_pE_pNtxtfNombre = new JTextField(10);
		this.pC_pE_pDtxtfDmg = new JTextField("0",3);
		this.pC_pE_pDtxtfCd = new JTextField("0.0",4);
		this.pC_pE_pStxtfHP = new JTextField("0",3);
		this.pC_pE_pStxtfFP = new JTextField("0",3);
		this.pC_pE_pStxtfAA = new JTextField("0",3);
		this.pC_pE_pStxtfTRP = new JTextField("0",3);
		this.pC_pE_pStxtfAVI = new JTextField("0",3);
		this.pC_pE_pStxtfRLD = new JTextField("0",3);
		this.pC_pE_pStxtfEVA = new JTextField("0",3);
		this.pC_pE_pTboxTipo = new JComboBox<TipoEquipamiento>(TipoEquipamiento.values());
		this.pC_pE_pAboxAmmo = new JComboBox<TipoAmmo>(TipoAmmo.values());
		this.pC_pE_pBbtnCrear = new JButton("Crear");
		this.pC_pE_pBbtnCancelar = new JButton("Cancelar");
	}
	
	private void montarComponentesPanelCreacion() {
		this.add(this.pCrear);
			this.pCrear.add(this.pC_pBarco);
				this.pC_pBarco.add(this.pC_pB_pNombre);
					this.pC_pB_pNombre.add(this.pC_pB_pNetqtNombre);
					this.pC_pB_pNombre.add(this.pC_pB_pNtxtfNombre);
				this.pC_pBarco.add(this.pC_pB_pClase);
					this.pC_pB_pClase.add(this.pC_pB_pC_etqtClase);
					this.pC_pB_pClase.add(this.pC_pB_pCtxtfClase);
				this.pC_pBarco.add(this.pC_pB_pFaccion);
					this.pC_pB_pFaccion.add(this.pC_pB_pFetqeFaccion);
					this.pC_pB_pFaccion.add(this.pC_pB_pFboxFaccion);
				this.pC_pBarco.add(this.pC_pB_pTipo);
					this.pC_pB_pTipo.add(this.pC_pB_pTetqtTipoBarco);
					this.pC_pB_pTipo.add(this.pC_pB_pTboxTipoBarco);
				this.pC_pBarco.add(this.pC_pB_pStats);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtHP);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfHP);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtFP);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfFP);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtAA);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfAA);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtTRP);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfTRP);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtAVI);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfAVI);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtRLD);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfRLD);
					this.pC_pB_pStats.add(this.pC_pB_pSetqtEVA);
					this.pC_pB_pStats.add(this.pC_pB_pStxtfEVA);
					this.pC_pB_pStats.add(new JLabel());
				this.pC_pBarco.add(this.pC_pB_pSlot1);
					this.pC_pB_pSlot1.add(this.pC_pB_pSetqtSlot1);
					this.pC_pB_pSlot1.add(this.pC_pB_pSboxSlot1);
				this.pC_pBarco.add(this.pC_pB_pSlot2);
					this.pC_pB_pSlot2.add(this.pC_pB_pSetqtSlot2);
					this.pC_pB_pSlot2.add(this.pC_pB_pSboxSlot2);
				this.pC_pBarco.add(this.pC_pB_pSlot3);
					this.pC_pB_pSlot3.add(this.pC_pB_pSetqtSlot3);
					this.pC_pB_pSlot3.add(this.pC_pB_pSboxSlot3);
				this.pC_pBarco.add(this.pC_pB_pCrear);
					this.pC_pB_pCrear.add(this.pC_pBbtnCrear);
				this.pC_pBarco.add(this.pC_pB_pCancelar);
					this.pC_pB_pCancelar.add(this.pC_pBbtnCancelar);
			this.pCrear.add(new JSeparator(SwingConstants.VERTICAL));
			this.pCrear.add(this.pC_pDer);
				this.pC_pDer.add(this.pC_pEquipamiento);
					this.pC_pEquipamiento.add(this.pC_pE_pNombre);
						this.pC_pE_pNombre.add(this.pC_pE_pNetqtNombre);
						this.pC_pE_pNombre.add(this.pC_pE_pNtxtfNombre);
					this.pC_pEquipamiento.add(this.pC_pE_pTipo);
						this.pC_pE_pTipo.add(this.pC_pE_pTetqtTipo);
						this.pC_pE_pTipo.add(this.pC_pE_pTboxTipo);
					this.pC_pEquipamiento.add(this.pC_pE_pDMGCD);
						this.pC_pE_pDMGCD.add(this.pC_pE_pDetqtDmg);
						this.pC_pE_pDMGCD.add(this.pC_pE_pDtxtfDmg);
						this.pC_pE_pDMGCD.add(this.pC_pE_pDetqtCd);
						this.pC_pE_pDMGCD.add(this.pC_pE_pDtxtfCd);
					this.pC_pEquipamiento.add(this.pC_pE_pStats);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtHP);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfHP);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtFP);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfFP);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtAA);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfAA);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtTRP);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfTRP);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtAVI);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfAVI);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtRLD);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfRLD);
						this.pC_pE_pStats.add(this.pC_pE_pSetqtEVA);
						this.pC_pE_pStats.add(this.pC_pE_pStxtfEVA);
						this.pC_pE_pStats.add(new JLabel(""));
					this.pC_pEquipamiento.add(this.pC_pE_pAmmo);
						this.pC_pE_pAmmo.add(this.pC_pE_pAetqtAmmo);
						this.pC_pE_pAmmo.add(this.pC_pE_pAboxAmmo);
					this.pC_pEquipamiento.add(this.pC_pE_pButtons);
						this.pC_pE_pButtons.add(this.pC_pE_pBbtnCrear);
						this.pC_pE_pButtons.add(this.pC_pE_pBbtnCancelar);
				this.pC_pDer.add(new JSeparator(SwingConstants.HORIZONTAL));
				this.pC_pDer.add(this.pC_p2);
					this.pC_p2.add(this.pC_p2_pEq);
						this.pC_p2_pEq.add(this.pC_p2_pEboxEq);
					this.pC_p2.add(this.pC_p2_pDuplicar);
						this.pC_p2_pDuplicar.add(this.pC_p2_pDbtnDuplicar);
						this.pC_p2_pDuplicar.add(this.pC_p2_pDbtnEliminar);
				this.pC_pDer.add(new JSeparator(SwingConstants.HORIZONTAL));
				this.pC_pDer.add(this.pC_p3);
					this.pC_p3.add(this.pC_p3_pDbtnVolver);
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
		this.crearComponentesPanelEquipamiento();
		this.montarComponentesPanelEquipamiento();
		this.pEquipar.setVisible(false);
		this.crearComponentesPanelCreacion();
		this.montarComponentesPanelCreacion();
		this.pCrear.setVisible(false);
	}
	
	public Vista() {
		this.crearTodo();
	}
	
	public void control(Controlador c) {
		//Panel principal
		this.pp_btnGoP1.addActionListener(c);
		this.pp_btnGoPBarcos.addActionListener(c);
		this.pp_btnGoPEquipar.addActionListener(c);
		this.pp_btnGoPCreacion.addActionListener(c);
		//Panel 1
		this.p1_btnBack.addActionListener(c);
		//Panel Barcos
		this.pBarcos_btnBack.addActionListener(c);
		this.pBarcos_btnEliminar.addActionListener(c);
		this.pBarcos_btnExaminar.addActionListener(c);
		this.pB_pIbtnCod.addActionListener(c);
		this.pB_pIbtnNombre.addActionListener(c);
		this.pB_pIbtnClase.addActionListener(c);
		this.pB_pIbtnTipo.addActionListener(c);
		this.pB_pIbtnFaccion.addActionListener(c);
		this.pB_pDbtnHP.addActionListener(c);
		this.pB_pDbtnFP.addActionListener(c);
		this.pB_pDbtnAA.addActionListener(c);
		this.pB_pDbtnTRP.addActionListener(c);
		this.pB_pDbtnAVI.addActionListener(c);
		this.pB_pDbtnRLD.addActionListener(c);
		this.pB_pDbtnEVA.addActionListener(c);
		//panel Equipar
		this.pEquipar_btnBack.addActionListener(c);
		this.pEquipar_boxBarco.addItemListener(c);
		this.pEquipar_boxBarcoEquipo.addItemListener(c);
		this.pEquipar_boxEquipamiento.addItemListener(c);
		this.pEquipar_p2_p2_ChckMostrarEquipados.addActionListener(c);
		this.pEquipar_p2_p2_ChckMostrarPosibles.addActionListener(c);
		this.pEquipar_btnEquipar.addActionListener(c);
		this.pEquipar_btnDesequipar.addActionListener(c);
		this.pEquipar_btnDesequiparTodo.addActionListener(c);
		//panel Crear
		this.pC_p3_pDbtnVolver.addActionListener(c);
		this.pC_pBbtnCrear.addActionListener(c);
		this.pC_pBbtnCancelar.addActionListener(c);
		this.pC_pE_pBbtnCrear.addActionListener(c);
		this.pC_pE_pBbtnCancelar.addActionListener(c);
		this.pC_p2_pDbtnDuplicar.addActionListener(c);
		this.pC_p2_pDbtnEliminar.addActionListener(c);
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

	public JList<String> getpBarcos_centro_lstBarcos() {
		return pBarcos_centro_lstBarcos;
	}
	
	public JButton getPp_btnGoPEquipar() {
		return pp_btnGoPEquipar;
	}
	
	public JPanel getpEquipar() {
		return pEquipar;
	}
	
	public JComboBox<Barco> getpEquipar_boxBarco() {
		return pEquipar_boxBarco;
	}
	
	public JComboBox<String> getpEquipar_boxBarcoEquipo() {
		return pEquipar_boxBarcoEquipo;
	}
	
	public JComboBox<Equipamiento> getpEquipar_boxEquipamiento() {
		return pEquipar_boxEquipamiento;
	}
	
	public JCheckBox getpEquipar_p2_p2_ChckMostrarEquipados() {
		return pEquipar_p2_p2_ChckMostrarEquipados;
	}
	
	public JButton getpEquipar_btnEquipar() {
		return pEquipar_btnEquipar;
	}
	
	public JButton getpEquipar_btnDesequipar() {
		return pEquipar_btnDesequipar;
	}
	
	public JButton getpEquipar_btnDesequiparTodo() {
		return pEquipar_btnDesequiparTodo;
	}
	
	public JButton getpEquipar_btnBack() {
		return pEquipar_btnBack;
	}

	
	public JPanel getpCrear() {
		return pCrear;
	}
	

	public JTextField getpC_pB_pNtxtfNombre() {
		return pC_pB_pNtxtfNombre;
	}
	

	public JTextField getpC_pB_pCtxtfClase() {
		return pC_pB_pCtxtfClase;
	}
	

	public JTextField getpC_pB_pStxtfHP() {
		return pC_pB_pStxtfHP;
	}
	

	public JTextField getpC_pB_pStxtfFP() {
		return pC_pB_pStxtfFP;
	}
	

	public JTextField getpC_pB_pStxtfAA() {
		return pC_pB_pStxtfAA;
	}
	

	public JTextField getpC_pB_pStxtfTRP() {
		return pC_pB_pStxtfTRP;
	}
	

	public JTextField getpC_pB_pStxtfAVI() {
		return pC_pB_pStxtfAVI;
	}
	

	public JTextField getpC_pB_pStxtfRLD() {
		return pC_pB_pStxtfRLD;
	}
	

	public JTextField getpC_pB_pStxtfEVA() {
		return pC_pB_pStxtfEVA;
	}
	

	public JComboBox<Faccion> getpC_pB_pFboxFaccion() {
		return pC_pB_pFboxFaccion;
	}
	

	public JComboBox<TipoBarco> getpC_pB_pTboxTipoBarco() {
		return pC_pB_pTboxTipoBarco;
	}
	

	public JComboBox<TipoEquipamiento> getpC_pB_pSboxSlot1() {
		return pC_pB_pSboxSlot1;
	}
	

	public JComboBox<TipoEquipamiento> getpC_pB_pSboxSlot2() {
		return pC_pB_pSboxSlot2;
	}
	

	public JComboBox<TipoEquipamiento> getpC_pB_pSboxSlot3() {
		return pC_pB_pSboxSlot3;
	}
	

	public JButton getpC_pBbtnCrear() {
		return pC_pBbtnCrear;
	}
	

	public JButton getpC_pBbtnCancelar() {
		return pC_pBbtnCancelar;
	}

	public JButton getPp_btnGoPCreacion() {
		return pp_btnGoPCreacion;
	}

	public JTextField getpC_pE_pNtxtfNombre() {
		return pC_pE_pNtxtfNombre;
	}

	public JTextField getpC_pE_pDtxtfDmg() {
		return pC_pE_pDtxtfDmg;
	}

	public JTextField getpC_pE_pDtxtfCd() {
		return pC_pE_pDtxtfCd;
	}

	public JTextField getpC_pE_pStxtfHP() {
		return pC_pE_pStxtfHP;
	}

	public JTextField getpC_pE_pStxtfFP() {
		return pC_pE_pStxtfFP;
	}

	public JTextField getpC_pE_pStxtfAA() {
		return pC_pE_pStxtfAA;
	}

	public JTextField getpC_pE_pStxtfTRP() {
		return pC_pE_pStxtfTRP;
	}

	public JTextField getpC_pE_pStxtfAVI() {
		return pC_pE_pStxtfAVI;
	}

	public JTextField getpC_pE_pStxtfRLD() {
		return pC_pE_pStxtfRLD;
	}

	public JTextField getpC_pE_pStxtfEVA() {
		return pC_pE_pStxtfEVA;
	}

	public JComboBox<TipoEquipamiento> getpC_pE_pTboxTipo() {
		return pC_pE_pTboxTipo;
	}

	public JComboBox<TipoAmmo> getpC_pE_pAboxAmmo() {
		return pC_pE_pAboxAmmo;
	}

	public JButton getpC_pE_pBbtnCrear() {
		return pC_pE_pBbtnCrear;
	}

	public JButton getpC_pE_pBbtnCancelar() {
		return pC_pE_pBbtnCancelar;
	}

	public JComboBox<Equipamiento> getpC_p2_pEboxEq() {
		return pC_p2_pEboxEq;
	}

	public JButton getpC_p2_pDbtnDuplicar() {
		return pC_p2_pDbtnDuplicar;
	}

	public JButton getpC_p3_pDbtnVolver() {
		return pC_p3_pDbtnVolver;
	}
	

	public JButton getpB_pIbtnCod() {
		return pB_pIbtnCod;
	}
	

	public JButton getpB_pIbtnNombre() {
		return pB_pIbtnNombre;
	}
	

	public JButton getpB_pIbtnClase() {
		return pB_pIbtnClase;
	}
	

	public JButton getpB_pIbtnTipo() {
		return pB_pIbtnTipo;
	}
	

	public JButton getpB_pIbtnFaccion() {
		return pB_pIbtnFaccion;
	}
	

	public JButton getpB_pDbtnHP() {
		return pB_pDbtnHP;
	}
	

	public JButton getpB_pDbtnFP() {
		return pB_pDbtnFP;
	}
	

	public JButton getpB_pDbtnAA() {
		return pB_pDbtnAA;
	}
	

	public JButton getpB_pDbtnTRP() {
		return pB_pDbtnTRP;
	}
	

	public JButton getpB_pDbtnAVI() {
		return pB_pDbtnAVI;
	}
	

	public JButton getpB_pDbtnRLD() {
		return pB_pDbtnRLD;
	}
	

	public JButton getpB_pDbtnEVA() {
		return pB_pDbtnEVA;
	}
	
	

	public JLabel getpEq_1etqtNombre() {
		return pEq_1etqtNombre;
	}
	

	public JLabel getpEq_1etqtHP() {
		return pEq_1etqtHP;
	}
	

	public JLabel getpEq_1etqtFP() {
		return pEq_1etqtFP;
	}
	

	public JLabel getpEq_1etqtAA() {
		return pEq_1etqtAA;
	}
	

	public JLabel getpEq_1etqtTRP() {
		return pEq_1etqtTRP;
	}
	

	public JLabel getpEq_1etqtAVI() {
		return pEq_1etqtAVI;
	}
	

	public JLabel getpEq_1etqtRLD() {
		return pEq_1etqtRLD;
	}
	

	public JLabel getpEq_1etqtEVA() {
		return pEq_1etqtEVA;
	}
	

	public JLabel getpEq_2etqtNombre() {
		return pEq_2etqtNombre;
	}
	

	public JLabel getpEq_2etqtHP() {
		return pEq_2etqtHP;
	}
	

	public JLabel getpEq_2etqtFP() {
		return pEq_2etqtFP;
	}
	

	public JLabel getpEq_2etqtAA() {
		return pEq_2etqtAA;
	}
	

	public JLabel getpEq_2etqtTRP() {
		return pEq_2etqtTRP;
	}
	

	public JLabel getpEq_2etqtAVI() {
		return pEq_2etqtAVI;
	}
	

	public JLabel getpEq_2etqtRLD() {
		return pEq_2etqtRLD;
	}
	

	public JLabel getpEq_2etqtEVA() {
		return pEq_2etqtEVA;
	}
	

	public JLabel getpEq_2etqtTipoSlot() {
		return pEq_2etqtTipoSlot;
	}
	

	public JLabel getpEq_2etqtDMG() {
		return pEq_2etqtDMG;
	}
	

	public JLabel getpEq_2etqtCD() {
		return pEq_2etqtCD;
	}
	

	public JLabel getpEq_2etqtTipoAmmo() {
		return pEq_2etqtTipoAmmo;
	}
	

	public JLabel getpEq_3etqtNombre() {
		return pEq_3etqtNombre;
	}
	

	public JLabel getpEq_3etqtHP() {
		return pEq_3etqtHP;
	}
	

	public JLabel getpEq_3etqtFP() {
		return pEq_3etqtFP;
	}
	

	public JLabel getpEq_3etqtAA() {
		return pEq_3etqtAA;
	}
	

	public JLabel getpEq_3etqtTRP() {
		return pEq_3etqtTRP;
	}
	

	public JLabel getpEq_3etqtAVI() {
		return pEq_3etqtAVI;
	}
	

	public JLabel getpEq_3etqtRLD() {
		return pEq_3etqtRLD;
	}
	

	public JLabel getpEq_3etqtEVA() {
		return pEq_3etqtEVA;
	}
	

	public JLabel getpEq_3etqtTipoSlot() {
		return pEq_3etqtTipoSlot;
	}
	

	public JLabel getpEq_3etqtDMG() {
		return pEq_3etqtDMG;
	}
	

	public JLabel getpEq_3etqtCD() {
		return pEq_3etqtCD;
	}
	

	public JLabel getpEq_3etqtTipoAmmo() {
		return pEq_3etqtTipoAmmo;
	}
	

	public JCheckBox getpEquipar_p2_p2_ChckMostrarPosibles() {
		return pEquipar_p2_p2_ChckMostrarPosibles;
	}
	

	public DefaultListModel<String> getListaBarcos() {
		return listaBarcos;
	}
	

	public JButton getpC_p2_pDbtnEliminar() {
		return pC_p2_pDbtnEliminar;
	}

	
	public JTable getP1_tabla() {
		return p1_tabla;
	}

	public void setP1_tabla(JTable p1_tabla) {
		this.p1_tabla = p1_tabla;
		this.p1_tabla.setVisible(false);
		this.p1_tabla.setVisible(true);
	}

	public JScrollPane getP1_pTabla() {
		return p1_pTabla;
	}

	public void setP1_pTabla(JScrollPane p1_pTabla) {
		this.p1_pTabla = p1_pTabla;
	}
	
	
	

	
	
}
