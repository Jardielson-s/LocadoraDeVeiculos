public class Caminhao extends Veiculo {

    private int carga;

    Caminhao(String marca, String modelo, int anoDeFabricacao, double valorAvaliado, double valorDiaria, String placa, int carga) {
        super(marca, modelo, anoDeFabricacao, valorAvaliado, valorDiaria, placa);
        this.carga = carga;
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

    @Override
    public void depressiacaoValores(double taxa) {
        double newValor = this.valorAvaliado-(this.valorAvaliado*taxa/100);

    }
    @Override
    public void aumentarValorAvaliado(double taxa) {
        super.aumentarValorAvaliado(taxa);
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}
