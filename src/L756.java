import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution756 {

    /**
     * 756. Pyramid Transition Matrix https://leetcode.com/problems/pyramid-transition-matrix/description/
     * @timeComplexity O(P) where P is the total number of possible pyramids
     * @spaceComplexity O(A) Where A is the number of allowed triplets
     * @param bottom The bottom to start with
     * @param allowed List of allowed triplets
     * @return Whether a pyramid can be found
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Preprocess allowed list to a map
        Map<String, Set<String>> allowedMap = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            allowedMap.putIfAbsent(key, new HashSet<>());
            allowedMap.get(key).add(s.substring(2));
        }
        return search(bottom, allowedMap);
    }

    private boolean search(String bottom, Map<String, Set<String>> allowedMap) {
        // We have reached the top
        if (bottom.length() == 1) {
            return true;
        }
        // If we don't have an allowed triple for next row, return false right away
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!allowedMap.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }
        // Find all possible new bottoms
        List<String> newBottoms = new ArrayList<>();
        getBottoms(bottom, "", 0, allowedMap, newBottoms);
        // For each new bottom, check if there is a way to top
        for (String newBottom : newBottoms) {
            if (search(newBottom, allowedMap)) {
                return true;
            }
        }
        return false;
    }

    private void getBottoms(String bottom, String prefix, int currentIndex, Map<String, Set<String>> allowedMap, List<String> newBottoms) {
        if (currentIndex == bottom.length() - 1) {
            newBottoms.add(prefix);
            return;
        }
        String key = bottom.substring(currentIndex, currentIndex + 2);
        if (!allowedMap.containsKey(key)) {
            return;
        } else {
            for (String topChar : allowedMap.get(key)) {
                // Use this char
                getBottoms(bottom, prefix + topChar, currentIndex + 1, allowedMap, newBottoms);
            }
        }
    }

}
