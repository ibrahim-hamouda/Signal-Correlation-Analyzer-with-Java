/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalanalyzer;
    import javax.sound.sampled.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Omarssssssss
 */
public class AudioSignalLoader {
    public static double[] loadWav(String path) {

        List<Double> samples = new ArrayList<>();

        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(path));

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = audioStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    samples.add((double) buffer[i]);
                }
            }

            audioStream.close();

        } catch (Exception e) {
            System.out.println("Error reading WAV: " + e.getMessage());
        }

        return samples.stream().mapToDouble(d -> d).toArray();
    }
}
