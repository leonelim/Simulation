package entities;

import core.BreadthFirstSearch;
import map.Coordinates;
import map.GameField;

import java.util.List;
import java.util.Map;

public class Herbivore extends Creature {
    public final static int speed = 1;
    public void makeMove(GameField gameField, Class<? extends Entity> targetClass) {
        List<Coordinates> path = BreadthFirstSearch.getPathList(gameField,gameField.getCoordinatesByEntity(this), targetClass);
        if (path.isEmpty()) {
            return;
        }
        gameField.moveCreature(gameField.getCoordinatesByEntity(this), path.getFirst());
    }
    @Override
    public boolean canEat(Entity entity) {
        if (entity instanceof Grass) {
            return true;
        }
        return false;
    }
}