package mikefitzgibbon.launchcode;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class PacketPanel extends Panel{
    public PacketPanel(){
        PacketDest dest = new PacketDest();
        PacketPort port = new PacketPort();
        PacketBody body = new PacketBody();
        
        add(new JLabel("Destination IP address:"));
        add(dest);
        add(new JLabel("Port:"));
        add(port);
        add(new JLabel("Body (in hexidecimal):"));
        add(body.getPane());
        add(new PacketSend(port, body, dest));
    }
}
