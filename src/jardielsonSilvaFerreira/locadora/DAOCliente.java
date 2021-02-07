package jardielsonSilvaFerreira.locadora;

import java.sql.*;
import java.util.ArrayList;

public class DAOCliente {

    public void salvar(Cliente cliente) throws SQLException {
        Connection con = Conexao.getConexao();

        Statement st = con.createStatement();
        String comando = "insert into clientes(cpf, nome)  values" +
                "("+ cliente.getCpf() + "," + "'"+cliente.getNome()+"'" +")";
        st.executeUpdate(comando);

        st.close();
    }

    public Cliente recuperar(int cpf) throws SQLException{
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "select * from clientes where cpf = " + cpf;
        ResultSet rs = st.executeQuery(comando);
        rs.next();
        String oNome = rs.getString("nome");
        Cliente p = new Cliente(cpf, oNome);
        st.close();
        if(p == null){
            return  null;
        }
        return p;
    }

    public ArrayList<Cliente> recuperarTodos() throws SQLException{
        ArrayList<Cliente> arrayList = new ArrayList<>();
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "select * from clientes";
        ResultSet rs = st.executeQuery(comando);
        while(rs.next()){
            String oNome = rs.getString("nome");
            int cpf = rs.getInt("cpf");
            Cliente p = new Cliente(cpf, oNome);
            arrayList.add(p);

        }

        st.close();
        return arrayList;
    }

    public void alterar(Cliente p) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "update clientes set nome = " + "'" +p.getNome() + "'"  + " where cpf = " + p.getCpf();
        st.executeUpdate(comando);
        st.close();
    }

    public void remover(int cpf) throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from clientes where cpf = " + cpf;
        st.executeUpdate(comando);
        st.close();
    }

    public void removerTodos() throws SQLException {
        Connection con = Conexao.getConexao();
        Statement st = con.createStatement();
        String comando = "delete from clientes";
        st.executeUpdate(comando);
        st.close();
    }

    public boolean inserir(Cliente c) throws SQLException {
            salvar(c);
            return true;
    }

    protected Cliente pesquisarCliente(int cpf) throws SQLException {
        for(Cliente c :recuperarTodos() ){
            if(c.getCpf() == cpf){
                return c;
            }
        }
        return null;
    }


}
