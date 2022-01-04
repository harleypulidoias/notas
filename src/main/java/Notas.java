import java.util.ArrayList;

public class Notas {

    private double valor;
    private double porcentaje;

    public Notas() {

    }

    public Notas(double valor, double porcentaje) {
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "valor=" + valor +
                ", porcentaje=" + porcentaje +
                '}';
    }



}
