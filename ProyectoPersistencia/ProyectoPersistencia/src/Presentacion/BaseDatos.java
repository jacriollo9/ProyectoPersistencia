package Presentacion;
import java.util.Scanner;

/**
 * @author
 * Fecha: 15-06-2022
 */

public class BaseDatos {
    void menuArchivoTexto(){
        Scanner sc = new Scanner(System.in);
        int op = 0;
        while (op < 4){
            System.out.println("Agregar       1");
            System.out.println("Eliminar      2");
            System.out.println("Listar        3");
            System.out.println("Salir         4");
            op = sc.nextInt();
            switch (op){
                case 1: AgregarClienteBD(); break;
                case 2: EliminarClienteBD(); break;
                case 3: ListarClienteBD(); break;
            }
        }
    }
    private void AgregarClienteBD() {
    }
    private void EliminarClienteBD() {
    }
    private void ListarClienteBD() {
    }

}
