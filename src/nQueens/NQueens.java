package nQueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<Integer>> tablero;
    private static int SIZE = 8;
    public NQueens(List<List<Integer>> tablero) {
        this.tablero = new ArrayList<List<Integer>>(SIZE);
    }

    private boolean validSite(int[] pos) {
        for (int i = 0; i < tablero.size(); i++) {
//            tablero.get(pos[i]).get(pos[1])
        }
        return false;
    }

}
