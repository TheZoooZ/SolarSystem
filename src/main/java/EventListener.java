import Models.CelestialObject;
import Models.Earth;
import Models.Sun;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class EventListener implements GLEventListener {
    public static GL2 centralPoint;

    private CelestialObject sun = new Sun(0, 0, 0);
    private CelestialObject earth = new Earth(0, 3, 0);
    private GLU gluSun;
    private GLU gluEarth;
    private GL2 glSun;
    private GL2 glEarth;

    public void init(GLAutoDrawable glAutoDrawable) {
        centralPoint = glAutoDrawable.getGL().getGL2();
        gluSun = new GLU();
        gluEarth = new GLU();
        glSun = glAutoDrawable.getGL().getGL2();
        glEarth = glAutoDrawable.getGL().getGL2();
        JFrameObjects.SetDefaultTimeOfCirculation(earth);
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {
        glEarth.glClear(GL2.GL_COLOR_BUFFER_BIT);
        glEarth.glLoadIdentity();

        applyMouseDragRotation(glSun);
        applyMouseDragRotation(glEarth);
        Graphics.drawBackground(glAutoDrawable);
        Graphics.drawSphere(glSun, gluSun, sun);
        Graphics.rotate(earth, glEarth);
        Graphics.drawSphere(glEarth, gluEarth, earth);
        applyJFrameButtons();
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(
                -Globals.WindowSize / 2.2,
                Globals.WindowSize / 2.2,
                -Globals.WindowSize / 2.2,
                Globals.WindowSize / 2.2,
                -Globals.WindowSize / 2.2,
                Globals.WindowSize / 2.2);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    private void applyMouseDragRotation(GL2 gl) {
        gl.glRotatef(MouseInput.getX() % 360, 0, 1, 1);
        gl.glRotatef(MouseInput.getY() % 360, 1, 0, 1);
    }

    private void applyJFrameButtons() {
        JFrameObjects.RangeLabel.setText("Range " + JFrameObjects.RangeSlider.getValue() * 100 + " km");
        JFrameObjects.TimeOfCirculationLabel.setText("ToC " + JFrameObjects.TimeOfCirculationSlider.getValue() + " s.");
    }

//    private void setCamera(GL2 gl, GLU glu, float distance) {
//        // Change to projection matrix.
//        gl.glMatrixMode(GL2.GL_PROJECTION);
//        gl.glLoadIdentity();
//
//        // Perspective.
//        float widthHeightRatio = 1;
//        glu.gluPerspective(45, widthHeightRatio, 1, 1000);
//        glu.gluLookAt(0, 0, distance, 0, 0, 0, 0, 1, 0);
//
//        // Change back to model view matrix.
//        gl.glMatrixMode(GL2.GL_MODELVIEW);
//        gl.glLoadIdentity();
//    }
}
