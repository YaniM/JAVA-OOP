package jediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillGalaxy();
    }

    private boolean isInRange(int rows, int cols) {
        return rows >= 0 && rows < this.stars.length && cols >= 0 && cols < this.stars[rows].length;
    }

    public void fillGalaxy() {
        int count = 0;
        for (int i = 0; i < stars.length; i++) {
            for (int j = 0; j < stars[i].length; j++) {
                stars[i][j] = new Star(count++);
            }
        }
    }

    public int getRows() {
        return this.stars.length;
    }

    public int getCols(int rows) {
        return this.stars[rows].length;
    }

    public void setStar(int row, int col, Star star) {

        if (this.isInRange(row, col)) {
            this.stars[row][col] = star;
        }
    }

    public int getStarValue(int row, int col) {
        int result = 0;
        if (this.isInRange(row, col)) {
            result = this.stars[row][col].getValue();
        }
        return result;
    }
}
