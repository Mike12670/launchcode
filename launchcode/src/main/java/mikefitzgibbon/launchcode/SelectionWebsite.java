package mikefitzgibbon.launchcode;

import static mikefitzgibbon.launchcode.Frame.frame;

public class SelectionWebsite extends Button{
    public SelectionWebsite(){
        super("Website");
    }
    
    @Override
    public void buttonAction(){
        WebsitePanel wp = new WebsitePanel();
        frame.setPanel(wp);
        frame.setVisible(true);
    }
}
