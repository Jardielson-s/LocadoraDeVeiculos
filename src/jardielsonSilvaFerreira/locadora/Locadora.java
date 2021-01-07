package jardielsonSilvaFerreira.locadora;

import java.util.ArrayList;
import java.util.Date;

public abstract class Locadora {

 ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
 ArrayList<Cliente> clientes = new ArrayList<Cliente>();
 ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

 public abstract boolean inserir(Veiculo v);

 public boolean inserir(Cliente c) {
  Cliente cliente = pesquisarCliente(c.getCpf());
  if (cliente == null) {
   clientes.add(c);
   return true;
  }
  return false;
 }

 protected Cliente pesquisarCliente(int cpf) {
  for (Cliente c : clientes) {
   if (c.getCpf() == cpf) {
    return c;
   }
  }
  return null;
 }
 // Retorna as motos com cilindrada maior ou igual a pesquisada.
 public abstract ArrayList<Veiculo> pesquisarMoto(int cilindrada);
 // tipo de carro
// 1 (passeio), 2 (SUV), 3 (pickup)
 public abstract ArrayList<Veiculo> pesquisarCarro(int tipoCarro);
 // Retorna os caminhões com capacidade de carga maior ou igual a pesquisada.
 public abstract ArrayList<Veiculo> pesquisarCaminhao(int carga);
 // Retorna os ônibus com capacidade de passageiros maior ou igual a pesquisada.
 public abstract ArrayList<Veiculo> pesquisarOnibus(int passageiros);

 //Seguro Moto = (valor do bem * 11%)/365
//Seguro Carro = (valor do bem * 3%)/365
//Seguro Caminhão = (valor do bem * 8%)/365
//Seguro Ônibus = (valor do bem * 20%)/365
//Aluguel = (valor da diária + seguro) * quantidade de dias
 public abstract double calcularAluguel(String placa, int dias) ;
 // Retorna falso se veiculo não existir ou se estiver alugado.
 public abstract boolean registrarAluguel(String placa, Date data, int dias, int cpf);
 // Retorna falso se veiculo não existir ou se não estiver alugado.
 public abstract boolean registrarDevolucao(String placa);

 // tipo de veiculo
// 0 (todos), 1 (moto), 2 (carro), 3 (caminhão), 4 (ônibus)
 public abstract void depreciarVeiculos(int tipo, double taxaDepreciacao);
 public abstract void aumentarDiaria(int tipo, double taxaAumento);

 // Retorna o valor total de faturamento para um tipo de veículo, durante um período.
// Os alugueis devem começar e terminar dentro do período.
 public abstract double faturamentoTotal(int tipo, Date inicio, Date fim);
 // Retorna a quantidade total de diárias de aluguel para um tipo de veículo, durante um período.
// Os alugueis devem começar e terminar dentro do período.
 public abstract int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim);
}