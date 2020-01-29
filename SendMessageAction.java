package geekbrains.lessons.lessonone.lessonFour;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SendMessageAction extends AbstractAction {

    private JTextField tfMessage;
    private JTextArea log;

    public SendMessageAction(JTextField tfMessage, JTextArea log) {
        this.tfMessage = tfMessage;
        this.log = log;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String message = tfMessage.getText() + System.getProperty("line.separator");
        log.append(message);
        tfMessage.setText("");
        try {
            Files.write(Paths.get("src/geekbrains/lessons/lessonone/lessonFour/text.txt"), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
