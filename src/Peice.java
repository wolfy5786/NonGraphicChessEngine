import java.util.ArrayList;

abstract class Peice {
    boolean team; //false for black and true for white
    boolean state; // true for alive false for dead
    abstract ArrayList<Squares>  possiblemovements(Squares sq, Board b);
    //i is rows and j is columns
    Squares line(Squares sq, Board b, ArrayList <Squares> possible,int xchange, int ychange)
    {
        int x=sq.getI();
        int y=sq.getJ();
        for(int i=x,j=y;((i<8)&&(j<8));i+=xchange,j+=ychange)
        {
            if(b.square[i][j]==sq)
            {
                continue;
            }
            if(b.square[i][j].p!=null)
            {
                System.out.println(i+" "+j);
                break;
            }
            possible.add(b.square[i][j]);
        }
        for(int i=x,j=y;i>=0&&j>=0;i-=xchange,j-=ychange)
        {
            if(b.square[i][j]==sq)
            {
                continue;
            }
            if(b.square[i][j].p!=null)
            {
                break;
            }
            possible.add(b.square[i][j]);
        }
        return null;
    }
}
