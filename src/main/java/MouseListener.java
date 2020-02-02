import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements MouseMotionListener {
    private static int mouseDragXPosition = 0;
    private static int mouseDragYPosition = 0;
    private static int scrollUnits = 0;

    public static int getMouseDragXPosition() {
        return mouseDragXPosition;
    }

    public static int getMouseDragYPosition() {
        return mouseDragYPosition;
    }

    public static int getScrollUnits() {
        return scrollUnits;
    }

    public void mouseDragged(MouseEvent e) {
        mouseDragXPosition = e.getX();
        mouseDragYPosition = e.getY();
    }

    public void mouseMoved(MouseEvent e) {
    }
}
