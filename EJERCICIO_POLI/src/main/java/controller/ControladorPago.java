package controller;

import model.Nequi;
import model.NequiAdapter;
import model.Pago;
import model.PayPal;
import model.PayPalAdapter;

public class ControladorPago{

    private Pago pago;

    public String procesarPago(String metodo, double monto) {
        if (metodo.equals("Nequi")) {
            pago = new NequiAdapter(new Nequi("diego@gmail.com"));
        } else {
            pago = new PayPalAdapter(new PayPal(1071162531));
        }

        // Capturar el resultado del pago y retornarlo
        return pago.realizarPago(monto);
    }
}