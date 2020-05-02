package edu.david;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class GameClock {
	
	private Game game;
	private boolean isPaused;
	private Timer clock = new Timer(500, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			game.update();
		}
		
	});
	
	public GameClock(Game game) {
		this.game = game;
	}
	
	public void start() {
		clock.start();
		isPaused = false;
	}
	
	public void togglePause() {
		if (isPaused) {
			clock.start();
			isPaused = false;
			System.out.println("[Resumed]");
		} else {
			clock.stop();
			isPaused = true;
			System.out.println("[Paused]");
		}
	}

	public boolean isPaused() {
		return isPaused;
	}

	public Timer getClock() {
		return clock;
	}

}
