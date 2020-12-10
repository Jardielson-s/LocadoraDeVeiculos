import org.junit.Assert;

public class LocadoraExecutaTest {

    @org.junit.Test
    public void inserir() {
        LocadoraExecuta l = new LocadoraExecuta();
        Moto m = new Moto("honda","yahmaha",2017,17.200,15,"555i",45.50);
        Moto m2 = new Moto("honda","yahmaha",2017,17.200,15,"555x",45.50);
        Moto m3 = new Moto("honda","yahmaha",2017,17.200,15,"555y",45.50);
        Carro c = new Carro("honda","yahmaha",2017,17.200,15,"555z",1);
        Carro c1 = new Carro("honda","yahmaha",2017,17.200,15,"555w",1);
        Cliente cl = new Cliente("jardielson","000.000.000-00");
        Cliente cl1 = new Cliente("json","000.000.000-01");
        Aluguel a = new Aluguel();
        Aluguel a1 = new Aluguel();
        a.setDias(2);
        a1.setDias(5);
        a.setAlugado(true);
        a1.setAlugado(true);
        a.setVeiculo(m);
        a1.setVeiculo(m2);
        l.inserir(m);
        l.inserir(c);
        l.inserir(c1);
        l.inserir(m2);
        l.inserirAlugel(a);
        l.inserirAlugel(a1);



        //l.inserir(c1);
        //l.aumentarDiaria(2,12);

       // l.depreciarVeiculos(2,12);
       // l.inserir(m);
        //Assert.assertEquals(16.8,c1.getValorDiaria(),0.2);
        //Assert.assertTrue(l.registrarAluguel("555w", 15, cl));
        //Assert.assertEquals(84.01,l.calcularAluguel("555w",5),0.2);
        //Assert.assertEquals(30.00,l.calcularAluguel("555i",2),0.2);
        //double Total = l.faturamentoTotal(0);
       // Assert.assertEquals(120,l.faturamentoTotal(0),0.2);
        Assert.assertEquals(5,l.quantidadeTotalDeDiarias(2));
    }
}