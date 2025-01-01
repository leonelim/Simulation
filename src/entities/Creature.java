package entities;

import map.Coordinates;
import map.GameField;

import java.util.List;
import java.util.Map;

import core.BreadthFirstSearch;

public abstract class Creature extends Entity {
    int speed = 1;
    public int healthPoints = 100;
    public void setHealthPoints(int healthPoints1) {
        healthPoints = healthPoints1;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public abstract boolean canEat(Entity entity);
}