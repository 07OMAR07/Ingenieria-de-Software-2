package services;

public class NequiAdapter implements PagoAdapter {
    private NequiAPI nequiAPI;

    public NequiAdapter() {
        this.nequiAPI = new NequiAPI(); // Suponiendo que NequiAPI es una clase externa para interactuar con Nequi.
    }

    @Override
    public void procesarPago(double monto) {
        // Aquí iría el código específico para procesar el pago con Nequi.
        nequiAPI.realizarPago(monto);
        System.out.println("Pago realizado con Nequi: " + monto);
    }
}