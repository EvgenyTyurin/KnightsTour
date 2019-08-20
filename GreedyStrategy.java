import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Knight moves to the cell where there is minimum opportunities
 * to make next move.
 */

class GreedyStrategy {
    static void tour(KnightFigure figure) {
        Random random = new Random();
        // While knight has moves - he moves!
        ArrayList<Point> moves = figure.getMoves(figure.getX(), figure.getY());
        while (!moves.isEmpty()) {
            // In search for best move
            int bestMove = 0;
            int minVariants = figure.getMoves(moves.get(bestMove).x, moves.get(bestMove).y).size();
            for (int idx = 1; idx < moves.size(); idx++) {
                int variants = figure.getMoves(moves.get(idx).x, moves.get(idx).y).size();
                // Minimum future possibilities - the best move
                if ((variants < minVariants) ||
                        ((variants == minVariants) && random.nextBoolean())) {
                    bestMove = idx;
                    minVariants = variants;
                }
            }
            // Move to best position and get next move variants
            figure.move(moves.get(bestMove));
            moves = figure.getMoves(figure.getX(), figure.getY());
        }
    }
}
