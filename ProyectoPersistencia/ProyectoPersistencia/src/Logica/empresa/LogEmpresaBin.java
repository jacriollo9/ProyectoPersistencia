package Logica.empresa;

import Archivos.empresa.EmpresaBin;
import Clases.Empresa;

import java.io.IOException;
import java.util.ArrayList;

public class LogEmpresaBin {
    EmpresaBin objEmpresaBin = new EmpresaBin();
    public boolean ValidarId(Empresa objCliente) throws IOException, ClassNotFoundException {
        ArrayList<Empresa> ArrayClientes;
        ArrayClientes = ListarEmpresa();
        // Valida si el codigo es correcto
        if (objCliente.getRuc().length() == 13){
            // Agregar al archivo texto
            ArrayClientes.add(objCliente);
            return objEmpresaBin.GrabarEmpresaBin(objCliente);
        }
        return false;
    }
    public ArrayList<Empresa> ListarEmpresa() throws IOException, ClassNotFoundException {
        return objEmpresaBin.ImportarEmpresaBin();
    }
}
