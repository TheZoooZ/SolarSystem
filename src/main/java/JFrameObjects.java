import javax.swing.*;
import java.awt.*;

public class JFrameObjects {
    public static JButton Button = setButton(200,200);
    public static JSlider AngleVelocitySlider = setSlider(0,0);
    public static JSlider RangeSlider = setSlider(0,50);

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
