package MP4;

/**
 * Created by mmcalvarez on 11/27/2016.
 */

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Square[][] maze;
    private int rows;
    private int cols;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new Square[rows][cols];
    }

    public void setRow(int i, String row) {
        for(int j = 0; j < cols; j++){
            maze[i][j] = new Square(row.charAt(j), false, i, j);
            //System.out.println(maze[i][j].toString());
        }
    }

    public Square origin() throws Exception {
        boolean found = false;
        Square sq = null;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(maze[i][j].getType() == 'o'){
                    //System.out.println("dfdfd");
                    found = true;
                    sq = maze[i][j];
                    break;
                }
            }
        }
        if(found){
            return sq;
        }else {
            throw new Exception("origin not found");
        }
    }

    public List<Square> neighbors(Square sq) {
        List<Square> neighbors = new ArrayList<>(4);
        // neighbors are adjacent squares that aren't walls
        // order is important! add to the list neighbors in this order:
        // - left
        // - up
        // - right
        // - down
        int i = sq.getRow();
        int j = sq.getCol();

        if(maze[i][j - 1].getType() != '#' && maze[i][j - 1].getType() != 'x' && maze[i][j - 1].getType() != 'o'){
            neighbors.add(maze[i][j - 1]);
        }
        if(maze[i - 1][j].getType() != '#' && maze[i - 1][j].getType() != 'x' && maze[i - 1][j].getType() != 'o'){
            neighbors.add(maze[i - 1][j]);
        }
        if(maze[i][j + 1].getType() != '#' && maze[i][j + 1].getType() != 'x' && maze[i][j + 1].getType() != 'o'){
            neighbors.add(maze[i][j + 1]);
        }
        if(maze[i + 1][j].getType() != '#' && maze[i + 1][j].getType() != 'x' && maze[i + 1][j].getType() != 'o'){
            neighbors.add(maze[i + 1][j]);
        }
        return neighbors;
    }

    public Square getSquare(int row, int col) {
        return maze[row][col];
    }

    @Override
    public String toString() {
        String mazeStr = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mazeStr += maze[i][j].getType();
            }
            if (i < rows - 1) {
                mazeStr += "\n";
            }
        }
        return mazeStr;
    }

    public Maze clone() {
        Maze clone = new Maze(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                clone.maze[i][j] = maze[i][j].clone();
            }
        }
        return clone;
    }

}