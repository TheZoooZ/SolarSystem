import com.sun.media.sound.SF2SoundbankReader;

import javax.swing.*;
import java.awt.*;

public class JFrameObjects {
    public static JLabel AngleVelocityLabel;
    public static JLabel RangeLabel;
    public static JSlider AngleVelocitySlider = setSlider(0,0);
    public static JSlider RangeSlider = setSlider(0,50);

    public static void addToolbars(JFrame frame){
        AngleVelocityLabel = setLabel(0,0, "Angle Velocity");
        AngleVelocitySlider = setSlider(0,30);
        RangeLabel = setLabel(0,80,"Range");
        RangeSlider = setSlider(0,110);

        frame.add(AngleVelocitySlider);
        frame.add(AngleVelocityLabel);
        frame.add(RangeSlider);
        frame.add(RangeLabel);
    }

    private static JLabel setLabel(int x, int y, String text){
        JLabel label = new JLabel(text);
        label.setBounds(x,y,100,30);
        return label;
    }

    private static JSlider setSlider(int x, int y) {
        JSlider slider = new JSlider();
        slider.setBounds(x, y, 100, 50);
        return slider;
    }

    private static JButton setButton(int x, int y){
        JButton button = new JButton("Hello World");
        button.setBounds(x,y,100,50);
        return button;
    }
}
