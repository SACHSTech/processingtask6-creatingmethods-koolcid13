import processing.core.PApplet;

/**
* A program Sketch.java that uses methods with parameters to draw composite objects at various locations
* @author: Avin A.
*
*/

public class Sketch extends PApplet {
  
  /**
   * Initial settings happens in it
   *
   */
  public void settings() {
    size(800, 400);
  }

  /**
   * Is called once and to set the initial environment code is to happen in
   *
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Is called continuously and executes the codes within it infinite times
   *
   */
  public void draw() {
    
    // runs two for's for row and column and draws stick figures each time. Might draw a heart or not.
	  for (int row = 1; row <= 7; row ++) {
      for (int col = 1; col <= 15; col ++) {
        drawGuy ((float) col / 16 * width, (float) row / 8 * height, row);
        drawHeart((float) col / 16 * width - 24, (float) row / 8 * height + 16, drawsOrNot(row, col));
      }
    }
	
  }

  /**
   * Given x and y coordinates, draws a stick figure in accordance to the colour input
   *
   * @param x  x-coordinates
   * @param y  y-coordinates
   * @param colour  colourcode
   *
   */
  private void drawGuy(float x, float y, int colour) 
  {
    // sets colours for the stick figure
    noFill();
    if (colour == 1) {
      stroke (242, 24, 24);
    }
    else if (colour == 2) {
      stroke (230, 142, 28);
    }
    else if (colour == 3) {
      stroke (223, 230, 28);
    }
    else if (colour == 4) {
      stroke (29, 153, 8);
    }
    else if (colour == 5) {
      stroke (10, 120, 171);
    }
    else if (colour == 6) {
      stroke (7, 53, 222);
    }
    else {
      stroke (143, 58, 222);
    }

    // draws stick figure
    ellipse(x, y - 30, width / 50, width / 50);
    line (x, y - 30 + width / 100, x, y - 5);
    line (x, y - 10, x + 10, y - 22);
    line (x, y - 10, x - 10, y - 22);
    line (x, y - 5, x + 10, y + 5);
    line (x, y - 5, x - 10, y + 5);
  }

  /**
   * Based on the number of row and coloum, determines whether an object should be drawn or not
   *
   * @param row  row number
   * @param col  column number
   * @return whether the object should or should not be drawn
   *
   */
  private boolean drawsOrNot (int row, int col) {
    // returns true if the location of the heart would match with the desired pattern
    if (row % 2 == col % 2 && col != 1 && row != 7) {
      return true;
    }
    return false;
  }
  
  /**
   * Given x and y coordinates, draws a heart in accordance to the value of shouldDraw
   *
   * @param x  x-coordinates
   * @param y  y-coordinates
   * @param shouldDraw determines whether the heart should be drawn
   *
   */
  private void drawHeart (float x, float y, boolean shouldDraw) {
    // draws heart if shouldDraw indicates so
    if (shouldDraw) {
      stroke (0);
      fill (0);
      ellipse(x - 4, y - 12, 7, 7);
      ellipse(x + 4, y - 12, 7, 7);
      triangle(x - 7, y - 10, x + 7, y - 10, x, y - 3);
    }
  }

}