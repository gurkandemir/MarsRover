package MarsRover;

import static MarsRover.Direction.BOUNDARY;

public final class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public String toString()
    {
        return x % BOUNDARY + ":" + y % BOUNDARY;
    }

    public boolean equals(Position position) {
        return x == position.x && y == position.y;
    }
}
