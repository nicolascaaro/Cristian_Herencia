package clases;

import java.util.Scanner;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String direccion;
    private String ciudadProcedencia;

    public Persona() {}

    public void registrarDatos(Scanner sc) {
        System.out.print("DNI: ");
        this.dni = sc.nextLine();
        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();
        System.out.print("Apellido: ");
        this.apellido = sc.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        this.fechaNacimiento = sc.nextLine();
        System.out.print("Direccion: ");
        this.direccion = sc.nextLine();
        System.out.print("Ciudad de procedencia: ");
        this.ciudadProcedencia = sc.nextLine();
    }

    public void imprimirDatosPersona(String datos) {
        System.out.println("--- Datos de Persona ---");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Fecha nacimiento: " + fechaNacimiento);
        System.out.println("Direccion: " + direccion);
        System.out.println("Ciudad procedencia: " + ciudadProcedencia);
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCiudadProcedencia() { return ciudadProcedencia; }
    public void setCiudadProcedencia(String ciudadProcedencia) { this.ciudadProcedencia = ciudadProcedencia; }
}
