

 NO ES MAIN PRINCIPAL ES MAIN PARA PROBAR
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 






import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainBeta implements KeyListener{

	private JButton[][] botones;
	private String[][] matrizMapa = new String[1000][1000];
	private FileReader mapa;
	private BufferedReader brMapa;
	private JFrame frame;
	private int alto, ancho;
	private int esquinax = 10;
	private int esquinay = 10;
	JLabel personaje;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainBeta window = new MainBeta();
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
	public MainBeta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 50, 1024, 690);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFocusable(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setResizable(false);
		
		//Creacion de la matriz
		alto = 0;
		ancho = 0;
		
		try {
			mapa = new FileReader("Maps/MapaTest1.map");			// Lee el mapa
			brMapa = new BufferedReader(mapa);				// Buffered del archivo mapa
			String filaMapa = "0";							// String para almacenar las filas del mapa
			while(filaMapa != null) {						// While para leer el mapa
				filaMapa = brMapa.readLine();				// Almacena la linea actual en filaMapa
				//System.out.print(filaMapa);
				if (ancho<filaMapa.length()) {				// Si el ancho actual es menor al de la fila
					ancho = filaMapa.length();				// Almacena el tamano de la fila en el ancho
				}
				if (filaMapa!=null) {						// Si la filaMapa es diferente de null
					for (int i=0; i<=(filaMapa.length()-1); i++) {		// For para meter la filaMapa actual en matrizMapa
						matrizMapa[alto][i] = String.valueOf(filaMapa.charAt(i));
					}										// Mete el valor de cada char en la matrizMapa
					alto++;									// Cuenta las filas del mapa
				}
				
			}
		} catch (Exception e) {
			System.out.print(e.toString()+"LALA\n");
		}
		//Finaliza la creacion de la matriz
		System.out.println(alto);
		System.out.println(ancho);
		//Completar la matriz
		for(int i=0; i<ancho; i++){
			for(int j=0; j<alto; j++){
				try{
					matrizMapa[j][i].length();
					if (matrizMapa[j][i].equals(" ")) {
						matrizMapa[j][i] = "1";
					}
				} catch(Exception e){
					matrizMapa[j][i] = "1";
				}
			}
		}
		int sizeX = ((frame.getWidth()-20)/ancho);
		int sizeY = ((520)/alto);
		System.out.print(sizeX);
		System.out.print(sizeY);
		//Leer archivo del mapa
		//ARREGLAR espacios en blanco sean 1
		botones = new JButton[alto][ancho];
		for(int i=0; i<ancho; i++){
			for(int j=0; j<alto; j++) {
				switch(matrizMapa[j][i]) {
					case "0"://Espacio blanco/Grama
						break;
					case "1"://Pared
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("Images/GroundTexture1.png"));
						break;/*
					case "2"://Cofres
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "3"://Casas
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "4"://Trampas
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "5"://Switches
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "!"://Wild/Hidden creeps
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "@"://Locked Doors
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "#"://Open Doors
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "$"://Bosses
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "%"://Revealed Creeps
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "^"://Non-Questing Npcs
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "&"://Loot
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "*"://Character
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;
					case "?"://Quest NPC
						botones[alto-1][ancho-1] = new JButton("");
						botones[alto-1][ancho-1].setBounds(esquinax+(i*(sizeX)), esquinay+(j*(sizeY)), sizeX, sizeY);
						botones[alto-1][ancho-1].setFocusable(false);
						botones[alto-1][ancho-1].setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Screen Shot 2015-07-15 at 5.15.56 PM.png"));
						break;*/
						
				}
				frame.getContentPane().add(botones[alto-1][ancho-1]);
			}
		}
		

		personaje = new JLabel("");
		personaje.setIcon(new ImageIcon("D:/Users/Freddie/git/Coding-Dungeons/src/Character.png"));
		personaje.setBounds(611, 629, 61, 16);
		frame.getContentPane().add(personaje);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP){
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
