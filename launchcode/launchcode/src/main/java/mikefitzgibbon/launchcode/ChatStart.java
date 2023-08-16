package mikefitzgibbon.launchcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Date;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.ConnectButton.client;
import static mikefitzgibbon.launchcode.ConnectButton.server;
import static mikefitzgibbon.launchcode.Frame.frame;
import static mikefitzgibbon.launchcode.ConnectButton.connectButton;

public class ChatStart extends ConnectButton{
    public ChatStart(ChatBody body){
        super("Start");
        this.body = body;
    }

    @Override
    public void buttonAction() {
        boolean isServer = false;
        try{
            if(server != null){
                server.close();
                body.setText(body.getText() + "\nEnded Session.");
                isServer = true;
                server = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while ending a server.");
            e.printStackTrace();
        }
        
        try{
            if(client != null){
                client.close();
                if(!isServer)
                    body.setText(body.getText() + "\nEnded Session.");
                client = null;
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while ending a client.");
            e.printStackTrace();
        }
        
        ServerThread thread = new ServerThread();
        thread.start();
        connectButton = this;
        body.setText(body.getText() + "Server started.\n");
    }

    private class ServerThread extends Thread{
        @Override
        public void run(){
            try{
                server = new ServerSocket(7293);
                client = server.accept();
            
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
                body.setText(body.getText() + "Client connected from " + client.getRemoteSocketAddress().toString() + ".\n");
            }
            catch(SocketException e){}
            catch(IOException e){
                JOptionPane.showMessageDialog(frame, "IOException while starting a server.");
                e.printStackTrace();
            }
            
            try{
                boolean run = true;
                while(run){
                    String text = in.readLine();
                    body.setText(body.getText() + new Date().toString() + " Them: " + text + "\n");
                }
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(frame, "IOException while reading from a server.");
                e.printStackTrace();
            }
        }
    }
}
