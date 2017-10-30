@@ -0,0 +1,151 @@
public class BankAccount {
    private String name;
    private int number;
    private char type;
    private double balance;
    private boolean isActive;
    
    public BankAccount(String name, int number) {
        this.name = name;
        this.number = number;
        isActive = false;
        balance = 0.0;
        type = 'I';
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public boolean getIsActive() {
        return isActive;
    }
    
    public double getBalance() {
        return balance;
    } 
    
    public void changeAccountType(char type) {
        if(type == 'I' || type == 'S' || type == 'M' || type == 'J') {
            this.type = type;
        } else {
            System.out.println("São apenas aceites contas do tipo Individual (I), Solidária (S), Mista (M) ou Conjunta (J)");
        }
    }
    
    public void open(double balance) {
        if(isActive == false & this.balance == 0.0) {
            if(balance >= 100) {
                this.balance = balance;
                isActive = true;
            } else {
                System.out.println("Para inicializar a conta são precisos pelo menos 100€.");
            }
        } else {
            System.out.print("A conta já foi aberta.");
        }
    }
    
    public void deposit(double amount) {
        if(isActive != true) {
            System.out.println("Conta inativa! Impossível fazer depósito.");
        } else {
            if(amount < 0) {
                System.out.println("O valor do depósito é inválido.");
            } else {
                balance += amount;
            }
        }
    }
    
    public void withdraw(double amount) {
        if(isActive != true) {
            System.out.println("Levantamento indispónivel porque a conta está inativa.");
        } else {
            if(amount < 0) {
                System.out.println("O valor do levantamento é inválido.");
            } else {
                if(balance < amount) {
                    System.out.println("O seu saldo só lhe permite levantar" + balance + " euros");
                } else {
                    balance -= amount;
                }
            }
        }
    }
    
    private String printType(char type) {
        if(type == 'I') 
            return "Individual";
        else if(type == 'S')
            return "Solidária";
        else if(type == 'M')
            return "Mista";
        else if(type == 'J') 
            return "Conjunta";
        else
            return "Indefinida"; 
    }
    
    private String printActive(boolean active) {
        if(active == true) { 
            return "Sim";
        }else {
            return "Não";
        }
    }
    
    public void showInfo() {
        System.out.println("      *** Dados da Conta *** ");
        System.out.println("Nome da conta: " + name);
        System.out.println("Número da conta: " + number);
        System.out.println("Tipo de conta: " + printType(type));
        System.out.println("Saldo: " + balance + " euros");
        System.out.println("Conta ativa? " + printActive(isActive));
    }
    
    public double annualInterest() {
        double lucro = 0;
        if(balance < 2000.0) 
            lucro = balance - (balance * 0.009);
        else if(balance >= 2000.0 & balance < 5000.0) 
            lucro = balance - (balance * 0.01);
        else if(balance>= 5000.0 & balance < 10000.0) 
            lucro = balance - (balance * 0.015);
        else if(balance >= 10000.0) 
            lucro = balance - (balance * 0.02);
        return lucro;        
    }
    
    public void creditAnnualInterest() {
        double lucro = 0;
        if(balance < 2000.0) 
            lucro = balance - (balance * 0.009);
        else if(balance >= 2000.0 & balance < 5000.0) 
            lucro = balance - (balance * 0.01);
        else if(balance>= 5000.0 & balance < 10000.0) 
            lucro = balance - (balance * 0.015);
        else if(balance >= 10000.0) 
            lucro = balance - (balance * 0.02);
            
        balance += lucro;
    }
    
    public double monthInterest() {
        double lucro = 0;
        if(balance < 2000.0) 
            lucro = balance -(Math.pow(1.009,(1/12)));
        else if(balance >= 2000.0 & balance < 5000.0) 
            lucro = Math.pow(1.01,(1/12)) - 1;
        else if(balance>= 5000.0 & balance < 10000.0) 
            lucro = Math.pow(1.015,(1/12)) - 1;
        else if(balance >= 10000.0) 
            lucro = Math.pow(1.02,(1/12)) - 1;
        return lucro;
    }
}
