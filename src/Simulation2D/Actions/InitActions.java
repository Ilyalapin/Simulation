package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Entity;
import Simulation2D.Map;

import java.util.Random;

public class InitActions<T extends Entity> extends Action {
    Random random = new Random();
    protected int quantityOnMap;

    public void getRandomEntity(Map worldMap) {
        int currentRate = 0;
        while (currentRate != quantityOnMap) {
            Coordinates coordinates = new Coordinates(
                    random.nextInt(Map.MAP_HEIGHT),
                    random.nextInt(Map.MAP_WIDTH));
            if (worldMap.isSquareEmpty(coordinates) && worldMap.isInsideMapBorder(coordinates)) {                                //
                worldMap.setEntity(coordinates, spawnEntity(coordinates));
                currentRate++;
            }
        }
    }

    protected T spawnEntity(Coordinates coordinates) {
        return null;
    }

}

