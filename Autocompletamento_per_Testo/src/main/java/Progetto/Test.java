package Progetto;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Test {
	
    public Test() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField f = new JTextField(10);

        @SuppressWarnings("unused")
		AutoSuggestor autoSuggestor = new AutoSuggestor(f, frame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {

                @SuppressWarnings({ "unchecked", "rawtypes" })
				ArrayList<String> words = new ArrayList();
                Words.Add(words);

                setDictionary(words);

                return super.wordTyped(typedWord);
            }
        };

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(100, 100, 100, 100));
        
        JButton btnNewButton = new JButton("Save Text");
        SaveButton.Save(btnNewButton, f);
        p.add(btnNewButton);
        p.add(f);

        frame.getContentPane().add(p);

        frame.pack();
        frame.setVisible(true);
    }
    
}