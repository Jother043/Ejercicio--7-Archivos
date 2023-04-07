import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            int opciones = 0;
            do {
                System.out.println(menu());
                System.out.println("Introduce una opción: ");
                opciones = sc.nextInt();
                switch (opciones) {
                    case 1:
                        listarContenido();
                        break;
                    case 2:
                        buscarFichero();
                        break;
                    case 3:
                        listarArchivos();
                        break;
                    case 4:
                        buscarArchivo();
                        break;
                    case 5:
                        buscarArchivoRecursivo();
                        break;
                    case 6:
                        System.out.println("Salir");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (opciones > 0 && opciones < 6);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            sc.close();
        }
    }

    public static String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Listar contenido directorio").append(System.lineSeparator());
        sb.append("2. Listar directorio y buscar fichero que comiencen con una palabra").append(System.lineSeparator());
        sb.append("3. Listar archivos con cierta extension en un directorio").append(System.lineSeparator());
        sb.append("4. Buscar un archivo en un directorio").append(System.lineSeparator());
        sb.append("5. Buscar recursivamente un archivo en un directorio").append(System.lineSeparator());
        sb.append("6. Salir").append(System.lineSeparator());
        return sb.toString();
    }

    /**
     * Método que lista el contenido de un directorio.
     */
    public static void listarContenido() {

        System.out.println("Introduce el nombre del directorio: ");
        File directorio = new File(sc.next());
        //Si el directorio pasado es un directorio entonces pasamos el contenido al array.
        if (directorio.isDirectory()) {
            //Creamos un array de tipo File para almacenar el contenido del directorio.
            File[] contenido = directorio.listFiles();
            //Si el array no es nulo entonces recorremos el array y mostramos el contenido.
            if (contenido!= null) {
                //Recorremos el array.
                for (File fichero : contenido) {
                    //Si el elemento es un directorio entonces lo mostramos como directorio.
                    if(fichero.isDirectory()) {
                        System.out.println("Directorio: " + fichero.getName());
                        //Si el elemento es un fichero entonces lo mostramos como fichero.
                    } else if(fichero.isFile()) {
                        System.out.println("Fichero: " + fichero.getName());
                    }
                }
            }
        }
    }

    /**
     * Método que lista el contenido de un directorio y busca un fichero que comience con una palabra.
     */
    public static void buscarFichero() {
        System.out.println("Introduce el nombre del directorio: ");
        File directorio = new File(sc.next());
        //Si el directorio pasado es un directorio entonces pasamos el contenido al array.
        if (directorio.isDirectory()) {
            //Creamos un array de tipo File para almacenar el contenido del directorio.
            File[] contenido = directorio.listFiles();

            System.out.println("Introduce la palabra a buscar: ");
            String palabra = sc.next();
            //Si el array no es nulo entonces recorremos el array y mostramos el contenido.
            if (contenido!= null) {
                //Recorremos el array.
                for (File fichero : contenido) {
                    /*
                     *Si el elemento comienza con la palabra introducida y es un fichero entonces lo mostramos.
                     * El método startsWith() comprueba si el String comienza con la palabra introducida.
                     */
                    if(fichero.getName().startsWith(palabra) && fichero.isFile()) {
                        //Si el elemento es un fichero entonces lo mostramos como fichero.
                        System.out.println("Fichero: " + fichero.getName());
                    }
                }
            }
        }
    }

    public static void listarArchivos() {
        System.out.println("Introduce el nombre del directorio: ");
        File directorio = new File(sc.next());
        //Si el directorio pasado es un directorio entonces pasamos el contenido al array.
        if (directorio.isDirectory()) {
            //Creamos un array de tipo File para almacenar el contenido del directorio.
            File[] contenido = directorio.listFiles();

            System.out.println("Introduce la extensión a buscar: ");
            String extension = sc.next();
            //Si el array no es nulo entonces recorremos el array y mostramos el contenido.
            if (contenido!= null) {
                //Recorremos el array.
                for (File fichero : contenido) {
                    /*
                     * Si el elemento comienza con la palabra introducida y es un fichero entonces lo mostramos.
                     * El método endsWith() comprueba si el String termina con la palabra introducida.
                     * El método isFile() comprueba si el elemento es un fichero.
                     */
                    if(fichero.getName().endsWith(extension) && fichero.isFile()) {
                        //Si el elemento es un fichero entonces lo mostramos como fichero.
                        System.out.println("Fichero: " + fichero.getName());
                    }
                }
            }
        }
    }

    public static void buscarArchivo() {
        System.out.println("Introduce el nombre del directorio: ");
        File directorio = new File(sc.next());
        //Si el directorio pasado es un directorio entonces pasamos el contenido al array.
        if (directorio.isDirectory()) {
            //Creamos un array de tipo File para almacenar el contenido del directorio.
            File[] contenido = directorio.listFiles();

            System.out.println("Introduce el nombre del archivo a buscar: ");
            String nombre = sc.next();
            //Si el array no es nulo entonces recorremos el array y mostramos el contenido.
            if (contenido!= null) {
                //Recorremos el array.
                for (File fichero : contenido) {
                    /*
                     * Si el elemento comienza con la palabra introducida y es un fichero entonces lo mostramos.
                     * El método endsWith() comprueba si el String termina con la palabra introducida.
                     * El método isFile() comprueba si el elemento es un fichero.
                     */
                    if(fichero.getName().equals(nombre) && fichero.isFile()) {
                        //Si el elemento es un fichero entonces lo mostramos como fichero.
                        System.out.println("Fichero: " + fichero.getName());
                    }
                }
            }
        }
    }

    public static void buscarArchivoRecursivo() {

    }

}