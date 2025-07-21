import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    int N;
    boolean[][] grid;
    int numberOfOpenSites = 0;
    WeightedQuickUnionUF uf;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Class should be constructed with a value greater than 0");
        }
        this.N = N;
        grid = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N);
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        validateIndices(row, col);

        return false;
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.
    private void validateIndices(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private int rcToIndex(int row, int col) {
        return row * N + col;
    }
}
