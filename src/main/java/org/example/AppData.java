package org.example;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }
    public String[] getHeader() {
        return header;
    }
    public int[][] getData() {
        return data;
    }
    public void saveDataToCsv(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.join(";", header));
            writer.newLine();
            for (int[] row : data) {
                writer.write(Arrays.toString(row)
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", ";"));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static AppData loadDataFromCsv(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");
            String row;
            int[][] data = new int[0][];
            while ((row = reader.readLine()) != null) {
                int[] rowData = Arrays.stream(row.split(";"))
                        .mapToInt(value -> {
                            try {
                                return Integer.parseInt(value.trim());
                            } catch (NumberFormatException e) {
                                return 0;
                            }
                        })
                        .toArray();
                data = Arrays.copyOf(data, data.length + 1);
                data[data.length - 1] = rowData;
            }

            return new AppData(header, data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{15, 25, 35}, {45, 55, 65}};
        AppData appData = new AppData(header, data);
        appData.saveDataToCsv("data.csv");
        AppData loadedDataFromCsv = AppData.loadDataFromCsv("data.csv");
        System.out.println(String.join(";", loadedDataFromCsv.getHeader()));
        for (int[] row : loadedDataFromCsv.getData()) {
            System.out.println(Arrays.toString(row)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ";"));
        }
    }
}