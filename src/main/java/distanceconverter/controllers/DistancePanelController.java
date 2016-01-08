package distanceconverter.controllers;

import distanceconverter.util.DistanceConverter;
import distanceconverter.util.interfaces.Clearable;
import distanceconverter.util.interfaces.Resultable;
import distanceconverter.views.panels.DistancePanelView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by anna on 02/01/16.
 */
public class DistancePanelController {
    private static final Logger LOGGER = LogManager.getLogger(DistancePanelController.class);

    private double result = 0;
    private DistancePanelView view;

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e.getActionCommand());

            Resultable window = (Resultable) SwingUtilities.getWindowAncestor(view);
            window.showResult();
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e.getActionCommand());

            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(view);
            ((Clearable) window).clear();
        }
    }

    public DistancePanelController(DistancePanelView view) {
        this.view = view;

        view.addConvertButtonListener(new ConvertButtonListener());
        view.addClearButtonListener(new ClearButtonListener());
    }

    public void setResult(double result) { this.result = result; }

    public double getResult() { return result; }

    public double calculateResult(String input) {
        if (input.equals(""))
            result = 0;
        else {

            double kilometers = 0;

            try {
                kilometers = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                LOGGER.warn("Not a number: " + input);
            }

            DistanceConverter converter = DistanceConverter.getInstance();
            result = converter.toMiles(kilometers);
        }

        return result;
    }

    public String getResultString() {
        String resultString = "";

        if (result != 0)
            resultString = String.format("%.2f miles", result);

        return resultString;
    }
}