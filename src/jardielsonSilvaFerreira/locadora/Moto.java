package jardielsonSilvaFerreira.locadora;

public class Moto extends Veiculo {


   private final double cilindrada;

    Moto(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, double cilindrada) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.cilindrada = cilindrada;
    }

    @Override
    public double retornaValorSeguro() {

        return (valorAvaliado*11/100) / 365;
    }



    public double getCilindrada() {
        return cilindrada;
    }

}
