package progetto;

import javax.swing.SwingUtilities;

import progetto.gui.Frame;

public class App {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame();
            }
        });
    }
	
}