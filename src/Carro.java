public class Carro extends Veiculo {

    // 1 (passeio), 2 (SUV), 3 (pickup)

    final private int categoria;

    Carro(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int categoria) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.categoria = categoria;

    }

    @Override
    public double retornaValorSeguro() {
        return (valorAvaliado*3/100) / 365;
    }

    @Override
    public double retornaValorAluguel(int quantidadeDias) {
        return ((valorDiaria + retornaValorSeguro()) * quantidadeDias);
    }

    @Override
    public void reduzirPrecoDiaria(double taxa) {
        this.valorDiaria = valorDiaria - (taxa * 10/100);
    }

    @Override
    public void aumentarPrecoDiaria(double taxa) {
        this.valorDiaria = getValorDiaria() + ((getValorDiaria() * taxa) /100);
    }

    @Override
    public void depressiacaoValores(double taxa) {
        this.valorAvaliado = this.valorAvaliado-(this.valorAvaliado*taxa/100);
    }

    @Override
    public void aumentarValorAvaliado(double taxa) {
        this.valorAvaliado = valorAvaliado + ((valorAvaliado * taxa) / 100);
    }

    public int getCategoria() {
        return categoria;
    }

}
