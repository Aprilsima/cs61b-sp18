package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayDeque;
import java.util.Comparator;

public class Solver {
    public SearchNode init;
    public ArrayDeque<WorldState> path;
    public MinPQ<SearchNode> pq;
    public class SearchNode {
        WorldState worldstate;
        int moves;
        SearchNode previous;
        public SearchNode(WorldState x) {
            worldstate = x;
            moves = 0;
            previous = null;
        }

        public SearchNode(WorldState x, int y, SearchNode z) {
            worldstate = x;
            moves = y;
            previous = z;
        }

        public class movesComparator implements Comparator<SearchNode> {
            public int compare(SearchNode a, SearchNode b) {
                return a.moves +a.worldstate.estimatedDistanceToGoal() - b.moves - b.worldstate.estimatedDistanceToGoal();
            }
        }
    }
    public Solver(WorldState initial) {
        init = new SearchNode(initial);
        Comparator<SearchNode> movescomparator = init.new movesComparator();
        pq = new MinPQ(movescomparator);
        pq.insert(init);
        path = new ArrayDeque<>();
        SearchNode now = pq.delMin();
        helper(now);
    }

    public void helper(SearchNode now) {
        if (now.worldstate.isGoal()) {
           SearchNode p = now;
            while (p != null) {
                path.addFirst(p.worldstate);
                p = p.previous;
            }
            return;
        } else {
            for (WorldState neighbour : now.worldstate.neighbors()) {
                if (now.previous == null || neighbour != now.previous.worldstate) {
                    SearchNode next = new SearchNode(neighbour, 1 + now.moves, now);
                    pq.insert(next);
                }
            }

            SearchNode next = pq.delMin();
            helper(next);
        }

    }

    public int moves() {
        return path.size() - 1;
    }
    public Iterable<WorldState> solution() {
        return path;
    }
}
