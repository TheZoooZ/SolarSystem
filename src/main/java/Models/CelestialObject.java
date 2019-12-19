package Models;

public abstract class CelestialObject {
    private Coords StartCoords;

    public Coords Coords;
    public double AngularVelocity;
    public int TimeOfCirculation;
    public int TimeOfRotation;
    public int Radius;
    public Color Color; //To delete in the future :)

    public CelestialObject(double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        this.AngularVelocity = angularVelocity;
        this.TimeOfCirculation = periodOfCirculation;
        this.TimeOfRotation = periodOfRotation;
    }

    public void setStartCoords(int x, int y, int z) {
        StartCoords = new Coords(x, y, z);
    }

    public Coords getStartCoords() {
        return StartCoords;
    }
}
