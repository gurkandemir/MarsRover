package MarsRover;

public class North implements Direction{
    @Override
    public Direction right() {
        return new East();
    }

    @Override
    public Direction left() {
        return new West();
    }

    public String toString(){
        return "N";
    }
    
    public Position forward(Position currentPosition){
        return new Position(
                currentPosition.x(),
                currentPosition.y() + 1 % BOUNDARY);
    }
}
