package co.edu.unbosque.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;

/**
 * 
 * @author OscarArley
 *
 */
public class Ataque extends JPanel {

	// Funcionamiento de fondo
	private static final long serialVersionUID = 1L;
	private JLabel net, lblEnemigo;
	private Keys key;
	private String intro2, intro1, intro3, intro4;
	private String[][] matrizTabla;
	private String[] titulosMatriz;
	private boolean running, enemigoCargado, menuAtaque, menuOpciones, bolsilloCargado;
	// Tabla
//	private JPanel pnlBolsillo;
	private JScrollPane scrollPaneTabla;
	private JTable tblPokemones;
	private ModeloTabla tblEstiloBolsillo;

	// Botones
	private JButton btnAccion;
	private JButton btnAtras;
	private Boolean ctrlAccion;

	private String[][] pokemones;
	private String[][] poderes;

	private String[] pokemon;
	private String[] aEnemigo;
	private String poder;

	private boolean blnCargarPokemones;
	private boolean blnCargarPoderes;
	private boolean blnCargarPokemon;
	private boolean blnCargarPoder;

	private boolean blnCerrarPanel;
	private ArrayList<String[]> enemigo;

	/**
	 * <b>Precondiciones:</b> Tener dos parametros: un String[][] y un String[],
	 * <br>
	 * tener la ruta de las imagenes del panel ajustadas<br>
	 * <b>Poscondiciones:</b> Iniciar las imagenes y funcionamiento del panel Ataque
	 * 
	 * @param nombrePokemones String[][] con el nombre de los pokemones provenientes
	 *                        del properties
	 * @param enemigo         ArrayList de String[]
	 */
	public Ataque(String[][] nombrePokemones, ArrayList<String[]> enemigo) {
		super();
		this.enemigo = enemigo;
		pokemon = new String[2];
		aEnemigo = new String[2];
		net = new JLabel();
		pokemones = nombrePokemones;
		intro2 = "data/intro2.jpg";
		intro1 = "data/intro1.jpg";
		intro4 = "data/FondoLejos.png";
		intro3 = "data/intro3.jpg";
		ctrlAccion = true;
		key = new Keys();
		btnAccion = new JButton("Escoger");
		btnAtras = new JButton("Atras");
		titulosMatriz = new String[1];
		matrizPokemones();
		running = true;
		enemigoCargado = false;
		menuAtaque = false;
		menuOpciones = false;
		bolsilloCargado = false;
		blnCargarPokemones = false;
		blnCargarPoderes = false;
		blnCargarPokemon = false;
		blnCargarPoder = false;
		blnCerrarPanel = false;
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 500));
		setFocusable(true);
		requestFocus();
		lblEnemigo = new JLabel();
		btnAccion.addActionListener(alAccion);
		btnAtras.addActionListener(alAtras);
		this.add(lblEnemigo);
		this.add(btnAccion);
		this.add(btnAtras);
		lblEnemigo.setVisible(true);
		inicioTabla();
		nombrEnemigo();
	}

	/**
	 * <b>Precondiciones:</b> Grapichs g
	 * <b>Poscondiciones:</b> Pintar los componentes de la tabla
	 */
	public void paintComponent(Graphics g) {
		try {
			int yAxis = 30;
			int xAxis = 30;
			int width = 540;
			int height = 510;
			g.drawRect(xAxis, yAxis, width, height);
			g.drawImage(key.intro(intro2), xAxis, yAxis, width, (height / 3) * 2, this);
			g.drawRect(xAxis, yAxis, (width / 5) * 2, height / 3);
			g.drawImage(key.intro(intro3), xAxis, yAxis, (width / 5) * 2, height / 3, this);
			g.drawRect(xAxis, yAxis + 340, width, height / 3);
			g.drawImage(key.intro(intro1), xAxis, yAxis + 340, width, height / 3, this);
			g.drawRect(xAxis, yAxis + 340, width - (width / 3), height / 3);
			g.drawImage(key.intro(intro4), xAxis, yAxis + 340, width - (width / 3), height / 3, this);
			lblEnemigo.setBounds(50, 40, 120, 60);
			Dimension size = scrollPaneTabla.getPreferredSize();
			btnAccion.setBounds(440, 400, 100, 30);
			btnAtras.setBounds(440, 450, 100, 30);
			scrollPaneTabla.setBounds(50, 390, size.width, size.height);
			if (enemigoCargado) {

			}
			if (menuAtaque) {

			}
			if (menuOpciones) {

			}
			if (bolsilloCargado) {

			}

		} catch (IOException e) {
			System.out.println("Fallo cargue de Fondo en menu principal en el metodo paint component");
		}

	}

	/**
	 * <b>Precondiciones:</b> variables: tblPokemones,scrollPaneTabla, tener creado el metodo menuBolsillo()
	 * <b>Poscondiciones:</b> Iniciar la tabla
	 */
	public void inicioTabla() {

//		 pnlBolsillo = new JPanel();
		tblPokemones = new JTable();
//		 pnlBolsillo.setBorder(new EmptyBorder(5, 5, 5, 5));
//		 this.add(pnlBolsillo);
		// pnlBolsillo.setLayout(new BorderLayout(0,0));
		// JLabel lblTituloTabla = new JLabel("Escoge para jugar");
		// lblTituloTabla.setFont(new Font("Rockwell", Font.BOLD, 16));
		// pnlBolsillo.add(lblTituloTabla, BorderLayout.NORTH);
		scrollPaneTabla = new JScrollPane();
		tblPokemones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblPokemones.getSelectionModel().setSelectionInterval(1, 2);
//		 pnlBolsillo.add(scrollPaneTabla);	 	
		tblPokemones.setBackground(Color.WHITE);
		tblPokemones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		// tblPokemones.addMouseListener((MouseListener) this);
		tblPokemones.setOpaque(false);
		// this.add(tblPokemones);
		scrollPaneTabla.setViewportView(tblPokemones);
		scrollPaneTabla.setPreferredSize(new Dimension(300, 125));
		this.add(scrollPaneTabla);
		menuBolsillo();

	}

	/**
	 * <b>Precondiciones:</b> parametro KeyEvent e, por defecto y tener el metodo test()
	 * <b>Poscondiciones:</b> Enviar a metodo test()
	 * @param e default de actionPerformed
	 */
	public void actionPerformed(KeyEvent e) {
		net = new JLabel();
		net.setText(String.valueOf(e.getKeyCode()));
		add(net);
		test();
	}
	
	/**
	 * <b>Precondiciones:</b> variables: agrega un Background con el color :Color.LIGHT_GRAY
	 * <b>Poscondiciones:</b> Envia al metodo repaint
	 */
	public void test() {
		String data = "Se metio test";
		net.setText(data);
		add(net);
		setBackground(Color.LIGHT_GRAY);
		repaint();
	}

	public void menuEnemigo() {

	}
	/**
	 * <b>Precondiciones:</b> variables: tblEstiloBolsillo,titulosMatriz,matrizTabla,tblPokemones,scrollPaneTabla
	 * <b>Poscondiciones:</b> Agregar valores a la tabla que obtiene los datos de los pokemones
	 *  que el usuario llevara a luchar
	 */
	public void menuBolsillo() {
		tblEstiloBolsillo = new ModeloTabla(matrizTabla, titulosMatriz);
		// se asigna el modelo a la tabla
		tblPokemones.setModel(tblEstiloBolsillo);
		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización
		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto
		for (int i = 0; i < titulosMatriz.length; i++) {// se resta 7 porque las ultimas 7 columnas se definen arriba
//		   System.out.println(i);
			tblPokemones.getColumnModel().getColumn(i).setCellRenderer(new AdministracionCeldas("texto"));
		}
		tblPokemones.getTableHeader().setReorderingAllowed(false);
		tblPokemones.setRowHeight(20);// tamaño de las celdas
		tblPokemones.setGridColor(new Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tblPokemones.getColumnModel().getColumn(0).setPreferredWidth(150);
		// personaliza el encabezado
		JTableHeader jtableHeader = tblPokemones.getTableHeader();
		jtableHeader.setDefaultRenderer(new tblEstiloEncabezado());
		tblPokemones.setTableHeader(jtableHeader);
		// se asigna la tabla al scrollPane
		scrollPaneTabla.setViewportView(tblPokemones);

	}
	
	/**
	 * <b>Precondiciones:</b> variables: btnAccion,blnCargarPoderes y <br>metodos:matrizPoderes(),menuBolsillo()
	 * <b>Poscondiciones:</b> Ejecutar los metodos : matrizPoderes(),menuBolsillo()
	 */
	public void menuAtaque() {
		btnAccion.setText("ATAQUE");
		blnCargarPoderes = true;
		matrizPoderes();
		menuBolsillo();

	}

	/**
	 * <b>Precondiciones:</b> Variables: btnAccion <br>metodos:matrizPoderes(),menuBolsillo()
	 * <b>Poscondiciones:</b> Agregar al btnAccion el text = "Escoger" , Ejecutar los metodos : matrizPoderes(),menuBolsillo()
	 */
	public void menuPrincipal() {
		btnAccion.setText("Escoger");
		matrizPokemones();
		menuBolsillo();

	}
	
	/**
	 * <b>Precondiciones:</b> Variables: blnCargarPoder
	 * <b>Poscondiciones:</b> Agregar a la variable blnCargarPoder = true
	 */
	public void lanzarAtaque() {
		blnCargarPoder = true;
	}

	/**
	 * Metodo encargado de cerrar la view
	 * <b>Poscondiciones:</b> removeAll() y deja de ser visible la view
	 */
	public void cerrar() {
		// iniciar proceso en el controlador de cargue del otro panel OJO
		this.setVisible(false);
		this.removeAll();
	}

	/**
	 * <b>Precondiciones:</b> Variables: tituloMatriz, matrizTabla, pokemones
	 * <b>Poscondiciones:</b> tituloMatriz[0= = "Pokemones"<br>
	 * matrizTabla iguala a pokemones
	 */
	public void matrizPokemones() {
		titulosMatriz[0] = "POKEMONES";
		matrizTabla = pokemones;
	}

	/**
	 * <b>Precondiciones:</b> Variables: pokemon, tblEstiloBolsillo, tblPokemones,titulosMatriz
	 * <b>Poscondiciones:</b> Mostrar ataques segun el pokemon elegido, 
	 * si ninguno fue elegido mostrar "Escoge un pokemon para jugar", 
	 * en caso de no tener ese error mostrar : e.getMessage()
	 */
	public void matrizPoderes() {
		try {

			pokemon[0] = (String) tblEstiloBolsillo.getValueAt(tblPokemones.getSelectedRow(),
					tblPokemones.getSelectedColumn());
			titulosMatriz[0] = "ATAQUES  : "
					+ tblEstiloBolsillo.getValueAt(tblPokemones.getSelectedRow(), tblPokemones.getSelectedColumn())
					+ "  Vida: " + pokemon[1];
			matrizTabla = poderes;
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Escoge un pokemon para jugar");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	ActionListener alAtras = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (ctrlAccion) {
				// Metodo para cerrar el panel
				blnCerrarPanel = true;
				cerrar();

			} else {
				menuPrincipal();
				ctrlAccion = true;
			}

		}
	};

	ActionListener alAccion = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (ctrlAccion) {
				menuAtaque();
				ctrlAccion = false;
			} else {
				lanzarAtaque();

			}
		}
	};

	/**
	 * <b>Precondiciones:</b> Variables: aEnemigo, enemigo, lblEnemigo
	 * <b>Poscondiciones:</b> Enviar los datos del enemigo (nombre y vida) 
	 */
	public void nombrEnemigo() {
//		for(String[] p : enemigo) {
//			System.out.println(p[0]);
//			System.out.println(p[1]);
//		}
		aEnemigo = enemigo.get(0);
		lblEnemigo.setText(
				"<html><font color='white'>" + aEnemigo[0] + " <br>Vida: " + aEnemigo[1] + "<br>" + "</font></html>");

	}

	/**
	 * getPokemones
	 * @return String[][] con pokemones
	 */
	public String[][] getPokemones() {
		return pokemones;
	}

	/**
	 * setPokemones
	 * @param pokemones String[][] pokemones
	 */
	public void setPokemones(String[][] pokemones) {
		this.pokemones = pokemones;
	}

	/**
	 * getPoderes
	 * @return String[][] poderes
	 */
	public String[][] getPoderes() {
		return poderes;
	}

	/**
	 * setPoderes
	 * @param poderes String [][] poderes
	 */
	public void setPoderes(String[][] poderes) {
		this.poderes = poderes;
	}

	/**
	 * getPokemon
	 * @return String[] pokemon
	 */
	public String[] getPokemon() {
		return pokemon;
	}

	/**
	 * setPokemon
	 * @param pokemon String[] pokemon
	 */
	public void setPokemon(String[] pokemon) {
		this.pokemon = pokemon;
	}

	/**
	 * getPoder
	 * @return String Poder
	 */
	public String getPoder() {
		return poder;
	}

	/**
	 * setPoder
	 * @param poder String 
	 */
	public void setPoder(String poder) {
		this.poder = poder;
	}

	/**
	 * get blnCargarPokemones
	 * @return boolean blnCargarPokemones
	 */
	public boolean isBlnCargarPokemones() {
		return blnCargarPokemones;
	}

	/**
	 * set blnCargarPokemones
	 * @param blnCargarPokemones boolean
	 */
	public void setBlnCargarPokemones(boolean blnCargarPokemones) {
		this.blnCargarPokemones = blnCargarPokemones;
	}

	/**
	 * boolean isBlnCargarPoderes
	 * @return blnCargarPoderes boolean
	 */
	public boolean isBlnCargarPoderes() {
		return blnCargarPoderes;
	}

	/**
	 * boolean blnCargarPoderes
	 * @param blnCargarPoderes boolean
	 */
	public void setBlnCargarPoderes(boolean blnCargarPoderes) {
		this.blnCargarPoderes = blnCargarPoderes;
	}

	/**
	 * boolean blnCargarPokemon
	 * @return blnCargarPokemon boolean
	 */
	public boolean isBlnCargarPokemon() {
		return blnCargarPokemon;
	}

	/**
	 * blnCargarPokemon set
	 * @param blnCargarPokemon boolean
	 */
	public void setBlnCargarPokemon(boolean blnCargarPokemon) {
		this.blnCargarPokemon = blnCargarPokemon;
	}

	/**
	 * get boolean blnCargarPoder
	 * @return blnCargarPoder boolean
	 */
	public boolean isBlnCargarPoder() {
		return blnCargarPoder;
	}

	/**
	 * set blnCargarPoder
	 * @param blnCargarPoder boolean
	 */
	public void setBlnCargarPoder(boolean blnCargarPoder) {
		this.blnCargarPoder = blnCargarPoder;
	}

	/**
	 * get blnCerrarPanel
	 * @return blnCerrarPanel boolean
	 */
	public boolean isBlnCerrarPanel() {
		return blnCerrarPanel;
	}

	/**
	 * setBlnCerrarPanel
	 * @param blnCerrarPanel boolean
	 */
	public void setBlnCerrarPanel(boolean blnCerrarPanel) {
		this.blnCerrarPanel = blnCerrarPanel;
	}

	/**
	 * getEnemigo
	 * @return ArrayList String[]
	 */
	public ArrayList<String[]> getEnemigo() {
		return enemigo;
	}

	/**
	 * setEnemigo
	 * @param enemigo ArrayList String[]
	 */
	public void setEnemigo(ArrayList<String[]> enemigo) {
		this.enemigo = enemigo;
	}

	/**
	 * get enemigo
	 * @return String[] enemigo
	 */
	public String[] getaEnemigo() {
		return aEnemigo;
	}

	/**
	 * setaEnemigo
	 * @param aEnemigo set 
	 */
	public void setaEnemigo(String[] aEnemigo) {
		this.aEnemigo = aEnemigo;
	}

	/**
	 * getBtnAccion
	 * @return getBtnAccion
	 */
	public JButton getBtnAccion() {
		return btnAccion;
	}

	/**
	 * setBtnAccion
	 * @param btnAccion setBtnAccion
	 */
	public void setBtnAccion(JButton btnAccion) {
		this.btnAccion = btnAccion;
	}

}
