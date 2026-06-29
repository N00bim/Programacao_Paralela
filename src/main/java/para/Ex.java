package para;

import java.util.concurrent.*;

public class Ex {
//    public static void main(String[] args) throws InterruptedException {
//
//        System.out.println("Iniciando operação...");
//
//        // Simula uma consulta ao banco de dados
//        Thread.sleep(5000);
//
//        System.out.println("Operação concluída!");
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Object RECURSO_A = new Object();
//        Object RECURSO_B = new Object();
//
//        Thread t1 = new Thread(() -> {
//            synchronized (RECURSO_A) {
//                System.out.println("Thread 1 pegou Recurso A");
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Thread 1 esperando Recurso B");
//
//                synchronized (RECURSO_B) {
//                    System.out.println("Thread 1 terminou");
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            synchronized (RECURSO_B) {
//                System.out.println("Thread 2 pegou Recurso B");
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("Thread 2 esperando Recurso A");
//
//                synchronized (RECURSO_A) {
//                    System.out.println("Thread 2 terminou");
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            Thread.sleep(3000);
            return "Tarefa concluída!";
        });

        System.out.println("Executando outras tarefas...");

        String resultado = future.get();

        System.out.println(resultado);

        executor.shutdown();
    }
}

