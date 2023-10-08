import java.util.Arrays;

public class ShortestSuperString {

	public String shortestSuperstring(String[] words) {
        int n = words.length;
        
        int[][] overlaps = createOverlapGraph(words);
        
        int maskLen = 1 << n;
        
        //dp[mask][i] : maximum overlap of set of words (which is represented by mask), 
        //and ending with words[i]
        int[][] dp = new int[maskLen][n];
        
        //prevWordIndex[mask][i] : Previous word index, after creating the set of words (which is represented by mask),
        //and ending with words[i]
        int[][] prevWordIndex = new int[maskLen][n];  
        
        
        calculateMaximumOverlap(words, dp, prevWordIndex, overlaps);
        
        //correct order of words, which lead to shortest superstring
        int[] orders = getCorrectOrder(dp, prevWordIndex);
        
        return getShortestSuperString(words, overlaps, orders);
    }
    
    
    private int[][] createOverlapGraph(String[] words){
        int n = words.length;
        int[][] overlaps = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                overlaps[i][j] = getOverlap(words[i], words[j]);
            }
        }
        
        return overlaps;
    }
    
    private int getOverlap(String word, String nextWord){
        int len = Math.min(word.length(), nextWord.length());
        
        for(int i = len; i >= 0; i--){
            if(word.endsWith(nextWord.substring(0, i))) return i;
        }
        
        return 0;
    }
    
    private void calculateMaximumOverlap(String[] words, int[][] dp, int[][] prevWordIndex, int[][] overlaps){
        int n = words.length;
        int maskLen = 1 << n;
        
        for(int mask = 1; mask < maskLen; mask++){
            Arrays.fill(prevWordIndex[mask], -1);
            
            for(int maskBitPos = 0; maskBitPos < n; maskBitPos++){
                    
                //ignore the zero bit of mask[current set of words]
                if(((mask >> maskBitPos) & 1) <= 0) continue;
                
                //set of word which was selected previously for current mask
                int prevMask = (mask ^ (1 << maskBitPos));
                
                //previous mask is zero, it means, first word we are adding
                //ignore this, as there will be 0 overlapping
                if(prevMask == 0) continue;
                
                    
                
                for(int prevMaskBitPos = 0; prevMaskBitPos < n; prevMaskBitPos++){
                    
                    //ignore the zero bit of prevMask[Previous set of words]
                    if(((prevMask >> prevMaskBitPos) & 1) <= 0) continue;
                    
                    //previous set of word overlap, ending with words[prevMaskBitPos]
                    int prevOverlap = dp[prevMask][prevMaskBitPos];
                    
                    //overlap after appending new words[maskBitPos] next to words[prevMaskBitPos]
                    prevOverlap +=  overlaps[prevMaskBitPos][maskBitPos];
                    
                    
                    
                    if(prevOverlap >= dp[mask][maskBitPos]){
                        //replace with maximum overlap
                        dp[mask][maskBitPos] = prevOverlap;
                        
                        prevWordIndex[mask][maskBitPos] = prevMaskBitPos;
                    }
                    
                }
            }
        }
    }
    
    private int[] getCorrectOrder(int[][] dp, int[][] prevWordIndex){
        int rows = dp.length;
        int cols = dp[0].length;
        
        
        //last word index
        int lastWordIndex = 0;
        for(int col = 1; col < dp[0].length; col++){
            if(dp[rows - 1][col] > dp[rows - 1][lastWordIndex]){
                lastWordIndex = col;
            }
        }
        
        int[] orders = new int[cols];
        int mask = rows - 1;
        
        for(int i = cols - 1; i >= 0; i--){
            orders[i] = lastWordIndex;
            
            int prev = prevWordIndex[mask][lastWordIndex];
            int prevMask = mask ^ (1 << lastWordIndex);
            
            mask = prevMask;
            lastWordIndex = prev;
        }
        
        return orders;
    }
    
    private String getShortestSuperString(String[] words, int[][] overlaps, int[]orders){
        StringBuilder sb = new StringBuilder(words[orders[0]]);
        
        for(int i  = 1; i < orders.length; i++){
            
            int overlap = overlaps[orders[i - 1]][orders[i]];
            
            String word = words[orders[i]].substring(overlap);
            sb.append(word);
        }
    
        return sb.toString();
    }
}
