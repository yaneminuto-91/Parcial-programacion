package CasaCambio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaccion {

    private Moneda origen;
    private Moneda destino;
    private double monto;
    private double resultado;

    public Transaccion(Moneda origen, Moneda destino, double monto, double resultado) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "us"));
        
        return formatoMoneda.format(monto) + " " + origen.getCodigo() +
                " → " + formatoMoneda.format(resultado) + " " + destino.getCodigo();
    }
}
