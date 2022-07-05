package MarsRover;

public class East implements Direction{
    @Override
    public Direction right() {
        return new South();
    }

    @Override
    public Direction left() {
        return new North();
    }

    public String toString(){
        return "E";
    }

    public Position forward(Position currentPosition){
        return new Position(
                currentPosition.x() + 1 % BOUNDARY,
                currentPosition.y());
    }
}
