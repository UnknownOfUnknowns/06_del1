package spil;

public class Spil {
    private Spiller s1;
    private Spiller s2;
    private boolean vinder_fundet;
    public Spil(){
        s1 = new Spiller();
        s2 = new Spiller();
        vinder_fundet = false;
    }

    public void start_spil(){
        while(!vinder_fundet){
            tag_tur(s1);
            tag_tur(s2);
        }
    }
    private void tag_tur(Spiller s){
        int sidste_slag = s.getSidste_slag();
        int slag_værdi = s.rul_terning();
        switch (slag_værdi){
            case 2:
                s.setPoint(0);
                break;
            case 12:
                if (s.getPoint() == 40){
                    vinder_fundet = true;
                }else if(sidste_slag == 12){
                    vinder_fundet = true;
                }else{
                    s.incrementPoint(slag_værdi);
                }
                break;
            default:
                s.incrementPoint(slag_værdi);
        }
        if(s.slog_2_ens()) {
            tag_tur(s);
        }
    }

}