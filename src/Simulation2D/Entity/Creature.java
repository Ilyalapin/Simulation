package Simulation2D.Entity;

import Simulation2D.Coordinates;
import Simulation2D.SearchAlgorithm;
import Simulation2D.Map;

import java.util.*;

public abstract class Creature extends Entity {
    protected final Class<? extends Entity> Victim;
    protected final int SPEED_MOVE;
    protected final int MAX_HEALTH_POINTS;
    protected int healthPoints;

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return SPEED_MOVE == creature.SPEED_MOVE && MAX_HEALTH_POINTS == creature.MAX_HEALTH_POINTS &&
                healthPoints == creature.healthPoints && Objects.equals(Victim, creature.Victim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Victim, SPEED_MOVE, MAX_HEALTH_POINTS, healthPoints);
    }

    public Creature(Coordinates coordinates) {
        super(coordinates);
        Class<? extends Creature> creatureClass = this.getClass();
        if (creatureClass.equals(Predator.class)) {
            Victim = Herbivore.class;
            SPEED_MOVE = 1;
            healthPoints = 20;
        } else {
            Victim = Grass.class;
            SPEED_MOVE = 2;
            healthPoints = 20;
        }
        MAX_HEALTH_POINTS = healthPoints;
    }

    public void eatVictim(Coordinates start, Coordinates to, Map worldMap) {
        worldMap.moveEntity(start, to);
        healthPoints += 10;
        if (MAX_HEALTH_POINTS < healthPoints) {
            healthPoints = MAX_HEALTH_POINTS;
        }
    }

    public void makeMove(Coordinates start, Map worldMap) {
        if (healthPoints > 0) {
            List<Coordinates> path = SearchAlgorithm.getShortestPath(start, worldMap, Victim);
            if (path.size() > 1) {
                int amountOfSpeed = Math.min(SPEED_MOVE, path.size() - 1);
                Coordinates to = path.get(amountOfSpeed);
                if (to == null || this.getClass().isInstance(worldMap.getEntity(to))) return;
                if (Victim.isInstance(worldMap.getEntity(to))) {
                    eatVictim(start, to, worldMap);
                    return;
                }
                worldMap.moveEntity(start, to);
            }
            healthPoints--;
        } else {
            worldMap.removeEntity(start);
        }
    }
}



