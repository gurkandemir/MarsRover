import MarsRover.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({
            "0:1:N,M",
            "0:2:N,MM",
            "0:9:S,RRM",
            "0:0:W,L",
            "0:0:S,LL",
            "0:0:E,LLL",
            "0:0:E,R",
            "2:3:N,MMRMMLM",
            "0:0:N,MMMMMMMMMM"
    })
    public void rotate(String endPosition, String commands)
    {
        MarsRover rover = new MarsRover();

        assertEquals(endPosition, rover.execute(commands));
    }

    @ParameterizedTest
    @CsvSource({
            "O:0:2:N,MMMM"
    })
    public void obstacle(String endPosition, String commands)
    {
        List<Position> obstacles = List.of(new Position(0, 3));
        MarsRover rover = new MarsRover(obstacles);

        assertEquals(endPosition, rover.execute(commands));
    }
}