public class Moto extends Veiculo {


   private double cilindrada;

    Moto(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, double cilindrada) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.cilindrada = cilindrada;
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
        return (valorDiaria + retornaValorSeguro()) * dias;
    }
    public void aumentarDiaria(double taxa) {
        this.valorDiaria = this.valorDiaria + (this.valorDiaria*taxa);
    }

    @Override
    public void aumentarValorAvaliado(double taxa) {
        super.aumentarValorAvaliado(taxa);
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}
