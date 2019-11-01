package Models;

public abstract class CelestialObject {
    public Coords Coords;
    public double AngularVelocity;
    public int PeriodOfCirculation;
    public int PeriodOfRotation;
    protected int Diameter;
    protected Colour Colour;
    private Coords PointOfCirculation;

    public CelestialObject(Coords coords, double angularVelocity, int periodOfCirculation, int periodOfRotation) {
        this.Coords = coords;
        this.AngularVelocity = angularVelocity;
        this.PeriodOfCirculation = periodOfCirculation;
        this.PeriodOfRotation = periodOfRotation;
    }

    public void SetPointOfCirculation(Coords coords){
        this.PointOfCirculation = coords;
    }
}
