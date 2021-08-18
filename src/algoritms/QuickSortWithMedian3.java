package algoritms;

public class QuickSortWithMedian3 implements SortInterface {
  
  private int column = 0;
  private Metrics metrics;

  public QuickSortWithMedian3() {
    this.column = 0;
    this.metrics = null;
  }
  
  @Override
  public String[][] sort(String[][] matrix, int colomunIndex, String pathToSaveMetrics) {
    
    this.column = colomunIndex;

    this.metrics = new Metrics(pathToSaveMetrics);
    this.metrics.start();
    this.metrics.writeMetrics();

    quickSortWithMedianOf3(matrix, 0, matrix.length - 1);

    this.metrics.start();
    this.metrics.writeMetrics();
    
    return matrix;
  }

  private void quickSortWithMedianOf3(String[][] matrix, int left, int right) {
    int size = right - left + 1;

    this.metrics.start();
    this.metrics.writeMetrics();

    if (size <= 3) {
      this.metrics.start();
      this.metrics.writeMetrics();

      manualSort(matrix, left, right);

    } else {

      this.metrics.start();
      this.metrics.writeMetrics();

      long median = medianOf3(matrix, left, right);
      int partition = partitionIt(matrix, left, right, median);
      quickSortWithMedianOf3(matrix, left, partition - 1);
      quickSortWithMedianOf3(matrix, partition + 1, right);

    }
  }

  private long medianOf3(String[][] matrix, int left, int right) {
    int center = (left + right) / 2;

    if (Integer.parseInt(matrix[left][this.column]) > Integer.parseInt(matrix[center][this.column])) {
      swap(left, center, matrix);
    }

    if (Integer.parseInt(matrix[left][this.column]) > Integer.parseInt(matrix[right][this.column])) {
      swap(left, right, matrix);
    }

    if (Integer.parseInt(matrix[center][this.column]) > Integer.parseInt(matrix[right][this.column])) {
      swap(center, right, matrix);
    }

    swap(center, right - 1, matrix);
    return Integer.parseInt(matrix[right - 1][this.column]);
  }

  private void swap(int dex1, int dex2, String[][] matrix) {
    String [] temp = matrix[dex1];
    matrix[dex1] = matrix[dex2];
    matrix[dex2] = temp;
  }

  private int partitionIt(String[][] matrix, int left, int right, long pivot) {
    int leftPtr = left;
    int rightPtr = right - 1;

    while (true) {
      
      while (Integer.parseInt(matrix[++leftPtr][this.column]) < pivot);
      while (Integer.parseInt(matrix[--rightPtr][this.column]) > pivot);

      if (leftPtr >= rightPtr) {
        break;
      } else {
        swap(leftPtr, rightPtr, matrix);
      }


    }
    swap(leftPtr, right - 1, matrix);
    return leftPtr;
  }

  private void manualSort(String[][] matrix, int left, int right) {
    int size = right - left + 1;
    
    if (size <= 1) {
      return;
    }

    if (size == 2) {
      if (Integer.parseInt(matrix[left][this.column]) > Integer.parseInt(matrix[right][this.column])) {
        swap(left, right, matrix);
      }
      return;

    } else {
      if (Integer.parseInt(matrix[left][this.column]) > Integer.parseInt(matrix[right - 1][this.column])) {
        swap(left, right - 1, matrix);
      }
      if (Integer.parseInt(matrix[left][this.column]) > Integer.parseInt(matrix[right][this.column])) {
        swap(left, right, matrix);
      }
      if (Integer.parseInt(matrix[right - 1][this.column]) > Integer.parseInt(matrix[right][this.column])) {
        swap(right - 1, right, matrix);
      }
    }
  }

}
