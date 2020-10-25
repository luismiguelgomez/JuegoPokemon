package co.edu.unbosque.vista;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoPrincipal extends JFrame {
	private JPanel panel;

	/**
	 * <b>Precondiciones:</b> Tener como parametros JPanel 
	 * <b>Poscondiciones:</b> Iniciar el panel de JPanel
	 * @param panel proveniente de JPanel
	 * @throws HeadlessException retorna mensaje de error (si ocurre) proveniente del JPanel
	 */
	public MarcoPrincipal(JPanel panel) throws HeadlessException {
		super();
		this.panel = panel;
		this.setTitle("POKEMON V1.0");		
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
	}
}
