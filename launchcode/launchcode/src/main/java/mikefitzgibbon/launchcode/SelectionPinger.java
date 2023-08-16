package mikefitzgibbon.launchcode;

import static mikefitzgibbon.launchcode.Frame.frame;

public class SelectionPinger extends Button{
    public SelectionPinger(){
        super("Pinger");
    }
    
    @Override
    public void buttonAction(){
        PingerPanel panel = new PingerPanel();
        frame.setPanel(panel);
        frame.setVisible(true);
    }
}
