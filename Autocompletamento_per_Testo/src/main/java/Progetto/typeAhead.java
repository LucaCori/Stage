package Progetto;

import javax.swing.SwingUtilities;

public class typeAhead {
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
	
}