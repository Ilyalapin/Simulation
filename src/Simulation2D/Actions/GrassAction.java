package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Grass;

public class GrassAction extends InitActions<Grass> {
    public GrassAction() {
        super.quantityOnMap = 100;
    }

    @Override
    protected Grass spawnEntity(Coordinates coordinates) {
        return new Grass(coordinates);
    }
}
