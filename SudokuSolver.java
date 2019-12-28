public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 5, 9, 6, 0, 0, 0},
                {7, 0, 0, 3, 0, 0, 0, 0, 0},
                {3, 2, 0, 8, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 3, 0},
                {4, 0, 1, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 6, 0, 0, 0, 8},
                {0, 0, 3, 0, 0, 0, 5, 9, 0},
                {0, 5, 0, 0, 0, 8, 6, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0}};
        print(board);
        System.out.println();
        System.out.println("Solution:-");
        System.out.println();
        solve(board);
    }

    public static boolean solve(int[][] board){

        int[] empty = empty(board);
        int row,col;
        if(empty[0] < 0 && empty[1] < 0){
            print(board);
            return true;
        }else{
             row = empty[0];
             col = empty[1];
        }

        for(int i=1;i<=9;i++){
            if(check(board,i,new int[]{row,col})){
                board[row][col] = i;

                if(solve(board))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean check(int[][] board, int num, int[] pos){
        //checking row, checking num and not the exact pos that we inserted.
        for(int i=0;i<board[0].length;i++){
            if(board[pos[0]][i] == num && pos[1] != i){
                return false;
            }
        }

        //checking coloumn
        for(int i = 0;i < board.length; i++){
            if(board[i][pos[1]] == num && pos[0] != i){
                return false;
            }
        }
        //checking individual squares
        //start pos. of current square.
        int sq_x = pos[1] / 3;
        int sq_y = pos[0] / 3;

        for(int i=sq_y*3;i<sq_y*3 +3;i++){
            for(int j = sq_x*3;j<sq_x*3 +3;j++){
                if( board[i][j] == num && i != pos[0] && j != pos[1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] empty(int[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 0){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }
    
    public static void print(int[][] board){
        for (int i = 0; i <board.length; i++) {
            if(i%3 == 0 && i!=0 ){
                System.out.println("- - - - - - - - - - - -");
            }
            for(int j=0;j<board[0].length;j++){
                if(j%3 == 0 && j!=0){
                    System.out.print(" | ");
                }

                if(j == 8) {
                    System.out.println(board[i][j]);
                }else {
                    System.out.print(board[i][j] + " ");
                }
            }
        }
    }

}
