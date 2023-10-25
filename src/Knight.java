public class Knight extends Peice {
    public Knight(boolean team, boolean state) {
        this.team=team;
        this.state=state;
}


    @Override
    Squares[] possiblemovements(Squares sq, Board b) {
        return new Squares[0];
    }
}
