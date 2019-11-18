import Models.CelestialObject;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Graphics {
    public static void drawCelestialObject(GL2 gl, CelestialObject object) {
        gl.glColor3f(object.Colour.Red, object.Colour.Green, object.Colour.Blue);
        gl.glBegin(GL2.GL_POLYGON);
        drawPolygon(gl, object);
    }

    public static void drawBackground(GLAutoDrawable glAutoDrawable) {
        GL2[] dots = new GL2[Constants.NumberOfPoints];
        for (int i = 0; i < Constants.NumberOfPoints; i++) {
            dots[i] = glAutoDrawable.getGL().getGL2();
            dots[i].glBegin(GL2.GL_POINTS);
            dots[i].glVertex2d(Constants.coords[i].X, Constants.coords[i].Y);
            dots[i].glEnd();
        }
    }

    private static void drawPolygon(GL2 gl, CelestialObject object) {
        double angle;
        int numVertices = 50;
        double angleIncrement = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            angle = i * angleIncrement;
            double x = (object.Diameter / 2) * Math.cos(angle);
            double y = (object.Diameter / 2) * Math.sin(angle);
            gl.glVertex2f((float) x, (float) y);
        }
        gl.glEnd();
    }
}