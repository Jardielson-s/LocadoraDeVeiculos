package jardielsonSilvaFerreira.locadora;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOVeiculos {

    private void salvar(Veiculo v,int discriminador) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();



        String comando = null;
        if(discriminador == 1){
            Moto moto = (Moto) v;
             comando = "insert into veiculo(placa,marca,modelo,ano,valoravaliado,valordiaria,cilindrada,discriminador) values" +
                    "(" + "'" + v.getPlaca()+ "'" + ","+ "'" + v.getMarca() + "'" + "," + "'" + v.getModelo() + "'" + "," + v.getAnoDeFabricacao()
                    + "," + v.getValorAvaliado() + "," + v.getValorDiaria() + "," + moto.getCilindrada() + "," + 1 + ")";
        }else if(discriminador == 2){
            Carro carro = (Carro) v;
            comando = "insert into veiculo(placa,marca,modelo,ano,valoravaliado,valordiaria,tipo,discriminador) values" +
                    "(" + "'" + v.getPlaca()+ "'" + ","+ "'" + v.getMarca() + "'" + "," + "'" + v.getModelo() + "'" + "," + v.getAnoDeFabricacao()
                    + "," + v.getValorAvaliado() + "," + v.getValorDiaria() + "," + carro.getTipo() + "," + 2 + ")";
        }else if(discriminador == 3){
            Caminhao caminhao = (Caminhao) v;
            comando = "insert into veiculo(placa,marca,modelo,ano,valoravaliado,valordiaria,carga,discriminador) values" +
                    "(" + "'" + v.getPlaca()+ "'" + ","+ "'" + v.getMarca() + "'" + "," + "'" + v.getModelo() + "'" + "," + v.getAnoDeFabricacao()
                    + "," + v.getValorAvaliado() + "," + v.getValorDiaria() + "," + caminhao.getCarga() + "," + 3 + ")";

        }else if(discriminador == 4){
            Onibus onibus = (Onibus) v;
            comando = "insert into veiculo(placa,marca,modelo,ano,valoravaliado,valordiaria,passageiros,discriminador) values" +
                    "(" + "'" + v.getPlaca()+ "'" + ","+ "'" + v.getMarca() + "'" + "," + "'" + v.getModelo() + "'" + "," + v.getAnoDeFabricacao()
                    + "," + v.getValorAvaliado() + "," + v.getValorDiaria() + "," + onibus.getQunatidadePassageiro() + "," + 4 + ")";
        }
     
        st.executeUpdate(comando);
        st.close();

    }


    public Veiculo recuperar(int discriminador) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "select * from veiculo where discriminador = " + discriminador;
        ResultSet rs = st.executeQuery(comando);
        rs.next();
       if(discriminador == 1) {
           String marca = rs.getString("marca");
           String modelo = rs.getString("modelo");
           int anoDeFabricacao = rs.getInt("ano");
           double valorAvaliado = rs.getDouble("valoravaliado");
           double valorDiaria = rs.getDouble("valordiaria");
           String placa = rs.getString("placa");
           double cilindrada = rs.getDouble("cilindrada");

           Moto moto = new Moto(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,cilindrada);
           st.close();
           return moto;
       }else if(discriminador == 2){
           String marca = rs.getString("marca");
           String modelo = rs.getString("modelo");
           int anoDeFabricacao = rs.getInt("ano");
           double valorAvaliado = rs.getDouble("valoravaliado");
           double valorDiaria = rs.getDouble("valordiaria");
           String placa = rs.getString("placa");
           int categoria = rs.getInt("tipo");

           Carro carro = new Carro(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,categoria);
           st.close();
           return carro;
       }else if(discriminador == 3){
           String marca = rs.getString("marca");
           String modelo = rs.getString("modelo");
           int anoDeFabricacao = rs.getInt("ano");
           double valorAvaliado = rs.getDouble("valoravaliado");
           double valorDiaria = rs.getDouble("valordiaria");
           String placa = rs.getString("placa");
           int carga = rs.getInt("carga");

           Caminhao caminhao = new Caminhao(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,carga);
           st.close();
           return caminhao;

       }else if(discriminador == 4){
           String marca = rs.getString("marca");
           String modelo = rs.getString("modelo");
           int anoDeFabricacao = rs.getInt("ano");
           double valorAvaliado = rs.getDouble("valoravaliado");
           double valorDiaria = rs.getDouble("valordiaria");
           String placa = rs.getString("placa");
           int quantidadeDePassageiro = rs.getInt("passageiros");

           Onibus onibus = new Onibus(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,quantidadeDePassageiro);
           st.close();
           return onibus;
       }
       return null;
    }




    public void remover(String discrminador) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from veiculo  where discriminador = " + "'"+discrminador+"'";
        st.executeUpdate(comando);
        st.close();
    }

    public void removerPorPlaca(String placa) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from veiculo  where placa = " + "'"+placa+"'";
        st.executeUpdate(comando);
        st.close();
    }

    public void removerTodos() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from veiculo";
        st.executeUpdate(comando);
        st.close();
    }

    public ArrayList<Veiculo> recuperarVeiculos(int discriminador) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        String comando = "select * from veiculo where discriminador = " + "'"+ discriminador + "'";
        ResultSet rs = st.executeQuery(comando);
        while(rs.next()) {
            int discrim = rs.getInt("discriminador");
            Veiculo p1 = recuperar(discrim);

            if(discriminador == 1) {
                Moto m = (Moto) recuperar(discrim);
                Moto moto = new Moto(m.marca,m.modelo,m.anoDeFabricacao,m.valorAvaliado,m.valorDiaria,m.placa,m.getCilindrada());
                veiculos.add(moto);
            }else if(discriminador == 2){
                Carro m = (Carro) recuperar(discrim);
                Carro carro = new Carro(m.marca,m.modelo,m.anoDeFabricacao,m.valorAvaliado,m.valorDiaria,m.placa,m.getTipo());
                veiculos.add(carro);
            }else if(discriminador == 3){
                Caminhao m = (Caminhao) recuperar(discrim);
                Caminhao caminhao = new Caminhao(m.marca,m.modelo,m.anoDeFabricacao,m.valorAvaliado,m.valorDiaria,m.placa,m.getCarga());
                veiculos.add(caminhao);
            }else if(discriminador == 4){
                Onibus m = (Onibus) recuperar(discrim);
                Onibus onibus = new Onibus(m.marca,m.modelo,m.anoDeFabricacao,m.valorAvaliado,m.valorDiaria,m.placa,m.getQunatidadePassageiro());
                veiculos.add(onibus);
            }
        }
        st.close();
        return veiculos;
    }



    public Veiculo recuperarVeiculoPorPlaca(String placa) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "select * from veiculo where placa = " +  "'"+placa+"'";
        ResultSet rs = st.executeQuery(comando);
        rs.next();
        int discriminador = rs.getInt("discriminador");

        return  recuperar(discriminador);
    }

    public void depreciarVeiculos(int discriminador, double taxaDepreciacao) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();


        switch (discriminador) {
            case 0:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    aux.depressiacaoValores(taxaDepreciacao);
                    String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado();
                    st.executeUpdate(comando);
                }
                break;
            case 1:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Moto) {
                        aux.depressiacaoValores(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Carro) {
                        aux.depressiacaoValores(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Caminhao) {
                        aux.depressiacaoValores(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Onibus) {
                        aux.depressiacaoValores(taxaDepreciacao);
                        String comando = "update veiculo set valordiariavaloravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
        }

        st.close();
    }

    public void aumentarDiaria(int discriminador, double taxaDepreciacao) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();


        switch (discriminador) {
            case 0:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    aux.aumentarPrecoDiaria(taxaDepreciacao);
                    String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ " where discriminador = " + discriminador;
                    st.executeUpdate(comando);
                }
                break;
            case 1:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Moto) {
                        aux.aumentarPrecoDiaria(taxaDepreciacao);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Carro) {
                        aux.aumentarPrecoDiaria(taxaDepreciacao);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Caminhao) {
                        aux.aumentarPrecoDiaria(taxaDepreciacao);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Onibus) {
                        aux.aumentarPrecoDiaria(taxaDepreciacao);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
        }

        st.close();
    }

    public void diminuirDiaria(int discriminador, double taxa) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();


        switch (discriminador) {
            case 0:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    aux.reduzirPrecoDiaria(taxa);
                    String comando = "update veiculo set valordiaria = " + aux.getValorDiaria();
                    st.executeUpdate(comando);
                }
                break;
            case 1:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Moto) {
                        aux.reduzirPrecoDiaria(taxa);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Carro) {
                        aux.reduzirPrecoDiaria(taxa);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Caminhao) {
                        aux.reduzirPrecoDiaria(taxa);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Onibus) {
                        aux.reduzirPrecoDiaria(taxa);
                        String comando = "update veiculo set valordiaria = " + aux.getValorDiaria()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
        }

        st.close();
        }

    public void aumentarValorVeiculo(int discriminador, double taxaDepreciacao) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();


        switch (discriminador) {
            case 0:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    aux.aumentarValorAvaliado(taxaDepreciacao);
                    String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado();
                    st.executeUpdate(comando);
                }
                break;
            case 1:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Moto) {
                        aux.aumentarValorAvaliado(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 2:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Carro) {
                        aux.aumentarValorAvaliado(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 3:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Caminhao) {
                        aux.aumentarValorAvaliado(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado()+ "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
            case 4:
                for (Veiculo aux : recuperarVeiculos(discriminador)) {
                    if (aux instanceof Onibus) {
                        aux.aumentarValorAvaliado(taxaDepreciacao);
                        String comando = "update veiculo set valoravaliado = " + aux.getValorAvaliado() + "where discriminador = " + discriminador;
                        st.executeUpdate(comando);
                    }
                }
                break;
        }

        st.close();
    }


    public ArrayList<Veiculo> consultarFrota(int CapacidadeDeCarga, int cilindradas, int categoria, int capacidadePassageriso) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = null;


        ArrayList<Veiculo> frota = new ArrayList<>();
        if(categoria != 0){
            comando = "select * from veiculo where tipo = " + categoria;
            ResultSet rs = st.executeQuery(comando);
            while(rs.next()) {
                String placa = rs.getString("placa");
                int discrim = rs.getInt("discriminador");
                int tipo = rs.getInt("tipo");
                Carro m = (Carro) recuperarVeiculoPorPlaca(placa);
                 //if(m instanceof Carro) {
                     if(categoria == tipo){
                         frota.add(m);
                     }
                //}
            }
            st.close();

        }else  if(capacidadePassageriso != 0){
            comando = "select * from veiculo where passageiros >= " + capacidadePassageriso;
            ResultSet rs = st.executeQuery(comando);
            while(rs.next()) {
                int discrim = rs.getInt("discriminador");
                int pass = rs.getInt("passageiros");

                Veiculo p1 = recuperar(discrim);
                if(p1 instanceof Onibus) {
                    if(((Onibus) p1).getQunatidadePassageiro() >= pass){
                        Onibus m = (Onibus) recuperar(discrim);
                        Onibus carro = new Onibus(m.marca, m.modelo, m.anoDeFabricacao, m.valorAvaliado, m.valorDiaria, m.placa, m.getQunatidadePassageiro());
                        frota.add(m);
                    }
                }
            }
            st.close();
        }else  if(CapacidadeDeCarga != 0){
            comando = "select * from veiculo where carga >= " + CapacidadeDeCarga;
            ResultSet rs = st.executeQuery(comando);
            while(rs.next()) {
                int discrim = rs.getInt("discriminador");
                int capacidade = rs.getInt("carga");
                Veiculo p1 = recuperar(discrim);
                if(p1 instanceof Caminhao) {System.out.println("kkk");
                    if(((Caminhao) p1).getCarga() >= capacidade){
                        Caminhao m = (Caminhao) recuperar(discrim);
                        Caminhao carro = new Caminhao(m.marca, m.modelo, m.anoDeFabricacao, m.valorAvaliado, m.valorDiaria, m.placa, m.getCarga());
                        frota.add(carro);
                    }
                }
            }
            st.close();
        }else  if(cilindradas != 0){
            comando = "select * from veiculo where cilindrada >= " + cilindradas;
            ResultSet rs = st.executeQuery(comando);
            while(rs.next()) {
                int discrim = rs.getInt("discriminador");
                int  cili = rs.getInt("cilindrada");
                Veiculo p1 = recuperar(discrim);
                if(p1 instanceof Moto) {
                    if(((Moto) p1).getCilindrada() >= cili){
                        Moto m = (Moto) recuperar(discrim);
                        Moto carro = new Moto(m.marca, m.modelo, m.anoDeFabricacao, m.valorAvaliado, m.valorDiaria, m.placa, m.getCilindrada());
                        frota.add(carro);
                    }
                }
            }
            st.close();
        }



        return frota;
    }

    public double consultarSeguro(int veiculo, String placa) throws SQLException {

        // barra tipo que não existe
        if (veiculo > 4 || veiculo < 0) {
            System.out.println("TIPO DE CARRO NÃO EXISTE NO REPOSIORIO");
            return -9999999;
        }
        for(Veiculo v : recuperarVeiculos(veiculo)) {
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

    public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) throws SQLException {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : recuperarVeiculos(2)) {
            if (aux1 instanceof Carro) {
                if (((Carro) aux1).getTipo() == tipoCarro) {
                    aux.add(aux1);
                }
            }
        }
        return aux;
    }

    public ArrayList<Veiculo> pesquisarCaminhao(int carga) throws SQLException {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : recuperarVeiculos(3)) {
            if (aux1 instanceof Caminhao) {
                if (((Caminhao) aux1).getCarga() >= carga) {
                    aux.add(aux1);
                }
            }
        }
        return aux;
    }

    public ArrayList<Veiculo> pesquisarOnibus(int passageiros) throws SQLException {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo aux1 : recuperarVeiculos(4)) {
            if (aux1 instanceof Onibus) {
                if (((Onibus) aux1).getQunatidadePassageiro() >= passageiros) {
                    aux.add(aux1);
                }
            }
        }
        return aux;
    }

    public ArrayList<Veiculo> pesquisarMoto(int cilindrada) throws SQLException {
        ArrayList<Veiculo> aux = new ArrayList<>();
        for (Veiculo v : recuperarVeiculos(1)) {
            if (v instanceof Moto) {
                if (((Moto) v).getCilindrada() >= cilindrada) {
                    aux.add(v);
                }
            }
        }
        return aux;
    }

    public boolean pesquisarPlaca(Veiculo v, int discriminador) throws SQLException {
        for (Veiculo aux : recuperarVeiculos(discriminador)) {
            if (v.getPlaca().equals(aux.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    public boolean inserir(Veiculo v,int discriminador) throws SQLException {

        if (!pesquisarPlaca(v,discriminador)) {
            salvar(v,discriminador);
            return true;
        }

        return false;
    }


    public Veiculo pesquisar(String placa) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();

        String comando = "select * from veiculo where placa = " + "'" + placa + "'";
        ResultSet rs = st.executeQuery(comando);
        rs.next();
        String p = null;

        p = rs.getString("placa");

        int disccriminador = rs.getInt("discriminador");
        if(p != null){
            if(disccriminador == 2) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int anoDeFabricacao = rs.getInt("ano");
                double valorAvaliado = rs.getDouble("valoravaliado");
                double valorDiaria = rs.getDouble("valordiaria");
                int categoria = rs.getInt("tipo");

                 Carro carro = new Carro(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,categoria);
                 return carro;

            }else if(disccriminador == 1) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int anoDeFabricacao = rs.getInt("ano");
                double valorAvaliado = rs.getDouble("valoravaliado");
                double valorDiaria = rs.getDouble("valordiaria");
                int cilindrada = rs.getInt("cilindrada");

                Moto moto = new Moto(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,cilindrada);
                return moto;

            }else if(disccriminador == 3) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int anoDeFabricacao = rs.getInt("ano");
                double valorAvaliado = rs.getDouble("valoravaliado");
                double valorDiaria = rs.getDouble("valordiaria");
                int carga = rs.getInt("carga");

                Caminhao caminhao = new Caminhao(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,carga);
                return caminhao;

            }else if(disccriminador == 4) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int anoDeFabricacao = rs.getInt("ano");
                double valorAvaliado = rs.getDouble("valoravaliado");
                double valorDiaria = rs.getDouble("valordiaria");
                int pessoas = rs.getInt("pessoas");

                Onibus onibus = new Onibus(marca,modelo,anoDeFabricacao,valorAvaliado,valorDiaria,placa,pessoas);
                return onibus;

            }
        }
     return null;
    }


}
