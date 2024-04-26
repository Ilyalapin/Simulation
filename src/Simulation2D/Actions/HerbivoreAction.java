package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Herbivore;

public class HerbivoreAction extends InitActions<Herbivore> {
    public HerbivoreAction() {
        this.quantityOnMap = 30;
    }

    @Override
    protected Herbivore spawnEntity(Coordinates coordinates) {
        return new Herbivore(coordinates);
    }
}
