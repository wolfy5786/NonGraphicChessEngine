import java.util.ArrayList;

public class Queen extends Peice{
    public Queen(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    ArrayList<Squares> possiblemovements(Squares sq, Board b) {
        ArrayList <Squares> possible = new ArrayList<>();
        Squares enemy;
         for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                if(i==0 &&j==0)
                {
                    continue;
                }
                enemy=super.line(sq,b,possible,i,j);
                add_enemy(enemy,possible);
            }
        }
        return possible;
    }
}
