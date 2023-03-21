package lab11.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private Queue<Integer> queue;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        queue = new ArrayDeque<>();     //so shocked! "Queue is an interface. You can't instantiate an interface
                                        //directly except via an anonymous inner class. Typically this isn't what
                                        //you want to do for a collection. Instead, choose an existing implementation."
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs(int v) {
        marked[v] = true;
        if (marked[t] == true) {
            targetFound = true;
        }
        if (targetFound) {
            announce();
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                queue.add(w);
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                if (targetFound) {
                    return;
                }
            }
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (targetFound) {
                announce();
                return;
            }
            bfs(queue.poll());
        }
    }


    @Override
    public void solve() {
        bfs(s);
    }
}

