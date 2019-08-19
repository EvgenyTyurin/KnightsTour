public class KnightsTour {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8);
        KnightFigure knightFigure = new KnightFigure(4, 4, chessBoard);
        knightFigure.tour();
        chessBoard.print();
    }
}
