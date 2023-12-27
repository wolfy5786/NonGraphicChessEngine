import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    Board b; //a5 to d6
    Squares wking;
    Squares bking;
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
                        b.square[i][j].p = new Knight(true, true);
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
                    b.square[i][j].p = new Pawn(true, true);
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
        wking=b.square[0][4];
        bking=b.square[7][4];
        create();
    }
    void moveapiece(Squares sq)
    {
        Scanner sc= new Scanner(System.in);
        ArrayList <Squares> possiblity=sq.p.possiblemovements(sq,b);// calculates possible squares for that peice
        illegalmoves(sq,possiblity);
        for(int s=0;s< possiblity.size();s++)
        {
            System.out.println(possiblity.get(s).getI()+" "+possiblity.get(s).getJ());
        }
        System.out.println("enter x and y coordinate");
        int x=sc.nextInt();
        int y=sc.nextInt();
        if(validinput(x,y,possiblity))
        {
            b.square[x][y].p=sq.p;
            if(sq.p instanceof King)
            {
                trackkings(b.square[x][y],sq.p);
            }
            sq.p=null;
        }
        else {
            System.out.println("invalid");
        }
    }
    void create()
    {
        printboard();
    }
    void render()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter peice co-ordinates");
        int x=sc.nextInt();
        int y =sc.nextInt();
        if(b.square[x][y].p!=null)
        {
            moveapiece(b.square[x][y]);
        }
        else {
            System.out.println("wrong square");
        }
        printboard();
    }
    void printboard()
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(b.square[i][j].p!=null) {

                    System.out.print(" p ");
                }
                else
                {
                    System.out.print(i+""+j+" ");
                }
            }
            System.out.println();
        }
    }
    void trackkings(Squares newsquare, Peice k) //track position of kings for checks
    {
        if(k.team)
        {
            wking=newsquare;
        }
        else {
            bking=newsquare;
        }
    }
    boolean validinput(int x, int y, ArrayList <Squares> possible)
    {
        for (int i=0;i<possible.size();i++)
        {
            if(possible.get(i).getI()==x && possible.get(i).getJ()==y)
            {
                return true;
            }
        }
        return false;
    }
    boolean check(Squares sq, King k) //return true if check
    {
        Knight kn=new Knight(k.team,k.state);
        Rook r = new Rook(k.team,k.state);
        Bishop bp= new Bishop(k.team,k.state);
        Pawn p=new Pawn(k.team,k.state);
        boolean is_check=false;
        if(threat(kn.possiblemovements(sq, b),k.team,kn))
        {
            is_check=true;
        }
        else if(threat(p.possiblemovements(sq,b),k.team,p))
        {
            is_check=true;
        }
        else if(threat(bp.possiblemovements(sq,b),k.team,bp))
        {
            is_check=true;
        }
        else if(threat(r.possiblemovements(sq,b),k.team,r))
        {
            is_check=true;
        }
        return is_check;
    }
    //input:standing square, list of possible squares
    void illegalmoves(Squares sq, ArrayList <Squares> possible)// removes illegal moves from possible
    {
        Peice buffer;
        Peice current;
        for(int i=0;i<possible.size();i++)
        {
            current=sq.p;
            buffer=possible.get(i).p;
            possible.get(i).p=sq.p;
            sq.p=null;
            if(current.team)
            {
                if(check(wking,(King) wking.p))
                {
                    sq.p=possible.get(i).p;
                    possible.get(i).p=buffer;
                    possible.remove(i);
                    i--;
                }
                else {
                    sq.p=possible.get(i).p;
                    possible.get(i).p=buffer;
                }
            }
            else
            {
                if(check(bking,(King) bking.p))
                {
                    sq.p=possible.get(i).p;
                    possible.get(i).p=buffer;
                    possible.remove(i);
                    i--;
                }
                else {
                    sq.p=possible.get(i).p;
                    possible.get(i).p=buffer;
                }
            }
        }
    }
    boolean threat(ArrayList <Squares> t, boolean team, Peice peice) //return true if enemy peice on path for check
    {
        for(int i=0;i<t.size();i++)
        {
            if(t.get(i).p!=null) {
                if ((t.get(i).p.team ^ team)) {
                    if((peice instanceof Rook) && ((t.get(i).p instanceof Rook)||(t.get(i).p instanceof Queen)))
                    {
                        return true;
                    }
                    else if((peice instanceof Bishop) && ((t.get(i).p instanceof Bishop)||(t.get(i).p instanceof Queen)))
                    {
                        return true;
                    }
                    else if((peice instanceof Knight) && (t.get(i).p instanceof Knight))
                    {
                        return true;
                    }
                    else if((peice instanceof Pawn) && (t.get(i).p instanceof Pawn))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
