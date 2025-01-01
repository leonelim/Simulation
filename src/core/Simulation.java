package core;

import actions.InitActions;
import map.Coordinates;
import map.GameField;
import actions.turnActions;

import java.util.Collections;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        int turnCounter = 0;
        GameField gameField = new GameField(15, 15);
        InitActions.initializeWorld(gameField, 20, 5, 2, 10, 20);
        while (true) {
            MapDisplayer.renderMap(gameField);
            turnActions.performTurn(gameField, turnCounter);
            turnCounter += 1;
            Thread.sleep(2000);
        }
    }
    public void nextTurn() {};
    public void startSimulation() {};
    public void pauseSimulation() {};
}
