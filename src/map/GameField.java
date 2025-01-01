package map;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import entities.*;

public class GameField {
    private final int length;
    private final int height;
    private final Map<Coordinates, Entity> gameField = new HashMap<>();
    public GameField(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Optional<Entity> getEntity(Coordinates coordinates) {

        return Optional.ofNullable(gameField.get(coordinates));
    }
    public void setEntity(Coordinates coordinates, Entity entity) {
        if (0 <= coordinates.getX() && coordinates.getX() <= getLength() && 0 <= coordinates.getY() && coordinates.getY() <= getHeight()) {
            gameField.put(coordinates, entity);
        }
    }
    public void removeEntity(Coordinates coordinates) {
        gameField.remove(coordinates);
    }

    public void moveCreature(Coordinates start, Coordinates end) {
        Entity entity = gameField.get(start);
        if (entity instanceof Creature creature) {
            gameField.remove(start);
            gameField.put(end, creature);
        }
    }
    public Map<Coordinates, Entity> getAllEntities() {
        return new HashMap<>(gameField);
    }

    public List<Coordinates> adjacentCells(Coordinates coordinates, Creature creature) {
        List<Coordinates> list = new ArrayList<>();
        if (coordinates.getX() > 0) {
            Optional<Entity> entity = getEntity(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
            if (entity.isEmpty() || creature.canEat(entity.get())) {
                list.add(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
            }
        }
        if (coordinates.getY() > 0) {
            Optional<Entity> entity = getEntity(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
            if (entity.isEmpty() || creature.canEat(entity.get())) {
                list.add(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
            }
        }
        if (coordinates.getY() < getHeight() - 1) {
            Optional<Entity> entity = getEntity(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
            if (entity.isEmpty() || creature.canEat(entity.get())) {
                list.add(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
            }
        }
        if (coordinates.getX() < getLength() - 1) {
            Optional<Entity> entity = getEntity(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
            if (entity.isEmpty() || creature.canEat(entity.get())) {
                list.add(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
            }
        }
        return list;
    }

    public Coordinates getCoordinatesByEntity(Entity entity) {
        for (Entity entity1: gameField.values()) {
            if (entity1 == entity) {
                for (Coordinates coordinates: gameField.keySet()) {
                    if (gameField.get(coordinates) == entity) {
                        return coordinates;
                    }
                }
            }
        }
        return null;
    }
}


