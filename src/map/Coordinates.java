package map;

import java.util.Objects;
import java.util.Random;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Coordinates getRandomCoordinates(GameField gameField) {
        Random random = new Random();
        Coordinates randomCoordinates = new Coordinates(random.nextInt(gameField.getLength()), random.nextInt(gameField.getHeight()));
        while (gameField.getAllEntities().containsKey(randomCoordinates)) {
            randomCoordinates = new Coordinates(random.nextInt(gameField.getLength()), random.nextInt(gameField.getHeight()));
        }
        return randomCoordinates;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if ((object == null) || getClass() != object.getClass()) return false;
        Coordinates coordinates = (Coordinates) object;
        return this.x == coordinates.x && Objects.equals(this.y, coordinates.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}