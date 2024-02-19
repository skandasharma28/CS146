package Hw2;

public class firstBadVersion {

    public static int firstBadVersion(int total) {
        int left = 1;
        int right = total;

        while (left < right) 
        {
            int middle = left + (right - left) / 2;
            boolean result = isBad(middle);

            if (result) {
                right = middle;  // Adjust right based on result
            } else {
                left = middle + 1;  // Adjust left based on result
            }
        }
        return left;
    }

    private static boolean isBad(int index) {
        // Simulating a bad version at index 33
        return index >= 2;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(200));
    }
}
