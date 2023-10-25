public class Rook extends Peice{
    public Rook(boolean team, boolean state) {
        this.team=team;
        this.state=state;
    }


    @Override
    Squares[] possiblemovements(Squares sq, Board b) {
        Squares possibleh[];
        Squares possiblev[];
        possibleh=super.horrizontalline(sq,b);
        possiblev=super.verticalline(sq, b);
         Squares possible[]= new Squares[possibleh.length+ possiblev.length];
         int j=0;
        for (int i=0; i< possibleh.length;i++)
        {
            possible[i]=possibleh[i];
            j++;
        }
        for (int i=0;i< possiblev.length;i++)
        {
            possible[j]=possiblev[i];
            j++;
        }


        return possible;
    }
}
