import Models.CelestialObject;
import Models.Coords;
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
            dots[i].glColor3f(255,250,250);
            dots[i].glBegin(GL2.GL_POINTS);
            dots[i].glVertex2d(Constants.coords[i].X, Constants.coords[i].Y);
            dots[i].glEnd();
        }
    }

    public static void drawOrbit(GLAutoDrawable glAutoDrawable, Coords centralPoint, int range) {
        GL2 circle = glAutoDrawable.getGL().getGL2();
        circle.glBegin(GL2.GL_LINES);
        double angle;
        int numVertices = 100;
        double angleIncrement = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            angle = i * angleIncrement;
            double x = centralPoint.X + (range * Math.cos(angle));
            double y = centralPoint.Y + (range * Math.sin(angle));
            circle.glVertex2d(x, y);
        }
        circle.glEnd();
    }

    private static void drawPolygon(GL2 gl, CelestialObject object) {
        double angle;
        int numVertices = 50;
        double angleIncrement = 2 * Math.PI / numVertices;
        for (int i = 0; i < numVertices; i++) {
            angle = i * angleIncrement;
            double x = object.Coords.X + (object.Diameter / 2) * Math.cos(angle);
            double y = object.Coords.Y + (object.Diameter / 2) * Math.sin(angle);
            gl.glVertex2f((float) x, (float) y);
        }
        gl.glEnd();
    }
}