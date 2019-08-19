import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class KnightFigure {
    private int x, y;
    private ChessBoard chessBoard;

    KnightFigure(int x, int y, ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        move(new Point(x, y));
    }

    private void move(Point point) {
        this.x = point.x;
        this.y = point.y;
        chessBoard.visitCell(x, y);
    }

    void tour() {
        do {
            ArrayList<Point> moves = getMoves(x, y);
            if (moves.isEmpty())
                break;
            int bestMove = 0;
            int minVariants = getMoves(moves.get(bestMove).x, moves.get(bestMove).y).size();
            for (int idx = 1; idx < moves.size(); idx++) {
                int variants = getMoves(moves.get(idx).x, moves.get(idx).y).size();
                if (variants < minVariants) {
                    bestMove = idx;
                    minVariants = variants;
                }
            }
            move(moves.get(bestMove));
        } while (true);
    }

    private ArrayList<Point> getMoves(int x, int y) {
        ArrayList<Point> movePoints = new ArrayList<>();
        if (x > 1 && y > 0 && chessBoard.getBoardCells()[x - 2][y - 1] == 0)
            movePoints.add(new Point(x - 2 , y - 1));
        if (x > 0 && y > 1 && chessBoard.getBoardCells()[x - 1][y - 2] == 0)
            movePoints.add(new Point(x - 1 , y - 2));
        if (x < chessBoard.getSize() - 1 && y > 1 && chessBoard.getBoardCells()[x + 1][y - 2] == 0)
            movePoints.add(new Point(x + 1 , y - 2));
        if (x < chessBoard.getSize() - 2 && y > 0 && chessBoard.getBoardCells()[x + 2][y - 1] == 0)
            movePoints.add(new Point(x + 2 , y - 1));
        if (x < chessBoard.getSize() - 2 && y < chessBoard.getSize() - 1 && chessBoard.getBoardCells()[x + 2][y + 1] == 0)
            movePoints.add(new Point(x + 2 , y + 1));
        if (x < chessBoard.getSize() - 1 && y < chessBoard.getSize() - 2 && chessBoard.getBoardCells()[x +1][y + 2] == 0)
            movePoints.add(new Point(x + 1 , y + 2));
        if (x > 0 && y < chessBoard.getSize() - 2 && chessBoard.getBoardCells()[x - 1][y + 2] == 0)
            movePoints.add(new Point(x - 1 , y + 2));
        if (x > 1 && y < chessBoard.getSize() - 1 && chessBoard.getBoardCells()[x - 2][y +1] == 0)
            movePoints.add(new Point(x - 2 , y + 1));
        return movePoints;
    }

}
