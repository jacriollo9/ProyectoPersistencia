package Logica.empresa;

import Archivos.empresa.EmpresaTxt;
import Clases.Empresa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LogEmpresaTxt {
    EmpresaTxt objEmpresaTxt = new EmpresaTxt();
    public boolean Validar(Empresa objEmpresa) throws IOException {
        // Valida si el codigo es correcto
        if (objEmpresa.getRuc().length() == 13){
            // Agregar al archivo texto
            return objEmpresaTxt.AgregarEmpresa(objEmpresa);
        }
        return false;
    }
    public ArrayList<Empresa> ListarEmpresas() throws FileNotFoundException {
        ArrayList<Empresa> ArrayEmpresa = objEmpresaTxt.LeerEmpresa();
        return ArrayEmpresa;
    }
}
