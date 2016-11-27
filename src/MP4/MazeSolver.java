package MP4;

import java.util.List;

/**
 * Created by mmcalvarez on 11/27/2016.
 */

public class MazeSolver {
    private Maze maze;
    private Maze solvedMaze;
    private Agenda ag;

    public MazeSolver(Maze maze, Agenda ag) {
        this.maze = maze;
        this.ag = ag;
        solvedMaze = maze.clone();
    }

    public boolean solve() throws Exception {
        return markPathToEnd(solvedMaze.origin());
    }

    private boolean markPathToEnd(Square sq) throws InstantiationException, IllegalAccessException {
        if(sq.getType() == '*'){
            return true;
        } else {
            if(sq.getType() != 'o') {
                sq.setType('x');
                sq.setVisited(true);
            }

            Agenda agenda = ag.newInstance();

            List<Square> square = solvedMaze.neighbors(sq);
            for(Square sq2 : square){
                agenda.add(sq2);
            }

            while (agenda.size() != 0) {
                if (markPathToEnd(agenda.remove())){
                    return true;
                }
            }
            sq.setType('.');
            return false;
        }

    }

    public Maze getSolvedMaze() {
        return solvedMaze;
    }

}