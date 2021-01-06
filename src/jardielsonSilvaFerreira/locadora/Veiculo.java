package jardielsonSilvaFerreira.locadora;

abstract public class Veiculo {
    protected String marca;
    protected String modelo;
    protected int anoDeFabricacao;
    protected double valorAvaliado;
    protected double valorDiaria;
    protected String placa;


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
    abstract public double retornaValorSeguro();


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

    // MÉTODOS QUE SE APLICAM A TODAS AS CLASSES QUE ENRDAM DE VEICULOS

    public void reduzirPrecoDiaria(double taxa) {
        this.valorDiaria = valorDiaria - taxa;
    }

    public double retornaValorAluguel(int quantidadeDias) {
        return ((valorDiaria + retornaValorSeguro()) * quantidadeDias);
    }


    public void aumentarPrecoDiaria(double taxa) {
        this.valorDiaria = getValorDiaria() + ((getValorDiaria() * taxa));
    }

    public void depressiacaoValores(double taxa) {
        this.valorAvaliado = this.valorAvaliado-(this.valorAvaliado*taxa);
    }


    public void aumentarValorAvaliado(double taxa) {
        this.valorAvaliado = valorAvaliado + ((valorAvaliado * taxa));
    }

}
