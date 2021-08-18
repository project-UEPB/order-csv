package algoritms;

public class QuickSortWithMedian3 implements SortInterface {
  
  private int column = 0;
  private Metrics metrics;
  private boolean sortForInt;
  private long pivotInt;
  private String pivotString;

  public QuickSortWithMedian3(boolean sortForInt) {
    this.column = 0;
    this.metrics = null;
    this.sortForInt = sortForInt;
    this.pivotInt = 0;
    this.pivotString = null;
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

      if (this.sortForInt) {
        manualSortInt(matrix, left, right);
      } else {
        manualSortString(matrix, left, right);
      }

    } else {

      this.metrics.start();
      this.metrics.writeMetrics();

      if (this.sortForInt) {
        this.pivotInt = medianOf3Int(matrix, left, right);        
      } else {
        this.pivotString = medianOf3String(matrix, left, right).toLowerCase();
      }

      int partition = partitionIt(matrix, left, right);
      quickSortWithMedianOf3(matrix, left, partition - 1);
      quickSortWithMedianOf3(matrix, partition + 1, right);

    }
  }

  private long medianOf3Int(String[][] matrix, int left, int right) {
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
  
  private String medianOf3String(String[][] matrix, int left, int right) {
    int center = (left + right) / 2;

    if (((int) matrix[left][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[center][this.column].toLowerCase().toCharArray()[0])) {
      swap(left, center, matrix);
    }

    if (((int) matrix[left][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right][this.column].toLowerCase().toCharArray()[0])) {
      swap(left, right, matrix);
    }

    if (((int) matrix[center][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right][this.column].toLowerCase().toCharArray()[0])) {
      swap(center, right, matrix);
    }

    swap(center, right - 1, matrix);
    return matrix[right - 1][this.column].toLowerCase();
  }

  private void swap(int dex1, int dex2, String[][] matrix) {
    String [] temp = matrix[dex1];
    matrix[dex1] = matrix[dex2];
    matrix[dex2] = temp;
  }

  private int partitionIt(String[][] matrix, int left, int right) {
    int leftPtr = left;
    int rightPtr = right - 1;

    while (true) {
      
      if (this.sortForInt) {
        while (Integer.parseInt(matrix[++leftPtr][this.column]) < this.pivotInt);
        while (Integer.parseInt(matrix[--rightPtr][this.column]) > this.pivotInt);
      } else {
        while (((int) (matrix[++leftPtr][this.column].toLowerCase().toCharArray()[0])) < ((int)(this.pivotString.toLowerCase().toCharArray()[0])));
        while (((int) (matrix[--rightPtr][this.column].toLowerCase().toCharArray()[0])) > ((int)(this.pivotString.toLowerCase().toCharArray()[0])));
      }

      if (leftPtr >= rightPtr) {
        break;
      } else {
        swap(leftPtr, rightPtr, matrix);
      }

    }

    swap(leftPtr, right - 1, matrix);
    return leftPtr;
  }

  private void manualSortInt(String[][] matrix, int left, int right) {
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

  private void manualSortString(String[][] matrix, int left, int right) {
    int size = right - left + 1;
    
    if (size <= 1) {
      return;
    }

    if (size == 2) {
      if (((int) matrix[left][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right][this.column].toLowerCase().toCharArray()[0])) {
        swap(left, right, matrix);
      }
      return;

    } else {
      if (((int) matrix[left][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right - 1][this.column].toLowerCase().toCharArray()[0])) {
        swap(left, right - 1, matrix);
      }
      if (((int) matrix[left][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right][this.column].toLowerCase().toCharArray()[0])) {
        swap(left, right, matrix);
      }
      if (((int) matrix[right - 1][this.column].toLowerCase().toCharArray()[0]) > ((int) matrix[right][this.column].toLowerCase().toCharArray()[0])) {
        swap(right - 1, right, matrix);
      }
    }
  }

}
