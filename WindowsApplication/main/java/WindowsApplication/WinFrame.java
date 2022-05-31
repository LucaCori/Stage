package WindowsApplication;

import java.awt.EventQueue;

import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class WinFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	
	public static void check(JLabel img, JLabel lblNewLabel_5, String name, String type, int Index) {
		switch(Index) {
		case 1:
			ImageIcon icon1 = new ImageIcon("C:/Users/iubar/Downloads/Icons/PDF.png");
			img.setIcon(icon1);								
			break;
		case 2:
			ImageIcon icon2 = new ImageIcon("C:/Users/iubar/Downloads/Icons/TXT.png");
			img.setIcon(icon2);
			break;
		case 3:
			ImageIcon icon3 = new ImageIcon("C:/Users/iubar/Downloads/Icons/DOCX.png");
			img.setIcon(icon3);
			break;
		case 4:
			ImageIcon icon4 = new ImageIcon("C:/Users/iubar/Downloads/Icons/RTF.png");
			img.setIcon(icon4);
			break;
		case 5:
			ImageIcon icon5 = new ImageIcon("C:/Users/iubar/Downloads/Icons/ODT.png");
			img.setIcon(icon5);
			break;
		case 6:
			ImageIcon icon6 = new ImageIcon("C:/Users/iubar/Downloads/Icons/XML.png");
			img.setIcon(icon6);
			break;
		default:
			ImageIcon icon = new ImageIcon("");
			img.setIcon(icon);
			break;
		}
		lblNewLabel_5.setText(name + type);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinFrame frame = new WinFrame();
					frame.setVisible(true);
				} catch (Exception e) {}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinFrame() {
		
		setTitle("Create File for Windows");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setBounds(157, 11, 131, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(337, 95, 55, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel img = new JLabel("");
		img.setBounds(347, 130, 30, 30);
		contentPane.add(img);
		
		String[] types = {"NONE", ".pdf", ".txt", ".docx", ".rtf", ".odt", ".xml"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox comboBox = new JComboBox(types);
		comboBox.setEnabled(false);
		comboBox.setBounds(188, 123, 100, 22);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_6.setText("");
				String type = "";
				String name = "";
				switch(comboBox.getSelectedIndex()) {
					case 0:
						textField_2.setEditable(true);
						ImageIcon icon = new ImageIcon("");
						img.setIcon(icon);
						lblNewLabel_5.setText("");
						int i = 0;
						for(i = 0; i < 7; i++) {
							if((textField_2.getText()).equals(types[i])) {
								break;
							}
						}
						type = textField_2.getText();
						name = textField.getText();
						check(img, lblNewLabel_5, name, type, i);
						break;
					default:
						textField_2.setEditable(false);
						type = (String)comboBox.getSelectedItem();
						name = textField.getText();
						check(img, lblNewLabel_5, name, type, comboBox.getSelectedIndex());
						break;
				}
			}
		});
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String)comboBox.getSelectedItem();
				String name = textField.getText();
				String message = textField_1.getText();
				HelloWorld pdf = new HelloWorld();
				switch(comboBox.getSelectedIndex()) {
					case 0:
						type = textField_2.getText();
						name = name + type;
						boolean existing = false;
						for(int i = 1; i < 7; i++) {
							if((textField_2.getText()).equals(types[i])) {
								existing = true;
								break;
							}
						}
						if(existing) {
							lblNewLabel_6.setText("");
							if(type.equals(".pdf")){
								try {
									pdf.create(name, message);
								} catch (IOException e1) {}
							}
							else {
								try {
									FileWriter fileout = new FileWriter(name);
									fileout.write(message);
									fileout.close();
								} catch (IOException e1) {}
							}
							lblNewLabel_6.setText("File created!");
						}
						else {
							lblNewLabel_6.setText("File type doesn't exist!");
						}
						break;
					case 1:
						lblNewLabel_6.setText("");
						try {
							name = name + type;
							pdf.create(name, message);
						} catch (IOException e1) {}
						break;
					default:
						lblNewLabel_6.setText("");
						try {
							name = name + type;
							FileWriter fileout = new FileWriter(name);
							fileout.write(message);
							fileout.close();
						} catch (IOException e1) {}
						break;
				}
			}
		});
		
		btnNewButton.setBounds(313, 211, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				textName();
			}
			public void removeUpdate(DocumentEvent e) {
				textName();
			}
			public void changedUpdate(DocumentEvent e) {
				textName();
			}
			public void textName() {
				lblNewLabel_6.setText("");
				switch(comboBox.getSelectedIndex()) {
					case 0:
						lblNewLabel_5.setText(textField.getText() + textField_2.getText());
						break;
					default:
						lblNewLabel_5.setText(textField.getText() + (String)comboBox.getSelectedItem());
						break;
				}
			}
		});
		textField.setBounds(188, 61, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 92, 100, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("PDF Name");
		lblNewLabel.setBounds(118, 64, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Message");
		lblNewLabel_1.setBounds(118, 95, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(118, 127, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void warn() {
				lblNewLabel_6.setText("");
				int i = 0;
				for(i = 0; i < 7; i++) {
					if((textField_2.getText()).equals(types[i])) {
						break;
					}
				}
				String type = textField_2.getText();
				String name = textField.getText();
				check(img, lblNewLabel_5, name, type, i);
			}
		});
		textField_2.setBounds(188, 156, 100, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("or");
		lblNewLabel_3.setBounds(118, 159, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(118, 191, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
				if((String.valueOf(passwordField.getPassword())).equals("ciao")) {
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					btnNewButton.setEnabled(true);
					comboBox.setEnabled(true);
					btnNewButton_1.setEnabled(false);
					passwordField.setEditable(false);
					lblNewLabel_6.setText("Correct Password!");
				}
				else {
					lblNewLabel_6.setText("Wrong Password!");
				}
			}
		});
		btnNewButton_1.setBounds(10, 211, 89, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				lblNewLabel_6.setText("");
			}
			public void removeUpdate(DocumentEvent e) {
				lblNewLabel_6.setText("");
			}
			public void changedUpdate(DocumentEvent e) {
				lblNewLabel_6.setText("");
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				if((String.valueOf(passwordField.getPassword())).equals("ciao")) {
					if(key == 10) {
						textField.setEditable(true);
						textField_1.setEditable(true);
						textField_2.setEditable(true);
						btnNewButton.setEnabled(true);
						comboBox.setEnabled(true);
						btnNewButton_1.setEnabled(false);
						passwordField.setEditable(false);
						lblNewLabel_6.setText("Correct Password!");
					}
				}
				else {
					if(key == 10) {
						lblNewLabel_6.setText("Wrong Password!");
					}
				}
			}
		});
		passwordField.setBounds(188, 187, 100, 22);
		contentPane.add(passwordField);
	}
}
