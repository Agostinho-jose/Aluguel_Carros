package aplicacao;

import entidades.Aluguel_Carros;
import entidades.Veiculo;
import servicos.AluguelServico;
import servicos.ImpostoBrasil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        System.out.println("Entre com dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String modelo = scan.nextLine();

        System.out.print("Data de saída(DD/MM/YYYY HH:mm): ");
        Date dataSaida = sdf.parse(scan.nextLine());
        System.out.print("Data de retorno(DD/MM/YYYY HH:mm): ");
        Date dataRetorno = sdf.parse(scan.nextLine());
        Aluguel_Carros ac = new Aluguel_Carros(dataSaida, dataRetorno, new Veiculo(modelo));

        System.out.print("Preço por hora: ");
        double precoHora = scan.nextDouble();
        System.out.print("Preço do dia: ");
        double precoDia = scan.nextDouble();
        AluguelServico as = new AluguelServico(precoHora, precoDia, new ImpostoBrasil());
        as.processandoServico(ac);

        System.out.println("Boleto: ");
        System.out.println("Pagamento Basico: " + String.format("%.2f", ac.getBoleto().getPagamentoBasico()));
        System.out.println("Taxa: " + String.format("%.2f", ac.getBoleto().getTaxa()));
        System.out.println("Total pagamento: " + String.format("%.2f", ac.getBoleto().totalPag()));
        scan.close();
    }
}
