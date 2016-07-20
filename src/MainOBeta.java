/**
 * Main class
 * Main functions:
 * - Run
 * 
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

import javax.swing.*;


public class MainOBeta implements KeyListener {

	private JFrame frame;
	private JButton btnMenu;
	private MapGenerator mapGenerator;
	private Interactions charInteraction;
	private FileReader map;
	private String adress;
	private JFrame mapframe;
    private JLabel personaje;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainOBeta window = new MainOBeta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainOBeta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMenu = new JButton("Boton de Machete"); //este boton hace todo
		btnMenu.setBounds(152, 125, 145, 23);
		frame.getContentPane().add(btnMenu);
		btnMenu.addActionListener(new ListenerMapGene());
		
		mapframe = new JFrame();
		mapframe.setBounds(100, 50, 1024, 690);
		mapframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mapframe.getContentPane().setLayout(null);
		mapframe.setVisible(false);
		
		mapframe.addKeyListener(this); // Agregar el key listener
		mapframe.setFocusable(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mapframe.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		mapframe.setResizable(false);
		
	}
	
	
	private class ListenerMapGene implements ActionListener{
		public void actionPerformed (ActionEvent e){
			final JFileChooser fc = new JFileChooser(); //Esto sirve para que se pueda examinar las carpetas del equipo
														// y asi escoger el mapa.	
			try {
				int op = fc.showOpenDialog(frame);
				if (op == JFileChooser.APPROVE_OPTION) {
					adress = fc.getSelectedFile().getPath();
					System.out.println(adress);
					map = new FileReader(adress);
					
					mapGenerator = new MapGenerator(null, null, map, 0, 0, 0, 0, null, null, null);
					mapGenerator.generateData();
					
					mapGenerator.creatMap(mapframe);
					mapframe.setVisible(true);
					frame.setVisible(false); 
					
					personaje = mapGenerator.getMyCharacter();
					
					//charInteraction = new Interactions(mapGenerator.getMatrixMap(), 
														mapGenerator.getCharAtX(), 
														mapGenerator.getCharAtY(),
														character);
				}

	
			}
			catch (Exception w) {
				JOptionPane.showMessageDialog(frame, "Error al cargar el archivo, asegurese de seleccionar una imagen.", 
												"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP){
			/*
			 * IF arriba libre, do...
			 * se mueve
			 * pos actual pone 0
			 * pos siguientepone asterisco
			 * */
			
			personaje.setBounds((int)personaje.getBounds().getMinX(), (int)personaje.getBounds().getMinY()-5, 19, 19);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			personaje.setBounds((int)personaje.getBounds().getMinX(), (int)personaje.getBounds().getMinY()+5, 19, 19);
		}

		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			personaje.setBounds((int)personaje.getBounds().getMinX()+5, (int)personaje.getBounds().getMinY(), 19, 19);
		}

		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			personaje.setBounds((int)personaje.getBounds().getMinX()-5, (int)personaje.getBounds().getMinY(), 19, 19);
		}


	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
