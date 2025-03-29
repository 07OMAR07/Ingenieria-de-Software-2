package model;

public class PayPal {
    private int cedula;



    public String hacerPagoPayPal(double cantidad) {
        return "Pago de $" + cantidad + " realizado con PayPal con cédula: " ;
    }
}