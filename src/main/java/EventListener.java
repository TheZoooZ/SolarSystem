import Models.CelestialObject;
import Models.Coords;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class EventListener implements GLEventListener {
    private CelestialObject sun = new CelestialObject(
            0,
            0,
            new Coords(0, 0, 0),
            new float[]{245f, 20f, 20f},
            20);
    private CelestialObject earth = new CelestialObject(
            365,
            24,
            new Coords(149.6, 0, 0),
            new float[]{24f, 74f, 248f},
            5);
    private GLU glu;

    public void init(GLAutoDrawable glAutoDrawable) {
        JFrameObjects.SetDefaultTimeOfCirculation(earth);
//        GL2 gl = glAutoDrawable.getGL().getGL2();
        this.glu = new GLU();

        JFrameObjects.RadiusSlider.setValue((int) earth.RadiusOfCirculation);
        JFrameObjects.TimeOfCirculationSlider.setValue((int) earth.TimeOfCirculation);
        JFrameObjects.TimeOfRotationSlider.setValue((int) earth.TimeOfRotation);
    }

    public void dispose(GLAutoDrawable glAutoDrawable) {
    }

    public void display(GLAutoDrawable glAutoDrawable) {
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        setCamera(gl, glu);
        if(JFrameObjects.RadiusSlider.hasFocus())
            earth.RadiusOfCirculation = JFrameObjects.RadiusSlider.getValue();
        if(JFrameObjects.TimeOfRotationSlider.hasFocus())
            earth.TimeOfRotation = JFrameObjects.TimeOfRotationSlider.getValue();
        if(JFrameObjects.TimeOfCirculationSlider.hasFocus())
            earth.TimeOfCirculation = JFrameObjects.TimeOfCirculationSlider.getValue();

        applyJFrameButtons();

        Graphics.drawBackground(gl);
        Graphics.drawSphere(gl, glu, sun);
        Graphics.drawSphere(gl, glu, earth);
        earth.Circulate();
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
        GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glViewport(0, 0, Globals.WindowSize, Globals.WindowSize);
        setCamera(gl, glu);
    }

    private void applyJFrameButtons() {
        JFrameObjects.TimeOfCirculationLabel.setText("ToC " + JFrameObjects.TimeOfCirculationSlider.getValue() + " d.");
        JFrameObjects.TimeOfRotationLabel.setText("ToR " + JFrameObjects.TimeOfRotationSlider.getValue() + " h.");
        JFrameObjects.RadiusLabel.setText("Radius " + JFrameObjects.RadiusSlider.getValue() + " M. km");
    }

    private void setCamera(GL2 gl, GLU glu) {
        // Change to projection matrix.
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        // Perspective.
        float widthHeightRatio = 1;
        glu.gluPerspective(45, widthHeightRatio, 0.1, 600);
        glu.gluLookAt(
                200, 200 + MouseWheelListener.getMouseWheelMovement(),
                200, 0, 0,
                0, 0, 0, 1);

        // Change back to model view matrix.
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
