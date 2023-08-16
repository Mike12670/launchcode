package mikefitzgibbon.launchcode;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea extends JTextArea{
    JScrollPane scrollPane;
    public TextArea(int width, int height){
        super(width, height);
    }
    
    public JScrollPane getPane(){
        scrollPane = new JScrollPane(this);  
  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        return scrollPane;
    }
}
