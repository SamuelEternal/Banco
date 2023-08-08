import java.util.ArrayList;
import java.util.List;

class ContaBancaria{ 
    private String nomeConta;
    private double saldo;
    private int numConta;

// construtor
    public ContaBancaria(String nome, double saldoInicial, int numeroDaConta){
        this.nomeConta = nome;
        this.saldo = saldoInicial;
        this.numConta = numeroDaConta;
    }

    public int getNumeroConta(){
        return numConta;
    }

    public String getNomeConta(){
        return nomeConta;
    }
    public double getSaldo(){
        return saldo;
    }

    public void deposito(double value){
        saldo += value;
    }
    public void sacar(double value){
        if(value <= saldo){
            saldo -= value;
        }
        else{
            System.out.println("Saldo insuficiente.");
        }
    }
}
class AgenciaBancaria{
    private int numeroAgencia;
    private List<ContaBancaria> contas;

    public AgenciaBancaria(int numeroAgencia){
        this.numeroAgencia = numeroAgencia;
        this.contas = new ArrayList<>(); 
    }
    public void adicionarConta(ContaBancaria conta){
        contas.add(conta);

    }
    public void removerConta(ContaBancaria conta ){
        contas.remove(conta);
    }
    public void ListarContas(){
        System.out.println("Lista de contas dentro da Agencia" + numeroAgencia);
        for (ContaBancaria conta : contas){
            System.out.println("Numero da conta: "+ conta.getNumeroConta());
            System.out.println("Nome da conta: "+ conta.getNomeConta());
            System.out.println("Saldo: "+ conta.getSaldo());
            System.out.println("-------------------------------");
        }
    }
}

public class Main{
    public static void main(String[] args){
        AgenciaBancaria agencia = new AgenciaBancaria(1337);
        ContaBancaria conta_pedro = new ContaBancaria("Pedro", 500.0, 9999);
        ContaBancaria conta_lucia = new ContaBancaria("Lucia", 1200.0, 4444);
        agencia.adicionarConta(conta_pedro);
        agencia.adicionarConta(conta_lucia);
        agencia.ListarContas();

        conta_lucia.deposito(2000);
        conta_pedro.deposito(1500);
        conta_pedro.sacar(300);
        conta_lucia.sacar(1000);

        agencia.ListarContas();

    }
}