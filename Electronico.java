/**
 * Clase que representa productos electrónicos
 * Hereda de Producto
 */
public class Electronico extends Producto {
    private int mesesGarantia;
    private String marca;
    
    /**
     * Constructor de productos electrónicos
     * @param nombre Nombre del producto
     * @param precio Precio base
     * @param stock Stock inicial
     * @param mesesGarantia Meses de garantía
     * @param marca Marca del producto
     */
    public Electronico(String nombre, double precio, int stock, 
                      int mesesGarantia, String marca) {
        super(nombre, precio, stock);
        this.mesesGarantia = mesesGarantia;
        this.marca = marca;
    }
    
    // Getters y setters específicos
    public int getMesesGarantia() { return mesesGarantia; }
    public void setMesesGarantia(int mesesGarantia) { 
        this.mesesGarantia = mesesGarantia; 
    }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    /**
     * Implementación del cálculo de precio para electrónicos
     * Aplica un impuesto del 18% y cargo por garantía
     * @return Precio final del producto electrónico
     */
    @Override
    public double calcularPrecio() {
        double impuesto = this.precio * 0.18;
        double cargoGarantia = this.mesesGarantia * 2.5;
        return this.precio + impuesto + cargoGarantia;
    }
    
    /**
     * Muestra información detallada del producto electrónico
     * @return String con información formateada
     */
    @Override
    public String mostrarInfo() {
        return String.format(
            "ELECTRÓNICO - ID: %s | Nombre: %s | Marca: %s | " +
            "Precio Base: $%.2f | Precio Final: $%.2f | " +
            "Garantía: %d meses | Stock: %d",
            this.id.substring(0, 8), this.nombre, this.marca,
            this.precio, this.calcularPrecio(),
            this.mesesGarantia, this.stock
        );
    }
}
