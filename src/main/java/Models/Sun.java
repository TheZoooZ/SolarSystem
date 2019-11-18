package Models;

public class Sun extends CelestialObject {
    public Sun(Models.Coords coords, double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        super(coords, angularVelocity, periodOfCirculation, periodOfRotation);

        this.Colour = new Colour(255,233,0);
        this.Diameter = 100;
    }
}
