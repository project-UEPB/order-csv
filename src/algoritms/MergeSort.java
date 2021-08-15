package algoritms;

public class MergeSort implements SortInterface {
  int indexColumn;

  public MergeSort() {
    this.indexColumn = 0;
  }

  @Override
  public String[][] sort(String[][] matrix, int colomunIndex, String pathToSaveMetrics) {
    
    this.indexColumn = colomunIndex;
    run(matrix, 0, matrix.length - 1);
    
    return matrix;
  }

  public void merge(String matrix[][], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    String L[][] = new String[n1][matrix[0].length];
    String R[][] = new String[n2][matrix[0].length];

    for (int i = 0; i < n1; ++i)
      L[i] = matrix[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = matrix[m + 1 + j];

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      if (Integer.parseInt(L[i][this.indexColumn]) <= Integer.parseInt(R[j][this.indexColumn])) {
        matrix[k] = L[i];
        i++;
      }
      else {
        matrix[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      matrix[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      matrix[k] = R[j];
      j++;
      k++;
    }
  }

  public void run(String matrix[][], int l, int r){
    if (l < r) {
      int m =l+ (r-l)/2;

      run(matrix, l, m);
      run(matrix, m + 1, r);

      merge(matrix, l, m, r);
    }
  }

}
