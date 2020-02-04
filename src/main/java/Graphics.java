import Models.CelestialObject;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import static com.jogamp.opengl.GL.GL_LINE_SMOOTH;

public class Graphics {
    private static float angle = 0;

    public static void drawSphere(GL2 gl, GLU glu, CelestialObject object) {
        final int slices = 128;
        final int stacks = 128;

        gl.glPushMatrix();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslated(object.coords.X, object.coords.Y, object.coords.Z);
        gl.glRotatef(angle, 0.0f, 0.0f, -1.0f); // Rotate planet
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f); // Correctly orient planet

        object.ApplyTexture(gl);
        GLUquadric sphere = glu.gluNewQuadric();

        glu.gluQuadricTexture(sphere, true);
        glu.gluQuadricDrawStyle(sphere, GLU.GLU_FILL);
        glu.gluQuadricNormals(sphere, GLU.GLU_FLAT);
        glu.gluQuadricOrientation(sphere, GLU.GLU_OUTSIDE);

        glu.gluSphere(sphere, object.radius, slices, stacks);

        glu.gluDeleteQuadric(sphere);
        gl.glEnd();
        if (object.texture != null) {
            gl.glDisable(GL2.GL_COLOR_MATERIAL);
            object.texture.disable(gl);
        }
        rotate(object);
        gl.glPopMatrix();
    }

    public static void drawBackground(GL2 gl) {
        gl.glColor3f(1f, 1f, 1f);
        for (int i = 0; i < Globals.NumberOfPoints; i++) {
            gl.glPushMatrix();
            gl.glMatrixMode(GL2.GL_MODELVIEW);
            gl.glLoadIdentity();

            gl.glBegin(GL2.GL_POINTS);
            gl.glVertex3d(Globals.starsCoords[i].X, Globals.starsCoords[i].Y, Globals.starsCoords[i].Z);
            gl.glEnd();
            gl.glPopMatrix();
        }
    }

    public static void drawPath(CelestialObject object, GL2 gl) {
        double inc = Math.PI / 24;
        double max = 2 * Math.PI;
        gl.glEnable(GL_LINE_SMOOTH);
        gl.glLineWidth(2f);

        gl.glBegin(GL2.GL_LINE_LOOP);
        gl.glColor3f(1.0f, 1.0f, 1.0f);

        for (double d = 0; d < max; d += inc) {
            gl.glVertex3d(Math.sin(d) * object.radiusOfCirculation, Math.cos(d) * object.radiusOfCirculation, 0);
        }
        gl.glEnd();
    }

    private static void rotate(CelestialObject object) {
        angle = (angle + 100f / (float) object.timeOfRotation) % 360;
    }
}