package mikefitzgibbon.launchcode;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{
    static Frame frame;
    public Frame(){
        super("Network Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); 
        
        SelectionPanel topPanel = new SelectionPanel();
        PingerPanel panel = new PingerPanel();
        panel.init();
        add(panel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.PAGE_START);
        
        setVisible(true);
    }
    
    public void setPanel(Panel p){
        getContentPane().removeAll();
        SelectionPanel topPanel = new SelectionPanel();
        p.init();
        add(topPanel, BorderLayout.PAGE_START);
        add(p);
    }
}
