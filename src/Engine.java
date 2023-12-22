import java.util.ArrayList;

public class Engine {
    Board b; //a5 to d6
    void initialise() {
        b=new Board();
        for(int i=0;i<=7;i++) //i is rows and j is columns
        {
            for(int j=0; j<=7; j++)
            {
                if(i==0)
                {
                    if(j==0 || j==7) //white is defined at 0 and 1 black at 6 & 7
                    {
                        b.square[i][j].setP(new Rook(true, true));
                    }
                    else if (j==1 || j==6)
                    {
                        //b.square[i][j].p = new Knight(true, true);
                    }
                    else if (j==2 || j==5)
                    {
                        b.square[i][j].p = new Bishop(true, true);
                    }
                    else if (j==3)
                    {
                        b.square[i][j].p = new Queen(true, true);
                    }
                    else if (j==4)
                    {
                        b.square[i][j].p = new King(true, true);
                    }
                }
                else if(i==1)
                {
                    //b.square[i][j].p = new Pawn(true, true);
                }
                if(i==7)
                {
                    if(j==0 || j==7)
                    {
                        b.square[i][j].p = new Rook(false, true);
                    }
                    else if (j==1 || j==6)
                    {
                        b.square[i][j].p = new Knight(false, true);
                    }
                    else if (j==2 || j==5)
                    {
                        b.square[i][j].p = new Bishop(false, true);
                    }
                    else if (j==3)
                    {
                        b.square[i][j].p = new Queen(false, true);
                    }
                    else if (j==4)
                    {
                        b.square[i][j].p = new King(false, true);
                    }
                }
                else if(i==6)
                {
                    b.square[i][j].p = new Pawn(false, true);
                }

            }
        }


    }
    void moveapiece()
    {
        System.out.println("enter a peice");
        ArrayList <Squares> possiblity=b.square[0][0].p.possiblemovements(b.square[0][0],b);
        for(int s=0;s< possiblity.size();s++)
        {
            System.out.println(possiblity.get(s).getJ());
        }
    }

}
