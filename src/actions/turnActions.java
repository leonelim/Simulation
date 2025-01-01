package actions;

import core.MapDisplayer;
import entities.*;
import map.Coordinates;
import map.GameField;

import java.util.Map;

public class turnActions {
    public static void performTurn(GameField gameField, int turnCounter) {
        Map<Coordinates, Entity> entities = gameField.getAllEntities();
        if (turnCounter % 3 == 0) {
            gameField.setEntity(Coordinates.getRandomCoordinates(gameField), new Grass());
        }
        if (turnCounter % 6 == 0) {
            gameField.setEntity(Coordinates.getRandomCoordinates(gameField), new Herbivore());
        }
        for (Entity entity: entities.values()) {
            if (turnCounter % 2 == 0) {
                if (entity instanceof Herbivore herbivore) {
                    herbivore.makeMove(gameField, Grass.class);
                }
            } else {
                if (entity instanceof Predator predator) {
                    predator.makeMove(gameField, Herbivore.class);
                }
            }
        }
    }
}
