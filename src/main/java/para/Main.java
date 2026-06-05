package para;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        //Declarações
        double inicio, fim;
        ArrayList<Transacao> transacao = new ArrayList<>();
        GeradorTransacoes.gerador(transacao, 1000);

        System.out.println("Iniciando...");

        //Sequencial
        inicio = System.currentTimeMillis();
        List<Transacao> tSuspeitaSequencial = transacao.stream().filter(ValidadorFraude::ehSuspeita).toList();
        fim = System.currentTimeMillis();

        System.out.println("Tempo stream sequencial: " + (fim - inicio) + "ms");
        System.out.println("Transações suspeitas: " + tSuspeitaSequencial.size());
        tSuspeitaSequencial.forEach(System.out::println);

        System.out.println("\n-------------\n");

        //Paralelo
        inicio = System.currentTimeMillis();
        List<Transacao> tSuspeitaParalelo = transacao.parallelStream().filter(ValidadorFraude::ehSuspeita).toList();
        fim = System.currentTimeMillis();

        System.out.println("Tempo stream paralelo: " + (fim - inicio) + "ms");
        System.out.println("Transações suspeitas: " + tSuspeitaParalelo.size());
        tSuspeitaParalelo.forEach(System.out::println);

        System.out.println("\n-------------\n");




        //Ex BONUS
        //Paralelismo Usando ArrayList externo ------------------------------------
        System.out.println("Iniciando parte 2...");

        ArrayList<Transacao> transacao2 = new ArrayList<>();
        GeradorTransacoes.gerador(transacao2, 200);

        //Modo errado
        ArrayList<Transacao> listaPerigosa = new ArrayList<>();
        transacao2.parallelStream().filter(ValidadorFraude::ehSuspeita)
                .forEach(t -> listaPerigosa.add(t)); //Pode causar problemas como adicionar duas vezes um msm ou deixar de adicionar um

        System.out.println("Lista Perigosa: " + listaPerigosa.size());
        listaPerigosa.forEach(System.out::println);


        System.out.println("\n-------------\n");


        //Modo certo
        List<Transacao> lista = new ArrayList<>();
        transacao2.parallelStream().filter(ValidadorFraude::ehSuspeita)
                .collect(Collectors.toList()).forEach(t -> lista.add(t)); //ToList garante que tudo fique em ordem

        System.out.println("Lista Correta: " + lista.size());
        lista.forEach(System.out::println);
    }
}
