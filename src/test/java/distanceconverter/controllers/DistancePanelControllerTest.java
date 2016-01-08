package distanceconverter.controllers;

import distanceconverter.views.panels.DistancePanelView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anna on 05/01/16.
 */
public class DistancePanelControllerTest {
    DistancePanelView view;
    DistancePanelController controller;

    @Before
    public void setUp() {
        view = new DistancePanelView();
        controller = view.getController();
    }

    @Test
    public void calculateResultIfInputEmpty() {
        double expected = 0;
        double actual = controller.calculateResult("");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputZero() {
        double expected = 0;
        double actual = controller.calculateResult("0");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void calculateResultIfInputDecimal() {
        double expected = 6.213712;
        double actual = controller.calculateResult("10.5");

        Assert.assertEquals(expected, actual, 0.5);
    }

    @Test
    public void calculateResultIfInputLetters() {
        double expected = 0;
        double actual = controller.calculateResult("asdf");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getResultStringIfResultZero() {
        controller.setResult(0);

        String expected = "";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResultStringIfResultInteger() {
        controller.setResult(100);

        String expected = "100.00 miles";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getResultStringIfResultDecimal() {
        controller.setResult(100.1234567);

        String expected = "100.12 miles";
        String actual = controller.getResultString();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        controller = null;
        view = null;
    }
}