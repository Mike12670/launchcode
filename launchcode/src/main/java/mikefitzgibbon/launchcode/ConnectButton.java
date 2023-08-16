/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mikefitzgibbon.launchcode;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gmf33
 */
public abstract class ConnectButton extends Button{
    static ConnectButton connectButton;
    static ServerSocket server;
    static Socket client;
    
    PrintWriter out;
    BufferedReader in;
    ChatBody body;
    
    public ConnectButton(String text) {
        super(text);
    }
    
}
