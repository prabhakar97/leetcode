import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution332 {
    private int totalSize;

    /**
     * 332. Reconstruct Itinerary https://leetcode.com/problems/reconstruct-itinerary/description/
     * @timeComplexity O(n^2) where n is the number of airports For each source, all possible destinations will be tried out in worst case.
     * @spaceComplexity O(n) Keep current itinerary and priority queue of destinations from each source
     * @param tickets String[][]
     *                List of all tickets.
     * @return Possible itinerary
     */
    public List<String> findItinerary(String[][] tickets) {
        totalSize = tickets.length;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (map.get(tickets[i][0]) == null) {
                map.put(tickets[i][0], new PriorityQueue<>(Arrays.asList(tickets[i][1])));
            } else {
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
        }

        List<String> itin = new ArrayList<>();
        solve(itin, "JFK", map);
        return itin;
    }

    void solve(List<String> itin, String curSource, Map<String, PriorityQueue<String>> map) {
        itin.add(curSource);
        // Check whether we used up all the tickets
        if (itin.size() == totalSize + 1) {
            return;
        }
        PriorityQueue<String> destinations = map.get(curSource);
        if (destinations != null) {
            while (!destinations.isEmpty()) {
                // Try this arrival airport
                String dest = destinations.poll();
                int curItinLength = itin.size();
                solve(itin, dest, map);
                // Did it work?
                if (itin.size() < totalSize + 1) {
                    // If no then backtrack
                    itin = itin.subList(0, curItinLength);
                } else {
                    return;
                }
            }
        }
    }
}
