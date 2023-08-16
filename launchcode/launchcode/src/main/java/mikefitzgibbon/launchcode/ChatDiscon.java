package mikefitzgibbon.launchcode;

import java.io.IOException;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class ChatDiscon extends ConnectButton{
    public ChatDiscon(ChatBody body){
        super("Disconnect");
        this.body = body;
    }

    @Override
    public void buttonAction() {
        boolean isServer = false;
        try{
            if(server != null){
                server.close();
                isServer = true;
                body.setText(body.getText() + "Server ended.\n");
                server = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while shutting down a server.");
            e.printStackTrace();
        }
        
        try{
            if(client != null){
                client.close();
                if(!isServer){
                    body.setText(body.getText() + "Disconnected from " + client.getRemoteSocketAddress().toString() + ".\n");
                }
                client = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while disconnecting from server.");
            e.printStackTrace();
        }
    }
}
