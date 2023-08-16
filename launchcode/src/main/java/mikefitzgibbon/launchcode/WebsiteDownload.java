package mikefitzgibbon.launchcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class WebsiteDownload extends Button{
    WebsiteURL url;
    public WebsiteDownload(WebsiteURL url){
        super("Download");
        this.url = url;
    }

    @Override
    public void buttonAction() { 
        try {
            URL url2 = new URI(url.getText()).toURL();
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(frame);
            File file = fc.getSelectedFile();
            BufferedReader readr = new BufferedReader(new InputStreamReader(url2.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
              
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }
  
            readr.close();
            writer.close();
        }
        catch (URISyntaxException | MalformedURLException e) {
            JOptionPane.showMessageDialog(frame, "Enter a vlid URL.");
        }
        catch (IOException ie) {
            JOptionPane.showMessageDialog(frame, "IOException while trying to lookup webpage.");
        }
    }
}
