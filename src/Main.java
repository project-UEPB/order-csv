import Console.Console;

public class Main {
  public static void main(String[] args) {
    
    Console console = new Console("caso_full_tratado.csv");
    
    // Console console = new Console("MelhorCaso_obitos.csv");
    // Console console = new Console("MelhorCaso_cidades.csv");
    // Console console = new Console("MelhorCaso_casos.csv");

    // Console console = new Console("PiorCaso_obitos.csv");
    // Console console = new Console("PiorCaso_cidades.csv");
    // Console console = new Console("PiorCaso_casos.csv");

    console.menu();

  }
}
