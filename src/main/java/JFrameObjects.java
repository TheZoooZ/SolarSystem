import javax.swing.*;

public class JFrameObjects {
    public static JLabel TimeOfCirculationLabel;
    public static JLabel RangeLabel;
    public static JSlider TimeOfCirculationSlider;
    public static JSlider RangeSlider;

    public static void addToolbars(JFrame frame) {
        TimeOfCirculationSlider = setSlider(0, 30);
        RangeSlider = setSlider(0, 110);

        RangeSlider.setMinimum(100);
        RangeSlider.setMaximum(300);

        TimeOfCirculationSlider.setMinimum(1);
        TimeOfCirculationSlider.setMaximum(10);
        TimeOfCirculationLabel = setLabel(0, 0, "ToC " + TimeOfCirculationSlider.getValue());
        RangeLabel = setLabel(0, 80, "Range " + RangeSlider.getValue() * 100 + " km");

        frame.add(TimeOfCirculationSlider);
        frame.add(TimeOfCirculationLabel);
        frame.add(RangeSlider);
        frame.add(RangeLabel);
    }

    private static JLabel setLabel(int x, int y, String text) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 30);
        return label;
    }

    private static JSlider setSlider(int x, int y) {
        JSlider slider = new JSlider();
        slider.setBounds(x, y, 100, 50);
        return slider;
    }

    private static JButton setButton(int x, int y) {
        JButton button = new JButton("Hello World");
        button.setBounds(x, y, 100, 50);
        return button;
    }
}
