public class Onibus extends Veiculo {

    private int qunatidadePassageiro;

    Onibus(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int qunatidadePassageiro) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.qunatidadePassageiro = qunatidadePassageiro;
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

    public int getQunatidadePassageiro() {
        return qunatidadePassageiro;
    }

    public void setQunatidadePassageiro(int qunatidadePassageiro) {
        this.qunatidadePassageiro = qunatidadePassageiro;
    }
}
