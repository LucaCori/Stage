package typeAhead;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	private JPanel contentPane;
	private JTextField mainTextField;

	public Frame() {
		setTitle("typeAhead");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainTextField = new MyTextField(contentPane);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(177, 182, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String daSalvare = mainTextField.getText();
				FileWriter Salvataggio;
				try {
					Salvataggio = new FileWriter("C:/Users/iubar/Desktop/Salvataggio.txt");
					Salvataggio.write(daSalvare);
					Salvataggio.close();
				} catch (IOException e1) {}
			}
		});

	}
}
