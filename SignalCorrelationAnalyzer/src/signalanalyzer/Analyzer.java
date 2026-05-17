package signalanalyzer;

public class Analyzer {

    public static double calcSimilarity(double[] s1, double[] s2) {
        double totalDiff = 0;
        double totalSize = 0;
        
        // --- THE FIX ---
        // Find the length of the shorter array so we never go out of bounds
        int minLength = Math.min(s1.length, s2.length);

        // Use minLength as the finish line instead of s1.length
        for (int i = 0; i < minLength; i++) {
            totalDiff += Math.abs(s1[i] - s2[i]);
            totalSize += Math.abs(s1[i]);
        }
        
        double diffRatio = totalDiff / (totalSize + 1e-9);
        return Math.max((1.0 - diffRatio) * 100.0, 0.0);
    }

    public static int findLag(double[] s1, double[] s2) {
        int    bestLag   = 0;
        double bestScore = Double.MAX_VALUE;
        for (int lag = -4; lag <= 4; lag++) {
            double score = calcDiffWithLag(s1, s2, lag);
            if (score < bestScore) {
                bestScore = score;
                bestLag   = lag;
            }
        }
        return bestLag;
    }

    static double calcDiffWithLag(double[] s1, double[] s2, int lag) {
        double totalDiff = 0;
        for (int i = 0; i < s1.length; i++) {
            int j = i - lag;
            if (j >= 0 && j < s2.length) {
                totalDiff += Math.abs(s1[i] - s2[j]);
            }
        }
        return totalDiff;
    }
    
}
