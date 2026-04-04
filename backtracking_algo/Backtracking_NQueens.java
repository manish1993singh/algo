package backtracking_algo;
// Question 1: N-Queens Problem
// Place N queens on an N x N chessboard so that no two queens threaten each other.
// Sample Input:
// N = 4
// Sample Output:
// [[.Q.., ..Q., Q..., ...Q], [...Q, Q..., ..Q., .Q..]]
// Limitations:
// - N >= 1
// - Board is square
// - No two queens can be in the same row, column, or diagonal
//
// Pseudocode:
// 1. Start with an empty board.
// 2. Try placing a queen in each row, one by one.
// 3. For each row, try all columns.
// 4. If placing a queen is safe, move to the next row.
// 5. If all queens are placed, add solution.
// 6. If not possible, backtrack and try next position.
//
// Guidance:
// - Use recursion for row placement.
// - Use arrays/sets to track columns and diagonals.
// - Backtrack when a placement leads to a conflict.
public class Backtracking_NQueens {
    // Implement here
}
