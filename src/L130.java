import java.util.Arrays;

public class L130 {
    /**
     * 130. Surrounded Regions https://leetcode.com/problems/surrounded-regions/
     *
     * @timeComplexity O(m * n)
     * @spaceComplexity O(m * n)
     */
    static class Solution {
        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) {
                return;
            }
            char[][] auxBoard = new char[board.length][board[0].length];
            // Find o on top border and bottom border
            for (int i = 0; i < board[0].length; i++) {
                flood(auxBoard, 0, i, board);
                flood(auxBoard, board.length - 1, i, board);
            }
            // Find o on left and right border
            for (int i = 0; i < board.length; i++) {
                flood(auxBoard, i, 0, board);
                flood(auxBoard, i, board[0].length - 1, board);
            }
            // Fill all non Os on auxBoard, fill board with X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (auxBoard[i][j] != 'O')
                        board[i][j] = 'X';
                }
            }
        }

        private void flood(char[][] auxBoard, int i, int j, char[][] board) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O' || auxBoard[i][j] == 'O') {
                return;
            }
            auxBoard[i][j] = 'O';
            flood(auxBoard, i - 1, j, board);   // Flood left
            flood(auxBoard, i + 1, j, board);   // Flood right
            flood(auxBoard, i, j - 1, board);   // Flood top
            flood(auxBoard, i, j + 1, board);   // Flood bottom
        }
    }
}
