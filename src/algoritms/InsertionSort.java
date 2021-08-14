package algoritms;

public class InsertionSort extends ReadCSV {
  
  InsertionSort(String filePath, String sep) {
    super(filePath, sep);
  }
  
  public static void printMatrix(String [][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.printf(" %s ", matrix[i][j]);
      }
      System.out.println();
    }
  }
}
