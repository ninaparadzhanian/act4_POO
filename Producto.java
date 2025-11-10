import java.util.UUID;

/**
 * Clase abstracta que representa un producto genérico en el inventario
 * Define los atributos y métodos comunes para todos los productos
 */
public abstract class Producto {
    // Atributos protegidos para que las subclases puedan acceder
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;
    
    /**
     * Constructor de la clase Producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param stock Cantidad en stock
     */
    public Producto(String nombre, double precio, int stock) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Métodos getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    
    /**
     * Método abstracto para calcular el precio final
     * Cada subclase debe implementar su propia lógica
     * @return Precio final del producto
     */
    public abstract double calcularPrecio();
    
    /**
     * Método abstracto para mostrar información del producto
     * @return String con la información formateada
     */
    public abstract String mostrarInfo();
    
    /**
     * Actualiza el stock del producto
     * @param cantidad Cantidad a agregar (positiva) o quitar (negativa)
     */
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
        if (this.stock < 0) {
            this.stock = 0;
        }
    }
    
    /**
     * Método concreto común a todos los productos
     * @return true si hay stock disponible
     */
    public boolean hayStock() {
        return this.stock > 0;
    }
}
