package typeAhead;
 
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MyTextField extends JTextField {
	final String COMMIT_ACTION = "commit";
	private final List<String> keywords;
	
	public MyTextField(JPanel contentPane) {
		this.setBounds(50, 107, 350, 25);
		contentPane.add(this, BorderLayout.CENTER);
		this.setColumns(10);
		this.setFocusTraversalKeysEnabled(false);
		keywords = new ArrayList<String>(5);
	        keywords.add("example");
	        keywords.add("autocomplete");
	        keywords.add("stackabuse");
	        keywords.add("java");
	        keywords.add("ciao");
	        //keywords.add("prova");
	        keywords.add("prova1");
	        keywords.add("prova2");
	        keywords.add("prova4");
	        keywords.add("saluto");
	    Autocomplete autoComplete = new Autocomplete(this, keywords);
	    this.getDocument().addDocumentListener(autoComplete);
	    this.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
		this.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());
	}
}
