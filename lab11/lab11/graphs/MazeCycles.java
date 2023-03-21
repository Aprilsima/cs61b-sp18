package lab11.graphs;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int[] parent;
    private boolean hascycle;

    public MazeCycles(Maze m) {
        super(m);
        hascycle = false;
        parent = new int[maze.V()];
    }

    @Override
    public void solve() {
        cycle(0);
    }

    public void cycle(int v) {
        marked[v] = true;
        announce();
        if (hascycle) {
            return;
        }
        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                parent[w] = v;
                cycle(w);
                if (hascycle) {
                    return;
                }
            } else {
                if (parent[v] != w) {
                    hascycle = true;
                    parent[w] = v;
                    drawparent(w, v);
                    edgeTo[w] = v;
                    announce();
                    return;
                }
            }
        }

    }

    public void drawparent(int source, int target) {
        if (source == target) {
            return;
        }
        drawparent(source, parent[target]);
        edgeTo[target] = parent[target];
        announce();
    }

}

