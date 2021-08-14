package algoritms;

public class SelectionSort implements SortInterface {
  
  @Override
  public String [][] sort(String[][] matrix, int colomunIndex) {

    Metrics metrics = new Metrics("csvs/Metrics_selectionSort.csv");
    metrics.start();
    metrics.writeMetrics();

    for (int i = 0; i < matrix.length-2; i++) {
      int min_idx = i;
      for (int j = i+1; j < matrix.length; j++) {
        if (Integer.parseInt(matrix[j][colomunIndex]) < Integer.parseInt(matrix[min_idx][colomunIndex])) {
          min_idx = j;
        }
        metrics.start();
        metrics.writeMetrics();
      }

      String [] temp = matrix[min_idx];
      matrix[min_idx] = matrix[i];
      matrix[i] = temp;

      metrics.start();
      metrics.writeMetrics();
    }

    metrics.start();
    metrics.writeMetrics();
    
    return matrix;
  }
}