package servicos;

public class ImpostoBrasil implements ServicoTaxas {

    public double taxas(double valor){
        if(valor <= 100){
            return valor * 0.2;
        }
        else {
            return valor * 0.15;
        }
    }
}
