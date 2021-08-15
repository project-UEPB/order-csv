package algoritms;

public class InsertionSort implements SortInterface {
  @Override
  public String[][] sort(String[][] matrix, int colomunIndex, String pathToSaveMetrics) {
    
    Metrics metrics = new Metrics(pathToSaveMetrics);
    metrics.start();
    metrics.writeMetrics();
    
    int key, j;
    for (int i = 0; i < matrix.length; i++) {
      key = Integer.parseInt(matrix[i][colomunIndex]);
      String [] keyRow = matrix[i];
      j = i - 1;

      while ((j >= 0) && (Integer.parseInt(matrix[j][colomunIndex]) > key)) {
        matrix[j+1] = matrix[j];
        j = j - 1;
        
        metrics.start();
        metrics.writeMetrics();
      }
      
      matrix[j+1] = keyRow;
      
      metrics.start();
      metrics.writeMetrics();
    }

    metrics.start();
    metrics.writeMetrics();

    return matrix;
  }
}
