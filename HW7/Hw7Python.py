from typing import List
import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals or len(intervals) == 0:
            return 0

        heap = []
        heapq.heappush(heap, intervals[0][1])  # Start by adding the end time of the first job

        for i in range(1, len(intervals)):  # Iterate through all the rows (Jobs)
            current_start = intervals[i][0]  # Gives start time of each job

            if current_start >= heap[0]:  # Checks if the new start is AFTER the previous end time
                heapq.heappop(heap)  # Removes the previous job

            heapq.heappush(heap, intervals[i][1])  # This becomes the new end time as the loop iterates.
                                                  # This also ensures that the number of items in the heap = the number of servers needed!!

        return len(heap)
