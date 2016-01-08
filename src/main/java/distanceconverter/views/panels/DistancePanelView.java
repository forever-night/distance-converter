package distanceconverter.views.panels;

import distanceconverter.controllers.DistancePanelController;
import distanceconverter.util.interfaces.Clearable;
import distanceconverter.util.interfaces.Resultable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by anna on 01/01/16.
 */
public class DistancePanelView extends JPanel implements Clearable, Resultable{
    private DistancePanelController controller;

    private JPanel pnlInput, pnlButtons, pnlResult;
    private JLabel lblEnter, lblResult;
    private JTextField txtInput;
    private JButton btnConvert, btnClear;


    public DistancePanelView() {
        setLayout(new GridLayout(3, 1));

        pnlInput = createInputPanel();
        pnlButtons = createButtonPanel();
        pnlResult = createResultPanel();

        add(pnlInput);
        add(pnlButtons);
        add(pnlResult);

        controller = new DistancePanelController(this);
    }

    public DistancePanelController getController() { return controller; }

    public String getInput() {
        return txtInput.getText();
    }

    public void addConvertButtonListener(ActionListener listener) {
        btnConvert.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    @Override
    public void showResult() {
        controller.calculateResult(getInput());

        String resultString = controller.getResultString();
        lblResult.setText(resultString);
    }

    @Override
    public void clear() {
        controller.setResult(0);
        txtInput.setText("");
        lblResult.setText("");
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();

        lblEnter = new JLabel("Enter distance in kilometers");
        txtInput = new JTextField(10);

        panel.add(lblEnter);
        panel.add(txtInput);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        btnConvert = new JButton("Convert");
        btnClear = new JButton("Clear");

        panel.add(btnConvert);
        panel.add(btnClear);

        return panel;
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel();

        lblResult = new JLabel();
        panel.add(lblResult);

        return panel;
    }
}