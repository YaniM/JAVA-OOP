package jediGalaxy;

public class StarsManipulation {
    private Galaxy galaxy;

    public StarsManipulation(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (isInRange(evilRow, evilCol)) {
                this.galaxy.setStar(evilRow,evilCol,new Star(0));
            }
            evilRow--;
            evilCol--;
        }
    }

    private boolean isInRange(int rows, int cols) {
        return rows >= 0 && rows < this.galaxy.getRows() && cols >= 0 && cols < this.galaxy.getCols(rows);
    }

    public int playerMove(int playerRow, int playerCol) {
        int starsCount = 0;
        while (playerRow >= 0 && playerCol < this.galaxy.getCols(0)) {
            if (isInRange(playerRow, playerCol)) {
                starsCount += this.galaxy.getStarValue(playerRow,playerCol);
            }
            playerRow--;
            playerCol++;
        }
        return starsCount;
    }
}
