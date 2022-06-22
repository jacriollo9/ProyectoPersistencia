package Archivos;
import Clases.Cliente;
import java.io.*;
import java.util.ArrayList;

/**
 * @author
 * Fecha: 15-06-2022
 */

public class ClienteBin {
    File fichero =new File("C:\\Users\\josea\\OneDrive\\Escritorio\\ProyectoPersistencia\\ProyectoPersistencia\\Programacion\\Cliente.dat");
    public boolean GrabarClienteBin(Cliente cliente) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Cliente> ArrayClientes = ImportarClienteBin();

        FileOutputStream outputStream = new FileOutputStream(fichero, false);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.flush();

        ArrayClientes.add(cliente);

        oos.writeObject(ArrayClientes);

        outputStream.close();
        oos.close();  // Se cierra al terminar.
        return true;
    }

    public ArrayList<Cliente> ImportarClienteBin() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(input);

        ArrayList<Cliente> ArrayClientes  = (ArrayList<Cliente>) ois.readObject();


        ois.close();
        input.close();

        return ArrayClientes;
    }



    public boolean AgregarClientes(ArrayList<Cliente> arrayClientes) {

        return false;
    }
}
