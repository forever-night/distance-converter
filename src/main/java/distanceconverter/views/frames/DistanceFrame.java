package distanceconverter.views.frames;

import distanceconverter.util.interfaces.Clearable;
import distanceconverter.util.interfaces.Resultable;
import distanceconverter.views.panels.AdvancedDistancePanelView;
import distanceconverter.views.panels.DistancePanelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by anna on 01/01/16.
 */
public class DistanceFrame extends JFrame implements Clearable, Resultable{
    private static final int WIDTH = 640;
    private static final int HEIGHT = 360;

    private JPanel pnlDistance, pnlAdvancedDistance;

    private ArrayList<Clearable> clearables;
    private ArrayList<Resultable> resultables;

    public DistanceFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));

        setTitle("Distance Calculator");
        setLayout(new GridLayout(2, 1));


        pnlDistance = new DistancePanelView();
        pnlAdvancedDistance = new AdvancedDistancePanelView();

        add(pnlDistance);
        add(pnlAdvancedDistance);


        clearables = new ArrayList<Clearable>();
        clearables.add((Clearable) pnlDistance);
        clearables.add((Clearable) pnlAdvancedDistance);

        resultables = new ArrayList<Resultable>();
        resultables.add((Resultable) pnlDistance);
        resultables.add((Resultable) pnlAdvancedDistance);

        setVisible(true);
    }

    public String getKilometersInput() {
        return ((DistancePanelView) pnlDistance).getInput();
    }

    @Override
    public void showResult() {
        for (Resultable r : resultables)
            r.showResult();
    }

    @Override
    public void clear() {
        for (Clearable c : clearables)
            c.clear();
    }
}