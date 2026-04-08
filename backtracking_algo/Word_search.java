package backtracking_algo;

public class Word_search {
    private static boolean findWord(char[][] grid, String word){
        int rows = grid.length;
        int columns = grid[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                if(grid[r][c] == word.charAt(c) && dfs(grid, word, r, c, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, String word, int r, int c, int index){

        if(index == word.length()){
            return true;
        }

        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != word.charAt(index)){
            return false;
        }

        char temp = grid[r][c];
        grid[r][c] = '#';

        boolean isFound = dfs(grid, word, r + 1, c, index + 1)||
        dfs(grid, word, r-1, c, index+1)||
        dfs(grid, word, r, c+1, index+1)||
        dfs(grid, word, r, c+1, index+1);

        grid[r][c] = temp;

        return isFound;
    }

    public static void main(String[] args){
        char[][] grid = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println(findWord(grid, "ABCCFB"));
    }
}
