package para;

public class Transacao {
    private String id;
    private double valor;
    private String status;
    private String CpfCliente;

    public Transacao(String id, double valor, String cpfCliente) {
        this.id = id;
        this.valor = valor;
        this.status = "PROCESSANDO";
        this.CpfCliente = cpfCliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpfCliente() {
        return CpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        CpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "Id:" + getId() + "\tValor:" + String.format("%.2f", valor) + "\tCPF:" + getCpfCliente();
    }
}
