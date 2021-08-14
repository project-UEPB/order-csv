package algoritms;

public class InsertionSort implements SortInterface {
  
  @Override
  public String [][] sort(String[][] matrix, int colomunIndex) {
    // TODO Auto-generated method stub
    
    // for (int i = 1; i < vetor.length; i++){ 
    //   int aux = vetor[i];
    //   int j = i;
      
    //   while ((j > 0) && (vetor[j-1] > aux)){
    //     vetor[j] = vetor[j-1];
    //     j -= 1;
    //   }
    //   vetor[j] = aux;
    // }

    return matrix;
  }
}

/*
public void insertionSort(int[] vetor){
  for (int i = 1; i < vetor.length; i++){ 
    int aux = vetor[i];
    int j = i;
    
    while ((j > 0) && (vetor[j-1] > aux)){
      vetor[j] = vetor[j-1];
      j -= 1;
    }
    vetor[j] = aux;
  }
}
*/
