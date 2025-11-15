package CasaCambio;

public abstract class Moneda {

    private String nombre;
    private String codigo;
    private double valorEnCOP;

    public Moneda(String nombre, String codigo, double valorEnCOP) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.valorEnCOP = valorEnCOP;
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getValorEnCOP() { return valorEnCOP; }

    public double convertirA(double monto, Moneda destino) {
        double montoEnCOP = monto * valorEnCOP;
        return montoEnCOP / destino.valorEnCOP;
    }

    @Override
    public String toString() {
        return codigo;
    }
}

