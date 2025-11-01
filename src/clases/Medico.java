package clases;

import java.util.Scanner;

public class Medico extends EmpleadoPlanilla {
    private String especialidad;
    private String numeroConsultorio;

    @Override
    public void registrarDatos(Scanner sc) {
        super.registrarDatos(sc);
        System.out.print("Especialidad: ");
        this.especialidad = sc.nextLine();
        System.out.print("Numero de consultorio: ");
        this.numeroConsultorio = sc.nextLine();
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);
        System.out.println("-- Datos Medico --");
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Numero consultorio: " + numeroConsultorio);
    }

    public String getEspecialidad() { return especialidad; }
    public String getNumeroConsultorio() { return numeroConsultorio; }
}
