package Progetto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SaveButton extends JButton{
	
	public static void Save(JButton btnNewButton, final JTextField f) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] frasi = new String[10];
					FileReader Dati_Salvati_r = new FileReader("C:\\Users\\iubar\\Desktop\\Dati_Salvati.txt");
					BufferedReader br = new BufferedReader(Dati_Salvati_r);
					int counter = 0;
					String tmp = "";
					do{
						tmp = br.readLine();
						if(tmp==null) {
							break;
						}
						else {
							frasi[counter] = tmp;
							counter++;
						}
					}while(Dati_Salvati_r!=null);
					br.close();
					Dati_Salvati_r.close();
					FileWriter Dati_Salvati_w = new FileWriter("C:\\Users\\iubar\\Desktop\\Dati_Salvati.txt");
					for(int i = 0; i < counter; i++) {
						Dati_Salvati_w.write(frasi[i] + "\r\n");
					}
					Dati_Salvati_w.write(f.getText());
					Dati_Salvati_w.close();
				} catch (IOException e1) {}
			}
		});
	}
	
}