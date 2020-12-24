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

    public double getCilindrada() {
        return cilindrada;
    }


    /*
     * (valor da diária + seguro) * quantidade de dias

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

     */
}
