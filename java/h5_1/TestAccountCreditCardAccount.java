package h5_1;

import java.util.Scanner;

public class TestAccountCreditCardAccount {
    public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            CreditCardAccount creaditAccount = new CreditCardAccount(1, 2, 2);

            System.out.println("--------信用卡账户的初始信息---------\n" + creaditAccount.toString());

            creaditAccount.depoit(input.nextDouble());

            System.out.println("--------信用卡账户存款后的信息--------\n" + creaditAccount.toString());

            creaditAccount.withdraw(input.nextDouble());

            System.out.println("--------信用卡账户取款后的信息--------\n" + creaditAccount.toString());
            
            System.out.println("\n*********************************************\n");
            SavingsCard savingsCard = new SavingsCard(2, 2);

            System.out.println("--------储蓄卡账户的初始信息---------\n" + savingsCard.toString());

            savingsCard.depoit(input.nextDouble());

            System.out.println("--------储蓄卡账户存款后的信息--------\n" + savingsCard.toString());

            savingsCard.withdraw(input.nextDouble());

            System.out.println("--------储蓄卡账户取款后的信息--------\n" + savingsCard.toString());
    }
}

class Account {
    private int id;
    private double balance;

    public Account(){}

    public Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }

    public void depoit(double money) {
        balance += money;
    }

    public void withdraw(double money) {
        balance -= money;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    @Override
    public String toString(){
        return "账户"+id+" 余额"+balance;
    }
    

}

class CreditCardAccount extends Account{
            private double creditCardLimit = 5000;
            public CreditCardAccount(){}
            public CreditCardAccount(int id,double balance,double creditCardLimit){
                super(id,balance);
                this.creditCardLimit=creditCardLimit;
            }

            @Override
            public void withdraw(double money){
                if (getBalance()-money < 0) {
                    System.out.println("余额不足");
                    return;
                }
                setBalance(getBalance()-money);
            }

            @Override
            public String toString(){
                return super.toString() + " 额度" + creditCardLimit;
            }
    }
class SavingsCard extends Account {
    public SavingsCard(){}
    public SavingsCard(int id,double balance){
        super(id,balance);
    }
    @Override
    public void withdraw(double money){
        double remain = getBalance() - money;
        if (remain<0) {
                System.out.println("余额不足");
                return;
            }
        setBalance(remain);
    }
    @Override
    public String toString(){
        return super.toString();
    }
}

