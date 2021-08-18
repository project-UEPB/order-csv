package algoritms;

public class QuickSort implements SortInterface {
  
  int indexColumn;
  Metrics metrics;
  public QuickSort() {
    this.indexColumn = 1;
    this.metrics = null;
  }

  @Override
  public String[][] sort(String[][] matrix, int colomunIndex, String pathToSaveMetrics) {
    this.indexColumn = colomunIndex;

    this.metrics = new Metrics(pathToSaveMetrics);
    this.metrics.start();
    this.metrics.writeMetrics();
    
    quickSort(matrix, 0, matrix.length - 1);
    
    this.metrics.start();
    this.metrics.writeMetrics();

    return matrix;
  }

  private void swap(String[][] matrix, int i, int j) {
    String [] temp = matrix[i];
    matrix[i] = matrix[j];
    matrix[j] = temp;
  }

  private int partition(String[][] matrix, int low, int high) {
    int pivot = Integer.parseInt(matrix[high][this.indexColumn]); 
    int i = (low - 1); 
  
    for(int j = low; j <= high - 1; j++) {
      if (Integer.parseInt(matrix[j][this.indexColumn]) < pivot) {
        i++; 
        swap(matrix, i, j);
      }
    }

    swap(matrix, i + 1, high);
    return (i + 1);
  }

  private void quickSort(String[][] matrix, int low, int high) {
    
    this.metrics.start();
    this.metrics.writeMetrics();

    if (low < high) { 
      int pi = partition(matrix, low, high);

      quickSort(matrix, low, pi - 1);
      quickSort(matrix, pi + 1, high);
    }

    this.metrics.start();
    this.metrics.writeMetrics();
  }
  
}
