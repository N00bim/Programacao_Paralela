package para;
import java.util.ArrayList;
import java.util.Random;

public class GeradorTransacoes {

    public static void gerador(ArrayList<Transacao> transacao, int quantidade){
        Random random = new Random();

        for(int i = 0; i < quantidade-2; i++){
            StringBuilder cpf = new StringBuilder();

            //Fraudes
            if(random.nextInt(20) == 0){
                cpf.append("000");
                for(int j = 0; j < 8; j++){
                    cpf.append(random.nextInt(10));
                }

                transacao.add(new Transacao(String.valueOf(i + 1), (random.nextDouble(10000) + 5000), cpf.toString()));

            }

            //Não fraudes
            else {
                for (int j = 0; j < 11; j++) {
                    int digito = random.nextInt(10);
                }
                transacao.add(new Transacao(String.valueOf(i + 1), random.nextDouble(100000), cpf.toString()));
            }
        }

        //Garantia que havera uma fraude
        transacao.add(new Transacao(String.valueOf(quantidade),7250, "00000000000"));
    }
}
