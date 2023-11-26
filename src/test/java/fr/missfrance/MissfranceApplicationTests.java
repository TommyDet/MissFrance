package fr.missfrance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MissfranceApplicationTests {

    public static int computeClosestToZero(int[] ts) {
        if (ts.length == 0) {
            return 0;
        }
        Map<Integer, Integer> temperaturesMinimales = new HashMap<>();
        int tempMinActuelle = Math.abs(ts[0]);
        temperaturesMinimales.put(tempMinActuelle, ts[0]);

        for (Integer temperature : ts) {
            int tempAbs = Math.abs(temperature);
            if (tempAbs == tempMinActuelle) {
                temperaturesMinimales.put(tempAbs, temperature);
            }
            if (tempAbs < tempMinActuelle) {
                temperaturesMinimales.clear();
                temperaturesMinimales.put(tempAbs, temperature);
            }
        }

        for (int valeur : temperaturesMinimales.values()) {
            if (valeur > 0) {
                return valeur;
            }
        }


        return 0;
    }


    @Test
    /* Ignore and do not change the code below */
    public void main() {
        int[] ts = {-15, -7, -9, -14, -12};
        int solution = computeClosestToZero(ts);
        System.out.println(solution);
    }
    /* Ignore and do not change the code above */
}

