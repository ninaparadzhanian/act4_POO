/**
 * Clase que representa productos de ropa
 * Hereda de Producto
 */
public class Ropa extends Producto {
    private String talla;
    private String color;
    private String material;
    
    /**
     * Constructor de productos de ropa
     * @param nombre Nombre del producto
     * @param precio Precio base
     * @param stock Stock inicial
     * @param talla Talla de la ropa
     * @param color Color de la ropa
     * @param material Material de la ropa
     */
    public Ropa(String nombre, double precio, int stock,
               String talla, String color, String material) {
        super(nombre, precio, stock);
        this.talla = talla;
        this.color = color;
        this.material = material;
    }
    
    // Getters y setters específicos
    public String getTalla() { return talla; }
    public void setTalla(String talla) { this.talla = talla; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    
    /**
     * Implementación del cálculo de precio para ropa
     * Aplica descuentos según el material
     * @return Precio final de la ropa
     */
    @Override
    public double calcularPrecio() {
        double precioFinal = this.precio;
        
        // Aplicar descuentos según el material
        switch (this.material.toLowerCase()) {
            case "algodón":
                precioFinal *= 0.95; // 5% descuento
                break;
            case "lino":
                precioFinal *= 0.90; // 10% descuento
                break;
            case "seda":
                precioFinal *= 1.10; // 10% de aumento
                break;
        }
        
        return precioFinal;
    }
    
    /**
     * Muestra información detallada de la ropa
     * @return String con información formateada
     */
    @Override
    public String mostrarInfo() {
        return String.format(
            "ROPA - ID: %s | Nombre: %s | Talla: %s | " +
            "Color: %s | Material: %s | " +
            "Precio Base: $%.2f | Precio Final: $%.2f | Stock: %d",
            this.id.substring(0, 8), this.nombre, this.talla,
            this.color, this.material, this.precio,
            this.calcularPrecio(), this.stock
        );
    }
}
