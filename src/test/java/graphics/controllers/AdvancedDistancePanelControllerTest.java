package graphics.controllers;

import graphics.views.panels.AdvancedDistancePanelView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

/**
 * Created by anna on 05/01/16.
 */
public class AdvancedDistancePanelControllerTest {
    AdvancedDistancePanelView view;
    AdvancedDistancePanelController controller;

    @Before
    public void setUp() {
        view = new AdvancedDistancePanelView();
        controller = view.getController();
    }

    @Test
    public void calculateResultIfInputEmpty() {
        double expected = 0;
        double actual = controller.calculateResult("", "meters");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputZero() {
        double expected = 0;
        double actual = controller.calculateResult("0", "meters");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputDecimalUnitsMeters() {
        double expected = 10500;
        double actual = controller.calculateResult("10.5", "meters");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputLettersUnitsMeters() {
        double expected = 0;
        double actual = controller.calculateResult("asdf", "meters");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputDecimalUnitsEmpty() {
        double expected = 0;
        double actual = controller.calculateResult("10.5", "");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getResultStringIfResultZero() {
        AbstractButton radioButton = new JRadioButton();
        radioButton.setActionCommand("meters");

        controller.setResult(0);
        controller.setSelectedButton(radioButton);

        String expected = "";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResultStringIfResultIntegerUnitsMeters() {
        AbstractButton radioButton = new JRadioButton();
        radioButton.setActionCommand("meters");

        controller.setResult(500);
        controller.setSelectedButton(radioButton);

        String expected = "500.00 meters";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResultStringIfResultDecimalUnitsMeters() {
        AbstractButton radioButton = new JRadioButton();
        radioButton.setActionCommand("meters");

        controller.setResult(100.1234567);
        controller.setSelectedButton(radioButton);

        String expected = "100.12 meters";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResultStringIfSelectedButtonNull() {
        AbstractButton radioButton = null;

        controller.setResult(1324);
        controller.setSelectedButton(radioButton);

        String expected = "";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        controller = null;
        view = null;
    }
}