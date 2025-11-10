/**
 * Interfaz que define el comportamiento de productos perecederos
 */
public interface Perecedero {
    /**
     * Verifica si el producto está caducado
     * @return true si está caducado, false en caso contrario
     */
    boolean estaCaducado();
}
