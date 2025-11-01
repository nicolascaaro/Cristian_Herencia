package clases;

import java.util.Scanner;

public class EmpleadoPlanilla extends Empleado {
    private double salarioMensual;
    private double porcentajeHoraExtra;

    @Override
    public void registrarDatos(Scanner sc) {
        super.registrarDatos(sc);
        try {
            System.out.print("Salario mensual: ");
            String s = sc.nextLine();
            this.salarioMensual = s.isEmpty() ? 0 : Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida para salario, se pone 0.");
            this.salarioMensual = 0;
        }
        try {
            System.out.print("% adicional por hora extra (ej: 10): ");
            String p = sc.nextLine();
            this.porcentajeHoraExtra = p.isEmpty() ? 0 : Double.parseDouble(p);
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida para porcentaje, se pone 0.");
            this.porcentajeHoraExtra = 0;
        }
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);
        System.out.println("-- Datos Empleado por Planilla --");
        System.out.println("Salario mensual: " + salarioMensual);
        System.out.println("% por hora extra: " + porcentajeHoraExtra);
    }
}
