import Models.CelestialObject;

import javax.swing.*;

class JFrameObjects {
    static JLabel timeOfCirculationLabel;
    static JLabel radiusLabel;
    static JSlider timeOfCirculationSlider;
    static JSlider timeOfRotationSlider;
    static JLabel timeOfRotationLabel;
    static JSlider radiusSlider;
    static JButton timeFreezeButton;

    static void addToolbars(JFrame frame) {
        timeOfCirculationLabel = setLabel(0, 0, "ToC 365 d.");
        timeOfCirculationSlider = setSlider(0, 30, 200, 400);

        radiusLabel = setLabel(0, 80, "Radius 149.6 M. km");
        radiusSlider = setSlider(0, 110, 50, 200);

        timeOfRotationLabel = setLabel(0,160, "ToR 24 h.");
        timeOfRotationSlider = setSlider(0,190,4,48);

        timeFreezeButton = setButton(120, 0);

        frame.add(timeOfCirculationSlider);
        frame.add(timeOfCirculationLabel);
        frame.add(radiusSlider);
        frame.add(radiusLabel);
        frame.add(timeOfRotationLabel);
        frame.add(timeOfRotationSlider);
        frame.add(timeFreezeButton);
    }

    static void SetDefaultTimeOfCirculation(CelestialObject object) {
        timeOfCirculationSlider.setValue((int) object.timeOfCirculation);
    }

    private static JLabel setLabel(int x, int y, String text) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        return label;
    }

    private static JSlider setSlider(int x, int y, int minimum, int maximum) {
        JSlider slider = new JSlider();
        slider.setBounds(x, y, 120, 50);
        slider.setMinimum(minimum);
        slider.setMaximum(maximum);
        return slider;
    }

    private static JButton setButton(int x, int y) {
        JButton button = new JButton("Time Freeze");
        button.setBounds(x, y, 120, 30);
        return button;
    }
}
