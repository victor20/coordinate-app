package com.company.view;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    JLabel statusLabel;
    JButton aboutButton;
    JButton updateCoordinatesButton;
    JButton disableAutoUpdate;

    public ButtonPanel() {

        statusLabel = new JLabel();
        statusLabel.setText("Downloading Coordinates...");
        statusLabel.setVisible(false);
        aboutButton = new JButton();
        aboutButton.setText("About");
        updateCoordinatesButton = new JButton();
        updateCoordinatesButton.setText("Update Coordinates");
        disableAutoUpdate = new JButton();
        disableAutoUpdate.setText("Disable Auto Update");
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.add(aboutButton);
        this.add(updateCoordinatesButton);
        this.add(disableAutoUpdate);
        this.add(statusLabel);
        this.setBorder(BorderFactory.createMatteBorder(1,0,0,0, Color.BLACK));

    }
}
