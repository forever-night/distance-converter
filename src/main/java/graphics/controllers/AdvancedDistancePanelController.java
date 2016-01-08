package graphics.controllers;

import graphics.util.DistanceConverter;
import graphics.views.panels.AdvancedDistancePanelView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by anna on 02/01/16.
 */
public class AdvancedDistancePanelController {
    private static final Logger LOGGER = LogManager.getLogger(AdvancedDistancePanelController.class);

    private double result;
    private AdvancedDistancePanelView view;
    private AbstractButton btnSelected;

    private class EnableCheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            switch(e.getStateChange()) {
                case ItemEvent.SELECTED:
                    view.setEnabled(true);
                    break;
                case ItemEvent.DESELECTED:
                    view.clear();
                    view.setEnabled(false);
                    break;
            }
        }
    }

    private class DistanceRadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            btnSelected = (JRadioButton) e.getSource();
        }
    }

    public AdvancedDistancePanelController(AdvancedDistancePanelView view) {
        this.view = view;

        view.addDistanceRadioButtonListener(new DistanceRadioButtonListener());
        view.addEnableCheckBoxListener(new EnableCheckBoxListener());
    }

    public double getResult() { return result; }

    public void setResult(double result) { this.result = result; }

    public AbstractButton getSelectedButton() { return btnSelected; }

    public void setSelectedButton(AbstractButton btnSelected) { this.btnSelected = btnSelected; }

    public double calculateResult(String input, String unit){
        if (input.equals(""))
            result = 0;
        else {
            try {
                result = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                LOGGER.warn("Not a number: " + input);
                return 0;
            }

            DistanceConverter distanceConverter = DistanceConverter.getInstance();
            result = distanceConverter.convertTo(result, unit);
        }

        return result;
    }

    public String getResultString() {
        String resultString = "";
        String unit = "";

        if (btnSelected != null)
            unit = btnSelected.getActionCommand();

        if (result != 0 && !unit.equals("")) {
            resultString = String.format("%.2f %s", result, unit);
        }

        return resultString;
    }
}