package Models;

public class Earth extends CelestialObject {
    public Earth(double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        super(angularVelocity, periodOfCirculation, periodOfRotation);

        this.Radius = 10;
        this.Color = new Color(0, 191, 255);
        this.setStartCoords(100,0,0);
        this.Coords = this.getStartCoords();
    }
}
