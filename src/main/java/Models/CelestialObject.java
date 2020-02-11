package Models;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CelestialObject {
    public Coords coords;
    public double timeOfCirculation;
    public double timeOfRotation;
    public int radius;
    public double radiusOfCirculation;
    public Texture texture;

    private double alpha = 0;

    public CelestialObject(
            int periodOfCirculation,
            int periodOfRotation,
            Coords coords,
            int radius) {
        this.timeOfCirculation = periodOfCirculation;
        this.timeOfRotation = periodOfRotation;
        this.coords = coords;
        this.radius = radius;

        radiusOfCirculation = CalculateRadius();
    }

    public boolean TryLoadTexture(String fileName) {
        try {
            String location = CelestialObject.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI().getPath();
            texture = TextureIO.newTexture(new File(location + fileName), true);
            return true;
        } catch (IOException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public void Circulate() {
        this.coords.X = radiusOfCirculation * Math.cos(alpha);
        this.coords.Y = radiusOfCirculation * Math.sin(alpha);
        alpha += (360.0 / (timeOfCirculation * 100.0));
        alpha %= 360;
    }

    public void ApplyTexture(GL2 gl) {
        if (texture != null) {
            texture.enable(gl);
            texture.bind(gl);
        } else {
            System.out.println("Texture not loaded");
        }
    }

    private double CalculateRadius() {
        return Math.sqrt(Math.pow(this.coords.X, 2) + Math.pow(this.coords.Y, 2) + Math.pow(this.coords.Z, 2));
    }
}
