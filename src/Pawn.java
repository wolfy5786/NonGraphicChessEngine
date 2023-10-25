public class Pawn extends Peice{
    public Pawn(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    Squares[] possiblemovements(Squares sq, Board b) {
        return new Squares[0];
    }
}

