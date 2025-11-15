package CasaCambio;

import java.util.ArrayList;

public class CasaDeCambio {

    private ArrayList<Transaccion> historial = new ArrayList<>();

    public double simular(double monto, Moneda origen, Moneda destino) {
        return origen.convertirA(monto, destino);
    }

    public void registrar(double monto, Moneda origen, Moneda destino) {
        double resultado = simular(monto, origen, destino);
        historial.add(new Transaccion(origen, destino, monto, resultado));
    }

    public ArrayList<String> obtenerHistorial() {
        ArrayList<String> datos = new ArrayList<>();
        for (Transaccion t : historial) {
            datos.add(t.toString());
        }
        return datos;
    }

    public void borrarHistorial() {
        historial.clear();
    }
}
