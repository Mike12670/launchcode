package mikefitzgibbon.launchcode;

import static mikefitzgibbon.launchcode.Frame.frame;

public class SelectionIPConfig extends Button{
    public SelectionIPConfig(){
        super("Console");
    }
    
    @Override
    public void buttonAction(){
        frame.setPanel(new ConsolePanel());
        frame.setVisible(true);
    }
}
