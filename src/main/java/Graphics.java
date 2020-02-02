import Models.CelestialObject;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

public class Graphics {
//    private static double angle = 0;

    public static void drawSphere(GL2 gl, GLU glu, CelestialObject object) {
        final int slices = 128;
        final int stacks = 128;

        gl.glPushMatrix();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glColor3f(object.Color[0], object.Color[1], object.Color[2]);
        gl.glTranslated(object.Coords.X, object.Coords.Y, object.Coords.Z);

        GLUquadric sphere = glu.gluNewQuadric();

        glu.gluQuadricDrawStyle(sphere, GLU.GLU_FILL);
        glu.gluQuadricNormals(sphere, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(sphere, GLU.GLU_OUTSIDE);

        glu.gluSphere(sphere, object.Radius, slices, stacks);

        glu.gluDeleteQuadric(sphere);
        gl.glEnd();
        gl.glFlush();
        gl.glPopMatrix();
    }

    public static void drawBackground(GL2 gl) {
        for (int i = 0; i < Globals.NumberOfPoints; i++) {
            gl.glPushMatrix();
            gl.glMatrixMode(GL2.GL_MODELVIEW);
            gl.glLoadIdentity();

            gl.glColor3f(255, 250, 250);
            gl.glBegin(GL2.GL_POINTS);
            gl.glVertex3d(Globals.starsCoords[i].X, Globals.starsCoords[i].Y, Globals.starsCoords[i].Z);
            gl.glEnd();
            gl.glFlush();
            gl.glPushMatrix();
        }
    }

//    public static void rotate(CelestialObject object, GL2 gl) {
//        double range = JFrameObjects.RangeSlider.getValue();
//        object.Coords.X = (int) (range * Math.cos(angle));
//        object.Coords.Y = (int) (range * Math.sin(angle));
//        object.Coords.Z = 0;
//
//        gl.glFlush();
//        gl.glPopMatrix();
//
//        angle = (angle + 0.15 * 1 / JFrameObjects.TimeOfCirculationSlider.getValue()) % 360;
//    }
}