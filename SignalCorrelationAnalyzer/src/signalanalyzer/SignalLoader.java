/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalanalyzer;
import java.io.*;
import java.util.*;

/**
 *
 * @author Omarssssssss
 */
public class SignalLoader {
    // قراءة TXT
    public static double[] loadTXT(String path) {
        List<Double> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    if (!line.trim().isEmpty()) {
                        list.add(Double.parseDouble(line.trim()));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid line: " + line);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return toArray(list);
    }

    // قراءة CSV
    public static double[] loadCSV(String path) {
        List<Double> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (String v : values) {
                    try {
                        if (!v.trim().isEmpty()) {
                            list.add(Double.parseDouble(v.trim()));
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid value: " + v);
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return toArray(list);
    }

    // تحويل List → Array
    private static double[] toArray(List<Double> list) {
        double[] arr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
