package graphics.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anna on 04/01/16.
 */
public class DistanceConverterTest {
    private DistanceConverter distanceConverter;

    @Before
    public void setUp() {
        distanceConverter = DistanceConverter.getInstance();
    }

    @Test
    public void oneKilometerToMiles() {
        double expected = 0.621371;
        double actual = distanceConverter.toMiles(1);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void oneKilometerToNautical() {
        double expected = 0.539957;
        double actual = distanceConverter.toNautical(1);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void oneKilometerToFeet() {
        double expected = 3280.84;
        double actual = distanceConverter.toFeet(1);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void oneKilometerToInches() {
        double expected = 39370.1;
        double actual = distanceConverter.toInches(1);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void oneKilometerToMeters() {
        double expected = 1000;
        double actual = distanceConverter.toMeters(1);

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void zeroToMiles() {
        double actual = distanceConverter.toMiles(0);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void zeroToNautical() {
        double actual = distanceConverter.toNautical(0);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void zeroToFeet() {
        double actual = distanceConverter.toFeet(0);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void zeroToInches() {
        double actual = distanceConverter.toInches(0);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void zeroToMeters() {
        double actual = distanceConverter.toMeters(0);

        Assert.assertEquals(0, actual, 0);
    }

    @Test
    public void doubleToMiles() {
        double expected = 34.4861;
        double actual = distanceConverter.toMiles(55.5);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void doubleToNautical() {
        double expected = 29.9676;
        double actual = distanceConverter.toNautical(55.5);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void doubleToFeet() {
        double expected = 182086.6;
        double actual = distanceConverter.toFeet(55.5);

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void doubleToInches() {
        double expected = 2185039;
        double actual = distanceConverter.toInches(55.5);

        Assert.assertEquals(expected, actual, 1e+2);
    }

    @Test
    public void doubleToMeters() {
        double expected = 55500;
        double actual = distanceConverter.toMeters(55.5);

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void convertToEmptyString() {
        double expected = 0;
        double actual = distanceConverter.convertTo(50, "");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void convertToNautical() {
        double expected = 26.9978;
        double actual = distanceConverter.convertTo(50, "nautical miles");

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void convertToFeet() {
        double expected = 164042;
        double actual = distanceConverter.convertTo(50, "feet");

        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void convertToInches() {
        double expected = 1.969e+6;
        double actual = distanceConverter.convertTo(50, "inches");

        Assert.assertEquals(expected, actual, 1e+6);
    }

    @Test
    public void convertToMeters() {
        double expected = 50000;
        double actual = distanceConverter.convertTo(50, "meters");

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void convertToDigits() {
        double expected = 0;
        double actual = distanceConverter.convertTo(50, "123");

        Assert.assertEquals(expected, actual, 0);
    }

    @After
    public void tearDown() {
        distanceConverter = null;
    }
}