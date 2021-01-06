package jardielsonSilvaFerreira.locadora;

public class Cliente {

    private final String nome;
    private final int cpf;

    public Cliente(int cpf,String nome){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }


    public int getCpf() {
        return cpf;
    }

}
