package edu.david;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GraphicRenderer {

	private Game game;
	private JFrame frame;
	private JPanel contentPanel;
	
	private int width = 900;
	private int height = 900;
	private JPanel cellArea;
	private JPanel[][] cellBlocks;
	private int blockSize;
	
	public GraphicRenderer(Game game) {
		this.game = game;
		this.blockSize = width / game.getGridSize();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void build() {
		frame = new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.getClock().togglePause();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.setVisible(true);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBounds(0, 0, width, height);
		contentPanel.setBackground(Color.GRAY);
		frame.add(contentPanel);
		
		cellArea = new JPanel();
		cellArea.setBounds(0, 0, width, width);
		contentPanel.add(cellArea);
		
		cellBlocks = new JPanel[game.getGridSize()][game.getGridSize()];
		
		for (int i = 0; i < cellBlocks.length; i++) {
			for (int i2 =0; i2 < cellBlocks[i].length; i2++) {
				cellBlocks[i][i2] = new JPanel();
				cellBlocks[i][i2].setSize(blockSize, blockSize);
				cellBlocks[i][i2].setLocation(i * blockSize, i2 * blockSize);
				cellBlocks[i][i2].setBackground(Color.WHITE);
				cellBlocks[i][i2].setBorder(new LineBorder(Color.black, 1, false));
				cellArea.add(cellBlocks[i][i2]);
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < cellBlocks.length; i++) {
			for (int i2 =0; i2 < cellBlocks[i].length; i2++) {
				
				if (game.getCells()[i][i2].isAlive()) {
					if (game.getCells()[i][i2].getTeam() == Team.BLUE) {
						cellBlocks[i][i2].setBackground(Color.BLUE);
					} else {
						cellBlocks[i][i2].setBackground(Color.RED);
					}
				} else {
					cellBlocks[i][i2].setBackground(Color.WHITE);
				}
				
				cellBlocks[i][i2].repaint();
			}
		}

		
		if (frame != null) {
			cellArea.repaint();
			frame.repaint();
		}
	}
}
