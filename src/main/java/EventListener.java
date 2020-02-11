import Models.CelestialObject;
import Models.Coords;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class EventListener implements GLEventListener {
    private CelestialObject sun = new CelestialObject(
            0,
            600,
            new Coords(0, 0, 0),
            20);
    private CelestialObject earth = new CelestialObject(
            365,
            24,
            new Coords(149.6, 0, 0),
            5);
    private GLU glu;

    public void init(GLAutoDrawable glAutoDrawable) {
        JFrameObjects.SetDefaultTimeOfCirculation(earth);
        GL2 gl = glAutoDrawable.getGL().getGL2();
        this.glu = new GLU();

        gl.glColor3d(32, 138, 35);

        earth.TryLoadTexture("earth.png");
        sun.TryLoadTexture("sun.png");

        JFrameObjects.radiusSlider.setValue((int) earth.radiusOfCirculation);
        JFrameObjects.timeOfCirculationSlider.setValue((int) earth.timeOfCirculation);
        JFrameObjects.timeOfRotationSlider.setValue((int) earth.timeOfRotation);
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {
    }

    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        setCamera(gl, glu);
        applyJFrameButtons();

        Graphics.drawBackground(gl);
        Graphics.drawPath(earth, gl);
        Graphics.drawSphere(gl, glu, earth);
        Graphics.drawSphere(gl, glu, sun);
        earth.Circulate();
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glViewport(0, 0, Globals.WindowSize, Globals.WindowSize);
        setCamera(gl, glu);
    }

    private void applyJFrameButtons() {
        if (JFrameObjects.radiusSlider.hasFocus())
            earth.radiusOfCirculation = JFrameObjects.radiusSlider.getValue();
        if (JFrameObjects.timeOfRotationSlider.hasFocus())
            earth.timeOfRotation = JFrameObjects.timeOfRotationSlider.getValue();
        if (JFrameObjects.timeOfCirculationSlider.hasFocus())
            earth.timeOfCirculation = JFrameObjects.timeOfCirculationSlider.getValue();

        JFrameObjects.timeOfCirculationLabel.setText("ToC " + JFrameObjects.timeOfCirculationSlider.getValue() + " d.");
        JFrameObjects.timeOfRotationLabel.setText("ToR " + JFrameObjects.timeOfRotationSlider.getValue() + " h.");
        JFrameObjects.radiusLabel.setText("Radius " + JFrameObjects.radiusSlider.getValue() + " M. km");
    }

    private void setCamera(GL2 gl, GLU glu) {
        // Change to projection matrix.
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Perspective.
        glu.gluPerspective(45, 1, 0.1, 1200);
        glu.gluLookAt(
                200, 200 + MouseWheelListener.getMouseWheelMovement(), 200,
                0, 0, 0,
                0, 0, 1);

        // Change back to model view matrix.
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
