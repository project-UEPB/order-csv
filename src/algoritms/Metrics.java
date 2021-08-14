package algoritms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Metrics {
  private double freeMem;
  private double allocatedMem;
  private double maxMem;
  private double totalFreeMem;
  private FileWriter arq;
  private PrintWriter gravarArq;
  private String pathToSave;

  public Metrics(String pathToSave) {
    this.freeMem = 0;
    this.allocatedMem = 0;
    this.maxMem = 0;
    this.totalFreeMem = 0;
    this.pathToSave = pathToSave;

    try {
      this.arq = new FileWriter(pathToSave);
      this.gravarArq = new PrintWriter(arq);
      this.gravarArq.println("free_memory,allocated_memory,max_memory,total_memory,milliseconds");
      this.gravarArq.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    Runtime runtime = Runtime.getRuntime();
    
    this.freeMem = runtime.freeMemory() / 1024;
    this.allocatedMem = runtime.totalMemory() / 1024;
    this.maxMem = runtime.maxMemory() / 1024;
    this.totalFreeMem = (runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory())) / 1024;
  }

  public void writeMetrics() {
    try {
      BufferedWriter arq = new BufferedWriter(new FileWriter(this.pathToSave, true));
      
      arq.append(getStringMetrics());
      arq.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String getStringMetrics() {
    String auxFreeMem = Double.toString(this.freeMem).replace(",", ".");
    String auxAllocatedMem = Double.toString(this.allocatedMem).replace(",", ".");
    String auxMaxMem = Double.toString(this.maxMem).replace(",", ".");
    String auxTotalFreeMem = Double.toString(this.totalFreeMem).replace(",", ".");

    String metrics = String.format("%s,%s,%s,%s,%d\n", auxFreeMem, 
                                                    auxAllocatedMem,
                                                    auxMaxMem,
                                                    auxTotalFreeMem,
                                                    System.currentTimeMillis());

    return metrics;
  }
}
