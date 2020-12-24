import org.junit.Assert;

public class LocadoraExecutaTest {

    @org.junit.Test
    public void inserir() {

        Moto moto = new Moto("honda","yahmaha",2017,17.200,15,"555i",45.50);
        Moto moto1 = new Moto("honda","yahmaha",2017,18.200,15,"555x",45.50);
        Caminhao caminhao = new Caminhao("honda","yahmaha",2017,17.200,15,"555y",45);
        Carro carro = new Carro("honda","yahmaha",2017,50.200,15,"555z",1);
        Carro carro1 = new Carro("honda","yahmaha",2017,17.950,15,"555w",1);
        Onibus onibus = new Onibus("house","honda",2017,5100,50.50,"LLL-222",15);
        Cliente cliente = new Cliente("jardielson","000.000.000-00");
        Cliente cliente1 = new Cliente("json","000.000.000-01");

        LocadoraExecuta locadora = new LocadoraExecuta();

        locadora.cadastrar(moto);
        locadora.cadastrar(moto1);
        locadora.cadastrar(caminhao);
        locadora.cadastrar(carro);
        locadora.cadastrar(carro1);
        locadora.cadastrar(onibus);

        locadora.inserir(cliente);
        locadora.inserir(cliente1);


        Assert.assertEquals(onibus.getPlaca(), locadora.pesquisar("LLL-222").getPlaca());
    }
}