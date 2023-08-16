package mikefitzgibbon.launchcode;

import java.awt.Dimension;
import javax.swing.JTextField;

public class PingerInput extends JTextField{
    public PingerInput(){
        setColumns(30);
        setPreferredSize(new Dimension(30, 30));
        setEditable(true);
        setMaximumSize(getPreferredSize());
    }
}
