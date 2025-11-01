package clases;

import java.util.Scanner;

public class EmpleadoEventual extends Empleado {
    private double honorariosPorHora;
    private String fechaTerminoContrato;

    @Override
    public void registrarDatos(Scanner sc) {
        super.registrarDatos(sc);
        try {
            System.out.print("Honorarios por hora: ");
            String h = sc.nextLine();
            this.honorariosPorHora = h.isEmpty() ? 0 : Double.parseDouble(h);
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida para honorarios, se pone 0.");
            this.honorariosPorHora = 0;
        }
        System.out.print("Fecha termino contrato: ");
        this.fechaTerminoContrato = sc.nextLine();
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);
        System.out.println("-- Datos Empleado Eventual --");
        System.out.println("Honorarios por hora: " + honorariosPorHora);
        System.out.println("Fecha termino contrato: " + fechaTerminoContrato);
    }
}
