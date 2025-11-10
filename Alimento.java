import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa productos alimenticios
 * Hereda de Producto e implementa Perecedero
 */
public class Alimento extends Producto implements Perecedero {
    private LocalDate fechaCaducidad;
    private String lote;
    
    /**
     * Constructor de productos alimenticios
     * @param nombre Nombre del producto
     * @param precio Precio base
     * @param stock Stock inicial
     * @param fechaCaducidad Fecha de caducidad
     * @param lote Número de lote
     */
    public Alimento(String nombre, double precio, int stock,
                   LocalDate fechaCaducidad, String lote) {
        super(nombre, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
        this.lote = lote;
    }
    
    // Getters y setters específicos
    public LocalDate getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(LocalDate fechaCaducidad) { 
        this.fechaCaducidad = fechaCaducidad; 
    }
    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }
    
    /**
     * Implementación del método de la interfaz Perecedero
     * @return true si el producto está caducado
     */
    @Override
    public boolean estaCaducado() {
        return LocalDate.now().isAfter(this.fechaCaducidad);
    }
    
    /**
     * Implementación del cálculo de precio para alimentos
     * Aplica descuento si está próximo a caducar
     * @return Precio final del alimento
     */
    @Override
    public double calcularPrecio() {
        LocalDate hoy = LocalDate.now();
        LocalDate unaSemanaDespues = hoy.plusDays(7);
        
        if (this.fechaCaducidad.isBefore(unaSemanaDespues)) {
            // 30% de descuento si caduca en menos de una semana
            return this.precio * 0.7;
        }
        return this.precio;
    }
    
    /**
     * Muestra información detallada del alimento
     * @return String con información formateada
     */
    @Override
    public String mostrarInfo() {
        String estado = estaCaducado() ? "CADUCADO" : "VÁLIDO";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        return String.format(
            "ALIMENTO - ID: %s | Nombre: %s | Lote: %s | " +
            "Precio Base: $%.2f | Precio Final: $%.2f | " +
            "Caducidad: %s | Estado: %s | Stock: %d",
            this.id.substring(0, 8), this.nombre, this.lote,
            this.precio, this.calcularPrecio(),
            this.fechaCaducidad.format(formatter), estado, this.stock
        );
    }
}
