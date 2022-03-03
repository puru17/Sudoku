import java.util.Arrays;
import java.util.Random;

public class Creator {
    // TODO: functionality to assign initial values Sudoku grid
    int[] num_array = {1,2,3,4,5,6,7,8,9};
    int[][] full_grid;
    int[][] blanks_grid;
    Creator() {
        full_grid = new int[9][9];
        blanks_grid = new int[9][9];
        wrongCreator();
    }

    void rowCreator() {

    }

    void wrongCreator() {
        Random gen = new Random();
        for(int i = 0; i < full_grid[0].length; i++) {
            for(int j = 0; j < full_grid[i].length; j++) {
                full_grid[i][j] = num_array[gen.nextInt(num_array.length)]; //assign random digits for now
                blanks_grid[i][j] = full_grid[i][j];
                if(gen.nextInt(2) == 0) blanks_grid[i][j] = 0; //flips a coin to make grid item blank or not
            }
        }
    }

    public int[][] getFull_grid() {
        return full_grid;
    }

    public int[][] getBlanks_grid() {
        return blanks_grid;
    }


}
