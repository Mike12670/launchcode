package mikefitzgibbon.launchcode;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatPanel extends Panel{
    public ChatPanel(){
        JPanel buttons = new JPanel();
        ChatAddress addr = new ChatAddress();
        ChatBody body = new ChatBody();
        ChatStart start = new ChatStart(body);
        ChatJoin join = new ChatJoin(addr, body);
        ChatDiscon discon = new ChatDiscon(body);
        buttons.add(start);
        buttons.add(join);
        buttons.add(discon);
        ChatMessage message = new ChatMessage();
        ChatSend send = new ChatSend(message, body);
        
        add(new JLabel("Enter IP address to which to connect for chat:"));
        add(addr);
        add(buttons);
        add(body.getPane());
        add(message);
        add(send);
    }
}
