import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que demuestra el uso del polimorfismo
 * en el sistema de gestión de inventarios
 */
public class SistemaInventario {
    
    private List<Producto> inventario;
    
    public SistemaInventario() {
        this.inventario = new ArrayList<>();
    }
    
    /**
     * Agrega un producto al inventario
     * @param producto Producto a agregar
     */
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println(" Producto agregado: " + producto.getNombre());
    }
    
    /**
     * Muestra todos los productos del inventario
     * Demuestra polimorfismo al llamar a mostrarInfo() de cada producto
     */
    public void mostrarInventario() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("INVENTARIO COMPLETO");
        System.out.println("=".repeat(80));
        
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        
        for (Producto producto : inventario) {
            // Polimorfismo: mismo método, comportamientos diferentes
            System.out.println(producto.mostrarInfo());
        }
    }
    
    /**
     * Calcula el valor total del inventario
     * Demuestra polimorfismo al llamar a calcularPrecio() de cada producto
     */
    public void calcularValorTotal() {
        double total = 0;
        
        for (Producto producto : inventario) {
            // Polimorfismo: cada producto calcula su precio de forma diferente
            total += producto.calcularPrecio() * producto.getStock();
        }
        
        System.out.printf("\n VALOR TOTAL DEL INVENTARIO: $%.2f\n", total);
    }
    
    /**
     * Verifica productos perecederos caducados
     * Demuestra el uso de instanceof para interfaces
     */
    public void verificarCaducados() {
        System.out.println("\n VERIFICANDO PRODUCTOS CADUCADOS");
        System.out.println("-".repeat(50));
        
        boolean hayCaducados = false;
        
        for (Producto producto : inventario) {
            // Verificar si el producto implementa la interfaz Perecedero
            if (producto instanceof Perecedero) {
                Perecedero perecedero = (Perecedero) producto;
                if (perecedero.estaCaducado()) {
                    System.out.println("x " + producto.getNombre() + " - ESTÁ CADUCADO");
                    hayCaducados = true;
                }
            }
        }
        
        if (!hayCaducados) {
            System.out.println(" No hay productos caducados en el inventario.");
        }
    }
    
    /**
     * Método principal que demuestra el funcionamiento del sistema
     */
    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        
        System.out.println(" INICIANDO SISTEMA DE GESTIÓN DE INVENTARIOS");
        System.out.println(" Demostración de Polimorfismo en Java");
        
        // Crear productos de diferentes tipos (POLIMORFISMO)
        Producto laptop = new Electronico("Laptop Gaming", 1200.0, 5, 24, "Dell");
        Producto telefono = new Electronico("Smartphone", 800.0, 10, 12, "Samsung");
        
        Producto leche = new Alimento("Leche Entera", 2.5, 20, 
                                    LocalDate.of(2024, 2, 15), "L-2024-001");
        Producto pan = new Alimento("Pan Integral", 1.8, 15,
                                  LocalDate.of(2024, 1, 10), "L-2024-002");
        
        Producto camisa = new Ropa("Camisa Casual", 35.0, 8, "M", "Azul", "Algodón");
        Producto vestido = new Ropa("Vestido Elegante", 89.0, 3, "S", "Rojo", "Seda");
        
        // Agregar productos al inventario
        sistema.agregarProducto(laptop);
        sistema.agregarProducto(telefono);
        sistema.agregarProducto(leche);
        sistema.agregarProducto(pan);
        sistema.agregarProducto(camisa);
        sistema.agregarProducto(vestido);
        
        // Demostrar polimorfismo
        sistema.mostrarInventario();
        sistema.calcularValorTotal();
        sistema.verificarCaducados();
        
        // Demostrar actualización de stock (método común)
        System.out.println("\n ACTUALIZANDO STOCKS");
        System.out.println("-".repeat(50));
        
        laptop.actualizarStock(-2); // Vender 2 laptops
        leche.actualizarStock(10);  // Comprar 10 leches
        
        sistema.mostrarInventario();
        
        // Demostrar método común hayStock()
        System.out.println("\n VERIFICACIÓN DE STOCK DISPONIBLE");
        System.out.println("-".repeat(50));
        
        for (Producto producto : sistema.inventario) {
            String estadoStock = producto.hayStock() ? " DISPONIBLE" : " AGOTADO";
            System.out.printf("%s: %s (Stock: %d)\n", 
                            producto.getNombre(), estadoStock, producto.getStock());
        }
    }
}
