package MarsRover;

public interface Direction {
    Direction right();
    Direction left();
    String toString();

    Position forward(Position currentPosition);
    int BOUNDARY = 10;

}


