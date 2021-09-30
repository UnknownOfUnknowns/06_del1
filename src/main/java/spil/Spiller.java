package spil;

public class Spiller {
    private int sidste_slag;
    private int point;
    private Terning t1;
    private Terning t2;
    private boolean slog_2_ens;

    public Spiller(){
        sidste_slag = 0;
        point = 0;
        t1 = new Terning();
        t2 = new Terning();
        slog_2_ens = false;
    }

    public int rul_terning(){
        t1.rul();
        t2.rul();
        int sum = t1.getVærdi() + t2.getVærdi();
        sidste_slag = sum;
        slog_2_ens = t1.getVærdi() == t2.getVærdi();
        return sum;
    }
    public int getPoint() {
        return point;
    }

    public int getSidste_slag() {
        return sidste_slag;
    }
    private int[] getTerningØjne(){
        return new int[]{t1.getVærdi(), t2.getVærdi()};
    }

    public int[] getStatus(){
        int[] øjne = getTerningØjne();
        return new int[]{øjne[0], øjne[1], getPoint()};
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean slog_2_ens() {
        return slog_2_ens;
    }

    public void incrementPoint(int p) {
        this.point += p;
        if(point>40){point=40;}
    }
}
