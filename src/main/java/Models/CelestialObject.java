package Models;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;

public class CelestialObject {
    public Coords Coords;
    public double TimeOfCirculation;
    public double TimeOfRotation;
    public int Radius;
    public float[] Color; //To delete in the future :)
    public double RadiusOfCirculation;
    private double alpha = 0;

    public CelestialObject(
            int periodOfCirculation,
            int periodOfRotation,
            Coords coords,
            float[] color,
            int radius) {
        this.TimeOfCirculation = periodOfCirculation;
        this.TimeOfRotation = periodOfRotation;
        this.Coords = coords;
        this.Color = color;
        this.Radius = radius;

        RadiusOfCirculation = CalculateRadius();
    }

    public void Circulate() {
        this.Coords.X = RadiusOfCirculation * Math.cos(alpha);
        this.Coords.Y = RadiusOfCirculation * Math.sin(alpha);
        alpha += (360.0 / (TimeOfCirculation * 100.0));
        alpha %= 360;
    }

    public void Rotate(GLAutoDrawable gl, GLU glu){

    }

    private double CalculateRadius() {
        return Math.sqrt(Math.pow(this.Coords.X, 2) + Math.pow(this.Coords.Y, 2) + Math.pow(this.Coords.Z, 2));
    }
}
