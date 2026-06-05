package para;

public class ValidadorFraude {

    public static boolean ehSuspeita(Transacao t) {
        boolean ehFraude = false;
        try {
        // Simula uma análise pesada ou latência de rede
            Thread.sleep(20);
            ehFraude = t.getValor() > 5000 && t.getCpfCliente().startsWith("000");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return ehFraude;
    }
}
