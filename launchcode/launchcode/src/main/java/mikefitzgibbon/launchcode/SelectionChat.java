package mikefitzgibbon.launchcode;

import static mikefitzgibbon.launchcode.Frame.frame;

public class SelectionChat extends Button{
    public SelectionChat(){
        super("Chat");
    }
    
    @Override
    public void buttonAction(){
        ChatPanel panel = new ChatPanel();
        frame.setPanel(panel);
        frame.setVisible(true);
    }
}
