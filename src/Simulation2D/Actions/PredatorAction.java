package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Predator;

public class PredatorAction extends InitActions<Predator> {
    public PredatorAction() {
        this.quantityOnMap = 50;
    }

    @Override
    protected Predator spawnEntity(Coordinates coordinates) {
        return new Predator(coordinates, 10);
    }
}
