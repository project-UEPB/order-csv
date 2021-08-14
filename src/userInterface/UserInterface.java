package userInterface;
import java.util.*;

public class UserInterface {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main myObj = new Main();
        myObj.menu();
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
        int digito = sc.nextInt();
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

    public void program(){
        System.out.printf("\t\tSelecione o Método de Ordenação\n");
        System.out.printf("Pressione a tecla para executar a função correspondente:\n\n");
        System.out.printf("Digite (1) - Selection Sort\n\n");
        System.out.printf("Digite (2) - Insertion Sort\n\n");
        System.out.printf("Digite (3) - Merge Sort\n\n");
        System.out.printf("Digite (4) - Quick Sort\n\n");
        System.out.printf("Digite (5) - QuickSort com Mediana de 3\n\n");
        System.out.printf("Digite (6) - counting\n\n");
        System.out.printf("Digite (7) - HeapSort\n\n");
        System.out.printf("Digite (0) - SAIR\n\n");
        int digito = sc.nextInt();
        clearConsole();   

        if (digito == 1) {
        // selectionSort();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 2) {
        // insertionSort();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 3) {
        // mergeSort();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 4) {
        // quickSort();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 5) {
        // quickSortWith3Median();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 6) {
        // counting();
        promptEnterKey();
        clearConsole();
        }
        else if (digito == 7) {
        // HeapSort();
        promptEnterKey();
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
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public final static void clearConsole() {  
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }
}


