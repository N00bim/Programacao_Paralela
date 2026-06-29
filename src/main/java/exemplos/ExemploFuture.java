package exemplos;

import java.util.concurrent.*;

public class ExemploFuture {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> resultado = executor.submit(() -> {
            Thread.sleep(3000); // Simula um cálculo demorado
            return 2 + 3;
        });

        System.out.println("Fazendo outras coisas...");

        // Espera o resultado ficar pronto
        System.out.println("Resultado: " + resultado.get());

        executor.shutdown();
    }
}
