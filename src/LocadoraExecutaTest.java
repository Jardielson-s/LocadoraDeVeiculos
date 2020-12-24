import org.junit.Assert;
import org.junit.Test;

public class LocadoraExecutaTest {

    @org.junit.Test
    public void inserir() {

        Moto moto = new Moto("honda","yahmaha",2017,17.200,15,"III-555",45.50);
        Moto moto1 = new Moto("honda","yahmaha",2017,18.200,15,"XXX-155",45.50);
        Caminhao caminhao = new Caminhao("honda","yahmaha",2017,17.200,15,"YYY-655",45);
        Carro carro = new Carro("honda","yahmaha",2017,50.200,15,"ZZZ-785",1);
        Carro carro1 = new Carro("honda","yahmaha",2017,17.950,15,"WWW-456",1);
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
        Assert.assertEquals(moto.getPlaca(), locadora.pesquisar(moto.getPlaca()).getPlaca());
        Assert.assertEquals(moto1.getPlaca(), locadora.pesquisar(moto1.getPlaca()).getPlaca());
        Assert.assertEquals(caminhao.getPlaca(), locadora.pesquisar(caminhao.getPlaca()).getPlaca());
        Assert.assertEquals(carro.getPlaca(), locadora.pesquisar(carro.getPlaca()).getPlaca());
        Assert.assertEquals("[" + carro +", "+  carro1 + "]", locadora.pesquisarCarro(1).toString());
    }

    @Test
    public void aumentaValor() {
        Moto moto = new Moto("honda","xlr8",2017,20000,500,"EDR-987",70);
        Moto moto2 = new Moto("honda","cg 125",2015,2000,50,"TVL-555",50.50);
        Onibus onibus = new Onibus("mercedes benz","401",2018,200000,600,"QET-900",40);
        Carro carro = new Carro("volks","civic",2020,20000,400,"TVU-340",2);
        Caminhao caminhao = new Caminhao("volks","civic",2021,250000,400,"LLL-234",50);

        LocadoraExecuta l = new LocadoraExecuta();
        l.cadastrar(moto);
        l.cadastrar(moto2);
        l.cadastrar(onibus);
        l.cadastrar(carro);
        l.cadastrar(caminhao);

        Veiculo procura = l.pesquisar(moto2.getPlaca());
        l.aumentarValorVeiculo(moto.getPlaca(),5);
        l.aumentarValorVeiculo(moto2.getPlaca(),20);
        l.aumentarValorVeiculo(onibus.getPlaca(),5);
        l.aumentarValorVeiculo(carro.getPlaca(), 7);
        l.aumentarValorVeiculo(caminhao.getPlaca(), 5);


        Assert.assertEquals(21000.0,moto.getValorAvaliado(),0.1);
        Assert.assertEquals(2400.0,moto2.getValorAvaliado(),0.1);
        Assert.assertEquals(210000.0,onibus.getValorAvaliado(),0.1);
        Assert.assertEquals(21400.0,carro.getValorAvaliado(),0.1);
        Assert.assertEquals(262500.0,caminhao.getValorAvaliado(),0.1);
        Assert.assertEquals(moto2.getPlaca(),procura.getPlaca());
    }

    @Test
    public void depreciaValor() {
        Moto moto = new Moto("honda","xlr8",2017,20000,500,"EDR-987",70);
        Moto moto2 = new Moto("honda","cg 125",2015,2000,50,"TVL-555",50.50);
        Onibus onibus = new Onibus("mercedes benz","401",2018,200000,600,"QET-900",40);
        Carro carro = new Carro("volks","civic",2020,20000,400,"TVU-340",2);
        Caminhao caminhao = new Caminhao("volks","civic",2021,250000,400,"LLL-234",50);

        LocadoraExecuta l = new LocadoraExecuta();
        l.cadastrar(moto);
        l.cadastrar(moto2);
        l.cadastrar(onibus);
        l.cadastrar(carro);
        l.cadastrar(caminhao);


        l.depreciaValorVeiculo("EDR-987",5);
        l.depreciaValorVeiculo("TVL-555",20);
        l.depreciaValorVeiculo("QET-900",5);
        l.depreciaValorVeiculo("TVU-340",7);
        l.depreciaValorVeiculo("LLL-234",5);


        Assert.assertEquals(19000.0,moto.getValorAvaliado(),0.1);
        Assert.assertEquals(1600.0,moto2.getValorAvaliado(),0.1);
        Assert.assertEquals(190000.0,onibus.getValorAvaliado(),0.1);
        Assert.assertEquals(18600.0,carro.getValorAvaliado(),0.1);
        Assert.assertEquals(237500.0,caminhao.getValorAvaliado(),0.1);

    }

    @Test
    public void retornaSeguro() {
        Moto moto = new Moto("honda","xlr8",2017,20000,500,"EDR-987",70);
        Moto moto2 = new Moto("honda","cg 125",2015,2000,50,"TVL-555",50.50);
        Onibus onibus = new Onibus("mercedes benz","401",2018,200000,600,"QET-900",40);
        Carro carro = new Carro("volks","civic",2020,20000,400,"TVU-340",2);
        Caminhao caminhao = new Caminhao("volks","civic",2021,250000,400,"LLL-234",50);

        LocadoraExecuta l = new LocadoraExecuta();
        l.cadastrar(moto);
        l.cadastrar(moto2);
        l.cadastrar(onibus);
        l.cadastrar(carro);
        l.cadastrar(caminhao);




        Assert.assertEquals(6.027,l.consultaSeguro(1,moto.getPlaca()),0.1);
        Assert.assertEquals(0.6027,moto2.retornaValorSeguro(),0.1);
        Assert.assertEquals(109.589041096,onibus.retornaValorSeguro(),0.1);
        Assert.assertEquals(1.643835616,carro.retornaValorSeguro(),0.1);
        Assert.assertEquals(54.794520548,caminhao.retornaValorSeguro(),0.1);

    }




}