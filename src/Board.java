public class Board {
    Squares square[][];

    public Board() {
        square=new Squares[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                square[i][j]=new Squares(i,j);
            }
        }
    }
}
