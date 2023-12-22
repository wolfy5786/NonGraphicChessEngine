import java.util.ArrayList;

public class Knight extends Peice {
    public Knight(boolean team, boolean state) {
        this.team=team;
        this.state=state;
}


    @Override
    ArrayList <Squares> possiblemovements(Squares sq, Board b) {
        return null;
    }
}
