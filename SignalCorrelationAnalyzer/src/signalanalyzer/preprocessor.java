/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalanalyzer;

/**
 *
 * @author Omarssssssss
 */
public class preprocessor {
    public static double[] clean(double[] data) {
        return java.util.Arrays.stream(data)
                .filter(d -> !Double.isNaN(d))
                .toArray();
    }
}
