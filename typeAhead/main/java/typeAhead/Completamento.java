package typeAhead;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Completamento {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Completamento window = new Completamento();
					window.frame.setVisible(true);
				} catch (Exception e) {}
			}
		});
	}

	public Completamento() {
		initialize();
	}

	private void initialize() {
		frame = new Frame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
