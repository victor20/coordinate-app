package com.company.view;

import com.company.model.models.ContactInfo;
import com.company.model.models.Coordinate;
import com.company.model.Model;
import com.company.view.viewmodels.ViewData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class MainFrame extends JFrame implements ActionListener{

    private MapPanel mapPanel;
    private ButtonPanel buttonPanel;
    private Model model;
    private volatile boolean autoUpdate = true;
    private SwingWorker<ArrayList<Void>, ViewData> worker;

    public MainFrame() {
        model = new Model();
        mapPanel = new MapPanel();
        buttonPanel = new ButtonPanel();
        buttonPanel.aboutButton.addActionListener(this);
        buttonPanel.updateCoordinatesButton.addActionListener(this);
        buttonPanel.disableAutoUpdate.addActionListener(this);

        this.setTitle("Coordinates");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.add(mapPanel);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
        startWorker();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonPanel.disableAutoUpdate) {
            buttonPanel.disableAutoUpdate.setEnabled(false);
            autoUpdate = false;
            stopWorker();
        }
        if(e.getSource() == buttonPanel.updateCoordinatesButton) {
            startWorker();
        }
        if(e.getSource() == buttonPanel.aboutButton) {
            showContactInfo();
        }
    }

    private void startWorker() {
        stopWorker();
        worker = new SwingWorker<>() {

            @Override
            protected ArrayList<Void> doInBackground() throws Exception {
                do {
                    publish(new ViewData(null, true));
                    ArrayList<Coordinate> coordinates = model.getCoordinates();
                    publish(new ViewData(coordinates, false));
                    Thread.sleep(3000);
                } while(autoUpdate);
                return null;
            }

            @Override
            protected void process(List<ViewData> chunks) {
                ViewData viewData = chunks.get(chunks.size() - 1);
                if (viewData.getCoordinates() != null) {
                    mapPanel.addCoordinates(viewData.getCoordinates());
                }
                buttonPanel.statusLabel.setVisible(viewData.isUpdating());
                super.process(chunks);
            }

            @Override
            protected void done() {
                try {
                    get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (CancellationException e) {

                }
                super.done();
            }
        };
        worker.execute();
    }

    private void stopWorker() {
        if(worker != null) {
            worker.cancel(true);
            worker = null;
        }
    }

    private void showContactInfo() {
        ContactInfo contactInfo = model.getContactInfo();
        JOptionPane.showMessageDialog(
                null,
                contactInfo.toString(),
                "Contact Information",
                JOptionPane.PLAIN_MESSAGE);
    }
}
