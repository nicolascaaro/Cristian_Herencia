package clases;

import java.util.Scanner;

public class Empleado extends Persona {
    private String codigoEmpleado;
    private double horasExtras;
    private String fechaIngreso;
    private String area;
    private String cargo;

    @Override
    public void registrarDatos(Scanner sc) {
        super.registrarDatos(sc);
        System.out.print("Codigo de empleado: ");
        this.codigoEmpleado = sc.nextLine();
        try {
            System.out.print("Horas extras (numero): ");
            String he = sc.nextLine();
            this.horasExtras = he.isEmpty() ? 0 : Double.parseDouble(he);
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida para horas extras, se pone 0.");
            this.horasExtras = 0;
        }
        System.out.print("Fecha de ingreso: ");
        this.fechaIngreso = sc.nextLine();
        System.out.print("Area: ");
        this.area = sc.nextLine();
        System.out.print("Cargo: ");
        this.cargo = sc.nextLine();
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);
        System.out.println("-- Datos Empleado --");
        System.out.println("Codigo empleado: " + codigoEmpleado);
        System.out.println("Horas extras: " + horasExtras);
        System.out.println("Fecha ingreso: " + fechaIngreso);
        System.out.println("Area: " + area);
        System.out.println("Cargo: " + cargo);
    }

    // getters y setters
    public String getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(String codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }
    public double getHorasExtras() { return horasExtras; }
    public void setHorasExtras(double horasExtras) { this.horasExtras = horasExtras; }
}
