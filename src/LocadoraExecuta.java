import java.util.ArrayList;


public class LocadoraExecuta extends Locadora {


    ArrayList<Veiculo> RepositorioVendas = new ArrayList<>();
    ArrayList<Aluguel> alugueis = new ArrayList<>();
    public boolean pesquisarPlaca(Veiculo v){
        for(Veiculo aux : RepositorioVendas){
            if(v.getPlaca().equals(aux.getPlaca())){
                return true;
            }
        }
        return false;
    }
    public boolean inserir(Veiculo v) {
        if(pesquisarPlaca(v))
        {
           return false;
        }else
        {
            RepositorioVendas.add(v);
            return true;
        }

    }
 public void inserirAlugel(Aluguel a){

        alugueis.add(a);

 }
    @Override
    public void inserir(Cliente c) {

    }

    @Override
    public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
        return null;
    }

    @Override
    public Veiculo pesquisar(String placa) {
        for(Veiculo aux : RepositorioVendas) {
            if (aux.getPlaca().equals(placa)) {
                return aux;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
        ArrayList<Veiculo> aux= new ArrayList<Veiculo>();
        for(Veiculo aux1 : RepositorioVendas){
            if(aux1 instanceof Carro){
                if(((Carro) aux1).getCategoria() == tipoCarro){
                    RepositorioVendas.add(aux1);
                }
            }
        }
        return aux;
    }

    @Override
    public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
        ArrayList<Veiculo> aux= new ArrayList<Veiculo>();
        for(Veiculo aux1 : RepositorioVendas){
            if( aux1 instanceof Caminhao){
                if(((Caminhao) aux1).getCarga() == carga){
                   RepositorioVendas.add(aux1);
                }
            }
        }
        return aux;
    }

    @Override
    public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for(Veiculo aux1 : RepositorioVendas){
            if(aux1 instanceof Onibus){
                RepositorioVendas.add(aux1);
            }
        }
        return aux;
    }

    @Override
    public double calcularAluguel(String placa, int dias) {
       for(Veiculo aux : RepositorioVendas){
           if(aux.getPlaca().equals(placa)){
               return aux.retornaValorAluguel(dias);
           }
       }
       return 0;
    }

    @Override
    public void registrarAluguel(Veiculo placa, int dias, Cliente c) {
       /* for(Aluguel x: alugueis) {
            if(x.getVeiculo().equals(placa)){
                return false;
            }
       */ //}
        for(Veiculo aux : RepositorioVendas){
            if(aux.getPlaca().equals(placa)){
               Cliente cli = c;
               Aluguel auxAl = new Aluguel();
               auxAl.cadastrar(placa,dias,c);
               alugueis.add(auxAl);
            }
        }

    }

    @Override
    public void registrarDevolucao(String placa, Cliente c) {
        for(Aluguel x: alugueis) {
            if(x.getVeiculo().equals(placa)) {
                x.setAlugado(false);
            }
        }
    }

    @Override
    public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
          switch (tipo){
              case 0:
                  for(Veiculo aux: RepositorioVendas) {
                      aux.depressiacaoValores(taxaDepreciacao);
                  }
                  for(Aluguel aux1 : alugueis) {
                      Veiculo aux2;
                      aux2 = aux1.getVeiculo();
                      aux2.depressiacaoValores(taxaDepreciacao);
                      aux1.setVeiculo(aux2);
                  }
                  break;
              case 1:
                  for(Veiculo aux: RepositorioVendas) {
                      if(aux instanceof Moto){
                          aux.depressiacaoValores(taxaDepreciacao);
                      }
                  }
                  for(Aluguel aux : alugueis){
                      Veiculo aux1 = aux.getVeiculo();
                      if(aux1 instanceof Moto){
                          Veiculo aux3;
                          aux3 = aux.getVeiculo();
                          aux3.depressiacaoValores(taxaDepreciacao);
                          aux.setVeiculo(aux3);
                      }
                  }
                  break;
              case 2:
                  for(Veiculo aux : RepositorioVendas){
                     if(aux instanceof Carro){
                         aux.depressiacaoValores(taxaDepreciacao);
                     }
                  }
                  for(Aluguel aux : alugueis){
                      Veiculo aux1 = aux.getVeiculo();
                      if(aux1 instanceof Carro){
                          Veiculo aux2;
                          aux2 = aux.getVeiculo();
                          aux2.depressiacaoValores(taxaDepreciacao);
                          aux.setVeiculo(aux2);
                      }
                  }
                  break;
              case 3:
                  for(Veiculo aux : RepositorioVendas){
                      if(aux instanceof Caminhao){
                          aux.depressiacaoValores(taxaDepreciacao);
                      }
                  }
                  for(Aluguel aux : alugueis){
                      Veiculo aux1 = aux.getVeiculo();
                      if(aux1 instanceof Caminhao){
                          Veiculo aux2;
                          aux2 = aux.getVeiculo();
                          aux2.depressiacaoValores(taxaDepreciacao);
                          aux.setVeiculo(aux2);
                      }
                  }
                  break;
              case 4:
                  for(Veiculo aux : RepositorioVendas){
                      if(aux instanceof Onibus){
                          aux.depressiacaoValores(taxaDepreciacao);
                      }
                  }
                  for(Aluguel aux : alugueis){
                      Veiculo aux1 = aux.getVeiculo();
                      if(aux1 instanceof Onibus){
                          Veiculo aux2;
                          aux2 = aux.getVeiculo();
                          aux2.depressiacaoValores(taxaDepreciacao);
                          aux.setVeiculo(aux2);
                      }
                  }
                  break;
          }
    }

    @Override
    public void aumentarDiaria(int tipo, double taxaAumento) {
        switch (tipo){
            case 0:
                for(Veiculo aux: RepositorioVendas) {
                    aux.aumentarPrecoDiaria(taxaAumento);
                }
                for(Aluguel aux1 : alugueis) {
                    Veiculo aux2;
                    aux2 = aux1.getVeiculo();
                    aux2.aumentarPrecoDiaria(taxaAumento);
                    aux1.setVeiculo(aux2);
                }
                break;
            case 1:
                for(Veiculo aux: RepositorioVendas) {
                    if(aux instanceof Moto){
                        ((Moto) aux).aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for(Aluguel aux : alugueis){
                    Veiculo aux1 = aux.getVeiculo();
                    if(aux1 instanceof Moto){
                        Veiculo aux3;
                        aux3 = aux.getVeiculo();
                        aux3.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux3);
                    }
                }
                break;
            case 2:
                for(Veiculo aux : RepositorioVendas){
                    if(aux instanceof Carro){
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for(Aluguel aux : alugueis){
                    Veiculo aux1 = aux.getVeiculo();
                    if(aux1 instanceof Carro){
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 3:
                for(Veiculo aux : RepositorioVendas){
                    if(aux instanceof Caminhao){
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for(Aluguel aux : alugueis){
                    Veiculo aux1 = aux.getVeiculo();
                    if(aux1 instanceof Caminhao){
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 4:
                for(Veiculo aux : RepositorioVendas){
                    if(aux instanceof Onibus){
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for(Aluguel aux : alugueis){
                    Veiculo aux1 = aux.getVeiculo();
                    if(aux1 instanceof Onibus){
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
        }
    }

    @Override
    public double faturamentoTotal(int tipo) {
        double valor = 0;
        for(Aluguel a : alugueis){
            Veiculo aux = a.getVeiculo();
            if(a.getAlugado()) {
                switch (tipo) {
                    case 0:
                        valor +=  a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 1:
                        valor +=  a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 2:
                        valor +=  a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 3:
                        valor +=  a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 4:
                        valor +=  a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                }
            }
        }
        return valor;
    }

    @Override
    public int quantidadeTotalDeDiarias(int tipo) {
        int valor = 0;
        for(Aluguel a : alugueis){
            Veiculo aux = a.getVeiculo();
            if(a.getAlugado()) {
                switch (tipo) {
                    case 0:
                        valor +=  a.getDias();
                        break;
                    case 1:
                        valor += a.getDias();
                        break;
                    case 2:
                        valor += a.getDias();
                        break;
                    case 3:
                        valor += a.getDias();
                        break;
                    case 4:
                        valor += a.getDias();
                        break;
                }
            }
        }
        return valor;
    }






}
