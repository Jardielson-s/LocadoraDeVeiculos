package jardielsonSilvaFerreira.locadora;

public class Caminhao extends Veiculo {

    private final int carga;

    Caminhao(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int carga) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.carga = carga;
    }

    @Override
    public double retornaValorSeguro() {
        return (valorAvaliado*8/100) / 365;
    }


    public int getCarga() {
        return carga;
    }

}
