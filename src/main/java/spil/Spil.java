package spil;

public class Spil {
    private Spiller s1;
    private Spiller s2;
    private Spiller vinder;
    private Spiller tur_spiller; //Spiller der har sin tur

    public Spil(Spiller spiller1, Spiller spiller2){
        s1 = spiller1;
        s2 = spiller2;
        vinder = null;
        tur_spiller = s1;
    }

    public Spiller vinder(){
        return vinder;
    }

    public void tag_tur(Spiller s) throws Exception {
        if (!(s == tur_spiller)) {
            throw new Exception("Spiller udenfor tur");
        }
        int sidste_slag = s.getSidste_slag(); //Gem sidste slag
        int slag_værdi = s.rul_terning();
        //Tjek først for specielle cases i resultatet af slag
        switch (slag_værdi) {
            case 2:
                s.setPoint(0);
                break;
            case 12:
                if (s.getPoint() == 40) { //Reglen om at man vinder ved at slå 2 seksere når man har 40 point
                    vinder = s;
                } else if (sidste_slag == 12) { //Reglen om at man har vundet hvis man slår 2 seksere to gange i streg
                    vinder = s;
                } else {
                    s.incrementPoint(slag_værdi); //Hvis andet ikke sker så bare giv point
                }
                break;
            default:
                s.incrementPoint(slag_værdi);
        }
        if (!s.slog_2_ens()) {  //skift tur til anden spiller hvis aktuelle spiller ikke har slået to ens
            tur_spiller = (s == s1) ? s2 : s1;

        }
    }
}
