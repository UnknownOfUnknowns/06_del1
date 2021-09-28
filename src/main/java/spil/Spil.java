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

    }

}
