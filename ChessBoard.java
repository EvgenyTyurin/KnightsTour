
class ChessBoard {
    private int size;
    private int[][] boardCells;
    private int visit;

    ChessBoard(int size) {
        this.size = size;
        boardCells = new int[size][size];
    }

    void print() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++)
                System.out.print(boardCells[x][y] + "  ");
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    void visitCell(int x, int y) {
        boardCells[x][y] = ++visit;
    }

    public int[][] getBoardCells() {
        return boardCells;
    }

    public int getSize() {
        return size;
    }
}
