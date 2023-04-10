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

        }finally {
            sc.close();
        }
    }

    public static String menu() {
        String sb = "1. Listar contenido directorio" + System.lineSeparator() +
                "2. Listar directorio y buscar fichero que comiencen con una palabra" + System.lineSeparator() +
                "3. Listar archivos con cierta extension en un directorio" + System.lineSeparator() +
                "4. Buscar un archivo en un directorio" + System.lineSeparator() +
                "5. Buscar recursivamente un archivo en un directorio" + System.lineSeparator() +
                "6. Salir" + System.lineSeparator();
        return sb;
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

        int repetidos = 0;
        boolean encontrado = false;

        System.out.println("Introduce el nombre del directorio: ");
        File directorio = new File(sc.next());
        //Si el directorio pasado es un directorio entonces pasamos el contenido al array.
        if (directorio.isDirectory()) {
            //Creamos un array de tipo File para almacenar el contenido del directorio.
            File[] contenido = directorio.listFiles();

            System.out.println("Introduce el nombre del archivo a buscar: ");
            String nombre = sc.next();
            //Si el array no es nulo entonces recorremos el array y mostramos el contenido.
            if (contenido != null) {
                //Recorremos el array.
                for (File fichero : contenido) {
                    /*
                     * Si el elemento comienza con la palabra introducida y es un fichero entonces lo mostramos.
                     * El método endsWith() comprueba si el String termina con la palabra introducida.
                     * El método isFile() comprueba si el elemento es un fichero.
                     */
                    if (fichero.getName().equals(nombre) && fichero.isFile()) {
                        //Si el elemento es un fichero entonces lo mostramos como fichero.
                        repetidos++;
                        System.out.println("Fichero: " + repetidos + " " + fichero.getName());
                        encontrado = true;
                    }

                    if (fichero.isDirectory() && fichero.listFiles() != null) {
                        busquedaRecursiva(fichero, nombre);
                    }
                }
                if(encontrado == false){
                    System.out.println("No se ha encontrado el archivo");
                }
            }

        }else{
            System.err.println("El directorio no existe");
        }

    }

    public static void busquedaRecursiva(File directorio, String nombre) {
        int repetidos = 2;
        File[] contenido = directorio.listFiles();
        if (contenido != null) {
            for (File fichero : contenido) {
                if (fichero.getName().equals(nombre) && fichero.isFile()) {
                    System.out.println("Fichero: "+ repetidos + " " + fichero.getName());
                }

            }
        }
    }
}