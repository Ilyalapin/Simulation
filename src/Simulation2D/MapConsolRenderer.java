package Simulation2D;

import Simulation2D.Entity.Entity;
import Simulation2D.Entity.Herbivore;
import Simulation2D.Entity.Predator;
import Simulation2D.Entity.Grass;
import Simulation2D.Entity.Rock;
import Simulation2D.Entity.Tree;

public class MapConsolRenderer {
    public final String PREDATOR = "\uD83D\uDC3A ";
    public final String HERBIVORE = "\uD83D\uDC11 ";
    public final String TREE = "\uD83C\uDF33 ";
    public final String ROCK = "\uD83C\uDFD4\uFE0F ";
    public final String GRASS = "\uD83C\uDF40 ";
    public final String BORDER_MAP = "\uD83D\uDEA7" + " ";
    public final String EMPTY_CELL = "\uD83D\uDD38 ";

    public void BorderMapConsolRenderer() {
        for (int i = 0; i < 40; i++) {
            System.out.print(BORDER_MAP);
        }
    }

    public void MapConsoleRenderer(Map map) {
        BorderMapConsolRenderer();
        System.out.println();

        for (int coordinateY = 0; coordinateY < Map.MAP_HEIGHT; coordinateY++) {
            StringBuilder line = new StringBuilder();

            for (int coordinateX = 0; coordinateX < Map.MAP_WIDTH; coordinateX++) {
                Coordinates coordinates = new Coordinates(coordinateY, coordinateX);

                Entity entity = map.getEntity(coordinates);
                if (map.isSquareEmpty(coordinates)) {
                    line.append(EMPTY_CELL);
                } else if (entity instanceof Herbivore) {
                    line.append(HERBIVORE);
                } else if (entity instanceof Predator) {
                    line.append(PREDATOR);
                } else if (entity instanceof Tree) {
                    line.append(TREE);
                } else if (entity instanceof Rock) {
                    line.append(ROCK);
                } else if (entity instanceof Grass) {
                    line.append(GRASS);
                }

            }
            System.out.println(line);
        }
        BorderMapConsolRenderer();
        System.out.println();
    }
}















