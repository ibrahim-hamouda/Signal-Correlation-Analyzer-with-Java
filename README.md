# Signal Correlation Analyzer 📈

A robust Java-based desktop application designed to compute and visualize the cross-correlation between two digital signals. This tool is built to analyze text-based signals and `.wav` audio files to determine their similarity percentage and exact time-lag, making it ideal for fault detection, pattern matching, and signal synchronization.

Developed as a Communication Engineering project at **Suez Canal University**.

## 🚀 Features

* **Multi-Format Data Loading:** Supports reading signal arrays from `.txt`, `.csv`, and extracting audio samples directly from `.wav` files.
* **Mathematical Cross-Correlation:** Computes the mathematical correlation ($R_{xy}$) between two discrete signals.
* **Similarity & Lag Analysis:** Evaluates the processed correlation array to pinpoint the exact time-lag (delay) and calculates a normalized similarity percentage (0% to 100%).
* **Interactive Visualization:** Renders high-performance graphs of the input signals and the resulting correlation curve using `JFreeChart`.
* **Asynchronous Processing:** Utilizes background multithreading to ensure the Swing GUI remains responsive while processing massive audio arrays (e.g., 50,000+ samples).

## 🛠️ Project Architecture & Modules

The application is built with a modular architecture, represented by the core compiled classes:

* `SignalAnalyzerUI`: The main Graphical User Interface and Central Controller.
* `SignalLoader` & `AudioSignalLoader`: Handles parsing raw data and extracting audio samples.
* `preprocessor`: Cleans data arrays (filters `NaN` values).
* `signal_correlation`: The core math engine for processing array convolutions.
* `Analyzer`: The evaluation logic for extracting peak lag and similarity scores.
* `SignalVisualizer`: The charting module powered by JFreeChart.

## 💻 Installation & Usage

**Prerequisites:** * Java Development Kit (JDK 21 or newer is highly recommended to avoid `UnsupportedClassVersionError`).
* JFreeChart library (included in the `lib` directory or bundled in the JAR).

**How to Run:**
1. Download the released `SignalAnalyzer.jar` file.
2. For the best experience on Windows, simply double-click the included `Launch_Project.bat` script.
3. Alternatively, run the following command in your terminal:
   ```bash
   java -jar SignalAnalyzer.jar
