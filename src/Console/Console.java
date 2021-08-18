package Console;
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

    public Console() {
        this.loading = false;
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
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/SelectionSort/selectionSort_ordena_casos.csv", 
            "csvs/SelectionSort/metrics_selectionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new SelectionSort(true));
            this.loading = false;
            
            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/SelectionSort/selectionSort_ordena_obitos.csv", 
            "csvs/SelectionSort/metrics_selectionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new SelectionSort(true));
            this.loading = false;

            clearConsole();

            ReadCSV cidade = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/SelectionSort/selectionSort_ordena_cidades.csv", 
            "csvs/SelectionSort/metrics_selectionSort_ordena_cidades.csv", 
            "city", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            cidade.readCsv(new SelectionSort(false));
            this.loading = false; 

            clearConsole();

        } else if (digito == 2) {
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/InsertionSort/insertionSort_ordena_casos.csv", 
            "csvs/InsertionSort/metrics_insertionSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new InsertionSort());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/InsertionSort/InsertionSort_ordena_obitos.csv", 
            "csvs/InsertionSort/metrics_InsertionSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new InsertionSort());
            this.loading = false;
            
            clearConsole();
        } else if (digito == 3) {
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/MergeSort/MergeSort_ordena_casos.csv", 
            "csvs/MergeSort/metrics_MergeSort_ordena_casos.csv", 
            "last_available_confirmed", ",");
            

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new MergeSort());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/MergeSort/MergeSort_ordena_obitos.csv", 
            "csvs/MergeSort/metrics_MergeSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new MergeSort());
            this.loading = false;
            
            clearConsole();
        } else if (digito == 4) {
            
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/QuickSort/QuickSort_ordena_casos.csv", 
            "csvs/QuickSort/metrics_QuickSort_ordena_casos.csv", 
            "last_available_confirmed", ",");
            

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new QuickSort());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/QuickSort/QuickSort_ordena_obitos.csv", 
            "csvs/QuickSort/metrics_QuickSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new QuickSort());
            this.loading = false;

            clearConsole();
        } else if (digito == 5) {
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/QuickSortWithMedian3/QuickSortWithMedian3_ordena_casos.csv", 
            "csvs/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_casos.csv", 
            "last_available_confirmed", ",");
        
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();
    
            casosAcumulados.readCsv(new QuickSortWithMedian3());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/QuickSortWithMedian3/QuickSortWithMedian3_ordena_obitos.csv", 
            "csvs/QuickSortWithMedian3/metrics_QuickSortWithMedian3_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new QuickSortWithMedian3());
            this.loading = false;

            clearConsole();
        } else if (digito == 6) {
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/CountingSort/CountingSort_ordena_casos.csv", 
            "csvs/CountingSort/metrics_CountingSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new CountingSort());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/CountingSort/CountingSort_ordena_obitos.csv", 
            "csvs/CountingSort/metrics_CountingSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new CountingSort());
            this.loading = false;
            
            clearConsole();
        } else if (digito == 7) {
            ReadCSV casosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/HeapSort/HeapSort_ordena_casos.csv", 
            "csvs/HeapSort/metrics_HeapSort_ordena_casos.csv", 
            "last_available_confirmed", ",");

            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            casosAcumulados.readCsv(new HeapSort());
            this.loading = false;

            clearConsole();

            ReadCSV obitosAcumulados = new ReadCSV("csvs/base/casos_cg.csv",
            "csvs/HeapSort/HeapSort_ordena_obitos.csv", 
            "csvs/HeapSort/metrics_HeapSort_ordena_obitos.csv", 
            "last_available_deaths", ",");
            
            this.loading = true;
            new Thread() {
                @Override
                public void run() {
                    loading();
                }
            }.start();

            obitosAcumulados.readCsv(new HeapSort());
            this.loading = false;
            
            clearConsole();
        } else if (digito == 8) {
            
            
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


