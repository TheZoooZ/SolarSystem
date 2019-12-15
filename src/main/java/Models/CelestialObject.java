package Models;

public abstract class CelestialObject {
    private Coords StartCoords;

    public Coords Coords;
    public double AngularVelocity;
    public int PeriodOfCirculation;
    public int PeriodOfRotation;
    public int Radius;
    public Color Color; //To delete in the future :)

    public CelestialObject(double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        this.AngularVelocity = angularVelocity;
        this.PeriodOfCirculation = periodOfCirculation;
        this.PeriodOfRotation = periodOfRotation;
    }

    public void setStartCoords(int x, int y, int z) {
        StartCoords = new Coords(x, y, z);
    }

    public Coords getStartCoords() {
        return StartCoords;
    }
}
