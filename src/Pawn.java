import java.util.ArrayList;

public class Pawn extends Peice{
    public Pawn(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        ArrayList <Squares> possible= new ArrayList<>();
        if(sq.p.team) {
            if((sq.getI()==1)) {
                line(sq, b, possible, 1, 0, 2);
            }
            else {
                line(sq, b, possible, 1, 0, 1);
            }
        }else
        {
            if(sq.getI()==6) {
                line(sq, b, possible, -1, 0, 2);
            }
            else{
                line(sq, b, possible, -1, 0, 1);
            }
        }
        return possible;
    }
}

