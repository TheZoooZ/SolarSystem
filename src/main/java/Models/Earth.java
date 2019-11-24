package Models;

public class Earth extends CelestialObject {
    public Earth(Models.Coords coords, double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        super(coords, angularVelocity, periodOfCirculation, periodOfRotation);

        this.Diameter = 10;
        this.Colour = new Colour(0, 191, 255);
    }
}
