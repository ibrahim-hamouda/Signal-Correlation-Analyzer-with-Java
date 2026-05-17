/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalanalyzer;


public class signal_correlation {

    
    public static double[] computeCorrelation(double[] x, double[] y) {
        int n = x.length;
        int m = y.length;

        // حجم المصفوفة اللي شايلة النتيجة
        int resultSize = n + m - 1;
        double[] correlationResult = new double[resultSize];

        // الـ Loop اللي بيحرك الإشارة (Lag)
        for (int lag = 0; lag < resultSize; lag++) {
            double sum = 0;

            // الـ Loop اللي بيضرب ويجمع
            for (int i = 0; i < n; i++) {
                int j = lag - (n - 1) + i;

                // فحص الحدود (عشان البرنامج ميهنجش)
                if (j >= 0 && j < m) {
                    sum += x[i] * y[j];
                }
            }
            correlationResult[lag] = sum;
        }
        return correlationResult;
    }
}
