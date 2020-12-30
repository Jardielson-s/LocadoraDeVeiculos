import java.util.ArrayList;
import java.util.Date;


public class MinhaLocadora extends Locadora {


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

    public boolean inserir(Veiculo v) {

            if (!pesquisarPlaca(v)) {
                RepositorioVeiculos.add(v);
            }

        return false;
    }

    public void cadastrar(Veiculo v) {

        inserir(v);
    }


    public boolean registrarAluguel(String placa, Date date,int dias,int cpf) {

            for(Aluguel aux : alugueis) {
                    if(aux.getAlugado() || aux.getCliente().getCpf() == cpf) {
                        return false;
                    }
            }

            Veiculo aux = pesquisar(placa);
            if (pesquisarCliente(cpf) != null) {
                for (Veiculo v : RepositorioVeiculos) {
                    if(v.getPlaca().equals(aux.getPlaca()))
                        if (aux.getPlaca() != null) {
                            Aluguel a = new Aluguel();
                            a.cadastrar(v,dias,cpf);
                            a.setAlugado(true);
                            alugueis.add(a);
                            return true;
                        }
                }

            }

        return false;
    }



    @Override
    public boolean inserir(Cliente c) {
        if(pesquisarCliente(c.getCpf()) == null)
        {
            cliente.add(c);
            return true;
        }
        return false;
    }

    protected Cliente pesquisarCliente(int cpf){
        for(Cliente c : cliente){
            if(c.getCpf() == cpf){
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
                if (((Moto) v).getCilindrada() >= cilindrada) {
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
                    aux.add(aux1);
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
                if (((Caminhao) aux1).getCarga() >= carga) {
                    aux.add(aux1);
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
                if (((Onibus) aux1).getQunatidadePassageiro() >= passageiros) {
                    aux.add(aux1);
                }
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


    public void aumentarValorVeiculo(String placa,double taxa){
        Veiculo aux = pesquisar(placa);

        if (aux != null) {
            aux.aumentarValorAvaliado(taxa);
        }

    }

    public void depreciaValorVeiculo(String placa,double taxa){

        Veiculo aux = pesquisar(placa);

        if (aux != null) {
            aux.depressiacaoValores(taxa);
        }

    }


    @Override
    public boolean registrarDevolucao(String placa) {

          for (int i = 0; i < alugueis.size(); i++) {
              if (placa.equals(alugueis.get(i).getVeiculo().getPlaca()) && alugueis.get(i).getAlugado()) {
                  alugueis.remove(alugueis.get(i));
                  return true;
              }
          }
        return false;
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

    public void diminuirDiaria(String placa,double taxa){

        Veiculo v = pesquisar(placa);
        if (placa.equals(v.getPlaca())) {
            v.reduzirPrecoDiaria(taxa);
        }

    }

    @Override
    public double faturamentoTotal(int tipo,Date inicio,Date fim) {
        double valor = 0;

        for (Aluguel a : alugueis) {
            Veiculo aux = a.getVeiculo();
            int date = a.getDias();
            if (a.getAlugado()) {
                var b =true;// inicio.compareTo(fim) >= inicio.compareTo(date);
                switch (tipo) {
                    case 0:
                        valor = valor + a.getVeiculo().retornaValorAluguel(a.getDias());
                        break;
                    case 1:
                        if (aux instanceof Moto) {
                            if(b) {
                                //System.out.println(a.get);
                                valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                            }
                            //valor += a.getVeiculo().retornaValorAluguel(a.getDias().getDay());
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
        public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim){
            int dias = 0;

            for (Aluguel a : alugueis) {
                Veiculo aux = a.getVeiculo();
                int date = a.getDias();

                if (a.getAlugado()) {
                    var b = true;//inicio.compareTo(fim) >= inicio.compareTo(date);
                    switch (tipo) {
                        case 0:
                            if(b) {
                                dias += a.getDias();
                            }
                            break;
                        case 1:
                            if (aux instanceof Moto) {
                                if(b) {
                                    dias += a.getDias();
                                }
                            }
                            break;
                        case 2:
                            if (aux instanceof Carro) {
                                if(b) {
                                    dias += a.getDias();
                                }
                            }
                            break;
                        case 3:
                            if (aux instanceof Caminhao) {
                                if(b) {
                                    dias += a.getDias();
                                }
                            }
                            break;
                        case 4:
                            if (aux instanceof Onibus) {
                                if(b) {
                                    dias += a.getDias();
                                }
                            }
                            break;
                    }
                }
            }
            return dias;
        }

    public double consultaAluguel(int veiculo,int qunatidadeDias,String placa) {
        //barra se o veiculo não for do tipo certo
        if(veiculo > 4 || veiculo < 0){
            return -9999999;
        }
        for(Veiculo v : RepositorioVeiculos) {
            switch (veiculo) {
                case 1:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Moto) {
                            return v.retornaValorAluguel(qunatidadeDias);
                        }
                    }
                    break;
                case 2:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Carro) {
                            return v.retornaValorAluguel(qunatidadeDias);
                        }
                    }
                    break;
                case 3:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Caminhao) {
                            return v.retornaValorAluguel(qunatidadeDias);
                        }
                    }
                    break;
                case 4:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Onibus) {
                            return v.retornaValorAluguel(qunatidadeDias);
                        }
                    }
                    break;
            }
        }
        //caso não encontre nada
        return 0;
    }
    public String consultarFrota(int CapacidadeDeCarga, int cilindradas, int categoria, int capacidadePassageriso) {

        ArrayList<String> frota = new ArrayList<>();
        if (cilindradas != 0) {
            for (Veiculo moto : RepositorioVeiculos) {
                if(moto instanceof Moto) {
                    if (((Moto) moto).getCilindrada() >= cilindradas) {
                        frota.add(moto.toString());
                    }
                }
            }
        }
        if (categoria != 0) {
            for (Veiculo carro : RepositorioVeiculos) {
                if(carro instanceof Carro) {
                    if (((Carro) carro).getCategoria() == categoria) {
                        frota.add(carro.toString());
                    }
                }
            }
        }
        if (capacidadePassageriso != 0) {
            for (Veiculo onibus : RepositorioVeiculos) {
                if(onibus instanceof Onibus) {
                    if (((Onibus) onibus).getQunatidadePassageiro() >= capacidadePassageriso) {
                        frota.add(onibus.toString());
                    }
                }
            }
        }
        if (CapacidadeDeCarga != 0) {
            for (Veiculo caminhao : RepositorioVeiculos) {
                if(caminhao instanceof Caminhao) {
                    if (((Caminhao) caminhao).getCarga() >= CapacidadeDeCarga) {
                        frota.add(caminhao.toString());
                    }
                }
            }
        }

        return frota.toString();
    }

    public double consultaSeguro(int veiculo, String placa){

        // barra tipo que não existe
        if (veiculo > 4 || veiculo < 0) {
            System.out.println("TIPO DE CARRO NÃO EXISTE NO REPOSIORIO");
            return -9999999;
        }
        for(Veiculo v : RepositorioVeiculos) {
            if (placa.equals(v.getPlaca())) {

                switch (veiculo) {
                    case 1:
                        if(v instanceof Moto) {
                            return v.retornaValorSeguro();
                        }
                    case 2:
                        if(v instanceof Carro) {
                            return v.retornaValorSeguro();
                        }
                    case 3:
                        if(v instanceof Caminhao) {
                            return v.retornaValorSeguro();
                        }
                    case 4:
                        if(v instanceof Onibus) {
                            return v.retornaValorSeguro();
                        }
                }
            }



        }
        //caso não encontre nada
        return 0;
    }


}

