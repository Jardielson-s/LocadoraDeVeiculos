public class Veiculo {
    private String marca;
    private String modelo;
    private int anoDeFabricacao;
    protected double valorAvaliado;
    protected double valorDiaria;
    private String placa;


    Veiculo(String marca, String modelo, int anoDeFabricacao,
            double valorAvaliado, double valorDiaria,
            String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valorAvaliado = valorAvaliado;
        this.valorDiaria = valorDiaria;
        this.placa = placa;

    }
    public double retornaValorSeguro(){
        return (valorAvaliado*8/100)/365;
    }

    public double retornaValorAluguel(int quantidadeDias){
        return ((valorDiaria + retornaValorSeguro()) * quantidadeDias);
    }

    public void reduzirPrecoDiaria(double taxa){
         this.valorDiaria = valorDiaria - (taxa * 10/100);
    }

    public void aumentarPrecoDiaria(double taxa){
        this.valorDiaria = valorDiaria + ((valorDiaria * taxa) /100);
    }

    public void depressiacaoValores(double taxa) {
        this.valorAvaliado = this.valorAvaliado-(this.valorAvaliado*taxa/100);
    }

    public void aumentarValorAvaliado(double taxa){
        this.valorAvaliado = valorAvaliado + ((valorAvaliado * taxa) / 100);
    }

    public double getValorAvaliado() {
        return valorAvaliado;
    }

    public void setValorAvaliado(double valorAvaliado) {
        this.valorAvaliado = valorAvaliado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
