package Simulation2D;

import Simulation2D.Entity.Entity;

import java.util.*;

public class Map {
    public static final int MAP_HEIGHT = 10; // Y
    public static final int MAP_WIDTH = 40; // X
    static HashMap<Coordinates, Entity> worldMap = new HashMap<>();
    Random random = new Random();

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !worldMap.containsKey(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        worldMap.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return worldMap.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        worldMap.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);
        worldMap.remove(from);
        setEntity(to, entity);
    }

    public Coordinates getEmptySquareRandom() {        //для добавления травы
        while (true) {
            Coordinates coordinates = new Coordinates(
                    random.nextInt(10),
                    random.nextInt(40));
            if (isSquareEmpty(coordinates) && isInsideMapBorder(coordinates)) return coordinates;
        }
    }

    public boolean isInsideMapBorder(Coordinates coordinates) {
        return coordinates.COORDINATE_X < Map.MAP_WIDTH && coordinates.COORDINATE_Y < Map.MAP_HEIGHT;
    }

    public <T> HashMap<Coordinates, T> getEntitiesOfType(Class<T> typeEntity) {
        HashMap<Coordinates, T> result = new HashMap<>();
        for (java.util.Map.Entry<Coordinates, Entity> entry : worldMap.entrySet()) {
            if (typeEntity.isInstance(entry.getValue())) {
                //noinspection unchecked
                result.put(entry.getKey(), (T) entry.getValue());
            }
        }
        return result;
    }

}