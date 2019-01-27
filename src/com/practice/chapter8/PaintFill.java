package com.practice.chapter8;

public class PaintFill {
	public static void paintFill(Color[][] screen, int x, int y, Color newColor) {
        if (x < 0 || y < 0 || x > screen.length - 1 || y > screen[0].length - 1) return;
        if (screen == null || newColor == null || screen[x][y] == newColor) return;
        paintFill(screen, x, y, screen[x][y], newColor);
    }

    private static void paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if (x < 0 || y < 0 || x > screen.length - 1 || y > screen[0].length - 1) return;
        if (screen[x][y] == oldColor) {
            screen[x][y] = newColor;
            paintFill(screen, x + 1, y, oldColor, newColor);
            paintFill(screen, x - 1, y, oldColor, newColor);
            paintFill(screen, x, y + 1, oldColor, newColor);
            paintFill(screen, x, y - 1, oldColor, newColor);
        }
    }

    enum Color {R, G, B}

    //TEST----------------------------------
    public static void main(String[] args) {
        /* ______y
         * |RRGBR
         * |RGGGR
         * |RRGBG
         * |RBGGG
         * |GRGBG
         * x
         */
        Color[][] screen = {{Color.R,Color.R,Color.G,Color.B,Color.R},
                            {Color.R,Color.G,Color.G,Color.G,Color.R},
                            {Color.R,Color.R,Color.G,Color.B,Color.G},
                            {Color.R,Color.B,Color.G,Color.G,Color.G},
                            {Color.G,Color.R,Color.G,Color.B,Color.G}};
        printScreen(screen);
        paintFill(screen, 1, 1, Color.G);
        printScreen(screen);
        paintFill(screen, 100, 100, Color.G);
        printScreen(screen);
        paintFill(screen, 1, 1, Color.B);
        printScreen(screen);
    }

    private static void printScreen(Color[][] screen) {
        for (Color[] row : screen) {
            for (Color c : row) System.out.print(c);
            System.out.println();
        }
        System.out.println();
    }
}
