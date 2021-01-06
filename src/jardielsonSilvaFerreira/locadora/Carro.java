package jardielsonSilvaFerreira.locadora;

public class Carro extends Veiculo {

    // 1 (passeio), 2 (SUV), 3 (pickup)

    final private int tipo;

    Carro(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int categoria) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.tipo = categoria;

    }

    @Override
    public double retornaValorSeguro() {
        return (valorAvaliado*3/100) / 365;
    }



    public int getTipo() {
        return tipo;
    }

}
