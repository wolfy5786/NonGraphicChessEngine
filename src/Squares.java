public class Squares {
    int i;
    int j;
    boolean sq;
    Peice p;
    Squares(int i, int j)
    {
        this.i=i;
        this.j=j;
        sq=((i+j)%2==0)? true:false;
        p=null;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isSq() {
        return sq;
    }

    public Peice getP() {
        return p;
    }

    public void setP(Peice p) {
        this.p = p;
    }
}
