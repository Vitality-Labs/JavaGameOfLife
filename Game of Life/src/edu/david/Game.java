package edu.david;

public class Game {

	private final int gridSize = 150;
	private Cell[][] cells = new Cell[gridSize][gridSize];
	private Logic logic = new Logic(this);
	private GraphicRenderer graphics;
	private int genCount = 0;
	private int numOfLiveCells = 0;
	private GameClock clock;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		genCells();
		graphics = new GraphicRenderer(this);
		graphics.build();
		numOfLiveCells = 0;
		genCount = 1;
		clock = new GameClock(this);
		clock.start();
	}
	
	public void genCells() {
		for (int i = 0; i < cells.length; i++) {
			for (int i2 = 0; i2 < cells[i].length; i2++) {
				
				Team temp;
				
				if(Math.random() < 0.5) {
					temp = Team.BLUE;
				} else {
					temp = Team.RED;
				}
				
				cells[i][i2] = new Cell(this, i, i2, temp);
				if (logic.randLife() == 1) {
					cells[i][i2].setAlive(true);
				}
			}
		}
	}
	
	public void update() {
		if (graphics != null) {
			graphics.update();
		}
		
		for (int i = 0; i < cells.length; i++) {
			for (int i2 = 0; i2 < cells[i].length; i2++) {
				logic.checkCell(cells[i][i2]);
			}
		}
		
		numOfLiveCells = logic.calculateLiveCells();
		genCount++;
		
		System.out.println("[Gen Number: " + genCount + ", Number Of Live Cells: " + numOfLiveCells + "]");
	}

	public int getGridSize() {
		return gridSize;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public Logic getLogic() {
		return logic;
	}

	public int getGenCount() {
		return genCount;
	}

	public int getNumOfLiveCells() {
		return numOfLiveCells;
	}

	public GraphicRenderer getGraphics() {
		return graphics;
	}

	public GameClock getClock() {
		return clock;
	}

}
