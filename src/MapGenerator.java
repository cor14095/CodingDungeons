/**
 * Map generator class
 * Main functions:
 * - Generate map
 * - Spawn everything
 * - Generate map matrix
 * - Validate movement functions
 * 
 */

//package CDClasesBETA;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 * @author: 	Yizuz
 * @co-autor:	Perry
 * @co-autor:	Chavinchi
 */

public class MapGenerator {

	// Attributes
	/**
	 * @attrib buttons: Los botones que funcionan como paredes
	 * @attirb matrixMap: La matriz que almacena el mapa
	 * @attrib map: El archivo donde esta el mapa
	 * @attrib brMap: El buffered reader del archivo con el mapa
	 * @attrib matrixH/W: Es el ancho	 y largo de la matriz que 
	 * 					  almacena el mapa.
	 * @attrib cornerX/Y: Es la posicion de los elementos creados
	 * @attrib myCharacter: El label donde esta tu personaje
	 * @attrib bgLabel: Un label con el fondo del mapa
	 * @attrib objectsList: una lista de labels para cargar objetos
	 */
	private JButton[][] buttons;
	private String[][] matrixMap;
	private FileReader map;
	private BufferedReader brMap;
	private int matrixH, matrixW, cornerX, cornerY, charAtX, charAtY;
	private JLabel myCharacter, bgLabel;
	private JLabel[][] objectsList;
	
	// Methods
	
	/**
	 * @param buttons
	 * @param matrixMap
	 * @param map
	 * @param brMap
	 * @param matrixH
	 * @param matrixW
	 * @param cornerX
	 * @param cornerY
	 * @param myCharacter
	 * @param bgLabel
	 * @param objectsList
	 */
	public MapGenerator(JButton[][] buttons, String[][] matrixMap,
			FileReader map, int matrixH, int matrixW,
			int cornerX, int cornerY, JLabel myCharacter, JLabel bgLabel,
			JLabel[][] objectsList) {
		super();
		this.buttons = buttons;
		this.matrixMap = matrixMap;
		this.map = map;
		this.brMap = new BufferedReader(map);
		this.matrixH = matrixH;
		this.matrixW = matrixW;
		this.cornerX = cornerX;
		this.cornerY = cornerY;
		this.myCharacter = myCharacter;
		this.bgLabel = bgLabel;
		this.objectsList = objectsList;
		this.matrixMap = new String[1000][1000];
	}
	
	
	
	/**
	 * @return the buttons
	 */
	public JButton[][] getButtons() {
		return buttons;
	}



	/**
	 * @param buttons the buttons to set
	 */
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}



	/**
	 * @return the matrixMap
	 */
	public String[][] getMatrixMap() {
		return matrixMap;
	}



	/**
	 * @param matrixMap the matrixMap to set
	 */
	public void setMatrixMap(String[][] matrixMap) {
		this.matrixMap = matrixMap;
	}



	/**
	 * @return the map
	 */
	public FileReader getMap() {
		return map;
	}



	/**
	 * @param map the map to set
	 */
	public void setMap(FileReader map) {
		this.map = map;
	}



	/**
	 * @return the brMap
	 */
	public BufferedReader getBrMap() {
		return brMap;
	}



	/**
	 * @param brMap the brMap to set
	 */
	public void setBrMap(BufferedReader brMap) {
		this.brMap = brMap;
	}



	/**
	 * @return the matrixH
	 */
	public int getMatrixH() {
		return matrixH;
	}



	/**
	 * @param matrixH the matrixH to set
	 */
	public void setMatrixH(int matrixH) {
		this.matrixH = matrixH;
	}



	/**
	 * @return the matrixW
	 */
	public int getMatrixW() {
		return matrixW;
	}



	/**
	 * @param matrixW the matrixW to set
	 */
	public void setMatrixW(int matrixW) {
		this.matrixW = matrixW;
	}



	/**
	 * @return the cornerX
	 */
	public int getCornerX() {
		return cornerX;
	}



	/**
	 * @param cornerX the cornerX to set
	 */
	public void setCornerX(int cornerX) {
		this.cornerX = cornerX;
	}



	/**
	 * @return the cornerY
	 */
	public int getCornerY() {
		return cornerY;
	}



	/**
	 * @param cornerY the cornerY to set
	 */
	public void setCornerY(int cornerY) {
		this.cornerY = cornerY;
	}



	/**
	 * @return the myCharacter
	 */
	public JLabel getMyCharacter() {
		return myCharacter;
	}



	/**
	 * @param myCharacter the myCharacter to set
	 */
	public void setMyCharacter(JLabel myCharacter) {
		this.myCharacter = myCharacter;
	}



	/**
	 * @return the bgLabel
	 */
	public JLabel getBgLabel() {
		return bgLabel;
	}



	/**
	 * @param bgLabel the bgLabel to set
	 */
	public void setBgLabel(JLabel bgLabel) {
		this.bgLabel = bgLabel;
	}



	/**
	 * @return the objectsList
	 */
	public JLabel[][] getObjectsList() {
		return objectsList;
	}



	/**
	 * @param objectsList the objectsList to set
	 */
	public void setObjectsList(JLabel[][] objectsList) {
		this.objectsList = objectsList;
	}

	

	/**
	 * @return the charAtX
	 */
	public int getCharAtX() {
		return charAtX;
	}
	
	
	



	/**
	 * @param charAtX the charAtX to set
	 */
	public void setCharAtX(int charAtX) {
		this.charAtX = charAtX;
	}
	
	
	



	/**
	 * @return the charAtY
	 */
	public int getCharAtY() {
		return charAtY;
	}
	
	
	



	/**
	 * @param charAtY the charAtY to set
	 */
	public void setCharAtY(int charAtY) {
		this.charAtY = charAtY;
	}
	
	
	



	/**
	 * @makes genera el data para el mapa
	 */
	public void generateData() {
		try {
			/**
			 * Try donde se lee el archivo y 
			 * se trabajan los datos del mismo
			 * para obtener el ancho y largo del mapa
			 * */
			String filaMapa = "0";								// String para almacenar las filas del mapa
			while(filaMapa != null) {							// While para leer el archivo donde esta el mapa
				filaMapa = brMap.readLine();					
				//System.out.print(filaMapa);
				if (matrixW<filaMapa.length()) {				// Si el ancho actual es menor al de la fila
					matrixW = filaMapa.length();				// Almacena el tamano de la fila en el ancho
				}
				if (filaMapa!=null) {							// For para meter la filaMapa actual en matrizMapa
					for (int i=0; i<=(filaMapa.length()-1); i++) {
						matrixMap[matrixH][i] = String.valueOf(filaMapa.charAt(i));
					}										
					matrixH++;										// Cuenta las filas del mapa
				}
			}
		} catch (Exception e) {
			System.out.print(e.toString()+"\n");
		}
		
		for(int i=0; i<matrixW; i++){
			/**
			 * Ciclo for para llenar los espacios
			 * null y en blanco con paredes para 
			 * evitar futuros errores
			 */
			for(int j=0; j<matrixH; j++){
				try{
					matrixMap[j][i].length();
					if (matrixMap[j][i].equals(" ")) {
						matrixMap[j][i] = "1";
					}
				} catch(Exception e){
					matrixMap[j][i] = "1";
				}
			}
		}
		
		buttons = new JButton[matrixH][matrixW];
		objectsList = new JLabel[matrixH][matrixW];
	}
	

	
	/**
	 * @makes genera el mapa en base al parent que se le indique
	 */
	public void creatMap(JFrame parentFrame) {
		for(int i=0; i<matrixW; i++){
			for(int j=0; j<matrixH; j++){
				switch(matrixMap[j][i]){
				case "0"://Espacio blanco/Grama
					break;
				case "1": //Pared
					buildObject(parentFrame, true, 
							"Images/GroundTexture1.png", 
							i, j);
					break;
				case "2": //Cofres
					break;	
				case "3": //Casas
					break;
				case "4": //Trampas
					break;
				case "5": //Switches
					break;
				case "!": //Wild/Hidden creeps
					break;
				case "@": //Locked Doors
					break;
				case "#": //Open Doors
					break;
				case "$": //Bosses
					break;
				case "%": //Revealed Creeps
					break;
				case "^": //Non-Questing Npcs
					break;
				case "&": //Loot
					break;
				case "*": //Character
					buildObject(parentFrame, false, 
							"Images/Character.png", 
							i, j);
					charAtX = i;
					charAtY = j;
					break;
				case "?": //Quest NPC
					break; 
				}
			}
		}
	}
	
	
	
	/**
	 * @makes crea botones o labels segun se solicite
	 */
	public void buildObject(JFrame parentFrame, boolean btnlbl, String filePath, int i, int j) {
		int sizeX = ((parentFrame.getWidth()-20)/matrixW);
		int sizeY = ((520)/matrixH);
		/*
		 * btnlbl es una bandera para indicar si es necesario crear un boton o una label
		 * True para boton
		 * false para label
		*/
		if (btnlbl) {
			buttons[j][i] = new JButton("");
			buttons[j][i].setBounds(cornerX+(i*(sizeX)), cornerY+(j*(sizeY)), sizeX, sizeY);
			buttons[j][i].setFocusable(false);
			buttons[j][i].setIcon(new ImageIcon(filePath));
			parentFrame.getContentPane().add(buttons[j][i]);
		} else if (filePath.equals("Images/Character.png")) {
			myCharacter = new JLabel("");
			myCharacter.setBounds(cornerX+(i*(sizeX)), cornerY+(j*(sizeY)), sizeX, sizeY);
			myCharacter.setFocusable(false);
			myCharacter.setIcon(new ImageIcon(filePath));
			parentFrame.getContentPane().add(myCharacter);
		} else {
			objectsList[j][i] = new JLabel("");
			objectsList[j][i].setBounds(cornerX+(i*(sizeX)), cornerY+(j*(sizeY)), sizeX, sizeY);
			objectsList[j][i].setFocusable(false);
			objectsList[j][i].setIcon(new ImageIcon(filePath));
			parentFrame.getContentPane().add(objectsList[j][i]);
		}
		
	}
	
}
