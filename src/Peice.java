abstract class Peice {
    boolean team; //false for black and true for white
    boolean state; // true for alive false for dead
    abstract Squares[]  possiblemovements(Squares sq, Board b); //returns i indexs at 0 and j indexes at 1
    //i is rows and j is columns
    Squares[] horrizontalline(Squares sq, Board b)
    {

        int x=sq.getI();
        int y=sq.getJ();
        int k=0;
        Squares[] possible;
        Squares mark[]= new Squares[2];
        mark[0]=null;
        mark[1]=null;
        for(int m=0;m<8;m++)
        {
            if(m<y && b.square[x][m].p!=null)
            {
                mark[0]=b.square[x][m];
            }
            else if(m>y && b.square[x][m].p!=null)
            {
                mark[1]=b.square[x][m];
                break;
            }
        }
        int n=0;
        int h=8;
        if(mark[0]!=null)
        {
            n=mark[0].getJ()+1;
        }
        if (mark[1]!=null)
        {
            h=mark[1].getJ();
        }
        possible=new Squares[h-n-1];
            for(;n<h;n++) {
                if (n == y) {
                    continue;
                }
                possible[k]=b.square[x][n];
                k++;

            }

        return possible;
    }
    Squares[] verticalline(Squares sq, Board b)
    {
        int x=sq.getI();
        int y=sq.getJ();
        Squares [] possible;
        int k=0;
        Squares mark[]= new Squares[2];
        mark[0]=null;
        mark[1]=null;
        for(int m=0;m<8;m++)
        {
            if(m<x && b.square[m][y].p!=null)
            {
                mark[0]=b.square[m][y];
            }
            else if(m>x && b.square[m][y].p!=null)
            {
                mark[1]=b.square[m][y];
                break;
            }
        }
        int n=0;
        int h=8;
        if(mark[0]!=null)
        {
            n=mark[0].getI()+1;
        }
        if (mark[1]!=null)
        {
            h=mark[1].getI();
        }
        possible=new Squares[h-n-1];
        for(;n<h;n++) {
            if (n == x) {
                continue;
            }
            possible[k]=b.square[n][y];
            k++;
        }
        return possible;
    }
}
