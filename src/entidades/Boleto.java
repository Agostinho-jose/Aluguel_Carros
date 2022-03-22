package entidades;

public class Boleto {

   private Double pagamentoBasico;
   private Double taxa;

    public Boleto() {
    }

    public Boleto(Double pagamentoBasico, Double taxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxa = taxa;
    }

    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(Double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double totalPag(){
        return this.getTaxa()+this.getPagamentoBasico();
    }
}
