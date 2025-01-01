package core;

import entities.*;
import map.Coordinates;
import map.GameField;

public class MapDisplayer {
    public static void renderMap(GameField gameField) {
        for (int x = 0; x < gameField.getLength(); x++) {
            for (int y = 0; y < gameField.getHeight(); y++) {
                if (x == 0 && y == 0) {
                    System.out.println();
                }
                if (y == 0) {
                    System.out.println();
                }
                Entity entity = gameField.getEntity(new Coordinates(x, y)).orElse(null);
                if (entity == null) {
                    System.out.print("\uD83C\uDFFE");
                } if (entity instanceof Herbivore) {
                    System.out.print("\uD83D\uDC07");
                } if (entity instanceof Grass) {
                    System.out.print("\uD83C\uDF3F");
                } if (entity instanceof Predator) {
                    System.out.print("\uD83E\uDD8A");
                } if (entity instanceof Tree) {
                    System.out.print("\uD83C\uDF33");
                } if (entity instanceof Rock) {
                    System.out.print("\uD83E\uDDF1");
                }
            }
        }
        System.out.println();
    }
}
