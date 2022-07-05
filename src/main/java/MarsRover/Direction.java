package MarsRover;

public interface Direction {
    Direction right();
    Direction left();
    String toString();

    Position forward(Position currentPosition);

    static final int BOUNDARY = 10;

}


