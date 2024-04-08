class Solution(object):
    def floodFill(self, image, sr, sc, color):
        if image[sr][sc] == color:
            return image
        
        self.fill(image, sr, sc, image[sr][sc], color)
        
        return image

    def fill(self, image, row, col, originalColor, newColor):
        if row < 0 or row >= len(image) or col < 0 or col >= len(image[0]) or image[row][col] != originalColor:
            return

        image[row][col] = newColor

        self.fill(image, row + 1, col, originalColor, newColor)
        self.fill(image, row - 1, col, originalColor, newColor)
        self.fill(image, row, col + 1, originalColor, newColor)
        self.fill(image, row, col - 1, originalColor, newColor)
