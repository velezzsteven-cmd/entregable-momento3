import java.util.Scanner;
 
public class AmericanEagleBodega {
    public static boolean nombreFuncion(String[] lote, String nombreBuscado) {
        for (int i = 0; i < lote.length; i++) {
            if (lote[i] != null && lote[i].equalsIgnoreCase(nombreBuscado)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] lote = {"Jeans AirFlex", "Graphic Tee", "Denim Jacket", null, null};

        int opcion = 0;

        do {
            System.out.println("\n===== BODEGA AMERICAN EAGLE - CAJA DENIM =====");
            System.out.println("1. Listar Colección en Bodega");
            System.out.println("2. Buscar Referencia en Lote");
            System.out.println("3. Ingresar Prenda al Lote");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
 
            String entrada = sc.nextLine().trim();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0; // opción inválida
            }
 