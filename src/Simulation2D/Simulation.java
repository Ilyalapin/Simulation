package Simulation2D;

import Simulation2D.Actions.*;
import Simulation2D.Entity.Grass;
import Simulation2D.Entity.Herbivore;
import Simulation2D.Entity.Predator;

import java.util.ArrayList;
import java.util.List;


public class Simulation {
    private int countIteration;
    private final Map worldMap = new Map();
    private final MapConsolRenderer renderer = new MapConsolRenderer();
    TurnActions turnActions = new TurnActions();

    protected void nextTurn() {

        turnActions.makeMoveWithAllCreatures(worldMap);
        renderer.MapConsoleRenderer(worldMap);
        addGrassIfNecessary(worldMap);
        checkForLivingCreatures(worldMap);
        countIteration++;
        System.out.println("Количество итераций: " + countIteration);
    }

    protected void initWorld() {
        for (InitActions<?> spawnAction : getInitActions())
            spawnAction.getRandomEntity(worldMap);
        System.out.println("Сгенерированная карта");
        renderer.MapConsoleRenderer(worldMap);
    }

    private List<InitActions<?>> getInitActions() {
        List<InitActions<?>> initActions = new ArrayList<>();
        initActions.add(new GrassAction());
        initActions.add(new HerbivoreAction());
        initActions.add(new PredatorAction());
        initActions.add(new RockAction());
        initActions.add(new TreeAction());
        return initActions;
    }

    public void addGrassIfNecessary(Map worldMap) {

        while (worldMap.getEntitiesOfType(Grass.class).size() < 70) {
            Coordinates coordinates = worldMap.getEmptySquareRandom();
            worldMap.setEntity(coordinates, new Grass(coordinates));
        }
    }

    private void checkForLivingCreatures(Map worldMap) {
        if (worldMap.getEntitiesOfType(Herbivore.class).isEmpty()) {
            System.out.println("Живых овец не осталось. Проклятые волки всех пожрали.");
            System.exit(0);
        }
        if (worldMap.getEntitiesOfType(Predator.class).isEmpty()) {
            System.out.println("Живых волков не осталось. Овцы выжили.");
            System.exit(0);
        }
    }
}
