import java.util.ArrayList;

class King extends Peice {
    boolean check;

    public King(boolean team, boolean state) {
        this.team = team;
        this.state = state;
        check=false;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        ArrayList <Squares> possible= new ArrayList<>();
        Squares enemy;
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                enemy=line(sq,b,possible,i,j,1);
                possible.add(enemy);
            }
        }
        return possible;
    }
}

