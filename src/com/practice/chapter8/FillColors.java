package com.practice.chapter8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FillColors {
	
	public static void main(String[] args) {
		Board b = new Board();
		b.print();
		
		Color oldColor = b.board[1][1];
		//b.paintFill(1, 1, Color.R);
		
		//b.print();
	
		b.paintFillBFS(1, 1, Color.R);
		b.print();
	}
}

enum Color { B, W, R, Y, G }

class Board {
	Color[][] board;
	
	Board() {
		this.board = new Color[][]{{Color.R,Color.R,Color.G,Color.B,Color.R},
            {Color.R,Color.G,Color.G,Color.G,Color.R},
            {Color.R,Color.R,Color.G,Color.B,Color.G},
            {Color.R,Color.B,Color.G,Color.G,Color.G},
            {Color.G,Color.R,Color.G,Color.B,Color.G}};
	}
	
	void print() {
		if (board == null) return;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	boolean isValid(int r, int c, Color replaceColor, boolean[][] visited) {
		
		// It is easy to write the condition for which it can be valid as all other conditions are invalid
		if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && !visited[r][c] && board[r][c] == replaceColor) 
			return true;
		
		else return false;
	}
	
	
	void putIfValid(int r, int c, Color replaceColor, boolean[][]visited, Queue<Position> queue) {
		
		if (isValid(r, c, replaceColor, visited)) {
			queue.add(new Position(r, c));
		}	
	}
	
	
	void paintFillBFS(int r, int c, Color nColor) {
		
		System.out.println("Replacing old color : " + board[r][c] + " by " + nColor);
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(r, c));
		Color replaceColor = board[r][c];
		
		while (!queue.isEmpty()) {	
			// visit
			Position p = queue.remove();
			board[p.x][p.y] = nColor;
			visited[p.x][p.y] = true; // After change is done, visit is complete
			
			putIfValid(p.x-1, p.y, replaceColor, visited, queue);
			putIfValid(p.x+1, p.y, replaceColor, visited, queue);
			putIfValid(p.x, p.y-1, replaceColor, visited, queue);
			putIfValid(p.x, p.y+1, replaceColor, visited, queue);
		}
	}
	
	/**
	 * 
	 * DFS search to fill the boxes with some condition
	 * 
	 */
	public void paintFill(int x, int y, Color nColor) {
		
		System.out.println("Replacing old color : " + board[x][y] + " by " + nColor);
		
		
		if (x < 0 || y < 0 || x > board.length - 1 || y > board.length - 1) return;
        if (board == null || nColor == null || board[x][y] == nColor) return;
        paintFill(x, y, board[x][y], nColor);
	}

	private void paintFill(int r, int c, Color currentColor, Color nColor) {
		
		if (r < 0 || c < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1)
			return;
		else {
			if (board[r][c] == currentColor) {
				board[r][c] = nColor;
				
				paintFill(r - 1, c, currentColor, nColor);
				paintFill(r + 1, c, currentColor, nColor);
				paintFill(r, c - 1, currentColor, nColor);
				paintFill(r, c + 1, currentColor, nColor);				
			}
		}
	}
}

class Position {
	
	int x, y;
	
	public Position(int r, int c) {
		x = r;
		y = c;
	}
	
	public int hashCode() {
		return 31 * x + y;
	}
	
	public boolean equals(Object object) {
		
		if (this == object) return true;
		if (object == null) return false;
		if (getClass() != object.getClass())
			return false;
		
		Position p = (Position) object;
		return (this.x == p.x && this.y == p.y);
	}
}
