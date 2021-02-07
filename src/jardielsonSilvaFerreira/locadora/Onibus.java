package jardielsonSilvaFerreira.locadora;

public class Onibus extends Veiculo {

    //private static int qunatidadePassageiro;
    private final int qunatidadePassageiro;

    Onibus(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int qunatidadePassageiro) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.qunatidadePassageiro = qunatidadePassageiro;
    }

    @Override
    public double retornaValorSeguro() {
        return (valorAvaliado*20/100) / 365;
    }

    public  int getQunatidadePassageiro() {
        return qunatidadePassageiro;
    }

}
