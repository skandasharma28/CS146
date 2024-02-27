package HW7;
import java.util.PriorityQueue;


public class serverManager 
{
	public int minMeetingRooms(int[][] intervals)
	{
		
		if (intervals == null || intervals.length == 0) 
		{
            return 0;
		}
				
		PriorityQueue <Integer> queue = new PriorityQueue<>();
		
		queue.offer(intervals[0][1]); //Start by adding the end time of the first job
		
		for(int i = 1; i< intervals.length; i++) //Iterate through all the rows(Jobs)
		{
			int currentStart = intervals[i][0]; //Gives start time of each job
			
			if(currentStart >= queue.peek()) //Checks if the new start is AFTER the previous end time
			{
				queue.poll(); //Removes the previous job
			}
			
			queue.offer(intervals[i][1]); // This becomes the new end time as the loop iterates.
										// This also ensures that the number of items in the queue = the number of servers needed!!
				
		}
		
		return queue.size();
		
	}
	
	public static void main(String[] args) //Tester Class 
	{
		serverManager test = new serverManager();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}, {19,105}};
        System.out.println("Output for intervals1: " + test.minMeetingRooms(intervals1)); // Should return Output: 3

        int[][] intervals2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println("Output for intervals2: " + test.minMeetingRooms(intervals2)); // Should return Output: 1
    }
	

}
