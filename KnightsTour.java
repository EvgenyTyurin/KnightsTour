import java.util.Scanner;

/**
 * Knight must visit all cells of chessboard only once
 * Aug 2019 EvgenyT
 */

public class KnightsTour {
    public static void main(String[] args) {
        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size");
        int boardSize = scanner.nextInt();
        System.out.println("Enter start position X");
        int x = scanner.nextInt();
        System.out.println("Enter start position Y");
        int y = scanner.nextInt();
        // Lets solve this puzzle!
        ChessBoard chessBoard = new ChessBoard(boardSize);
        KnightFigure knightFigure = new KnightFigure(x, y, chessBoard);
        GreedyStrategy.tour(knightFigure);
        chessBoard.print();
    }
}
