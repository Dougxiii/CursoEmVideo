package ContaBanco;

public class ContaBanco {

    //Atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    // Métodos
    public void estadoAtual(){
        System.out.println("-------------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Cliente: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: "+ this.getStatus() );
        System.out.println("-------------------------------------------");

    }
    public void abrirConta(String tipo){
        this.setTipo(tipo);
        this.setStatus(true);

        if(tipo == "cc"){
            this.setSaldo(50);

        }else if (tipo == "cp"){
            this.setSaldo(150);
        }
        else{
            System.out.println("Digite um tipo de conta válido! ");
        }
        System.out.println("Conta aberta com sucesso! ");
    }

    public void fecharConta(){
        if(this.getSaldo() > 0){
            System.out.println("Não pode ser fechada! Conta com saldo positivo");

        }else if(this.getSaldo() < 0){
            System.out.println("Não pode ser fechada! Conta em débito");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso! ");
        }
    }

    public void depositar(float valor){
        if(this.getStatus() == true){
            this.setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado na conta de " + this.getDono());
        }else{
            System.out.println("Impossivel depositar! ");
        }
    }

    public void sacar(float valor){
        if(getStatus() == true ){
            if(getSaldo() >= valor){
                setSaldo(getSaldo() -  valor);
                System.out.println("Saque realizado com sucesso! ");
            }else{
                System.out.println("Saldo Insuficiente! ");
            }
        }else{
            System.out.println("Operação Impossivel! ");
        }
    }

    public void pagarMensal(){
        float mensalidade = 0 ;
        if(this.getTipo() == "cc"){
            mensalidade = 12;
        }else if(this.getTipo()=="cp"){
            mensalidade = 20;
        }else{
            System.out.println("tipo de conta invalida");
        }
        if(getStatus() == true){
            if(saldo>mensalidade){
                setSaldo(getSaldo() - mensalidade);
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("Operação Impossivel! ");
        }

    }

    // Construtor
    public ContaBanco(){
        this.setSaldo(0);
        this.setStatus(false);
    }

    // getters and setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
