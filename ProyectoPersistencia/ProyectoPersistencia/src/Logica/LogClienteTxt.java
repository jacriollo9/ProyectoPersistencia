package Logica;
import Archivos.ClienteTxt;
import Clases.Cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author
 * Fecha: 15-06-2022
 */

public class LogClienteTxt {
    ClienteTxt objClienteTxt = new ClienteTxt();
    public boolean  ValidarId(Cliente objCliente) throws IOException {
        // Valida si el codigo es correcto
        if (objCliente.getId() > 0){
            // Agregar al archivo texto
            return objClienteTxt.AgregarCliente(objCliente);
        }
        return false;
    }
    public ArrayList<Cliente> ListarClientes() throws FileNotFoundException {
        ArrayList<Cliente> ArrayClientes = objClienteTxt.LeerCliente();
        return ArrayClientes;
    }
}
