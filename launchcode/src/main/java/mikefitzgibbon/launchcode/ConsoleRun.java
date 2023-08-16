package mikefitzgibbon.launchcode;

import java.io.IOException;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class ConsoleRun extends Button{
    
    public ConsoleRun() {
        super("Run Console");
        
    }

    @Override
    public void buttonAction() {
        try{
            Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "Could not start cmd.exe.");
        }
    }

}
