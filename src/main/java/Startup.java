import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Startup {
    private static GLProfile profile;
    private static GLCapabilities capabilities;
    private static GLCanvas glCanvas;
    private static JFrame frame;
    private static FPSAnimator animator;

    public static void main(String[] args) {
        initializeCanvas();
        initializeSwingWindow();
        addSwingObjects();
        wrapCanvasToSwingWindow();
        animateCanvas();
    }

    private static void initializeCanvas() {
        GLProfile.initSingleton();
        profile = GLProfile.get(GLProfile.GL2);
        capabilities = new GLCapabilities(profile);
        glCanvas = new GLCanvas(capabilities);
        glCanvas.setSize(640,640);
    }

    private static void initializeSwingWindow() {
        frame = new JFrame("SolarSystemMainWindow");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });
    }

    private static void addSwingObjects() {
        JFrameObjects.addToolbars(frame);
    }

    private static void wrapCanvasToSwingWindow() {
        frame.getContentPane().add(glCanvas, BorderLayout.CENTER);
        frame.setSize(640,640);
        frame.setVisible(true);
    }

    private static void animateCanvas() {
        glCanvas.addGLEventListener(new Listener());
        animator = new FPSAnimator(glCanvas,30);
        animator.start();
    }
}