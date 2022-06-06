package progetto.gui.components;

import java.util.List;

import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import progetto.Words;

/**
 * 
 * <!-- https://mvnrepository.com/artifact/org.swinglabs/swingx -->
 *
 */

@SuppressWarnings("serial")
public class AutoSuggestorJTextField extends JTextField{

	public AutoSuggestorJTextField() {
        super();
        List<String> words = Words.getWords();
        AutoCompleteDecorator.decorate(this, words, false);
	}
}