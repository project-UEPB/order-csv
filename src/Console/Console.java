package Console;

import java.io.File;
import java.io.IOException;
import java.util.*;

import algoritms.ReadCSV;
import algoritms.SelectionSort;
import algoritms.InsertionSort;
import algoritms.MergeSort;
import algoritms.QuickSort;
import algoritms.QuickSortWithMedian3;
import algoritms.CountingSort;
import algoritms.HeapSort;


public class Console {
    Scanner entrada = new Scanner(System.in);
    boolean loading;

    File directory = new File("");
    String basePAth;
    String fileBase;

    public Console(String fileBase) {
        this.loading = false;
        this.basePAth = directory.getAbsolutePath() + "/csvs";
        this.fileBase = this.basePAth + "/base/" + fileBase;
    }

    public void menu() { 
        
        while (true) {
            
            System.out.printf("\t\t-------------------------------\n");
            System.out.printf("\t\t|      COVID DATA Brasil      |\n");
            System.out.printf("\t\t-------------------------------\n");
            System.out.printf("Pressione a tecla para executar a função correspondente:\n\n");
            System.out.printf("Digite (1) - INICIAR\n\n");
            System.out.printf("Digite (2) - SOBRE\n\n");
            System.out.printf("Digite (3) - CRÉDITOS\n\n");
            System.out.printf("Digite (0) - SAIR\n\n");
            
            int digito = getEnter();

            clearConsole();   

            if (digito == 1) {
                program();  
            }
            else if (digito == 2) {
                sobre();
            }
            else if (digito == 3) {
                creditos();
            }
            else if (digito == 0) {
                clearConsole();  
                System.out.printf(" PROGRAMA ENCERRADO !\n");
                entrada.close();
                break;
            } else {
                System.out.printf("Valor incorreto, tente novamente!\n");
                
                try { 
                    Thread.sleep (1500); 
                } catch (InterruptedException ex) {}

                clearConsole();   
            }
        }

    }

    private int getEnter() {
        int num = entrada.nextInt();
        return num;
    }

    public void program(){

        System.out.printf("\t\tSelecione o Método de Ordenação\n");
        System.out.printf("\t\t-------------------------------\n\n");
        System.out.printf("Pressione a tecla para executar a função correspondente:\n\n");
        System.out.printf("Digite (1) - Selection Sort\n\n");
        System.out.printf("Digite (2) - Insertion Sort\n\n");
        System.out.printf("Digite (3) - Merge Sort\n\n");
        System.out.printf("Digite (4) - Quick Sort\n\n");
        System.out.printf("Digite (5) - Quick Sort com Mediana de 3\n\n");
        System.out.printf("Digite (6) - Counting\n\n");
        System.out.printf("Digite (7) - HeapSort\n\n");
        System.out.printf("Digite (8) - Execultar Todos\n\n");
        System.out.printf("Digite (0) - SAIR\n\n");
        
        int digito = getEnter();
        clearConsole();   
        
        
        if (digito == 1) {

            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_casos.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new SelectionSort(true));
            
            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_obitos.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumulados.readCsv(new SelectionSort(true));

            ReadCSV cidade = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_cidades.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_cidades.csv", 
            "city", ",");

            cidade.readCsv(new SelectionSort(false));
            this.loading = false;
            clearConsole();
             

        } else if (digito == 2) {

            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/insertionSort_ordena_casos.csv", 
            this.basePAth+"/InsertionSort/metrics_insertionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new InsertionSort(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/InsertionSort_ordena_obitos.csv", 
            this.basePAth+"/InsertionSort/metrics_InsertionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumulados.readCsv(new InsertionSort(true));

            ReadCSV cidade = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/InsertionSort_ordena_cidades.csv", 
            this.basePAth+"/InsertionSort/metrics_InsertionSort_ordena_cidades.csv", 
            "city", ",");

            cidade.readCsv(new InsertionSort(false));
            this.loading = false;
            clearConsole();

        } else if (digito == 3) {

            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_casos.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_casos.csv", 
            "last_available_confirmed", ",");
            

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new MergeSort(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_obitos.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            

            obitosAcumulados.readCsv(new MergeSort(true));
            
            ReadCSV cidades = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_cidades.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_cidades.csv", 
            "city", ",");
            

            cidades.readCsv(new MergeSort(false));
            this.loading = false;

            clearConsole();
        } else if (digito == 4) {
            
            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_casos.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new QuickSort(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_obitos.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumulados.readCsv(new QuickSort(true));

            ReadCSV cidades = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_cidades.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_cidades.csv", 
            "city", ",");

            cidades.readCsv(new QuickSort(false));
            this.loading = false;

            clearConsole();

        } else if (digito == 5) {

            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_casos.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_casos.csv", 
            "last_available_confirmed", ",");
        
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();
    
            casosAcumulados.readCsv(new QuickSortWithMedian3(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_obitos.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumulados.readCsv(new QuickSortWithMedian3(true));

            ReadCSV cidades = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_cidades.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_cidades.csv", 
            "city", ",");

            cidades.readCsv(new QuickSortWithMedian3(false));
            this.loading = false;

            clearConsole();
            
        } else if (digito == 6) {
            
            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_casos.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new CountingSort(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_obitos.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumulados.readCsv(new CountingSort(true));
            
            ReadCSV cidades = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_cidades.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_cidades.csv", 
            "city", ",");

            cidades.readCsv(new CountingSort(false));
            this.loading = false;
            
            clearConsole();

        } else if (digito == 7) {

            ReadCSV casosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_casos.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new HeapSort(true));

            ReadCSV obitosAcumulados = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_obitos.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            obitosAcumulados.readCsv(new HeapSort(true));
            
            ReadCSV cidades = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_cidades.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_cidades.csv", 
            "city", ",");
            
            cidades.readCsv(new HeapSort(false));
            this.loading = false;
            
            clearConsole();
        } else if (digito == 8) {
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            // SelectionSort
            ReadCSV casosAcumuladosSelectionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_casos.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosSelectionSort.readCsv(new SelectionSort(true));
            
            ReadCSV obitosAcumuladosSelectionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_obitos.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumuladosSelectionSort.readCsv(new SelectionSort(true));

            ReadCSV cidadeSelectionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/SelectionSort/selectionSort_ordena_cidades.csv", 
            this.basePAth+"/SelectionSort/metrics_selectionSort_ordena_cidades.csv", 
            "city", ",");

            cidadeSelectionSort.readCsv(new SelectionSort(false));
            // SelectionSort


            // InsertionSort
            ReadCSV casosAcumuladosInsertionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/insertionSort_ordena_casos.csv", 
            this.basePAth+"/InsertionSort/metrics_insertionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosInsertionSort.readCsv(new InsertionSort(true));

            ReadCSV obitosAcumuladosInsertionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/InsertionSort_ordena_obitos.csv", 
            this.basePAth+"/InsertionSort/metrics_InsertionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumuladosInsertionSort.readCsv(new InsertionSort(true));

            ReadCSV cidadeInsertionSort = new ReadCSV(this.fileBase,
            this.basePAth+"/InsertionSort/InsertionSort_ordena_cidades.csv", 
            this.basePAth+"/InsertionSort/metrics_InsertionSort_ordena_cidades.csv", 
            "city", ",");

            cidadeInsertionSort.readCsv(new InsertionSort(false));
            // InsertionSort

            
            // MergeSort
            ReadCSV casosAcumuladosMergeSort = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_casos.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosMergeSort.readCsv(new MergeSort(true));

            ReadCSV obitosAcumuladosMergeSort = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_obitos.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            

            obitosAcumuladosMergeSort.readCsv(new MergeSort(true));
            
            ReadCSV cidadesMergeSort = new ReadCSV(this.fileBase,
            this.basePAth+"/MergeSort/MergeSort_ordena_cidades.csv", 
            this.basePAth+"/MergeSort/metrics_MergeSort_ordena_cidades.csv", 
            "city", ",");

            cidadesMergeSort.readCsv(new MergeSort(false));
            // MergeSort


            // QuickSort
            ReadCSV casosAcumuladosQuickSort = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_casos.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosQuickSort.readCsv(new QuickSort(true));

            ReadCSV obitosAcumuladosQuickSort = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_obitos.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumuladosQuickSort.readCsv(new QuickSort(true));

            ReadCSV cidadesQuickSort = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSort/QuickSort_ordena_cidades.csv", 
            this.basePAth+"/QuickSort/metrics_QuickSort_ordena_cidades.csv", 
            "city", ",");

            cidadesQuickSort.readCsv(new QuickSort(false));
            // QuickSort


            // QuickSortWithMedian3
            ReadCSV casosAcumuladosQuickSortWithMedian3 = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_casos.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_casos.csv", 
            "last_available_confirmed", ",");
    
            casosAcumuladosQuickSortWithMedian3.readCsv(new QuickSortWithMedian3(true));

            ReadCSV obitosAcumuladosQuickSortWithMedian3 = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_obitos.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumuladosQuickSortWithMedian3.readCsv(new QuickSortWithMedian3(true));

            ReadCSV cidadesQuickSortWithMedian3 = new ReadCSV(this.fileBase,
            this.basePAth+"/QuickSortWithMedian3/QuickSortWithMedian3_ordena_cidades.csv", 
            this.basePAth+"/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_cidades.csv", 
            "city", ",");

            cidadesQuickSortWithMedian3.readCsv(new QuickSortWithMedian3(false));
            // QuickSortWithMedian3

            
            // CountingSort
            ReadCSV casosAcumuladosCountingSort = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_casos.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosCountingSort.readCsv(new CountingSort(true));

            ReadCSV obitosAcumuladosCountingSort = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_obitos.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_obitos.csv", 
            "last_available_deaths", ",");

            obitosAcumuladosCountingSort.readCsv(new CountingSort(true));
            
            ReadCSV cidadesCountingSort = new ReadCSV(this.fileBase,
            this.basePAth+"/CountingSort/CountingSort_ordena_cidades.csv", 
            this.basePAth+"/CountingSort/metrics_CountingSort_ordena_cidades.csv", 
            "city", ",");

            cidadesCountingSort.readCsv(new CountingSort(false));
            // CountingSort


            // HeapSort
            ReadCSV casosAcumuladosHeapSort = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_casos.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            casosAcumuladosHeapSort.readCsv(new HeapSort(true));

            ReadCSV obitosAcumuladosHeapSort = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_obitos.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            obitosAcumuladosHeapSort.readCsv(new HeapSort(true));
            
            ReadCSV cidadesHeapSort = new ReadCSV(this.fileBase,
            this.basePAth+"/HeapSort/HeapSort_ordena_cidades.csv", 
            this.basePAth+"/HeapSort/metrics_HeapSort_ordena_cidades.csv", 
            "city", ",");
            
            cidadesHeapSort.readCsv(new HeapSort(false));
            // HeapSort
            
            
            this.loading = false;
            clearConsole();
        }
        else if (digito == 0) {
            clearConsole();
        } else {
            System.out.printf("Valor incorreto, tente novamente!\n");
        
            try { 
                Thread.sleep (1500); 
            } catch (InterruptedException ex) {}

            clearConsole(); 
        }
    }

    public void sobre(){
        System.out.printf("O programa COVID DATA Brasil é uma ferramenta feita com o intuito de indicar as estatísticas do avanço do COVID-19 no Brasil. Que por meio de um arquivo .csv analisa e ordena os dados utilizando os seguintes métodos:\n\t• Selection Sort;\n\t• Insertion Sort;\n\t• Merge Sort;\n\t• Quick Sort;\n\t• QuickSort com Mediana de 3;\n\t• counting;\n\t• HeapSort \n\n\n");
        promptEnterKey();
        clearConsole();
    }

    public void creditos(){
        System.out.printf("Desenvolvedores :\n\n");
        System.out.printf("João Vitor Barbosa - joao.vitor@aluno.uepb.edu.br\n\n");
        System.out.printf("Klayton Marcos - klayton.junior@aluno.uepb.edu.br\n\n");
        promptEnterKey();
        clearConsole();   
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static void clearConsole() {  
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    private void loading() {
        String [] arr = {"/", "|", "\\", "-"};
        int i = 0;
        while (this.loading) {
            System.out.printf("Processando %s \r", arr[i++]);
          
            if (i == arr.length) {
                i = 0;
            }
    
            try {
                Thread.sleep(100); 
            } catch (InterruptedException ex) {}
        }
    }

}


