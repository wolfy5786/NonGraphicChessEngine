import java.util.ArrayList;

public class Knight extends Peice {
    public Knight(boolean team, boolean state) {
        this.team=team;
        this.state=state;
}


    @Override
    ArrayList <Squares> possiblemovements(Squares sq, Board b) {
        ArrayList <Squares> possible =new ArrayList<>();
        for(int i=-2;i<=2;i++)
        {
            System.out.println("called");
            if(i==0)
            {
                continue;
            }
            for(int j=-2;j<2;j++)
            {
                if (j==0)
                {
                    continue;
                }
                if(Math.abs(i)==Math.abs(j))
                {
                    continue;
                }
                line(sq,b,possible,i,j,1);
            }
        }


        return possible;
    }
}
