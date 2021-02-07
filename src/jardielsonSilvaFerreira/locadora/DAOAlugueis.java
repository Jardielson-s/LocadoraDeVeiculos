package jardielsonSilvaFerreira.locadora;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DAOAlugueis {

    ArrayList<Aluguel> alugueisDevolvido = new ArrayList<>();

    private void salvar(Aluguel aluguel,int tipoAluguel) throws SQLException {
        Connection con = Conexao.getConexao();

        Statement st = con.createStatement();
        if(tipoAluguel == 1) {
            String comando = "insert into aluguel(placa,cpf,aluguel,dias,valor,fechado)  values" +
                    "(" + "'" + aluguel.getVeiculo().getPlaca() + "'" + "," + aluguel.getCpf() + "," + tipoAluguel + "," + aluguel.getDias() + "," +
                    aluguel.getVeiculo().getValorDiaria() + "," + aluguel.getAlugado() + ")";
            st.executeUpdate(comando);
        }else  if(tipoAluguel == 2){
            String comando = "insert into aluguel(placa,cpf,aluguel,dias,valor,fechado)  values" +
                    "(" + "'" + aluguel.getVeiculo().getPlaca() + "'" + "," + aluguel.getCpf() + "," + tipoAluguel + "," + aluguel.getDias() + "," +
                    aluguel.getVeiculo().getValorDiaria() + "," + aluguel.getAlugado() + ")";
            st.executeUpdate(comando);
        }else  if(tipoAluguel == 3){
            String comando = "insert into aluguel(placa,cpf,aluguel,dias,valor,fechado)  values" +
                    "(" + "'" + aluguel.getVeiculo().getPlaca() + "'" + "," + aluguel.getCpf() + "," + tipoAluguel + "," + aluguel.getDias() + "," +
                    aluguel.getVeiculo().getValorDiaria() + "," + aluguel.getAlugado() + ")";
            st.executeUpdate(comando);
        }else  if(tipoAluguel == 4){
            String comando = "insert into aluguel(placa,cpf,aluguel,dias,valor,fechado)  values" +
                    "(" + "'" + aluguel.getVeiculo().getPlaca() + "'" + "," + aluguel.getCpf() + "," + tipoAluguel + "," + aluguel.getDias() + "," +
                    aluguel.getVeiculo().getValorDiaria() + "," + aluguel.getAlugado() + ")";
            st.executeUpdate(comando);
        }
        st.close();
    }

    public Aluguel recuperar(int cpf) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "select * from aluguel where cpf = " + cpf;
        ResultSet rs = st.executeQuery(comando);
        rs.next();


        String oPlaca = rs.getString("placa");
        DAOVeiculos daoVeiculos = new DAOVeiculos();
        Veiculo veiculo = daoVeiculos.recuperarVeiculoPorPlaca(oPlaca);
        int dias = rs.getInt("dias");
        Aluguel p = new Aluguel();

        p.cadastrar(veiculo,dias,cpf);
        st.close();
        return p;
    }

    private boolean verifica(int fechado){
        if(fechado == 1){
            return true;
        }
            return false;
    }
    private void alterar(Aluguel a,int fechado) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        boolean fech = verifica(fechado);
        a.setAlugado(fech);
        String comando = "update aluguel set fechado = "  + a.getAlugado() +
                 " where cpf = "  + a.getCpf();
        st.executeUpdate(comando);
        st.close();
    }

    public void remover(int cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from aluguel where cpf = " + cpf;
        st.executeUpdate(comando);
        st.close();
    }


    public void removerTodos() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from aluguel";
        st.executeUpdate(comando);
        st.close();
    }

    public ArrayList<Aluguel> recuperarAluguel() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
        String comando = "select * from aluguel ";
        ResultSet rs = st.executeQuery(comando);
        while(rs.next()) {
            int cpf = rs.getInt("cpf");
            String placa = rs.getString("placa");
            int dias = rs.getInt("dias");
            DAOVeiculos daoVeiculos = new DAOVeiculos();
            Veiculo veiculo = daoVeiculos.recuperarVeiculoPorPlaca(placa);
            Aluguel aluguel = new Aluguel();
            aluguel.cadastrar(veiculo,dias,cpf);
            alugueis.add(aluguel);
        }
        st.close();
        return alugueis;
    }

    public double faturamentoTotal(int aluguel, Date inicio, Date fim) throws SQLException {
        double valor = 0;
        for (Aluguel a : alugueisDevolvido) {
            Veiculo aux = a.getVeiculo();
            //if (a.getAlugado()) {
            var b =  inicio.compareTo(fim) >= inicio.compareTo(new Date());
            switch (aluguel) {
                case 0:
                    if(b) {
                        valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                    }
                    break;
                case 1:
                    if (aux instanceof Moto) {
                        if(b) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                    }
                    break;
                case 2:
                    if (aux instanceof Carro) {
                        if(b) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }                        }
                    break;
                case 3:
                    if (aux instanceof Caminhao) {
                        if(b) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }                        }
                    break;
                case 4:
                    if (aux instanceof Onibus) {
                        if(b) {
                            valor += a.getVeiculo().retornaValorAluguel(a.getDias());
                        }
                    }
                    break;
            }
        }

        return valor;
    }

    public boolean registrarDevolucao(String placa, int fechado) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();

        for(Aluguel aluguel : recuperarAluguel()) {
            if(aluguel.getVeiculo().getPlaca().equals(placa) && aluguel.getAlugado()) {
                return false;
            }
        }

        for(Aluguel aluguel : recuperarAluguel()) {
            if(aluguel.getVeiculo().getPlaca().equals(placa)) {
                alugueisDevolvido.add(aluguel);
                remover(aluguel.getCpf());
                return true;
            }
        }

        return false;


    }

    public double consultarAluguel(String placa,int qunatidadeDias, int veiculo) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        //barra se o veiculo não for do tipo certo
        if(veiculo > 4 || veiculo < 0){
            return -9999999;
        }
        for(Veiculo v : daoVeiculos.recuperarVeiculos(veiculo)) {
            switch (veiculo) {
                case 1:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Moto) {
                            String comando = "select * from aluguel where placa = " + "'"+placa+"'" ;
                            ResultSet rs = st.executeQuery(comando);
                            rs.next();
                            int dias = rs.getInt("dias");
                            return v.retornaValorAluguel(dias);
                        }
                    }
                    break;
                case 2:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Carro) {
                            String comando = "select * from aluguel where placa = " + "'"+placa+"'" ;
                            ResultSet rs = st.executeQuery(comando);
                            rs.next();
                            int dias = rs.getInt("dias");
                            return v.retornaValorAluguel(dias);                      }
                    }
                    break;
                case 3:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Caminhao) {
                            String comando = "select * from aluguel where placa = " + "'"+placa+"'" ;
                            ResultSet rs = st.executeQuery(comando);
                            rs.next();
                            int dias = rs.getInt("dias");
                            return v.retornaValorAluguel(dias);                       }
                    }
                    break;
                case 4:
                    if (placa.equals(v.getPlaca())) {
                        if(v instanceof Onibus) {
                            String comando = "select * from aluguel where placa = " + "'"+placa+"'" ;
                            ResultSet rs = st.executeQuery(comando);
                            rs.next();
                            int dias = rs.getInt("dias");
                            return v.retornaValorAluguel(dias);                        }
                    }
                    break;
            }
        }
        //caso não encontre nada
        return 0;
    }

    public int quantidadeTotalDeDiarias(int tipo, Date inicio, Date fim){
        int dias = 0;

        for (Aluguel a : alugueisDevolvido) {
            Veiculo aux = a.getVeiculo();
            var b = inicio.compareTo(fim) >= inicio.compareTo(new Date());
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
        return dias;
    }

    public boolean registrarAluguel(String placa, Date date,int dias,int cpf) throws SQLException {

        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();

        String comando = "select * from veiculo where placa = " + "'"+placa+"'" ;
        ResultSet rs = st.executeQuery(comando);
        rs.next();
        String p = rs.getString("placa");
        int discriminador = rs.getInt("discriminador");

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        for(Aluguel aux : recuperarAluguel()) {
            if(aux.getAlugado() || aux.getCliente().getCpf() == cpf) {
                return false;
            }
        }




        Veiculo aux = daoVeiculos.recuperarVeiculoPorPlaca(placa);
        //if (daoCliente.recuperar(cpf) != null) {
            for (Veiculo v : daoVeiculos.recuperarVeiculos(discriminador)) {
                if(v.getPlaca().equals(aux.getPlaca()))
                    if (aux.getPlaca() != null) {
                        Aluguel a = new Aluguel();
                        a.cadastrar(v,dias,cpf);
                        a.setAlugado(true);
                        salvar(a,discriminador);
                        return true;
                    }
            }

       // }

        return false;
    }



}
