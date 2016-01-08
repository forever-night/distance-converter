package distanceconverter.util;

/**
 * Created by anna on 01/01/16.
 */
public class DistanceConverter {
    private static DistanceConverter instance;

    private DistanceConverter() {}

    public static DistanceConverter getInstance() {
        if (instance == null)
            instance = new DistanceConverter();

        return instance;
    }

    public double toMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    public double toNautical(double kilometers) {
        return kilometers * 0.539957;
    }

    public double toFeet(double kilometers) {
        return kilometers * 3280.84;
    }

    public double toInches(double kilometers) {
        return kilometers * 39370.1;
    }

    public double toMeters(double kilometers) {
        return kilometers * 1000;
    }

    public double convertTo(double kilometers, String unit) {
        if (unit.equalsIgnoreCase("nautical miles"))
            return toNautical(kilometers);
        else if (unit.equalsIgnoreCase("feet"))
            return toFeet(kilometers);
        else if (unit.equalsIgnoreCase("meters"))
            return toMeters(kilometers);
        else if (unit.equalsIgnoreCase("inches"))
            return toInches(kilometers);

        return 0;
    }
}
