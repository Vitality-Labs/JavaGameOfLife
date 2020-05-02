package edu.david;

public class Cell {
	
	private Game game;
	private boolean isAlive;
	private int x;
	private int y;
	private Team team;

	public Cell(Game game, int x, int y, Team t) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.isAlive = false;
		this.team = t;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
