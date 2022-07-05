package MarsRover;

import java.util.Collections;
import java.util.List;

public class MarsRover {

    public static final char MOVE_LETTER = 'M';
    public static final char LEFT_LETTER = 'L';
    public static final char RIGHT_LETTER = 'R';
    public static final String OBSTACLE_LETTER = "O";
    public static final String DELIMITER = ":";
    private Position currentPosition;
    private Direction currentDirection;
    private List<Position> obstacles = Collections.emptyList();

    public MarsRover() {
        currentPosition = new Position(0, 0);
        currentDirection = new North();
    }

    public MarsRover(List<Position> obstacles) {
        this();
        this.obstacles = obstacles;
    }

    public String execute(String commands) {
        String prefix = "";
        for (char command : commands.toCharArray()) {
            try {
                tryToExecute(command);
            } catch (Exception e) {
                prefix = OBSTACLE_LETTER + DELIMITER;
                break;
            }
        }

        return prefix + currentPosition.toString() + DELIMITER + currentDirection;
    }

    private void tryToExecute(char command) {
        switch (command) {
            case MOVE_LETTER -> move();
            case LEFT_LETTER -> turnLeft();
            case RIGHT_LETTER -> turnRight();
        }
    }

    private void turnRight() {
        currentDirection = currentDirection.right();
    }

    private void turnLeft() {
        currentDirection = currentDirection.left();
    }

    private void move() {
        Position possiblePosition = currentDirection.forward(currentPosition);

        for (Position obstacle : obstacles) {
            if (obstacle.equals(possiblePosition)) {
                throw new ObstacleException();
            }
        }

        currentPosition = possiblePosition;
    }
}
