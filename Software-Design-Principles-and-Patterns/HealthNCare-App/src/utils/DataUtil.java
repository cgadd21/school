package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
  public List<String> getLines(String fileName) {
    List<String> lines = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lines;
  }

  public void createLine(String fileName, String newLine) {
    try (FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(writer)) {
      bw.write(newLine);
      bw.newLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateLine(String fileName, String deletedLine, String updatedLine) {
    List<String> lines = getLines(fileName);
    try (FileWriter writer = new FileWriter(fileName, false);
        BufferedWriter bw = new BufferedWriter(writer)) {
      for (String line : lines) {
        bw.write(!line.equals(deletedLine) ? line : updatedLine);
        bw.newLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteLine(String fileName, String deletedLine) {
    List<String> lines = getLines(fileName);
    try (FileWriter writer = new FileWriter(fileName, false);
        BufferedWriter bw = new BufferedWriter(writer)) {
      for (String line : lines) {
        if (!line.equals(deletedLine)) {
          bw.write(line);
          bw.newLine();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
