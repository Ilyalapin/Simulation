package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Rock;

public class RockAction extends InitActions<Rock> {
    public RockAction() {
        this.quantityOnMap = 25;
    }

    @Override
    protected Rock spawnEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }
}
