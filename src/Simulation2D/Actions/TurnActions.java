package Simulation2D.Actions;

import Simulation2D.Coordinates;
import Simulation2D.Map;
import Simulation2D.Entity.Creature;

public class TurnActions {
    public void makeMoveWithAllCreatures(Map worldMap) {
        for (java.util.Map.Entry<Coordinates, Creature> entry : worldMap.getEntitiesOfType(Creature.class).entrySet()) {
            Creature creature = entry.getValue();
            creature.makeMove(entry.getKey(), worldMap);
        }
    }
}




