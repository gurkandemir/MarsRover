package MarsRover;

public class West implements Direction{
    @Override
    public Direction right() {
        return new North();
    }

    @Override
    public Direction left() {
        return new South();
    }

    public String toString(){
        return "W";
    }

    public Position forward(Position currentPosition){
        return new Position(
                (currentPosition.x() - 1 + BOUNDARY) % BOUNDARY,
                currentPosition.y());
    }
}
