import java.util.ArrayList;

public class Pawn extends Peice{
    public Pawn(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        return null;
    }
}

