package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Entity.Tree;

public class TreeAction extends InitActions<Tree> {
    public TreeAction() {
        this.quantityOnMap = 25;
    }

    @Override
    protected Tree spawnEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }
}
