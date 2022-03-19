import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Collections;

public class Creator {
    // TODO: functionality to assign initial values to Sudoku grid
    int[] num_array = {1,2,3,4,5,6,7,8,9};
    List<Integer> num_list = Arrays.asList(1,2,3,4,5,6,7,8,9);
    int[][] full_grid;
    int[][] blanks_grid;
    int randSelect;
    int recurCount;
    int gridRow;

    Creator() {
        recurCount = 0;
        gridRow = 0;
        full_grid = new int[9][9];
        blanks_grid = new int[9][9];

        rowCreator();
//        wrongCreator();
    }

    int factorial(int number) {
        int result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }

    int genRandomNum(int n) {
        int limit = factorial(n);
        Random gen = new Random();
        return gen.nextInt(limit) + 1;
    }

    void rowCreator() {
        for(int i = 0; i < num_list.size(); i++) {
            recurCount = 0;
            randSelect = genRandomNum(num_list.size());
            gridRow = i;
            permute(num_list, 0);
        }
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

    void permute(List<Integer> arr, int k) {
        for(int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size()-1) {
            recurCount += 1;
            if(recurCount == randSelect) {
//                System.out.println(Arrays.toString(arr.toArray()));
                full_grid[gridRow] = arr.stream().mapToInt(i->i).toArray();
                blanks_grid[gridRow] = full_grid[gridRow];
//                System.out.println( "" + recurCount + " " + Arrays.toString(arr.toArray()));
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
