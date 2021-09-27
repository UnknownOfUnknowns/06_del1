package spil;

public class Spiller {
    private int sidste_slag;
    private int point;
    private Terning t1;
    private Terning t2;

    public Spiller(){
        sidste_slag = 0;
        point = 0;
        t1 = new Terning();
        t2 = new Terning();
    }

    public int rul_terning(){
        t1.rul();
        t2.rul();
        int sum = t1.getVærdi() + t2.getVærdi();
        sidste_slag = sum;
        return sum;

    }
    public int getPoint() {
        return point;
    }

    public int getSidste_slag() {
        return sidste_slag;
    }

    public void incrementPoint(int point) {
        this.point += point;
    }
}
