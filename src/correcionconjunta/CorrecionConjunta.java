
package correcionconjunta;


public class CorrecionConjunta {

      private int x;
    private int y;

    public CorrecionConjunta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getEjeX() {
        return x;
    }

    public void setEjeX(int x) {
        this.x = x;
    }

    public int getEjeY() {
        return y;
    }

    public void setEjeY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + this.x+","+this.y+")";
    }
}
