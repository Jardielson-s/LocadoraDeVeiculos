package jardielsonSilvaFerreira.locadora;


import java.sql.SQLException;
import java.util.Date;



import org.junit.Assert;
import org.junit.Test;



import static org.junit.Assert.*;






public class TesteLocadoraResumido {


    @Test
    public void pesquisar() throws SQLException {


        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);

        DAOVeiculos daoVeiculos = new DAOVeiculos();

        daoVeiculos.removerTodos();

        daoVeiculos.inserir(moto1,1);
        daoVeiculos.inserir(carro1,2);

        Veiculo p = daoVeiculos.pesquisar("X-911");
        Assert.assertEquals("X-911",p.getPlaca());

        //Veiculo p1 = daoVeiculos.pesquisar("X-0000");
        //assertNull(p1);

    }




    @Test
    public void salvarCliente() throws SQLException {


        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        Cliente cli1 = new Cliente(123456, "Zé Roberto");
        Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);





        DAOCliente dao = new DAOCliente();

        dao.removerTodos();

        //slavar cliente
        dao.inserir(cli1);


        //retorna quantos veiculos o cliente alugou
        Cliente outra = dao.recuperar(123456);
        assertEquals("Zé Roberto", outra.getNome());

    }

    @Test
    public void salvarAlugueis() throws SQLException {

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        Cliente cli1 = new Cliente(123456, "Zé Roberto");


        DAOAlugueis dao = new DAOAlugueis();
        dao.removerTodos();


        Date hoje = new Date();

        Date ontem = new Date(hoje.getTime() - 1);

        Date amanha = new Date(hoje.getTime() + 1);



        dao.registrarAluguel(moto1.getPlaca(),hoje,5,cli1.getCpf());
        Assert.assertTrue(dao.registrarDevolucao(moto1.getPlaca(), 1));


    }

    @Test
    public void salvarVeiculos() throws SQLException {

        Moto moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        DAOVeiculos daoVeiculos = new DAOVeiculos();

        daoVeiculos.removerTodos();

        daoVeiculos.inserir(moto1,1);


        Onibus onibus3 = new Onibus("Cálcio Motores", "Bicusp", 1985, 50000, 85, "W-321", 70);
        daoVeiculos.inserir(onibus3,4);



        Carro carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 3);
        daoVeiculos.inserir(carro1,2);



        Caminhao caminhao = new Caminhao("Ford", "F-1000", 1980, 12000, 50, "LVF-1000", 500);
        daoVeiculos.inserir(caminhao,3);

        Caminhao caminhao1 = new Caminhao("tesla", "F-600", 1980, 15000, 100, "TSL-1005", 400);
        daoVeiculos.inserir(caminhao1,3);

        Caminhao caminhao2 = new Caminhao("toyota", "F-500", 1980, 10000, 90, "TYA-1050", 200);
        daoVeiculos.inserir(caminhao2,3);


        daoVeiculos.depreciarVeiculos(1,0.15);
        Assert.assertEquals(12750.0,daoVeiculos.recuperarVeiculoPorPlaca(moto1.getPlaca()).getValorAvaliado(),0.1);

        daoVeiculos.aumentarDiaria(3,0.25);
        Assert.assertEquals(50.0,daoVeiculos.recuperarVeiculoPorPlaca(caminhao.placa).getValorDiaria(),0.1);


        daoVeiculos.diminuirDiaria(3,0.555);
        Assert.assertEquals(50.0,daoVeiculos.recuperarVeiculoPorPlaca(caminhao.getPlaca()).getValorDiaria(),0.1);



        daoVeiculos.aumentarValorVeiculo(4,0.50);
        assertEquals(75000.0,daoVeiculos.recuperarVeiculoPorPlaca(onibus3.getPlaca()).getValorAvaliado(),0.1);

    }


    @Test
    public void testeFaturamentoTotalDAO() throws SQLException {


        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        DAOVeiculos daoVeiculos = new DAOVeiculos();
        daoVeiculos.removerTodos();
        daoVeiculos.inserir(moto1,1);



        Cliente cli1 = new Cliente(1234, "Zé Carlos");
        Cliente cli2 = new Cliente(1734, "Zé Carlos");


        DAOCliente daoCliente = new DAOCliente();
        daoCliente.removerTodos();
        daoCliente.inserir(cli1);
        daoCliente.inserir(cli2);

        Date hoje = new Date();

        Date ontem = new Date(hoje.getTime() - 1);

        Date amanha = new Date(hoje.getTime() + 1);




        DAOAlugueis daoAlugueis = new DAOAlugueis();
        daoAlugueis.removerTodos();

        daoAlugueis.registrarAluguel("X-911", hoje, 5, 1234);

        daoAlugueis.registrarDevolucao("X-911",1);


        daoAlugueis.registrarAluguel("X-911", amanha, 4, 1234);

        daoAlugueis.registrarDevolucao("X-911",1);



        assertEquals(400.68, daoAlugueis.faturamentoTotal(1, ontem, amanha), 0.01);// Faturamento total de motos

    }

    @Test
    public void testeCalcularAluguelDAO() throws SQLException {

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        daoVeiculos.removerTodos();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        daoVeiculos.inserir(moto1,1);

       DAOAlugueis daoAlugueis = new DAOAlugueis();
       Aluguel aluguel = new Aluguel();

       Date date = new Date();
       daoAlugueis.registrarAluguel(moto1.getPlaca(),date,5,00015);

        double aluguelMoto = daoAlugueis.consultarAluguel("X-911",5,1);

// Confirmando valor do aluguel da moto: (40(diaria) + 4.52(seguro diario)) * 5 dias = 222.6

        assertEquals(222.6, aluguelMoto, 0.01);

    }


    @Test
    public void ConsultarFrotaDAO() throws SQLException {

        Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 2);

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        Veiculo carro2 = new Carro("Ford", "KA", 2010, 30000, 100, "HDL-3000", 1);

        Onibus onibus3 = new Onibus("Cálcio Motores", "Bicusp", 1985, 50000, 85, "W-321", 70);

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        daoVeiculos.removerTodos();
        daoVeiculos.inserir(carro1,2);
        daoVeiculos.inserir(carro2,2);
        daoVeiculos.inserir(onibus3,4);
        System.out.println(daoVeiculos.consultarFrota(0,0,0,70).get(0).getPlaca());
        System.out.println(daoVeiculos.consultarFrota(0,0,1,0).get(0).getPlaca());

    }


    @Test
    public void consultarSeguroDAO() throws SQLException {
        Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 1);

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        daoVeiculos.removerTodos();
        daoVeiculos.inserir(carro1,2);

        Assert.assertEquals(0.821917808219178, daoVeiculos.consultarSeguro(2, carro1.getPlaca()),0.1);

    }

    @Test
    public void pesquisarCarroDAO() throws SQLException {
        Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 1);


        DAOVeiculos daoVeiculos = new DAOVeiculos();
        daoVeiculos.removerTodos();
        daoVeiculos.inserir(carro1,2);

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        daoVeiculos.inserir(moto1,1);

        Assert.assertEquals("LVF-1000",daoVeiculos.pesquisarCarro(1).get(0).getPlaca());
        Assert.assertEquals("X-911",daoVeiculos.pesquisarMoto(50).get(0).getPlaca());


    }

    @Test

    public   void testeQuantidadeTotalDeDiariasDAO() throws SQLException {

        DAOVeiculos daoVeiculos = new DAOVeiculos();
        DAOAlugueis daoAlugueis = new DAOAlugueis();
        DAOCliente daoCliente = new DAOCliente();
        daoVeiculos.removerTodos();
        daoAlugueis.removerTodos();
        daoCliente.removerTodos();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);
        daoVeiculos.inserir(moto1,1);



        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        daoCliente.inserir(cli1);



        Date hoje = new Date();

        Date ontem = new Date(hoje.getTime() - 1);

        Date amanha = new Date(hoje.getTime() + 1);



        daoAlugueis.registrarAluguel("X-911", hoje, 5, 1234);


        daoAlugueis.registrarDevolucao("X-911",1);

        assertEquals(5, daoAlugueis.quantidadeTotalDeDiarias(1, ontem, amanha));// Quantidade de diárias de moto
    }

}