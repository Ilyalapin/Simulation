package Simulation2D.Entity;

import Simulation2D.Coordinates;
import Simulation2D.Map;

public class Predator extends Creature {
    private final int ATACK_POWER;

    public Predator(Coordinates coordinates, int atackPower) {
        super(coordinates);
        this.ATACK_POWER = atackPower;
    }

    @Override
    public void eatVictim(Coordinates start, Coordinates to, Map worldMap) {
        Creature herbivore = (Creature) worldMap.getEntity(to);
        if (herbivore.getHealthPoints() - ATACK_POWER <= 0)
            super.eatVictim(start, to, worldMap);
        else herbivore.setHealthPoints(herbivore.getHealthPoints() - ATACK_POWER);
    }

}
