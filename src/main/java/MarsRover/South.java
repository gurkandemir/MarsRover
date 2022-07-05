package MarsRover;

public class South implements Direction{
    @Override
    public Direction right() {
        return new West();
    }

    @Override
    public Direction left() {
        return new East();
    }

    public String toString(){
        return "S";
    }

    public Position forward(Position currentPosition){
        return new Position(
                currentPosition.x(),
                (currentPosition.y() - 1 + BOUNDARY) % BOUNDARY);
    }
}
