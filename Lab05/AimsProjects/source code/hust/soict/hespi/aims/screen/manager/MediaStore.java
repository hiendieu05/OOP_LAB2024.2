package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {

    public MediaStore(Media media) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                if (media instanceof Playable playable) {
                    playable.play();

                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing: " + media.getTitle());
                    dialog.setSize(400, 200);
                    dialog.setLayout(new BorderLayout());

                    JTextArea textArea = new JTextArea(media.toString());
                    textArea.setEditable(false);
                    dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);

                    dialog.setVisible(true);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}