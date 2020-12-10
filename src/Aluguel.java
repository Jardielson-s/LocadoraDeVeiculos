import java.util.Date;

public class Aluguel {

    private Cliente cliente;
    private Veiculo placa;
    private boolean alugado;

    private int dias;
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
   /* public Date getData() {
        return data;
    }
    //public void setData(Date data) {
        this.data = data;
    }*/
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public void cadastrar(Veiculo placa, int dias, Cliente cliente) {
        this.dias = dias;
        this.cliente = cliente;
        this.placa = placa;
    }
    }
