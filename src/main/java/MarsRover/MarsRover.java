package MarsRover;

public class MarsRover {

    public static final char MOVE_LETTER = 'M';
    public static final char LEFT_LETTER = 'L';
    public static final char RIGHT_LETTER = 'R';
    public static final String DELIMITER = ":";
    private Position currentPosition;
    private Direction currentDirection;

    public MarsRover() {
        currentPosition = new Position(0, 0);
        currentDirection = new North();
    }

    public String execute(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case MOVE_LETTER -> move();
                case LEFT_LETTER -> turnLeft();
                case RIGHT_LETTER -> turnRight();
            }
        }

        return currentPosition.toString() + DELIMITER + currentDirection;
    }

    private void turnRight() {
        currentDirection = currentDirection.right();
    }

    private void turnLeft() {
        currentDirection = currentDirection.left();
    }

    private void move() {
        currentPosition = currentDirection.forward(currentPosition);
    }
}
