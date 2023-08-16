package mikefitzgibbon.launchcode;

import javax.swing.JLabel;

public class WebsitePanel extends Panel{
    public WebsitePanel(){
        WebsiteURL url = new WebsiteURL();
        WebsiteBody body = new WebsiteBody();
        WebsiteLookup lookup = new WebsiteLookup(url, body);
        WebsiteDownload download = new WebsiteDownload(url);
        
        add(new JLabel("Website URL: "));
        add(url);
        add(lookup);
        add(body.getPane());
        add(download);
    }
}
