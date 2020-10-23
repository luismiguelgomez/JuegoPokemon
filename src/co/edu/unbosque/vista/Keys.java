package co.edu.unbosque.vista;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

//Modelo
public class Keys {
	public static final int NUM_KEYS = 8;
	public static boolean[] keyState = new boolean[8];
	public static boolean[] prevKeyState = new boolean[8];  
	public static int UP = 0;
	public static int LEFT = 1;
	public static int DOWN = 2;
	public static int RIGHT = 3;
	public static int SPACE = 4;
	public static int ENTER = 5;
	public static int ESCAPE = 6;
	public static int F1 = 7;
	

	public static void keySet(int i, boolean b) {
		if (i == 38) { keyState[UP] = b; }
		else if (i == 37) { keyState[LEFT] = b; }
		else if (i == 40) { keyState[DOWN] = b; }
		else if (i == 39) { keyState[RIGHT] = b; }
		else if (i == 32) { keyState[SPACE] = b; }
		else if (i == 10) { keyState[ENTER] = b; }
		else if (i == 27) { keyState[ESCAPE] = b; }
		else if (i == 112) { keyState[F1] = b; }
	}
	
	public static void update() {
		for (int i = 0; i < 8; i++) {
			prevKeyState[i] = keyState[i];
		}
	}

	public static boolean isPressed(int i) {
		return (keyState[i] && !prevKeyState[i]);
	}

	public static boolean isDown(int i) {
		return keyState[i];
	}
 
	public static boolean anyKeyDown() {
		for (int i = 0; i < 8; i++) {
			if (keyState[i]) return true; 
			} 
		return false;
	}

	public static boolean anyKeyPress() {
		for (int i = 0; i < 8; i++) {
			if (keyState[i] && !prevKeyState[i]) return true; 
		} 
		return false;
	}
	public Image intro(String s) throws IOException {
		FileInputStream file = new FileInputStream(s);
		Image intro = ImageIO.read(file);
		file.close();
		return intro;
	}
}
