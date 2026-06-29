package exemplos;

import java.util.concurrent.*;

public class ExemploCompletableFuture {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {}

                    return 2 + 3;
                })
                .thenAccept(resultado ->
                        System.out.println("Resultado: " + resultado)
                );

        System.out.println("Fazendo outras coisas...");
    }
}
