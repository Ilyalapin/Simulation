package Simulation2D;

import Simulation2D.Entity.Entity;
import Simulation2D.Entity.Creature;
import Simulation2D.Entity.Herbivore;
import Simulation2D.Entity.Predator;
import Simulation2D.Entity.Rock;
import Simulation2D.Entity.Tree;

import java.util.*;

import static Simulation2D.Map.*;


public class SearchAlgorithm {
    static Class<? extends Entity> victim;

    // метод получения кратчайшего пути.
    public static List<Coordinates> getShortestPath(Coordinates startSquare, Map worldMap, Class<? extends Entity> victim) {
        SearchAlgorithm.victim = victim;
        return goalSerch(startSquare, worldMap);
    }

    // Поиск пути. Алгоритм обхода в ширину.
    public static List<Coordinates> goalSerch(Coordinates startSquare, Map worldMap) {
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visitedSquare = new HashSet<>();
        HashMap<Coordinates, Coordinates> parentMap = new HashMap<>();
        Coordinates resultSquare = null;
        queue.add(startSquare);
        visitedSquare.add(queue.element());         //раскомитил строку

        while (!queue.isEmpty()) {
            visitedSquare.add(queue.element());
            Coordinates currentSquare = queue.remove();


            if (!(worldMap.isSquareEmpty(currentSquare)) && worldMap.getEntity(currentSquare).getClass().equals(victim)) {
                resultSquare = currentSquare;
                break;
            }

            List<Coordinates> neighbourSquare = getSquareWithoutProhibited(currentSquare, worldMap);

            for (Coordinates square : neighbourSquare) {
                if (!(visitedSquare.contains(square)) && worldMap.isInsideMapBorder(square)) {
                    parentMap.put(square, currentSquare);
                    queue.add(square);
                    visitedSquare.add(square);

                }
            }
        }
        List<Coordinates> path = new ArrayList<>();

        while (resultSquare != null) {
            path.add(resultSquare);
            resultSquare = parentMap.get(resultSquare);
        }
        Collections.reverse(path);
        return path;
    }

    private static List<Coordinates> getSquareWithoutProhibited(Coordinates current, Map map) {
        List<Coordinates> nodesAround = new ArrayList<>();
        int cordY = current.COORDINATE_Y;
        int cordX = current.COORDINATE_X;

        if (!(cordY - 1 < 0) && isSquareProhibited(cordY - 1, cordX, map))
            nodesAround.add(new Coordinates(cordY - 1, cordX));
        if (!(cordX + 1 > MAP_WIDTH) && isSquareProhibited(cordY, cordX + 1, map))
            nodesAround.add(new Coordinates(cordY, cordX + 1));
        if (!(cordY + 1 > MAP_HEIGHT) && isSquareProhibited(cordY + 1, cordX, map))
            nodesAround.add(new Coordinates(cordY + 1, cordX));
        if (!(cordX - 1 < 0) && isSquareProhibited(cordY, cordX - 1, map))
            nodesAround.add(new Coordinates(cordY, cordX - 1));
        return nodesAround;
    }

    private static boolean isSquareProhibited(int y, int x, Map worldMap) {
        Entity entity = worldMap.getEntity(new Coordinates(y, x));
        if (victim == Herbivore.class) return !(entity instanceof Predator || entity instanceof Rock ||
                entity instanceof Tree);
        return !(entity instanceof Creature || entity instanceof Rock || entity instanceof Tree);
    }

}
