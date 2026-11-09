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
            System.out.println("\n BODEGA AMERICAN EAGLE ");
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
 
            switch (opcion) {
                case 1:
                    System.out.println("\n Referencias en la caja ");
                    boolean hayPrendas = false;

                    for (int i = 0; i < lote.length; i++) {
                        if (lote[i] != null) {
                            System.out.println((i + 1) + ". " + lote[i]);
                            hayPrendas = true;
                        }
                    }
                    if (!hayPrendas) {
                        System.out.println("La caja está vacía.");
                    }
                    break;
 
                case 2:
                    System.out.print("Ingrese el nombre o el número (1-" + lote.length + ") de la referencia a buscar: ");
                    String buscado = sc.nextLine().trim();
                    if (buscado.isEmpty()) {
                        System.out.println("Debe ingresar un nombre o un número válido.");
                        break;
                    }
 
                    boolean esNumero = true;
                    int posicion = 0;
                    try {
                        posicion = Integer.parseInt(buscado);
                    } catch (NumberFormatException e) {
                        esNumero = false;
                    }
 
                    if (esNumero) {

                        if (posicion < 1 || posicion > lote.length) {
                            System.out.println("Número fuera de rango. Use un valor entre 1 y " + lote.length + ".");
                        } else if (lote[posicion - 1] != null) {
                            System.out.println("Posición " + posicion + ": " + lote[posicion - 1]);
                        } else {
                            System.out.println("La posición " + posicion + " está libre (sin prenda).");
                        }
                    } else {
                        
                        if (nombreFuncion(lote, buscado)) {
                            System.out.println("La referencia \"" + buscado + "\" SÍ está guardada en la caja.");

                            for (int i = 0; i < lote.length; i++) {
                                if (lote[i] != null && lote[i].equalsIgnoreCase(buscado)) {
                                    System.out.println("Posición " + (i + 1) + ": " + lote[i]);
                                }
                            }
                        } else {
                            System.out.println("La referencia \"" + buscado + "\" NO se encuentra en la caja.");
                        }
                    }
                    break;
 
                case 3:
                    System.out.print("Ingrese el nombre de la nueva referencia: ");
                    String nueva = sc.nextLine().trim();
                    if (nueva.isEmpty()) {
                        System.out.println("Debe ingresar un nombre válido.");
                        break;
                    }
                    boolean guardada = false;
                    for (int i = 0; i < lote.length; i++) {
                        if (lote[i] == null) {
                            lote[i] = nueva;
                            System.out.println("Prenda \"" + nueva + "\" almacenada en la posición " + (i + 1) + ".");
                            guardada = true;
                            break;
                        }
                    }
                    if (!guardada) {
                        System.out.println("La caja está llena. No hay espacio para más referencias.");
                    }
                    break;
 
                case 4:
                    System.out.println("Cerrando la aplicación.");
                    break;
 
                default:
                    System.out.println("Opción inválida. Elija un número entre 1 y 4.");
            }
 
        } while (opcion != 4);
 
        sc.close();
    }
}
 