package Hw11;

public class PixelSolution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color) 
    {
        // Check if the new color is the same original
        if (image[sr][sc] == color) 
        {
            return image;
        }
        
        // Perform flood fill starting from image[sr],image[sc]
        fill(image, sr, sc, image[sr][sc], color);
        
        return image;
    }

    private void fill(int[][] image, int row, int col, int originalColor, int newColor)
    {
        // Check if row or col are out of bounds, and if the current pixel color is the original color
    	//BASE CASE
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }
        // Change color of current pixel
        image[row][col] = newColor;

        // Recursively perform flood fill for adjacent pixels
        fill(image, row + 1, col, originalColor, newColor); 
        fill(image, row - 1, col, originalColor, newColor); 
        fill(image, row, col + 1, originalColor, newColor); 
        fill(image, row, col - 1, originalColor, newColor); 
    }
}
