package spil;

public class Terning {
    private int værdi;

    public Terning(){
        værdi = 1;
    }
    public void rul(){
        værdi = (int) (Math.random()*6)+1;
    }

    public int getVærdi() {
        return værdi;
    }
}
