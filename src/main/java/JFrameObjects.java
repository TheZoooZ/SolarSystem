import Models.CelestialObject;

import javax.swing.*;

class JFrameObjects {
    static JLabel TimeOfCirculationLabel;
    static JLabel RadiusLabel;
    static JSlider TimeOfCirculationSlider;
    static JSlider TimeOfRotationSlider;
    static JLabel TimeOfRotationLabel;
    static JSlider RadiusSlider;
    static JButton TimeFreezeButton;

    static void addToolbars(JFrame frame) {
        TimeOfCirculationLabel = setLabel(0, 0, "ToC 365 d.");
        TimeOfCirculationSlider = setSlider(0, 30, 200, 400);

        RadiusLabel = setLabel(0, 80, "Radius 149.6 M. km");
        RadiusSlider = setSlider(0, 110, 50, 200);

        TimeOfRotationLabel = setLabel(0,160, "ToR 24 h.");
        TimeOfRotationSlider = setSlider(0,190,4,48);

        TimeFreezeButton = setButton(120, 0);

        frame.add(TimeOfCirculationSlider);
        frame.add(TimeOfCirculationLabel);
        frame.add(RadiusSlider);
        frame.add(RadiusLabel);
        frame.add(TimeOfRotationLabel);
        frame.add(TimeOfRotationSlider);
        frame.add(TimeFreezeButton);
    }

    static void SetDefaultTimeOfCirculation(CelestialObject object) {
        TimeOfCirculationSlider.setValue((int) object.TimeOfCirculation);
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
