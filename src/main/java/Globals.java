import Models.Coords;
import com.jogamp.opengl.GL2;

import java.util.Random;

public class Globals {
    public static int WindowSize = 640;
    public static int NumberOfPoints = 1000;
    public static Coords[] starsCoords = generateRandomPoints(NumberOfPoints);

    public static Coords[] generateRandomPoints(int countOfPoints) {
        Random rn = new Random();
        Coords[] coords = new Coords[countOfPoints];

        for (int i = 0; i < countOfPoints; i++)
            coords[i] = new Coords(
                    (int) rn.nextInt() % (WindowSize / 2),
                    (int) rn.nextInt() % (WindowSize / 2),
                    (int) rn.nextInt() % WindowSize / 2);
        return coords;
    }
}