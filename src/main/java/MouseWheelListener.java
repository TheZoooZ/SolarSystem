import java.awt.event.MouseWheelEvent;

public class MouseWheelListener implements java.awt.event.MouseWheelListener {
    private static int mouseWheelMovement = 0;

    public static int getMouseWheelMovement() {
        return mouseWheelMovement;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
            float amount = e.getWheelRotation();
            mouseWheelMovement += amount * 5;
        }
    }
}
