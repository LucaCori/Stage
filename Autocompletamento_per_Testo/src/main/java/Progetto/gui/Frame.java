package progetto.gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import progetto.Words;
import progetto.gui.components.AutoSuggestorJComboBox;
import progetto.gui.components.AutoSuggestorJTextField;
import progetto.gui.components.AutoSuggestorTextField;
import progetto.gui.components.SaveButton;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private AutoSuggestorJComboBox comboBox = new AutoSuggestorJComboBox();
	
    private JPanel panel = new JPanel();       
    
    private AutoSuggestorTextField textField = new AutoSuggestorTextField(this, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f);
    
    private AutoSuggestorJTextField jtextfield = new AutoSuggestorJTextField();
    
    private SaveButton button = new SaveButton("Save Text");
    
    public Frame() {
    	this.setTitle("typeAhead");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(280, 150, 500, 300);
        this.panel.setBorder(new EmptyBorder(100, 100, 100, 100));        
        this.button.setTextField(textField); 
        this.panel.add(this.button);        
    	List<String> words = Words.getWords();
        this.textField.setDictionary(words);        
        this.textField.setColumns(10);
        this.panel.add(textField);
        this.getContentPane().add(panel);      
        this.comboBox.setBounds(113, 28, 200, 22);
        this.panel.add(this.comboBox);
        this.pack();
        this.setVisible(true);
        this.panel.add(jtextfield);
        this.jtextfield.setColumns(10);
    }
    
}