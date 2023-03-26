package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {
    public int N;
    public int[][] tile;
    public static final int BLANK = 0;
    public Board(int[][] tiles) {
        N = tiles.length;
        tile = new int[N][N];
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                tile[i][j] = tiles[i][j];
            }
    }}
    public int tileAt(int i, int j) {
        if ( i < 0 || j < 0 || (i > N - 1) || (j > N - 1)) {
            throw new java.lang.IndexOutOfBoundsException("both i and j are between 0 and N − 1.");
        }
        int result = tile[i][j];
        if (result == 0) {
            return BLANK;
        }return result;
    }
    public int size() {
        return N;
    }
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int result = 0;
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile.length; j++) {
                int right = i * N + j + 1;
                int value = tileAt(i, j);
                if (value != BLANK && value != right) {
                    result++;
                }
            }
        }return result - 1;
    }
    public int manhattan() {
        int result = 0;
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile.length; j++) {
                int right = i * N + j + 1;
                result += helper(i, j);
                }
            }
        return result;
    }

    public int helper(int x, int y) {
        int value = tileAt(x, y);
        if (value != BLANK) {
            int shouldx = (value - 1) / N;
            int shouldy = (value - 1) % N;
            return (shouldx + shouldy - x - y);
        }
        return 0;
    }

    public int estimatedDistanceToGoal() {
        return manhattan();
    }
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null || this.getClass() != y.getClass()) {
            return false;
        }
        Board other = (Board) y;
        if (this.N != other.N) return false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (this.tile[i][j] != other.tile[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
