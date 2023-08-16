package mikefitzgibbon.launchcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class ChatJoin extends ConnectButton{
    ChatAddress addr;
    public ChatJoin(ChatAddress addr, ChatBody body){
        super("Join");
        this.addr = addr;
        this.body = body;
    }

    @Override
    public void buttonAction() {
        try{
            if(client != null){
                client.close();
                body.setText(body.getText() + "\nEnded Session.");
                client = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while disconnecting from server.");
            e.printStackTrace();
        }
        
        try{
            if(server != null){
                server.close();
                body.setText(body.getText() + "\nEnded Session.");
                server = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while shutting down server.");
            e.printStackTrace();
        }
        
        try{
            client = new Socket(addr.getText(), 7293);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            connectButton = this;
            body.setText(body.getText() + "Connected to server at " + addr.getText() + ".\n");
        }
        catch(UnknownHostException e){
            JOptionPane.showMessageDialog(frame, "Could not find host at address: " + addr.getText());
            e.printStackTrace();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while trying to connect to server. Address: " + addr.getText());
            e.printStackTrace();
        }
        
        ClientThread thread = new ClientThread();
        thread.start();
    }

    private class ClientThread extends Thread{
        @Override
        public void run(){
            try{
                boolean run = true;
                while(run){
                    String text = in.readLine();
                    body.setText(body.getText() + new Date().toString() + " Them: " + text + "\n");
                }
            }
            catch(IOException e){
                body.setText(body.getText() + "You were disconnected from " + addr.getText() + ".\n");
            }
        }
    }
}
