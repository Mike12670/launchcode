package mikefitzgibbon.launchcode;

public class SelectionPanel extends Panel{
    public SelectionPanel(){
        add(new SelectionPinger());
        add(new SelectionPacket());
        add(new SelectionWebsite());
        add(new SelectionChat());
        add(new SelectionIPConfig());
    }
}
