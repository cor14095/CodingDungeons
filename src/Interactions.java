/**
 * Interactions class
 * Main functions:
 * - Manejar las interacciones con los objetos
 * - Validar movimientos del mapa
 * 
 */

import java.awt.*;

public class Interactions {
	// Attributes
	private String[][] matrixMap;
	private int charAtX, charAtY;
	private Character character;
	
	// Methods
	/**
	 * @param matrixMap
	 * @param charAtX
	 * @param charAtY
	 * @param character
	 */
	public Interactions(String[][] matrixMap, int charAtX, int charAtY, Character character) {
		super();
		this.matrixMap = matrixMap;
		this.charAtX = charAtX;
		this.charAtY = charAtY;
		this.character = character;
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
	 * @return the character
	 */
	public Character getCharacter() {
		return character;
	}
	

	/**
	 * @param character the character to set
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}
	

	/**
	 * @return If move can be made, and its interactions
	 */
	public boolean canMove(int nextX, int nextY) {
		switch(matrixMap[nextY][nextX]) {
		case "0"://Espacio blanco/Grama
			return true;
		case "1": //Pared
			
			return false;
		case "2": //Cofres
			
			return false;	
		case "3": //Casas

			return false;
		case "4": //Trampas
			
			return true;
		case "5": //Switches
			
			return false;
		case "!": //Wild/Hidden creeps
			
			return false;
		case "@": //Locked Doors
			/*if key at character inventory, then can move through door*/
			if (true) {
				/*If key owned. change the door to an open door, then, you can move*/
				matrixMap[nextY][nextX] = "#";
				return false;
			} else {
				/*If key not owned, display message saying key not owned*/
				return false;
			}
		case "#": //Open Doors
			
			return true;
		case "$": //Bosses
			
			return false;
		case "%": //Revealed Creeps
			
			return false;
		case "^": //Non-Questing NPCs
			
			return false;
		case "&": //Loot
			
			return true;
		case "*": //Character
			/*If character moves over character, display a WTF message, and crash*/
			
			return false;
		case "?": //Quest NPC
			
			return false;
		}
		
		return false;
	}
	
}