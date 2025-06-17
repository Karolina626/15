public class Board {
    private final char[][] board;
    private final boolean[][] occupied;
    private final int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        occupied = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';
    }

    public boolean placeMark(int row, int col, char player) {
        if (occupied[row][col]) return false;
        board[row][col] = player;
        occupied[row][col] = true;
        return true;
    }

    public boolean isFull() {
        for (boolean[] row : occupied)
            for (boolean cell : row)
                if (!cell) return false;
        return true;
    }

    public boolean checkWin(char player) {
        int toWin = 3;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - toWin; j++) {
                if (checkLine(player, i, j, 0, 1) || checkLine(player, j, i, 1, 0)) return true;
            }
        }
        for (int i = 0; i <= size - toWin; i++) {
            for (int j = 0; j <= size - toWin; j++) {
                if (checkLine(player, i, j, 1, 1) || checkLine(player, i, j + 2, 1, -1)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(char player, int startRow, int startCol, int dRow, int dCol) {
        for (int k = 0; k < 3; k++) {
            int r = startRow + k * dRow;
            int c = startCol + k * dCol;
            if (r < 0 || r >= size || c < 0 || c >= size || board[r][c] != player)
                return false;
        }
        return true;
    }

    public void print() {
        System.out.print("    ");
        for (int j = 1; j <= size; j++) System.out.print(" " + j + " ");
        System.out.println();

        System.out.print("  ");
        for (int j = 0; j < size; j++) System.out.print("----");
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < size; j++) System.out.print(" " + board[i][j] + " |");
            System.out.println();

            if (i < size - 1) {
                System.out.print("  ");
                for (int j = 0; j < size; j++) System.out.print("----");
                System.out.println();
            }
        }

        System.out.print("  ");
        for (int j = 0; j < size; j++) System.out.print("----");
        System.out.println();
    }
}