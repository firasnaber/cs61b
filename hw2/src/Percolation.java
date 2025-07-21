import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    int N;
    boolean[][] grid;
    int numberOfOpenSites = 0;
    WeightedQuickUnionUF uf;
    WeightedQuickUnionUF ufFull; // Used to prevent backwash in isFull
    int virtualTop;
    int virtualBottom;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Class should be constructed with a value greater than 0");
        }
        this.N = N;
        grid = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N * N + 2);
        ufFull = new WeightedQuickUnionUF(N * N + 1);
        virtualTop = N * N;
        virtualBottom = N * N + 1;
    }

    public void open(int row, int col) {
        validateIndices(row, col);
        grid[row][col] = true;
        numberOfOpenSites++;

        int p = rcToIndex(row, col);

        if (row == 0) {
            uf.union(p, virtualTop);
            ufFull.union(p, virtualTop);
        }
        if (row == N - 1) uf.union(p, virtualBottom);

        if (row > 0 && isOpen(row - 1, col)) {
            int q = rcToIndex(row - 1, col); // top
            uf.union(p, q);
            ufFull.union(p, q);
        }
        if (row < N - 1 && isOpen(row + 1, col)) {
            int q = rcToIndex(row + 1, col); // bottom
            uf.union(p, q);
            ufFull.union(p, q);
        }
        if (col > 0 && isOpen(row, col - 1)) {
            int q = rcToIndex(row, col - 1); // left
            uf.union(p, q);
            ufFull.union(p, q);
        }
        if (col < N - 1 && isOpen(row, col + 1)) {
            int q = rcToIndex(row, col + 1); // right
            uf.union(p, q);
            ufFull.union(p, q);
        }
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        validateIndices(row, col);
        int p = rcToIndex(row, col);
        return ufFull.connected(virtualTop, p);
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        return uf.connected(virtualTop, virtualBottom);
    }
    private void validateIndices(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private int rcToIndex(int row, int col) {
        return row * N + col;
    }
}
