package distanceconverter.views.panels;

import distanceconverter.controllers.AdvancedDistancePanelController;
import distanceconverter.util.interfaces.Clearable;
import distanceconverter.util.interfaces.Resultable;
import distanceconverter.views.frames.DistanceFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Enumeration;

/**
 * Created by anna on 02/01/16.
 */
public class AdvancedDistancePanelView extends JPanel implements Clearable, Resultable{
    private AdvancedDistancePanelController controller;

    private JPanel pnlConvert, pnlSelect, pnlResult;
    private JLabel lblResult;
    private JRadioButton btnNautical, btnFeet, btnMeter, btnInch;
    private ButtonGroup btnGroupDistance;
    private JCheckBox chkEnable;


    public AdvancedDistancePanelView() {
        setLayout(new GridLayout(3, 1));

        pnlConvert = createConvertPanel();
        pnlSelect = createSelectPanel();
        pnlResult = createResultPanel();

        add(pnlConvert);
        add(pnlSelect);
        add(pnlResult);

        setEnabled(false);

        this.controller = new AdvancedDistancePanelController(this);
    }

    public AdvancedDistancePanelController getController() { return controller; }

    public AbstractButton getSelectedRadioButton() {
        if (pnlSelect.isEnabled()) {
            Enumeration<AbstractButton> radioButtons = btnGroupDistance.getElements();

            while (radioButtons.hasMoreElements()) {
                AbstractButton button = radioButtons.nextElement();

                if (button.isSelected())
                    return button;
            }
        }

        return null;
    }

    public void addEnableCheckBoxListener(ItemListener listener) {
        chkEnable.addItemListener(listener);
    }

    public void addDistanceRadioButtonListener(ActionListener listener) {
        Enumeration<AbstractButton> radioButtons = btnGroupDistance.getElements();

        while (radioButtons.hasMoreElements())
            radioButtons.nextElement().addActionListener(listener);
    }

    @Override
    public void showResult() {
        DistanceFrame window = (DistanceFrame) SwingUtilities.getWindowAncestor(this);
        String input = window.getKilometersInput();

        if (getSelectedRadioButton() != null)
            controller.calculateResult(input, getSelectedRadioButton().getActionCommand());

        String resultString = controller.getResultString();
        lblResult.setText(resultString);
    }

    @Override
    public void clear() {
        controller.setResult(0);
        lblResult.setText("");
        btnGroupDistance.clearSelection();
    }

    @Override
    public void setEnabled(boolean enabled) {
        setEnabled(this, enabled);
    }

    private void setEnabled(Container container, boolean enabled) {
        Component[] components = container.getComponents();

        for (Component component : components) {
            // checkbox to enable this panel is always enabled
            if (!(component instanceof JCheckBox))
                component.setEnabled(enabled);

            if (component instanceof Container)
                setEnabled((Container) component, enabled);
        }
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel();

        lblResult = new JLabel();
        panel.add(lblResult);

        return panel;
    }

    private JPanel createConvertPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        chkEnable = new JCheckBox("Convert also to:");
        panel.add(chkEnable);

        return panel;
    }

    private JPanel createSelectPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        btnNautical = new JRadioButton("nautical miles");
        btnFeet = new JRadioButton("feet");
        btnMeter = new JRadioButton("meters");
        btnInch = new JRadioButton("inches");

        btnNautical.setActionCommand("nautical miles");
        btnFeet.setActionCommand("feet");
        btnMeter.setActionCommand("meters");
        btnInch.setActionCommand("inches");


        btnGroupDistance = new ButtonGroup();

        btnGroupDistance.add(btnNautical);
        btnGroupDistance.add(btnFeet);
        btnGroupDistance.add(btnMeter);
        btnGroupDistance.add(btnInch);

        panel.add(btnNautical);
        panel.add(btnFeet);
        panel.add(btnMeter);
        panel.add(btnInch);

        return panel;
    }
}
