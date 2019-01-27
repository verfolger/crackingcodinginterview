package com.practice.chapter8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class RobotInGrid {

	private static List<Location> existingPath = new ArrayList<>();
	
	// Path : top left -> bottom right
	public static boolean doesPathExist(Grid g) {
		
		boolean[][] visited = new boolean[g.position.length][g.position[0].length];
		
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(0, 0));
		
		while (!queue.isEmpty()) {
			
			Location current = queue.poll();
			// VISIT
			existingPath.add(current);
			visited[current.x][current.y] = true; 
			
			// ADD ELIGIBLE CHILDREN
			putIfValid(current.x, current.y + 1, g, queue, visited);
			putIfValid(current.x + 1, current.y, g, queue, visited);
		}
		
		if (visited[g.position.length - 1][g.position[0].length - 1]) return true;
		else return false;
	}
	
	public static void printPath(Grid g) {
		
		if (existingPath.contains(new Location(g.position.length - 1, g.position[0].length - 1)))
			System.out.println("Path exists");
		System.out.print(existingPath);
	}

	private static void putIfValid(int x, int y, Grid grid, Queue<Location> queue, boolean[][] visited) {
		
		int row = grid.position.length;
		int col = grid.position[0].length;
		
		if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y] && !grid.position[x][y].equals("1")) {
			queue.add(new Location(x, y));
		}
	}
	
	public static void main(String[] args) {
		Grid g = new Grid(5, 5);
		g.printGrid();
		
		System.out.println(doesPathExist(g));
		printPath(g);
	}
	
	private static class Location {
		int x, y;
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
		public boolean equals(Object o) {
			
			if (o == null) return false;
			if (o == this) return true;
			
			if (getClass() != o.getClass()) return false;
			
			Location loc = (Location) o;
			if (this.x == loc.x && this.y == loc.y) return true;
			
			return false;
		}
	}
}

class Grid {
	
	String[][] position;
	
	Grid(int row, int col) {
		
		position = new String[row][col];
		
		Random r = new Random(123456789);
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				position[i][j] = r.nextInt(2) == 0 ? "0" : "1";
			}
		}
		position[0][0] = "0";
		position[row - 1][col - 1] = "0";	
	}
	
	void printGrid() {
		if (position == null) return;
		
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < position[0].length; j++) {
				System.out.print(this.position[i][j]);
			}
			System.out.println();
		}
	}
}
