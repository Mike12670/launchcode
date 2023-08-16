package mikefitzgibbon.launchcode;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public abstract class Panel extends JPanel{
    public void init(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
