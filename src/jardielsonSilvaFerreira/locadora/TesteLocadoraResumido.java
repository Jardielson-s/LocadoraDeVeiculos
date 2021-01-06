package jardielsonSilvaFerreira.locadora;

import java.util.Date;


import jardielsonSilvaFerreira.locadora.*;
import org.junit.Assert;
import org.junit.Test;



import static org.junit.Assert.*;



import java.util.ArrayList;



public class TesteLocadoraResumido {

    @Test

  public  void testeInserirVeiculo() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 3);

        locadora.inserir(carro1);

        assertFalse(locadora.inserir(carro1));

        Veiculo recuperado = locadora.pesquisar("LVF-1000");

        Assert.assertEquals("Ford", recuperado.getMarca());

        Assert.assertEquals("F-1000", recuperado.getModelo());

        Assert.assertEquals(1980, recuperado.getAnoDeFabricacao());

        Assert.assertEquals(10000, recuperado.getValorAvaliado(), 0.0001);

        Assert.assertEquals(50, recuperado.getValorDiaria(),0);

        assertEquals(3, ((Carro) recuperado).getTipo());

    }



    @Test

   public void testeInserirCliente() {

        MinhaLocadora locadora = new MinhaLocadora();

        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        locadora.inserir(cli1);

        assertFalse(locadora.inserir(cli1));

        Cliente cli2 = locadora.pesquisarCliente(1234);

        assertEquals("Zé Carlos", cli2.getNome());

    }



    @Test

  public   void testePesquisarVeiculo() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo carro1 = new Carro("Ford", "F-1000", 1980, 10000, 50, "LVF-1000", 3);

        Veiculo carro2 = new Carro("Ford", "KA", 2010, 30000, 100, "LVF-3000", 1);



        locadora.inserir(carro1);

        locadora.inserir(carro2);

        Veiculo pesquisa = locadora.pesquisar("LVF-3000");

// Teste para saber se a pesquisa deu certo

        Assert.assertEquals("KA", pesquisa.getModelo());

        Veiculo pesquisa2 = locadora.pesquisar("LVF-1111");

// Teste para saber se a pesquisa nao encontrou nada

        assertNull(pesquisa2);

    }



    @Test

   public void testePesquisarOnibus() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo onibus1 = new Onibus("Estrela", "Aldebarã", 1975, 30000, 60, "X-911", 49);

        Veiculo onibus2 = new Onibus("Joca Motores", "Kall'anggo", 1978, 40000, 70, "Q-123", 50);

        Veiculo onibus3 = new Onibus("Cálcio Motores", "Bicusp", 1985, 50000, 85, "W-321", 70);



        locadora.inserir(onibus1);

        locadora.inserir(onibus2);

        locadora.inserir(onibus3);



        ArrayList<Veiculo> onibus50p = locadora.pesquisarOnibus(50);



// Confirmando numero de onibus com 50 passageiros

        assertEquals(2, onibus50p.size());

    }



    @Test

   public void testeCalcularAluguel(){

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        locadora.inserir(moto1);



        double aluguelMoto = locadora.calcularAluguel("X-911", 5);



// Confirmando valor do aluguel da moto: (40(diaria) + 4.52(seguro diario)) * 5 dias = 222.6

        assertEquals(222.6, aluguelMoto, 0.01);



    }



    @Test

  public   void testeRegistrarAluguel() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);

        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        locadora.inserir(carro1);

        locadora.inserir(cli1);



        Date hoje = new Date();

        locadora.registrarAluguel("A-100", hoje, 5, 1234);

// Registrar aluguel de veiculo já registrado

        assertFalse(locadora.registrarAluguel("A-100", hoje, 5, 1234));

// Registrar aluguel de veiculo inexistente

        assertFalse(locadora.registrarAluguel("A-111", hoje, 5, 1234));

// Registrar aluguel de cliente inexistente

        assertFalse(locadora.registrarAluguel("A-111", hoje, 5, 1111));

    }



    @Test

  public   void testeRegistrarDevolucao() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo carro1 = new Carro("Estrela", "Antares", 1980, 20000, 50, "A-100", 1);

        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        locadora.inserir(carro1);

        locadora.inserir(cli1);



        Date hoje = new Date();

        assertTrue(locadora.registrarAluguel("A-100", hoje, 5, 1234));

        assertTrue(locadora.registrarDevolucao("A-100"));



// Tentar devolução de veiculo não alugado

        assertFalse(locadora.registrarDevolucao("A-100"));



// Tentar devolução de veiculo de veiculo não existente

        assertFalse(locadora.registrarDevolucao("A-111"));

    }



    @Test

  public   void testeAumentarDiaria() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        locadora.inserir(moto1);



        locadora.aumentarDiaria(1, 0.1);// Aumentando diária de motos em 10%



        assertEquals(44, locadora.pesquisar("X-911").getValorDiaria(), 0.01);



    }



    @Test

   public void testeFaturamentoTotal()  {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        locadora.inserir(moto1);



        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        locadora.inserir(cli1);

        Date hoje = new Date();

        Date ontem = new Date(hoje.getTime() - 1);

        Date amanha = new Date(hoje.getTime() + 1);



        locadora.registrarAluguel("X-911", hoje, 5, 1234);// Valor do aluguel = 222.6  (moto)

        locadora.registrarDevolucao("X-911");



        assertEquals(222.6, locadora.faturamentoTotal(1, ontem, amanha), 0.01);// Faturamento total de motos

    }



    @Test

  public   void testeQuantidadeTotalDeDiarias() {

        MinhaLocadora locadora = new MinhaLocadora();

        Veiculo moto1 = new Moto("Estrela", "Andromeda", 1975, 15000, 40, "X-911", 50);

        locadora.inserir(moto1);



        Cliente cli1 = new Cliente(1234, "Zé Carlos");

        locadora.inserir(cli1);



        Date hoje = new Date();

        Date ontem = new Date(hoje.getTime() - 1);

        Date amanha = new Date(hoje.getTime() + 1);



        locadora.registrarAluguel("X-911", hoje, 5, 1234);// 5 diárias de moto

        locadora.registrarDevolucao("X-911");



        assertEquals(5, locadora.quantidadeTotalDeDiarias(1, ontem, amanha));// Quantidade de diárias de moto

    }



}