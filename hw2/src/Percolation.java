import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    // TODO: Add any necessary instance variables.
    int N;
    boolean[][] grid;
    WeightedQuickUnionUF uf;

    public Percolation(int N) {
        this.N = N;
        grid = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N);
    }

    public void open(int row, int col) {
        // TODO: Fill in this method.
    }

    public boolean isOpen(int row, int col) {
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        // TODO: Fill in this method.
        return false;
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return 0;
    }

    public boolean percolates() {
        // TODO: Fill in this method.
        return false;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
