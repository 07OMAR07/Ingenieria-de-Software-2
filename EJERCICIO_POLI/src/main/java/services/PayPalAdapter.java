package services;

public class PayPalAdapter implements PagoAdapter {
    private PayPalAPI paypalAPI;

    public PayPalAdapter() {
        this.paypalAPI = new PayPalAPI(); // Suponiendo que PayPalAPI es una clase externa para interactuar con PayPal.
    }

    @Override
    public void procesarPago(double monto) {
        // Aquí iría el código específico para procesar el pago con PayPal.
        paypalAPI.realizarPago(monto);
        System.out.println("Pago realizado con PayPal: " + monto);
    }
}