package entities;

import core.BreadthFirstSearch;
import map.Coordinates;
import map.GameField;

import java.util.List;
import java.util.Map;

public class Predator extends Creature {
    public int attackStrength;
    public final static int speed = 2;
    public void makeMove(GameField gameField, Class<? extends Entity> targetClass) {
        List<Coordinates> path = BreadthFirstSearch.getPathList(gameField, gameField.getCoordinatesByEntity(this), targetClass);
        if (path.isEmpty()) {
            return;
        }
        if (path.size() == 1) {
            gameField.moveCreature(gameField.getCoordinatesByEntity(this), path.getFirst());
        } else {
            gameField.moveCreature(gameField.getCoordinatesByEntity(this), path.get(1));
        }

    }
    @Override
    public boolean canEat(Entity entity) {
        if (entity instanceof Herbivore) {
            return true;
        }
        return false;
    }
}