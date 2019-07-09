
package latiendita;


public class Producto {
    private int codigo;
    private double precio;
    private String seccion;
    private int cantidad;

    public Producto(int codigo, double precio, String seccion, int cantidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.seccion = seccion;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", precio=" + precio + ", seccion=" + seccion + ", cantidad=" + cantidad + '}';
    }
    
    
}
