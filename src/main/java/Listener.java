import Models.CelestialObject;
import Models.Coords;
import Models.Sun;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Listener implements GLEventListener {
    private static Coords sunStartCoords = new Coords(0, 0);
    private CelestialObject sun;

    public void init(GLAutoDrawable glAutoDrawable) {
        sun = new Sun(sunStartCoords, 0, 0, 0);
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {
        Graphics.drawBackground(glAutoDrawable);

        GL2 glSun = glAutoDrawable.getGL().getGL2();
        Graphics.drawCelestialObject(glSun, sun);
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(
                -Constants.WindowWidth / 2,
                Constants.WindowWidth / 2,
                -Constants.WindowHeight / 2,
                Constants.WindowHeight / 2,
                -1,
                1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }
}
