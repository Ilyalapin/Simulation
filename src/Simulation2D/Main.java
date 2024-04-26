package Simulation2D;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int START_SIMULATION = 1;
    private static final int PERFORM_ITERATION = 2;
    private static final int EXIT = 3;
    private static final int PAUSE_SIMULATION = 4;


    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.initWorld();
        while (true) {
            System.out.println("Выберите действие: 1 - Запуск симуляции. 2 - Сделать одну итерацию. 3 - Выйти");
            switch (scanner.nextInt()) {
                case START_SIMULATION:
                    int userInput = START_SIMULATION;
                    while (true) {
                         userInput = simulationControl(userInput);
                        if (userInput == PAUSE_SIMULATION)
                            break;
                        System.out.println(" 4 - Пауза симуляции");
                        simulation.nextTurn();
                    }
                    break;
                case PERFORM_ITERATION:
                    simulation.nextTurn();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
            }
        }

    }

    private static int simulationControl(int current) {
        try {
            Thread.sleep(1000);
            if (System.in.available() > 0) {
                if (scanner.nextInt() == PAUSE_SIMULATION) {
                    System.out.println("1 - Продолжить симуляцию");
                    return PAUSE_SIMULATION;

                }
                return START_SIMULATION;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return current;
    }

}
