import Models.CelestialObject;
import Models.Coords;
import Models.Earth;
import Models.Sun;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Listener implements GLEventListener {
    private static Coords sunStartCoords = new Coords(0, 0);
    private static Coords earthStartCoords = new Coords(sunStartCoords.X + 200, sunStartCoords.Y + 0);
    private CelestialObject sun = new Sun(sunStartCoords, 0, 0, 0);
    private CelestialObject earth = new Earth(earthStartCoords, 0, 0, 0);
    private GL2 glSun;
    private GL2 glEarth;

    public void init(GLAutoDrawable glAutoDrawable) {
        glSun = glAutoDrawable.getGL().getGL2();
        glEarth = glAutoDrawable.getGL().getGL2();
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {
        Graphics.drawBackground(glAutoDrawable);
        Graphics.drawCelestialObject(glSun, sun);
        Graphics.drawCelestialObject(glEarth,earth);
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
