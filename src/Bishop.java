public class Bishop extends Peice{
    public Bishop(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }

    @Override
    Squares[] possiblemovements(Squares sq, Board b) {
        return new Squares[0];
    }
}
