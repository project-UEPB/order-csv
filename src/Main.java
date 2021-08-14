import algoritms.ReadCSV;
import algoritms.SelectionSort;

public class Main {
  public static void main(String[] args) {
    ReadCSV filetest = new ReadCSV("csvs/casos_cg.csv",
    "csvs/casos_cg_selectionSort.csv", "last_available_confirmed", ",");
    
    SelectionSort selectionSort = new SelectionSort();
    filetest.readCsv(selectionSort);
    
  }  

}