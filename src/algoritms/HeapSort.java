package algoritms;

public class HeapSort implements SortInterface {
  
  private int column;
  private Metrics metrics;
  
  public HeapSort() {
    this.column = 0;
    this.metrics = null;
  }

  @Override
  public String[][] sort(String[][] matrix, int colomunIndex, String pathToSaveMetrics) {

    this.column = colomunIndex;

    this.metrics = new Metrics(pathToSaveMetrics);
    this.metrics.start();
    this.metrics.writeMetrics();

    run(matrix);

    this.metrics.start();
    this.metrics.writeMetrics();

    return matrix;
  }

  private void run(String matrix[][]) {
    int n = matrix.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      this.metrics.start();
      this.metrics.writeMetrics();
      heapify(matrix, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      this.metrics.start();
      this.metrics.writeMetrics();
      
      String [] temp = matrix[0];
      matrix[0] = matrix[i];
      matrix[i] = temp;

      this.metrics.start();
      this.metrics.writeMetrics();

      heapify(matrix, i, 0);
    }
  }

  private void heapify(String matrix[][], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && Integer.parseInt(matrix[l][this.column]) > Integer.parseInt(matrix[largest][this.column])) {
      largest = l;
    }

    if (r < n && Integer.parseInt(matrix[r][this.column]) > Integer.parseInt(matrix[largest][this.column])) {
      largest = r;
    }

    if (largest != i) {
      String [] swap = matrix[i];
      matrix[i] = matrix[largest];
      matrix[largest] = swap;

      heapify(matrix, n, largest);
    }
  }

}
