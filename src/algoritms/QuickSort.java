package algoritms;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class QuickSort implements SortInterface {
  
  private int indexColumn;
  private Metrics metrics;
  private boolean sortForInt;
  private Pattern pattern;

  public QuickSort(boolean sortForInt) {
    this.indexColumn = 1;
    this.metrics = null;
    this.sortForInt = sortForInt;
    this.pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
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

  private int partitionForInt(String[][] matrix, int low, int high) {
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
  
  private int partitionForString(String[][] matrix, int low, int high) {
    String pivot = semAcento(matrix[high][this.indexColumn]).toLowerCase(); 
    int i = (low - 1);
  
    for(int j = low; j <= high - 1; j++) {
      if (!((semAcento(matrix[j][this.indexColumn]).toLowerCase())
            .compareTo(pivot) > 0)) {
        i++; 
        swap(matrix, i, j);
      }
    }

    swap(matrix, i + 1, high);
    return (i + 1);
  }

  private String semAcento(String str) {
    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
    return this.pattern.matcher(nfdNormalizedString).replaceAll("");
  }

  private void quickSort(String[][] matrix, int low, int high) {
    
    this.metrics.start();
    this.metrics.writeMetrics();

    int pi = 0;
    if (low < high) { 
      if (this.sortForInt) {
        pi = partitionForInt(matrix, low, high);
      } else {
        pi = partitionForString(matrix, low, high);
      }

      quickSort(matrix, low, pi - 1);
      quickSort(matrix, pi + 1, high);
    }

    this.metrics.start();
    this.metrics.writeMetrics();
  }
  
}
