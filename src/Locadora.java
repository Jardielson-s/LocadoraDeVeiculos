import java.util.ArrayList;

public abstract class Locadora {

   // public abstract void inserir(Veiculos v);
    public abstract void inserir(Cliente c);
    public abstract <pesquisarMoto> Veiculo pesquisar(String placa);

    public abstract ArrayList<Veiculo> pesquisarMoto(int cilindrada);
    // tipo de carro
    // 1 (passeio), 2 (SUV), 3 (pickup)
    public abstract ArrayList<Veiculo> pesquisarCarro(int tipoCarro);
    public abstract ArrayList<Veiculo> pesquisarCaminhao(int carga);
    public abstract ArrayList<Veiculo> pesquisarOnibus(int passageiros);

    //Seguro Moto = (valor do bem * 11%)/365
    //Seguro Carro = (valor do bem * 3%)/365
    //Seguro Caminhão = (valor do bem * 8%)/365
    //Seguro Ônibus = (valor do bem * 20%)/365
    //Aluguel = (valor da diária + seguro) * quantidade de dias
    public abstract double calcularAluguel(String placa, int dias);
    public abstract void registrarAluguel(Veiculo placa, int dias, Cliente c);
    public abstract void registrarDevolucao(String placa, Cliente c);

    // tipo de veiculo
    // 0 (todos), 1 (moto), 2 (carro), 3 (caminhão), 4 (ônibus)
    public abstract void depreciarVeiculos(int tipo, double taxaDepreciacao);
    public abstract void aumentarDiaria(int tipo, double taxaAumento);
    public abstract double faturamentoTotal(int tipo);
    public abstract int quantidadeTotalDeDiarias(int tipo);
}
