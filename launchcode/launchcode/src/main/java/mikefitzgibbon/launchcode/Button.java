package mikefitzgibbon.launchcode;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public abstract class Button extends JButton{
    public Button(String text){
        super(text);
        addActionListener((ActionEvent e) -> {
            buttonAction();
        });
    }
    
    public abstract void buttonAction();
}
