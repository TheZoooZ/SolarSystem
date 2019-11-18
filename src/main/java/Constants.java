import Models.Coords;

import java.util.Random;

public class Constants {
    public static int WindowWidth = 640;
    public static int WindowHeight = 640;
    public static int NumberOfPoints = 400;
    public static Coords[] coords = generateRandomPoints(NumberOfPoints);

    public static Coords[] generateRandomPoints(int countOfPoints) {
        Random rn = new Random();
        Coords[] coords = new Coords[countOfPoints];

        for (int i = 0; i < countOfPoints; i++)
            coords[i] = new Coords(
                    (int) rn.nextInt() % (WindowWidth / 2),
                    (int) rn.nextInt() % (WindowHeight / 2));
        return coords;
    }
}