package test;

import org.junit.jupiter.api.Test;
import spil.Terning;

import static org.junit.Assert.assertTrue;

public class TerningTest {
    final int TEST_GANGE = 1000;
    @Test
    void distribution(){
        int[] værdier = new int[]{0,0,0,0,0,0}; //Array til at holde antal af forekomster af slag
        Terning test_terning = new Terning();

        for(int i = 0; i < TEST_GANGE; i++){
            test_terning.rul();
            værdier[test_terning.getVærdi()-1] +=1;
        }
        //Ligger forekomsterne indenfor +/- 10% af den teoretiske værdi
        for(int værdi : værdier){
            assertTrue(værdi > (double) (TEST_GANGE/6)*0.9 && værdi < (double)(TEST_GANGE/6)*1.1);
        }

    }

    //Ligger alle slagene indenfor intervallet [1:6]
    @Test
    void interval(){
        Terning test_terning = new Terning();
        for(int i = 0; i < TEST_GANGE; i++){
            test_terning.rul();
            assertTrue( test_terning.getVærdi()>= 1 && test_terning.getVærdi()<= 6);
        }
    }
}
