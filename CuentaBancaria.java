public class CuentaBancaria {
    private double balance;
    private String numeroCuenta;
    public double getBalance(){
        return balance;
    }
    public String getnumeroCuenta(){
        return numeroCuenta;
    }
    public CuentaBancaria(String numeroCuenta, double balanceInicial){
        this.numeroCuenta = numeroCuenta;
        this.balance = balanceInicial;
    }
    public void depositar(double cantidad){
        balance += cantidad;
    }
    public void retirar(double cantidad){
        balance -= cantidad;
    }
}
