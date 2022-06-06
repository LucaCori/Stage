package progetto.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SaveButton extends JButton {
	
	protected static final String fileName = "C:\\Users\\iubar\\Desktop\\Dati_Salvati.txt";
	private JTextField textField = null;

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public SaveButton(String string) {
		super(string);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] frasi = new String[10];
					FileReader Dati_Salvati_r = new FileReader(fileName);
					BufferedReader br = new BufferedReader(Dati_Salvati_r);
					int counter = 0;
					String tmp = "";
					do{
						tmp = br.readLine();
						if(tmp==null) {
							break;
						} else {
							frasi[counter] = tmp;
							counter++;
						}
					}while(Dati_Salvati_r!=null);
					br.close();
					Dati_Salvati_r.close();
					FileWriter fw = new FileWriter(fileName);
					for(int i = 0; i < counter; i++) {
						fw.write(frasi[i] + "\r\n");
					}
					fw.write(SaveButton.this.textField.getText());
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

 
	
}