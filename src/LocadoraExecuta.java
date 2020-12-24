import java.util.ArrayList;


public class LocadoraExecuta extends Locadora {


    ArrayList<Veiculo> RepositorioVeiculos = new ArrayList<>();
    ArrayList<Aluguel> alugueis = new ArrayList<>();
    ArrayList<Cliente> cliente = new ArrayList<>();

    public boolean pesquisarPlaca(Veiculo v) {
        for (Veiculo aux : RepositorioVeiculos) {
            if (v.getPlaca().equals(aux.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    public void inserir(Veiculo v) {
        if (!pesquisarPlaca(v)) {
            RepositorioVeiculos.add(v);
        }
    }

    public void cadastrar(Veiculo v) {

        inserir(v);
    }


    public void registrarAluguel(Veiculo placa, int dias,Cliente c) {
            // Aluguel a1 = new Aluguel();
            for(Aluguel aux : alugueis) {
                if(aux.getVeiculo().getPlaca().equals(placa.getPlaca())  || aux.getCliente().getCpf().equals(c.getCpf())){
                    if(aux.getAlugado()) {
                        return;
                    }
                }

            }
            Veiculo aux = pesquisar(placa.getPlaca());
            if (procurarCliente(c.getCpf()) != null) {
                for (Veiculo v : RepositorioVeiculos) {
                    if(v.getPlaca().equals(aux.getPlaca()))
                        if (aux.getPlaca() != null) {
                            Aluguel a = new Aluguel();
                            c = new Cliente(c.getNome(), c.getCpf());
                            a.cadastrar(v,dias,c);
                            a.setAlugado(true);
                            alugueis.add(a);
                        }
                }

            } else {
                System.out.println("CLIENTE INEXISTENTE");
            }


        }



    @Override
    public void inserir(Cliente c) {
        if(procurarCliente(c.getCpf()) == null)
        {
            cliente.add(c);
        }
    }

    private Cliente procurarCliente(String cpf){
        for(Cliente c : cliente){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    @Override

    public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo v : RepositorioVeiculos) {
            if (v instanceof Moto) {
                if (((Moto) v).getCilindrada() == cilindrada) {
                    aux.add(v);
                }
            }
        }
        return aux;
    }

    @Override
    public Veiculo pesquisar(String placa) {
        for (Veiculo aux : RepositorioVeiculos) {
            if (aux.getPlaca().equals(placa)) {
                return aux;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : RepositorioVeiculos) {
            if (aux1 instanceof Carro) {
                if (((Carro) aux1).getCategoria() == tipoCarro) {
                    RepositorioVeiculos.add(aux1);
                }
            }
        }
        return aux;
    }

    @Override
    public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : RepositorioVeiculos) {
            if (aux1 instanceof Caminhao) {
                if (((Caminhao) aux1).getCarga() == carga) {
                    RepositorioVeiculos.add(aux1);
                }
            }
        }
        return aux;
    }

    @Override
    public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : RepositorioVeiculos) {
            if (aux1 instanceof Onibus) {
                RepositorioVeiculos.add(aux1);
            }
        }
        return aux;
    }

    @Override
    public double calcularAluguel(String placa, int dias) {
        for (Veiculo aux : RepositorioVeiculos) {
            if (aux.getPlaca().equals(placa)) {
                return aux.retornaValorAluguel(dias);
            }
        }
        return 0;
    }

    //@Override
   /* public void registrarAluguel(Veiculo placa, int dias, Cliente c) {

        for (Veiculo aux : RepositorioVeiculos) {
            if (aux.getPlaca().equals(placa.getPlaca())) {
                Aluguel auxAl = new Aluguel();
                auxAl.cadastrar(placa, dias, c);
                alugueis.add(auxAl);
            }
        }

    }
    */

    @Override
    public void registrarDevolucao(String placa, Cliente c) {
        for (Aluguel x : alugueis) {
            if (placa.equals(x.getVeiculo().getPlaca())) {
                x.setAlugado(false);
            }
        }
    }

    @Override
    public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
        switch (tipo) {
            case 0:
                for (Veiculo aux : RepositorioVeiculos) {
                    aux.depressiacaoValores(taxaDepreciacao);
                }
                for (Aluguel aux1 : alugueis) {
                    Veiculo aux2;
                    aux2 = aux1.getVeiculo();
                    aux2.depressiacaoValores(taxaDepreciacao);
                    aux1.setVeiculo(aux2);
                }
                break;
            case 1:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Moto) {
                        aux.depressiacaoValores(taxaDepreciacao);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Moto) {
                        Veiculo aux3;
                        aux3 = aux.getVeiculo();
                        aux3.depressiacaoValores(taxaDepreciacao);
                        aux.setVeiculo(aux3);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Carro) {
                        aux.depressiacaoValores(taxaDepreciacao);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Carro) {
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.depressiacaoValores(taxaDepreciacao);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Caminhao) {
                        aux.depressiacaoValores(taxaDepreciacao);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Caminhao) {
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.depressiacaoValores(taxaDepreciacao);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Onibus) {
                        aux.depressiacaoValores(taxaDepreciacao);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Onibus) {
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
        switch (tipo) {
            case 0:
                for (Veiculo aux : RepositorioVeiculos) {
                    aux.aumentarPrecoDiaria(taxaAumento);
                }
                for (Aluguel aux1 : alugueis) {
                    Veiculo aux2;
                    aux2 = aux1.getVeiculo();
                    aux2.aumentarPrecoDiaria(taxaAumento);
                    aux1.setVeiculo(aux2);
                }
                break;
            case 1:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Moto) {
                         aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Moto) {
                        Veiculo aux3;
                        aux3 = aux.getVeiculo();
                        aux3.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux3);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Carro) {
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Carro) {
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Caminhao) {
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Caminhao) {
                        Veiculo aux2;
                        aux2 = aux.getVeiculo();
                        aux2.aumentarPrecoDiaria(taxaAumento);
                        aux.setVeiculo(aux2);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : RepositorioVeiculos) {
                    if (aux instanceof Onibus) {
                        aux.aumentarPrecoDiaria(taxaAumento);
                    }
                }
                for (Aluguel aux : alugueis) {
                    Veiculo aux1 = aux.getVeiculo();
                    if (aux1 instanceof Onibus) {
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
        for (Aluguel a : alugueis) {
            Veiculo aux = a.getVeiculo();

            if (a.getAlugado()) {
                switch (tipo) {
                    case 0:
                        valor = valor + a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 1:
                        if (aux instanceof Moto) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                        break;
                    case 2:
                        if (aux instanceof Carro) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                        break;
                    case 3:
                        if (aux instanceof Caminhao) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                        break;
                    case 4:
                        if (aux instanceof Onibus) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                        break;
                }
            }
        }
        return valor;
    }

        @Override
        public int quantidadeTotalDeDiarias ( int tipo){
            int dias = 0;
            for (Aluguel a : alugueis) {
                Veiculo aux = a.getVeiculo();
                if (a.getAlugado()) {
                    switch (tipo) {
                        case 0:
                            dias += a.getDias();
                            break;
                        case 1:
                            if (aux instanceof Moto) {
                                dias += a.getDias();
                            }
                            break;
                        case 2:
                            if (aux instanceof Carro) {
                                dias += a.getDias();
                            }
                            break;
                        case 3:
                            if (aux instanceof Caminhao) {
                                dias += a.getDias();
                            }
                            break;
                        case 4:
                            if (aux instanceof Onibus) {
                                dias += a.getDias();
                            }
                            break;
                    }
                }
            }
            return dias;
        }
    }


