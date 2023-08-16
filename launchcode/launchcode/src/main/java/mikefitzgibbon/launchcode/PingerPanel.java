package mikefitzgibbon.launchcode;

import javax.swing.JLabel;

public class PingerPanel extends Panel{
    public PingerPanel(){
        PingerInput in = new PingerInput();
        PingerOutput out = new PingerOutput();
        add(new JLabel("IP address: "));
        add(in);
        add(new JLabel("Output: "));
        add(out.getPane());
        add(new PingerRun(in, out));
    }
}
