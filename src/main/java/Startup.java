import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Startup {
    private static GLWindow window = null;

    public static void main(String[] args) {
        initializeWindow();
    }

    private static void initializeWindow() {
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        window = GLWindow.create(capabilities);
        window.setSize(640, 300);
        window.setResizable(false);
        window.addGLEventListener(new Listener());

        FPSAnimator animator = new FPSAnimator(window, 30);
        animator.start();

        window.setVisible(true);
    }
}