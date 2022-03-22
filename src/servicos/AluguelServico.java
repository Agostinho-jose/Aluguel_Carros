package servicos;

import entidades.Aluguel_Carros;
import entidades.Boleto;

public class AluguelServico {

    private Double precoHora;
    private Double precoDia;

    private ServicoTaxas servicoTaxas;

    public AluguelServico(Double precoHora, Double precoDia, ServicoTaxas servicoTaxas) {
        this.precoHora = precoHora;
        this.precoDia = precoDia;
        this.servicoTaxas = servicoTaxas;
    }

    public void processandoServico(Aluguel_Carros ac){

        long t1 = ac.getSaida().getTime();
        long t2 = ac.getRetorno().getTime();
        double horas = (double) (t2-t1) / 1000 / 60 / 60;

        double pagamentoBasico;
        if(horas <= 12){
            pagamentoBasico = Math.ceil(horas) * this.precoHora;//classe para arrendondamento
        } else {
            pagamentoBasico = Math.ceil(horas/24) * this.precoDia;
        }

        double taxa = servicoTaxas.taxas(pagamentoBasico);//calculo de taxa apartir do resultado pagamento Basico;
        ac.setBoleto(new Boleto(pagamentoBasico, taxa));

    }
}

