package Simulation2D.Entity;

import Simulation2D.Coordinates;

public abstract class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
