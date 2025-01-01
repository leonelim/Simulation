package core;

import entities.Creature;
import entities.Entity;
import entities.Tree;
import map.Coordinates;
import map.GameField;

import java.util.*;


public class BreadthFirstSearch {
    public static List<Coordinates> getPathList(GameField gameField, Coordinates start, Class<? extends Entity> targetEntityClass) {
        Queue<Coordinates> coordinatesToLookThrough = new LinkedList<>();
        Map<Coordinates, Integer> distanceBetweenStartAndCell = new HashMap<>();
        Map<Coordinates, Integer> distanceToEntities = new HashMap<>();
        Map<Coordinates, Coordinates> pathFromOneCellToAnother = new HashMap<>();
        Set<Coordinates> visitedCells = new HashSet<>();
        coordinatesToLookThrough.add(start);
        visitedCells.add(start);
        distanceBetweenStartAndCell.put(start, 0);
        while (!(coordinatesToLookThrough.isEmpty())) {
            Coordinates coordinates = coordinatesToLookThrough.poll();
            if (coordinates == null) {
                return new ArrayList<>();
            }
            visitedCells.add(coordinates);
            for (Coordinates childCoordinates: gameField.adjacentCells(coordinates, ((Creature) gameField.getEntity(start).get()))) {
                if (!(visitedCells.contains(childCoordinates))) {
                    distanceBetweenStartAndCell.put(childCoordinates, distanceBetweenStartAndCell.get(coordinates) + 1);
                    if (gameField.getEntity(childCoordinates).isPresent()) {
                        distanceToEntities.put(childCoordinates, distanceBetweenStartAndCell.get(coordinates) + 1);
                    }
                    coordinatesToLookThrough.add(childCoordinates);
                    pathFromOneCellToAnother.put(childCoordinates, coordinates);
                }
            }
        }
        Map<Coordinates, Integer> targets = new HashMap<>();
        for (Coordinates coordinates: distanceToEntities.keySet()) {
            if (gameField.getEntity(coordinates).get().getClass() == targetEntityClass) {
                targets.put(coordinates, distanceToEntities.get(coordinates));
            }
        }
        if (targets.isEmpty()) {
            return new ArrayList<>();
        }
        int minimum = Collections.min(targets.values());
        Coordinates target = null;
        for (Coordinates coordinates: targets.keySet()) {
            if (targets.get(coordinates) == minimum) {
                target = coordinates;
                break;
            }
        }
        List<Coordinates> path = new ArrayList<>();
        path.add(target);
        Coordinates parent = pathFromOneCellToAnother.get(target);
        path.add(parent);
        while (!(parent.equals(start))) {
            parent = pathFromOneCellToAnother.get(parent);
            path.add(parent);
        }
        path.removeLast();
        return path.reversed();
    }
}
