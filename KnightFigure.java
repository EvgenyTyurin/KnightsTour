import java.awt.*;
import java.util.ArrayList;

/**
 * Knight figure
 */

class KnightFigure {
    private int x, y;
    private ChessBoard chessBoard;

    KnightFigure(int x, int y, ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        move(new Point(x, y));
    }

    void move(Point point) {
        this.x = point.x;
        this.y = point.y;
        chessBoard.visitCell(x, y);
    }

    /** Returns collection of of possible moves from x,y position */
    ArrayList<Point> getMoves(int x, int y) {
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

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
