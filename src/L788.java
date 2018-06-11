import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution788 {
    private static final Map<Character, Character> ROTATION_MAP = new HashMap<Character, Character>() {{
       put('0', '0');
       put('1', '1');
       put('2', '5');
       put('5', '2');
       put('6', '9');
       put('8', '8');
       put('9', '6');
    }};

    private static final IntPredicate IS_GOOD_NUMBER = (N) -> {
        String inputChars = String.valueOf(N);
        String mappedChars = inputChars.chars().
                filter(c -> ROTATION_MAP.containsKey((char)c)).
                mapToObj(c -> String.valueOf(ROTATION_MAP.get((char)c))).
                collect(Collectors.joining());
        if (mappedChars.length() != inputChars.length()) {
            return false;
        } else if (mappedChars.equals(inputChars)) {
            return false;
        }
        return true;
    };

    /**
     * 788. Rotated Digits https://leetcode.com/problems/rotated-digits/description/
     * @timeComplexity O(N * log N) in terms of N. O(2^N * N) in terms of input size.
     *          For each number upto N, we perform a linear time operation on each digit to check if it is good number
     * @spaceComplexity O(1) - The hashmap has constant number of records.
     * @param N The number N
     * @return Number of good numbers in the range [1, N]
     */
    public int rotatedDigits(int N) {
        return (int) IntStream.range(1, N + 1).filter(IS_GOOD_NUMBER).count();
    }
}
