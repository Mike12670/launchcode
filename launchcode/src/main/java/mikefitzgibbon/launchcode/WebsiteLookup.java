package mikefitzgibbon.launchcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;
import static mikefitzgibbon.launchcode.Frame.frame;

public class WebsiteLookup extends Button{
    WebsiteBody body;
    WebsiteURL source;
    
    String url;
    public WebsiteLookup(WebsiteURL source, WebsiteBody body){
        super("Lookup");
        this.body = body;
        this.source = source;
    }

    @Override
    public void buttonAction() {
        try{
            this.url = source.getText();
            URL site = new URI(url).toURL();
            HttpURLConnection connection = (HttpURLConnection) site.openConnection();
            connection.setRequestMethod("GET");
    
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    line += "\n";
                    responseBuilder.append(line);
                }
                
                body.setText(responseBuilder.toString());
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(frame, "IOException while trying to lookup webpage.");
            }
            
        }
        catch(URISyntaxException | MalformedURLException e){
            JOptionPane.showMessageDialog(frame, "Enter a valid URL.");
        }
        catch(ProtocolException e){
            JOptionPane.showMessageDialog(frame, "Enter a valid URL.");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(frame, "IOException while trying to lookup webpage.");
        }
    }
}
