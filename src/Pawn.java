import java.util.ArrayList;

public class Pawn extends Peice{
    public Pawn(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        ArrayList <Squares> possible= new ArrayList<>();
        ArrayList <Squares> check = new ArrayList<>();
        Squares ld,rd;
        if(sq.p.team) {
            if((sq.getI()==1)) {
                line(sq, b, possible, 1, 0, 2);
            }
            else {
                line(sq, b, possible, 1, 0, 1);
            }
            ld=line(sq,b,check,1,-1,1);
            rd=line(sq,b,check,1,1,1);
            if(ld!=null)
            {
                possible.add(ld);
            }
            if(rd!=null)
            {
                possible.add(rd);
            }
        }else
        {
            if(sq.getI()==6) {
                line(sq, b, possible, -1, 0, 2);
            }
            else{
                line(sq, b, possible, -1, 0, 1);
            }
            ld=line(sq,b,check,-1,-1,1);
            rd=line(sq,b,check,-1,1,1);
            if(ld!=null)
            {
                possible.add(ld);
            }
            if(rd!=null)
            {
                possible.add(rd);
            }
        }
        return possible;
    }
}

