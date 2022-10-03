public class Cuenta2 implements Runnable{
    private CuentaBancaria cuenta =  new CuentaBancaria("12345-6789", 1000.00);
    int con = 0;
    public static void main(String[] args) {
        Cuenta2 p = new Cuenta2();
        Thread uno = new Thread(p);
        Thread dos = new Thread(p);
        uno.setName("Carlos");
        dos.setName("Marta");
        uno.start();
        dos.start();
    }
    public synchronized void run(){
        if(con == 0){
            System.out.println();
            hacerIngreso(1000.00);
            System.out.println();
            hacerRetiro(20.00);
            System.out.println();
            con++;
        }
        else if(con == 1){
            System.out.println();
            hacerIngreso(203.75);
            System.out.println();
            hacerRetiro(100.00);
            System.out.println();
        }
    }
    private void hacerRetiro(double cant){
        if(cuenta.getBalance() >= cant){
            System.out.println("La cuenta actualmente es: $" + cuenta.getBalance());
            System.out.println(Thread.currentThread().getName() + " con numero de cuenta: " + cuenta.getnumeroCuenta() + " hara un retiro de $" + cant + ".");
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
            cuenta.retirar(cant);
            System.out.println(Thread.currentThread().getName() + " completo el retiro. \nCuenta actual: $" + cuenta.getBalance());
        }
        else{
            System.out.println("No suficiente en cuenta para que " + Thread.currentThread().getName() + " con numero de cuenta: " + cuenta.getnumeroCuenta() + " haga un retiro. \nCuenta actual: $" + cuenta.getBalance());
        }
    }
    private void hacerIngreso(double cant){
        System.out.println("La cuenta actualmente es: $" + cuenta.getBalance());
        System.out.println(Thread.currentThread().getName() + " con numero de cuenta: " + cuenta.getnumeroCuenta() + " hara un deposito de $" + cant + ".");
        cuenta.depositar(cant);
        System.out.println("La cuenta actualmente es: $" + cuenta.getBalance());
    }
}
