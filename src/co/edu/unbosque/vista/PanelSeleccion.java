package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

public class PanelSeleccion extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPaneTabla;
	private JTable tblPokemones; 
	private ModeloTabla tblEstiloBolsillo;
	private String[][]matrizPokemones;
	private String[][]bolsillo;
	private String[] titulosMatriz;
	private JPanel pnlBolsillo;
	
	private JButton btnSalir;
	private JButton btnJugar;
	private boolean blnCerrar;
	private boolean blnAtaque;
	private boolean blnTerminar;
	private boolean blnBolsilloLleno;

	


	public PanelSeleccion(String [][] nombrePokemones) {
		
	
		
			titulosMatriz = new String[1];
			titulosMatriz[0]="POKEMONES";	
			matrizPokemones = nombrePokemones;
			bolsillo = new String[5][1];
//			matrizPokemones();
			btnSalir = new JButton("SALIR");
			btnJugar = new JButton("JUGAR");
			btnSalir.addActionListener(alSalir);
			btnJugar.addActionListener(alJugar);
			//btnJugar.addActionListener(controlador);
			blnCerrar = false;
			blnAtaque= false;
			blnTerminar=false;
			blnBolsilloLleno=false;
			this.add(btnJugar);
			this.add(btnSalir);
			this.setBackground(Color.WHITE);		
			this.setPreferredSize(new Dimension(500,500));
			setFocusable(true);
			requestFocus();
			inicioTabla();
	}

	public void paintComponent (Graphics g) {
		btnSalir.setBounds(250, 300, 100, 30);
		btnJugar.setBounds(250, 350, 100, 30);
		 scrollPaneTabla.setPreferredSize(new Dimension(400,125));
		Dimension size = scrollPaneTabla.getPreferredSize();
		scrollPaneTabla.setBounds(90, 100, size.width, size.height);
	}

		public void inicioTabla() {

			 pnlBolsillo = new JPanel();
			 tblPokemones = new JTable();
			 pnlBolsillo.setBorder(new EmptyBorder(5, 5, 5, 5));
			 this.add(pnlBolsillo);
			 pnlBolsillo.setLayout(new BorderLayout(0,0));	  
			 JLabel lblTituloTabla = new JLabel("Escoge 5 para jugar");
			 lblTituloTabla.setFont(new Font("Rockwell", Font.BOLD, 16));
			 pnlBolsillo.add(lblTituloTabla, BorderLayout.NORTH);	  
			 scrollPaneTabla = new JScrollPane();
			 pnlBolsillo.add(scrollPaneTabla);	 	
			 tblPokemones.setBackground(Color.WHITE);
			 tblPokemones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			// tblPokemones.addMouseListener((MouseListener) this);
			 tblPokemones.setOpaque(false);
			 scrollPaneTabla.setViewportView(tblPokemones);
			 scrollPaneTabla.setPreferredSize(new Dimension(300,125));
			 this.add(scrollPaneTabla);
			 menuBolsillo();
	 
		}
		 
		public void menuBolsillo() {	
			 tblEstiloBolsillo=new ModeloTabla(matrizPokemones, titulosMatriz);
			  //se asigna el modelo a la tabla
			  tblPokemones.setModel(tblEstiloBolsillo);  
			  //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización  
			  //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
			  for (int i = 0; i < titulosMatriz.length; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
//			   System.out.println(i);
			   tblPokemones.getColumnModel().getColumn(i).setCellRenderer(new AdministracionCeldas("texto"));
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
		
//		public void matrizPokemones() {
//			
//			bolsillo=new String[5][1];
//			for(int i=0;i<5;i++) {
//				bolsillo[i][0]="Pokemon "+(i+1)+"-------------";
//			}
//		}
		
		
		ActionListener alSalir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			cerrar();
			blnTerminar=true;

			}
		};
		
		ActionListener alJugar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int [] seleccion = tblPokemones.getSelectedRows();
				for(int i =0; i<seleccion.length;i++) {
					bolsillo[i][0]=matrizPokemones[seleccion[i]][0];
					if (i==4) {
						blnBolsilloLleno=true;
					}else if (i>=5) {blnBolsilloLleno=false;}
				}

				
				if(blnBolsilloLleno) {					
					ataque();
					cerrar();
					blnBolsilloLleno=false;
				}else {
					JOptionPane.showMessageDialog(null, "Pokemones insuficientes para jugar");
				}
			      
			}
			
		};
		
		public void ataque() {
			
			blnAtaque=true;

		   
		}
		public void cerrar() {
			blnCerrar = true; 
		//	this.setVisible(false);
		//	controlador.cerrar();
			//iniciar proceso en el controlador de cargue del otro panel OJO
		}
		
		public boolean getBlnCerrar() {
			return blnCerrar;
		}
		
		public void setBlnCerrar(boolean cerrar) {
			blnCerrar = false;
		}
		
		public boolean isBlnAtaque() {
			return blnAtaque;
		}
		public void setBlnAtaque(boolean blnAtaque) {
			this.blnAtaque = blnAtaque;
		}
		public boolean isBlnTerminar() {
			return blnTerminar;
		}
		
		public String[][] isBolsillo() {
			return bolsillo;
		}

}
	


