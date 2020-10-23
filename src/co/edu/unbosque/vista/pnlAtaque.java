package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;



public class pnlAtaque extends JFrame implements KeyListener, Runnable{


	/**
	 * 
	 */
	//Funcionamiento de fondo
	private static final long serialVersionUID = 1L;
	private JLabel net, lblEnemigo;
	private Keys key;
	private String intro2, intro1, intro3,intro4;
	private String[][]bolsillo;
	private String[] titulosBolsillo;
	private boolean running, enemigoCargado,menuAtaque, menuOpciones, bolsilloCargado;
 // Tabla
//	private JPanel pnlBolsillo;
	private JScrollPane scrollPaneTabla;
	private JTable tblPokemones; 
	private tblModeloTabla tblEstiloBolsillo;
	
	//Botones
	private JButton btnAccion;
	private JButton btnAtras;
	private Boolean ctrlAccion;
	 

	public pnlAtaque() {
		super();	
		net = new JLabel();
		intro2="src/data/intro2.jpg";
		intro1="src/data/intro1.jpg";
		intro4="src/data/FondoLejos.png";
		intro3="src/data/intro3.jpg";
		ctrlAccion = true;
		key = new Keys();
		btnAccion= new JButton("Escoger");
		btnAtras = new JButton("Atras");
		titulosBolsillo = new String[1];
		matrizPokemones();
		running= true;
		enemigoCargado=false;
		menuAtaque=false;
		menuOpciones=false;
		bolsilloCargado=false;
		this.setBackground(Color.WHITE);		
		this.setPreferredSize(new Dimension(500,500));
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		lblEnemigo= new JLabel("<html><font color='white'>Enemigo #1 <br>Vida:  100%<br>"
				+ "</font></html>");
		btnAccion.addActionListener(alAccion);
		btnAtras.addActionListener(alAtras);
		this.add(lblEnemigo);
		this.add(btnAccion);
		this.add(btnAtras);
		lblEnemigo.setVisible(true);
		inicioTabla();
}
	public void paintComponent (Graphics g) {
		try {
		int yAxis	=	30;
		int xAxis	=	30;
		int width	=	540;
		int height	=	510;
		g.drawRect(xAxis, yAxis, width, height);
		g.drawImage(key.intro(intro2), xAxis, yAxis, width, (height/3)*2,this);
		g.drawRect(xAxis, yAxis, (width/5)*2, height/3);
		g.drawImage(key.intro(intro3), xAxis, yAxis, (width/5)*2, height/3,this);
		g.drawRect(xAxis, yAxis+340, width, height/3);
		g.drawImage(key.intro(intro1), xAxis, yAxis+340, width, height/3,this);
		g.drawRect(xAxis, yAxis+340, width-(width/3), height/3);
		g.drawImage(key.intro(intro4), xAxis, yAxis+340, width-(width/3), height/3,this);
		lblEnemigo.setBounds(50, 40, 120, 60);
		Dimension size = scrollPaneTabla.getPreferredSize();
		btnAccion.setBounds(440, 400, 100, 30);
		btnAtras.setBounds(440, 450, 100, 30);
		scrollPaneTabla.setBounds(50, 390, size.width, size.height);
		if(enemigoCargado) {
			
		}
		if(menuAtaque) {
			
		}
		if(menuOpciones) {
			
		}
		if(bolsilloCargado) {
			
		}
		
		}
		catch(IOException e) {
			System.out.println("Fallo cargue de Fondo en menu principal en el metodo paint component");
		}
		
	}

	public void inicioTabla() {

//		 pnlBolsillo = new JPanel();
		 tblPokemones = new JTable();
//		 pnlBolsillo.setBorder(new EmptyBorder(5, 5, 5, 5));
//		 this.add(pnlBolsillo);
		 //pnlBolsillo.setLayout(new BorderLayout(0,0));	  
		 //JLabel lblTituloTabla = new JLabel("Escoge para jugar");
		 //lblTituloTabla.setFont(new Font("Rockwell", Font.BOLD, 16));
		// pnlBolsillo.add(lblTituloTabla, BorderLayout.NORTH);	  
		 scrollPaneTabla = new JScrollPane();
//		 pnlBolsillo.add(scrollPaneTabla);	 	
		 tblPokemones.setBackground(Color.WHITE);
		 tblPokemones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		// tblPokemones.addMouseListener((MouseListener) this);
		 tblPokemones.setOpaque(false);
		// this.add(tblPokemones);
		 scrollPaneTabla.setViewportView(tblPokemones);
		 scrollPaneTabla.setPreferredSize(new Dimension(300,125));
		 this.add(scrollPaneTabla);
		 menuBolsillo();
 
	}
	 public void actionPerformed(KeyEvent e)
     {
			net = new JLabel();
			net.setText(String.valueOf(e.getKeyCode()));
			add(net);
			test();
     }            
 

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String data = String.valueOf(e.getKeyCode());		
		net.setText(data);
		add(net);
		Keys.keySet(e.getKeyCode(),true);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		setBackground(Color.WHITE);
		this.remove(net);
	}

	public void test () {
		String data = "Se metio test";		
		net.setText(data);
		add(net);
		setBackground(Color.LIGHT_GRAY);
		repaint();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(this.running) {
		if (Keys.anyKeyDown())test();
		}
	}
	
	public void menuEnemigo() {
		
	}
	public void menuBolsillo() {	
		 tblEstiloBolsillo=new tblModeloTabla(bolsillo, titulosBolsillo);
		  //se asigna el modelo a la tabla
		  tblPokemones.setModel(tblEstiloBolsillo);  
		  //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización  
		  //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
		  for (int i = 0; i < titulosBolsillo.length; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
//		   System.out.println(i);
		   tblPokemones.getColumnModel().getColumn(i).setCellRenderer(new tblAdministracionCeldas("texto"));
		  }		  
		  tblPokemones.getTableHeader().setReorderingAllowed(false);
		  tblPokemones.setRowHeight(20);//tamaño de las celdas
		  tblPokemones.setGridColor(new Color(0, 0, 0)); 
		  //Se define el tamaño de largo para cada columna y su contenido
		  tblPokemones.getColumnModel().getColumn(0).setPreferredWidth(150);
		  //personaliza el encabezado
		  JTableHeader jtableHeader = tblPokemones.getTableHeader();
		  jtableHeader.setDefaultRenderer(new tblEstiloEncabezado());
		  tblPokemones.setTableHeader(jtableHeader);
		     //se asigna la tabla al scrollPane
		  scrollPaneTabla.setViewportView(tblPokemones);
		  

	}

	public void menuAtaque () {
		btnAccion.setText("DISPARAR");
		matrizPoderes();
		menuBolsillo();
		
	}
	public void menuPrincipal() {
		btnAccion.setText("Escoger");
		matrizPokemones();
		menuBolsillo();
		
	}
	public void lanzarAtaque() {
		
	}
	public void cerrar() {
		//iniciar proceso en el controlador de cargue del otro panel OJO
		  pnlPanelSeleccion panel = new pnlPanelSeleccion();
	      JFrame frame = new JFrame("POKEMON V0.1");
	      frame.setSize(600, 600);
	      frame.setResizable(false);
	      frame.add(panel);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
			this.setVisible(false);
			this.removeAll();
	}
	public void matrizPokemones() {
		titulosBolsillo[0]="POKEMONES";	
		bolsillo=new String[5][1];
		for(int i=0;i<5;i++) {
			bolsillo[i][0]="Pokemon "+(i+1)+"-------------";
		}
	}
	public void matrizPoderes() {
		titulosBolsillo[0]="ATAQUES  : " +tblEstiloBolsillo.getValueAt(tblPokemones.getSelectedRow(),tblPokemones.getSelectedColumn());	
		bolsillo=new String[4][1];
		for(int i=0;i<4;i++) {
			bolsillo[i][0]="Ataque "+(i+1)+"-------------";
		}
	}
	
	ActionListener alAtras = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(ctrlAccion) {
				//Metodo para cerrar el panel
				cerrar();
			} else {
				menuPrincipal();
				ctrlAccion=true;
			}

		}
	};
	
	ActionListener alAccion = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(ctrlAccion) {
				menuAtaque();
				ctrlAccion=false;
			} else {
				lanzarAtaque();
				
			}
		}
	};
	

}
