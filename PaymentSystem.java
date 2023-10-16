//Strategy Pattern
//Task-6
public class PaymentSystem {
    public static void main(String[] args) {
      
        PaymentMethod creditCardMethod = new CreditCardPayment("213-134-013","Abhishek");
        PaymentMethod payPalMethod = new PayPalPayment("abhishekchowdhury054@gmail.com");
        PaymentMethod bankTransferMethod = new BankTransferPayment("213-134-013");

        PaymentContext paymentContext = new PaymentContext(creditCardMethod);
        paymentContext.performPayment(100.0);

        PaymentContext paymentContext2 = new PaymentContext(payPalMethod);
        paymentContext2.performPayment(1000.00);

        PaymentContext paymentContext3 = new PaymentContext(bankTransferMethod);
        paymentContext3.performPayment(500.0);
    }
}

class PaymentContext{
    private PaymentMethod paymentMethod;

    public PaymentContext(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void performPayment(double amount){
        paymentMethod.pay(amount);
    }
}

interface PaymentMethod{
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod{
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name){
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid $" + amount + " using credit card number: " + cardNumber);
    }
}

class PayPalPayment implements PaymentMethod{
    private String email;

    public PayPalPayment(String email){
        this.email = email;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid $" + amount + " using PayPal Id" + email);
    }
}

class BankTransferPayment implements PaymentMethod{
    private String accountNumber;

    public BankTransferPayment(String accountNumber){
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid $" + amount + "using account no: " +accountNumber);
    }
}