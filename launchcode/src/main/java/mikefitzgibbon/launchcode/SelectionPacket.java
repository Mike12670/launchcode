package mikefitzgibbon.launchcode;

import static mikefitzgibbon.launchcode.Frame.frame;

public class SelectionPacket extends Button{
    public SelectionPacket(){
        super("Packet Sender");
    }
    
    @Override
    public void buttonAction(){
        PacketPanel panel = new PacketPanel();
        frame.setPanel(panel);
        frame.setVisible(true);
    }
}
