public class Carro extends Veiculo {

    // 1 (passeio), 2 (SUV), 3 (pickup)

    final private int categoria;
    Carro(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int categoria) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.categoria = categoria;

    }




    /*
     * (valor da diária + seguro) * quantidade de dias */

    @Override
    public double retornaValorAluguel(int quantidadeDias) {
        return super.retornaValorAluguel(quantidadeDias);
    }

    @Override
    public double retornaValorSeguro() {
        return super.retornaValorSeguro();
    }

    @Override
    public void reduzirPrecoDiaria(double taxa) {
        super.reduzirPrecoDiaria(taxa);
    }

    @Override
    public void aumentarPrecoDiaria(double taxa) {
        super.aumentarPrecoDiaria(taxa);
    }


    public double aluguel(int dias) {
        return (this.valorDiaria + retornaValorSeguro()) * dias;
    }
    public void aumentarDiaria(double taxa) {
        this.valorDiaria = this.valorDiaria + (this.valorDiaria*taxa);
    }

    @Override
    public void aumentarValorAvaliado(double taxa) {
        super.aumentarValorAvaliado(taxa);
    }

    public int getCategoria() {
        return categoria;
    }

}
