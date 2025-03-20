package controller;

import services.PagoAdapter;
import services.NequiAdapter;
import services.PayPalAdapter;

public class ControladorPago {

    public void procesarPago(String metodoPago, double monto) {
        PagoAdapter pagoAdapter;

        // Elegir el adaptador correcto según el método de pago
        if ("Nequi".equals(metodoPago)) {
            pagoAdapter = new NequiAdapter();
        } else if ("PayPal".equals(metodoPago)) {
            pagoAdapter = new PayPalAdapter();
        } else {
            System.out.println("Método de pago no soportado");
            return;
        }

        // Procesar el pago utilizando el adaptador seleccionado
        pagoAdapter.procesarPago(monto);
    }
}