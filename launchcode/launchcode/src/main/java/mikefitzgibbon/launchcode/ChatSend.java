package mikefitzgibbon.launchcode;

import java.util.Date;
import static mikefitzgibbon.launchcode.ConnectButton.connectButton;

public class ChatSend extends Button{
    ChatMessage message;
    ChatBody body;
    public ChatSend(ChatMessage mess, ChatBody body){
        super("Send");
        this.message = mess;
        this.body = body;
    }

    @Override
    public void buttonAction() {
        connectButton.out.println(message.getText());
        body.setText(body.getText() + new Date().toString() + " You: " + message.getText() + "\n");
        message.setText("");
    }
}
