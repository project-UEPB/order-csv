package algoritms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCSV {

  private String filePath;
  private String sep;

  public ReadCSV(String filePath, String sep) {
    this.filePath = filePath;
    this.sep = sep.length() == 0 ? "," : sep;
  }

  public void readCsv() {

    String arquivoCSV = this.filePath;
    BufferedReader br = null;
    String linha = "";

    int lineSize = lineSize();
    int columnSize = columnsSize();
    String [][] matrix = new String[lineSize][columnSize];
    int i = 0;

    try {

      br = new BufferedReader(new FileReader(arquivoCSV));
      while ((linha = br.readLine()) != null) {

        matrix[i++] = linha.split(this.sep);

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private int lineSize() {

    String arquivoCSV = this.filePath;
    BufferedReader br = null;
    int lines = 0;

    try {

      br = new BufferedReader(new FileReader(arquivoCSV));
      while (br.readLine() != null) {
        lines++;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return lines;
  }

  private int columnsSize () {
    String arquivoCSV = filePath;
    BufferedReader br = null;

    int columns = 0;

    try {

      br = new BufferedReader(new FileReader(arquivoCSV));
      String [] lineColumn = br.readLine().split(this.sep);
      
      for (int i = 0; i < lineColumn.length; i++) {
        columns++;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return columns;
  }

}
