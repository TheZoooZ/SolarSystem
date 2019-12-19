import Models.CelestialObject;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

public class Graphics {
    private static double angle = 0;

    public static void drawSphere(GL2 gl2, GLU glu, CelestialObject object) {
        final int slices = 128;
        final int stacks = 128;

        gl2.glColor3f(object.Color.Red, object.Color.Green, object.Color.Blue);
        GLUquadric sphere = glu.gluNewQuadric();

        glu.gluQuadricDrawStyle(sphere, GLU.GLU_FILL);
        glu.gluQuadricNormals(sphere, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(sphere, GLU.GLU_OUTSIDE);

        glu.gluSphere(sphere, object.Radius, slices, stacks);

        glu.gluDeleteQuadric(sphere);
    }

    public static void drawBackground(GLAutoDrawable glAutoDrawable) {
        GL2[] dots1 = new GL2[Globals.NumberOfPoints];

        for (int i = 0; i < Globals.NumberOfPoints; i++) {
            dots1[i] = glAutoDrawable.getGL().getGL2();
            dots1[i].glColor3f(255, 250, 250);
            dots1[i].glBegin(GL2.GL_POINTS);
            dots1[i].glVertex3d(Globals.starsCoords[i].X, Globals.starsCoords[i].Y, Globals.starsCoords[i].Z);
            dots1[i].glEnd();
        }
    }

    public static void rotate(CelestialObject object, GL2 gl) {
        double range = JFrameObjects.RangeSlider.getValue();
        object.Coords.X = (int) (range * Math.cos(angle));
        object.Coords.Y = (int) (range * Math.sin(angle));
        object.Coords.Z = 0;
        gl.glTranslatef(object.Coords.X, object.Coords.Y, object.Coords.Z);
        angle = (angle + 0.15 * 1 / JFrameObjects.TimeOfCirculationSlider.getValue()) % 360;
    }
}