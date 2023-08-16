package mikefitzgibbon.launchcode;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class PacketSend extends Button{
    PacketPort port;
    PacketBody body;
    PacketDest addr;
    
    public PacketSend(PacketPort port, PacketBody body, PacketDest addr){
        super("Send");
        this.port = port;
        this.body = body;
        this.addr = addr;
    }

    @Override
    public void buttonAction() {
        try {
            DatagramSocket socket = new DatagramSocket(Integer.parseInt(port.getText()));
            InetAddress dest = InetAddress.getByName(addr.getText());
            byte[] dataToSend = Integer.toString(Integer.parseInt(body.getText(), 16)).getBytes();
            DatagramPacket packet = new DatagramPacket(dataToSend, dataToSend.length, dest, Integer.parseInt(port.getText()));
            socket.send(packet);
        }
        catch(BindException e){
            JOptionPane.showMessageDialog(frame, "You recently set a packet at that port and address, wait a while so the connection can reset.");
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Enter a valid hexidecimal number.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
