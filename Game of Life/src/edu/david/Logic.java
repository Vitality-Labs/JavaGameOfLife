package edu.david;

public class Logic {

	private Game game;

	public Logic(Game game) {
		this.game = game;
	}

	public void checkCell(Cell c) {
		int surroundingAlive = 0;
		int surroundingHostile = 0;
		Team cellTeam = c.getTeam();

		// Checking Surrounding Friendly Cells

		if (c.getX() != 0) {
			if (game.getCells()[c.getX() - 1][c.getY()].isAlive() // Checking to the west of the cell
					&& game.getCells()[c.getX() - 1][c.getY()].getTeam() == cellTeam)
				surroundingAlive++;

			if (c.getY() != 0) {
				if (game.getCells()[c.getX() - 1][c.getY() - 1].isAlive() // Checking south west of the cell
						&& game.getCells()[c.getX() - 1][c.getY() - 1].getTeam() == cellTeam)
					surroundingAlive++;
			}

			if (c.getY() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX() - 1][c.getY() + 1].isAlive() // Checking north west of the cell
						&& game.getCells()[c.getX() - 1][c.getY() + 1].getTeam() == cellTeam)
					surroundingAlive++;
			}

			if (c.getX() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX() + 1][c.getY()].isAlive() // Checking the east side of the cell
						&& game.getCells()[c.getX() + 1][c.getY()].getTeam() == cellTeam)
					surroundingAlive++;

				if (c.getY() != 0) {
					if (game.getCells()[c.getX() + 1][c.getY() - 1].isAlive() // Checking the south east side of the cell
							&& game.getCells()[c.getX() + 1][c.getY() - 1].getTeam() == cellTeam)
						surroundingAlive++;
				}

				if (c.getY() != game.getGridSize() - 1) {
					if (game.getCells()[c.getX() + 1][c.getY() + 1].isAlive() // Checking the north east of the cell
							&& game.getCells()[c.getX() + 1][c.getY() + 1].getTeam() == cellTeam)
						surroundingAlive++;
				}

			}
		} else {
			if (game.getCells()[c.getX() + 1][c.getY()].isAlive() // Checking the east side of the cell
					&& game.getCells()[c.getX() + 1][c.getY()].getTeam() == cellTeam)
				surroundingAlive++;
		}

		if (c.getY() != 0) {
			if (game.getCells()[c.getX()][c.getY() - 1].isAlive() // checking the south side of the cell
					&& game.getCells()[c.getX()][c.getY() - 1].getTeam() == cellTeam)
				surroundingAlive++;

			if (c.getY() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX()][c.getY() + 1].isAlive() // checking the north side of the cell
						&& game.getCells()[c.getX()][c.getY() + 1].getTeam() == cellTeam)
					surroundingAlive++;
			}
		} else {
			if (game.getCells()[c.getX()][c.getY() + 1].isAlive() // checking the north side of the cell
					&& game.getCells()[c.getX()][c.getY() + 1].getTeam() == cellTeam)
				surroundingAlive++;

			if (c.getX() == 0) {
				if (game.getCells()[c.getX() + 1][c.getY() + 1].isAlive() // checking the north east side of the cell
						&& game.getCells()[c.getX() + 1][c.getY() + 1].getTeam() == cellTeam) {
					surroundingAlive++;
				}
			}
		}

		// ---------------------------------------------------

		if (c.getX() != 0) {
			if (game.getCells()[c.getX() - 1][c.getY()].isAlive()
					&& game.getCells()[c.getX() - 1][c.getY()].getTeam() != cellTeam)
				surroundingHostile++;

			if (c.getY() != 0) {
				if (game.getCells()[c.getX() - 1][c.getY() - 1].isAlive()
						&& game.getCells()[c.getX() - 1][c.getY() - 1].getTeam() != cellTeam)
					surroundingHostile++;
			}

			if (c.getY() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX() - 1][c.getY() + 1].isAlive()
						&& game.getCells()[c.getX() - 1][c.getY() + 1].getTeam() != cellTeam)
					surroundingHostile++;
			}

			if (c.getX() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX() + 1][c.getY()].isAlive()
						&& game.getCells()[c.getX() + 1][c.getY()].getTeam() != cellTeam)
					surroundingHostile++;

				if (c.getY() != 0) {
					if (game.getCells()[c.getX() + 1][c.getY() - 1].isAlive()
							&& game.getCells()[c.getX() + 1][c.getY() - 1].getTeam() != cellTeam)
						surroundingHostile++;
				}

				if (c.getY() != game.getGridSize() - 1) {
					if (game.getCells()[c.getX() + 1][c.getY() + 1].isAlive()
							&& game.getCells()[c.getX() + 1][c.getY() + 1].getTeam() != cellTeam)
						surroundingHostile++;
				}

			}
		} else {
			if (game.getCells()[c.getX() + 1][c.getY()].isAlive()
					&& game.getCells()[c.getX() + 1][c.getY()].getTeam() != cellTeam)
				surroundingHostile++;
		}

		if (c.getY() != 0) {
			if (game.getCells()[c.getX()][c.getY() - 1].isAlive()
					&& game.getCells()[c.getX()][c.getY() - 1].getTeam() != cellTeam)
				surroundingHostile++;

			if (c.getY() != game.getGridSize() - 1) {
				if (game.getCells()[c.getX()][c.getY() + 1].isAlive()
						&& game.getCells()[c.getX()][c.getY() + 1].getTeam() != cellTeam)
					surroundingHostile++;
			}
		} else {
			if (game.getCells()[c.getX()][c.getY() + 1].isAlive()
					&& game.getCells()[c.getX()][c.getY() + 1].getTeam() != cellTeam)
				surroundingHostile++;

			if (c.getX() == 0) {
				if (game.getCells()[c.getX() + 1][c.getY() + 1].isAlive()
						&& game.getCells()[c.getX() + 1][c.getY() + 1].getTeam() != cellTeam) {
					surroundingHostile++;
				}
			}
		}

		// ---------------------------------------------------

		if ((surroundingAlive + surroundingHostile) < 2 || (surroundingAlive + surroundingHostile) > 3 || surroundingHostile >= 2) {
			c.setAlive(false);
		} else {
			c.setAlive(true);
		}
	}

	public int randLife() {
		if (Math.random() < 0.75) { // Probability of life (Currently: 25%)
			return 0;
		}
		return 1;
	}

	public int calculateLiveCells() {
		int output = 0;

		if (game.getCells() != null) {
			for (int i = 0; i < game.getCells().length; i++) {
				for (int i2 = 0; i2 < game.getCells()[i].length; i2++) {
					if (game.getCells()[i][i2].isAlive()) {
						output++;
					}
				}
			}
		}

		return output;
	}

	public Game getGame() {
		return game;
	}

}
