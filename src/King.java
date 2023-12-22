import java.util.ArrayList;

class King extends Peice {

    public King(boolean team, boolean state) {
        this.team = team;
        this.state = state;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        return null;
    }
}

