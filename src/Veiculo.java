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

    abstract public double retornaValorAluguel(int quantidadeDias);

    abstract public void reduzirPrecoDiaria(double taxa);

    abstract public void aumentarPrecoDiaria(double taxa);

    abstract public void depressiacaoValores(double taxa);

    abstract public void aumentarValorAvaliado(double taxa);

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
