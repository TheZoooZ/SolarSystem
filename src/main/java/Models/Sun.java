package Models;

public class Sun extends CelestialObject {
    public Sun(double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        super(angularVelocity, periodOfCirculation, periodOfRotation);

        this.Color = new Color(255, 233, 0);
        this.Radius = 50;
        this.setStartCoords(0, 0, 0);
        this.Coords = this.getStartCoords();
    }
}
