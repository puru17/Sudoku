import java.util.Scanner;

public class Sudoku {
//    static int[][] grid;
//    static boolean blur;

    static void printGrid(int[][] grid, boolean blur) {
        int spacer = 0;
        int spacer2 = 0;
        for (int[] row: grid) {
            spacer2++;
            for(int item: row) {
                if(spacer % 3 == 0) System.out.print("\t");
                if(item <= 0 && blur) System.out.print("░\t");
                else System.out.print(item +"\t");
                spacer++;
            }
            System.out.println("");
            if(spacer2 % 3 == 0) System.out.println("");
        }
    }

    static boolean getInput(int[][] grid) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a position and number [x,y,n], 'q' to quit:");
        String[] input = myObj.nextLine().split(",");
        if(input[0].equalsIgnoreCase("q")) {
            System.out.println("Bye!");
            return false;
        }

        // TODO: check user input validity
        grid[Integer.valueOf(input[0])-1][Integer.valueOf(input[1])-1] = Integer.valueOf(input[2]);
        return true;
    }

    public static void main(String[] args) {
        System.out.println("\n\tSudoku v-0.1");

//        grid = new int[9][9];
//        blur = false;
        Creator creator = new Creator();

        printGrid(creator.getFull_grid(), true);
        printGrid(creator.getBlanks_grid(), true);
//        boolean keep_looping = true;
//        while(keep_looping){
//            printGrid(creator.getBlanks_grid(), true);
//            keep_looping = getInput(creator.blanks_grid);
//        }

    }
}
