package jardielsonSilvaFerreira.locadora;

import java.util.Date;

public class Aluguel {

    private Cliente cliente;
    private int cpf;
    private Veiculo placa;
    private boolean alugado;

    private int dias;
   // private Date dias;
    public void setAlugado(boolean alugado){
        this.alugado = alugado;
    }
    public boolean getAlugado(){return alugado;}
    public Veiculo getVeiculo() {
        return placa;
    }
    public void setVeiculo(Veiculo placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public void cadastrar(Veiculo placa, int dias, int cpf) {
        this.dias = dias;
        this.cpf = cpf;
        this.placa = placa;
    }
    }
