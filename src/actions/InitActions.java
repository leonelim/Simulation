package actions;

import entities.*;
import map.Coordinates;
import map.GameField;

public class InitActions {
    public static void initializeWorld(GameField gameField, int grassCnt, int herbivoreCnt, int predatorCnt, int rockCnt, int treeCnt) {
        for (int i = 0; i < grassCnt; i++) {
            Coordinates coordinates = Coordinates.getRandomCoordinates(gameField);
            gameField.setEntity(coordinates, new Grass());
        }
        for (int i = 0; i < herbivoreCnt; i++) {
            Coordinates coordinates = Coordinates.getRandomCoordinates(gameField);
            gameField.setEntity(coordinates, new Herbivore());
        }
        for (int i = 0; i < predatorCnt; i++) {
            Coordinates coordinates = Coordinates.getRandomCoordinates(gameField);
            gameField.setEntity(coordinates, new Predator());
        }
        for (int i = 0; i < rockCnt; i++) {
            Coordinates coordinates = Coordinates.getRandomCoordinates(gameField);
            gameField.setEntity(coordinates, new Rock());
        }
        for (int i = 0; i < treeCnt; i++) {
            Coordinates coordinates = Coordinates.getRandomCoordinates(gameField);
            gameField.setEntity(coordinates, new Tree());
        }
    }
}