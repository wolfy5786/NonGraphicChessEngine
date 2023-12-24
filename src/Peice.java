import java.util.ArrayList;

abstract class Peice {
    boolean team; //false for black and true for white
    boolean state; // true for alive false for dead
    abstract ArrayList<Squares>  possiblemovements(Squares sq, Board b);
    //i is rows and j is columns
    Squares line(Squares sq, Board b, ArrayList <Squares> possible,int xchange, int ychange, int step)
    {
        System.out.println("c");
        int x=sq.getI();
        int y=sq.getJ();
        int s=0;
        for(int i=x,j=y;((i<8)&&(j<8)&&(i>=0)&&(j>=0)&&(s<step));i+=xchange,j+=ychange)
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
            s++;
        }
        return null;
    }
    Squares line(Squares sq, Board b, ArrayList <Squares> possible,int xchange, int ychange)
    {
        line(sq,b,possible,xchange,ychange,8);
        return null;
    }
}
