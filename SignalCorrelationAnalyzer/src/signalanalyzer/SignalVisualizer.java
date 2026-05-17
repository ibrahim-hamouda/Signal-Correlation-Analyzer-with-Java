package signalanalyzer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// =====================================================
//  اسم الملف : SignalVisualizer.java
//  المهمة    : رسم 3 جرافات (Signal 1, Signal 2, Correlation)
//  المبرمج   : إسماعيل (شخص رقم 5)
// =====================================================

public class SignalVisualizer {

    // ---------------------------------------------------
    // الدالة الرئيسية - بيستدعيها أنور من الـ GUI
    // بتاخد 3 مصفوفات وترسم 3 جرافات
    // ---------------------------------------------------
    public void showCharts(double[] signal1, double[] signal2, double[] correlation) {

        // ارسم الجراف الأول - Signal 1
        drawChart(signal1, "Signal 1", "Sample", "Amplitude");

        // ارسم الجراف التاني - Signal 2
        drawChart(signal2, "Signal 2", "Sample", "Amplitude");

        // ارسم الجراف التالت - Cross Correlation
        drawChart(correlation, "Cross-Correlation", "Lag", "R_xy[m]");
    }

    // ---------------------------------------------------
    // دالة مساعدة - بترسم جراف واحد بس
    // data  = الأرقام اللي هترسمها
    // title = اسم الجراف
    // xLabel, yLabel = أسماء المحاور
    // ---------------------------------------------------
    private void drawChart(double[] data, String title, String xLabel, String yLabel) {

        // الخطوة 1: حط الأرقام في "Series" (ده زي ورقة بيانات)
        XYSeries series = new XYSeries(title);
        for (int i = 0; i < data.length; i++) {
            series.add(i, data[i]);  // x = رقم العينة، y = قيمتها
        }

        // الخطوة 2: حط الـ Series في Dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // الخطوة 3: اعمل الجراف
        JFreeChart chart = ChartFactory.createXYLineChart(
            title,             // عنوان الجراف
            xLabel,            // اسم المحور الأفقي
            yLabel,            // اسم المحور الرأسي
            dataset,           // البيانات
            PlotOrientation.VERTICAL,
            false,             // legend
            true,              // tooltips
            false              // urls
        );

        // الخطوة 4: افتح نافذة وعرض الجراف فيها
        ChartFrame frame = new ChartFrame(title, chart);
        frame.setSize(700, 400);
        frame.setVisible(true);
    }

    // ---------------------------------------------------
    // main - لو عايز تجرب الكود لوحده بدون باقي الفريق
    // ---------------------------------------------------
    public static void main(String[] args) {

        int n = 100; // عدد العينات

        // اعمل Signal 1 (موجة جيب تمام بسيطة)
        double[] signal1 = new double[n];
        for (int i = 0; i < n; i++) {
            signal1[i] = Math.sin(2 * Math.PI * i / 20.0);
        }

        // اعمل Signal 2 (نفس الموجة بس متأخرة شوية)
        double[] signal2 = new double[n];
        for (int i = 0; i < n; i++) {
            signal2[i] = Math.sin(2 * Math.PI * (i - 10) / 20.0);
        }

        // اعمل Correlation (بيانات تجريبية بسيطة)
        double[] correlation = new double[2 * n - 1];
        for (int lag = -(n - 1); lag < n; lag++) {
            double sum = 0;
            for (int i = 0; i < n; i++) {
                int j = i + lag;
                if (j >= 0 && j < n) {
                    sum += signal1[i] * signal2[j];
                }
            }
            correlation[lag + (n - 1)] = sum;
        }

        // شغّل الـ visualizer
        SignalVisualizer visualizer = new SignalVisualizer();
        visualizer.showCharts(signal1, signal2, correlation);
    }
}