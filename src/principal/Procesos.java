package principal;

import clases.*;
import java.util.Scanner;

public class Procesos {
    private ModeloDatos miModelo;
    private Scanner sc;

    public Procesos() {
        miModelo = new ModeloDatos();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Empleado Eventual");
            System.out.println("3. Registrar Empleado por Planilla");
            System.out.println("4. Registrar Medico");
            System.out.println("5. Registrar Cita Medica");
            System.out.println("6. Imprimir Pacientes");
            System.out.println("7. Imprimir Empleados Eventuales");
            System.out.println("8. Imprimir Empleados por Planilla (incluye medicos)");
            System.out.println("9. Imprimir Medicos");
            System.out.println("10. Imprimir Citas");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1": registrarPaciente(); break;
                case "2": registrarEmpleadoEventual(); break;
                case "3": registrarEmpleadoPlanilla(); break;
                case "4": registrarMedico(); break;
                case "5": registrarCita(); break;
                case "6": miModelo.imprimirPacientes(); break;
                case "7": miModelo.imprimirEmpleadosEventuales(); break;
                case "8": miModelo.imprimirEmpleadosPlanilla(); break;
                case "9": miModelo.imprimirMedicos(); break;
                case "10": miModelo.imprimirCitas(); break;
                case "0": salir = true; break;
                default: System.out.println("Opcion no valida"); break;
            }
        }
        System.out.println("Saliendo... adios!");
        sc.close();
    }

    private void registrarPaciente() {
        Paciente p = new Paciente();
        System.out.println("\n--- Registrar Paciente ---");
        p.registrarDatos(sc);
        try {
            miModelo.registrarPaciente(p);
            System.out.println("Paciente registrado correctamente.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarEmpleadoEventual() {
        EmpleadoEventual ee = new EmpleadoEventual();
        System.out.println("\n--- Registrar Empleado Eventual ---");
        ee.registrarDatos(sc);
        try {
            miModelo.registrarEmpleadoEventual(ee);
            System.out.println("Empleado eventual registrado.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarEmpleadoPlanilla() {
        EmpleadoPlanilla ep = new EmpleadoPlanilla();
        System.out.println("\n--- Registrar Empleado por Planilla ---");
        ep.registrarDatos(sc);
        try {
            miModelo.registrarEmpleadoPlanilla(ep);
            System.out.println("Empleado por planilla registrado.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarMedico() {
        Medico m = new Medico();
        System.out.println("\n--- Registrar Medico ---");
        m.registrarDatos(sc);
        try {
            miModelo.registrarMedico(m);
            System.out.println("Medico registrado.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarCita() {
        System.out.println("\n--- Registrar Cita Medica ---");
        System.out.print("DNI del paciente: ");
        String dni = sc.nextLine();
        Paciente p = miModelo.consultarPacientePorDni(dni);
        if (p == null) {
            System.out.println("Paciente no encontrado. Registrelo primero.");
            return;
        }
        System.out.print("Nombre del medico (tal cual registrado): ");
        String nombreMed = sc.nextLine();
        Medico m = miModelo.consultarMedicoPorNombre(nombreMed);
        if (m == null) {
            System.out.println("Medico no encontrado. Registrelo primero.");
            return;
        }
        System.out.print("Servicio/consulta: ");
        String servicio = sc.nextLine();
        System.out.print("Fecha (dd/mm/aaaa): ");
        String fecha = sc.nextLine();
        System.out.print("Hora (hh:mm): ");
        String hora = sc.nextLine();

        CitaMedica cita = new CitaMedica(p, m, fecha, hora, servicio);
        miModelo.registrarCita(cita);
        System.out.println("Cita registrada correctamente.");
    }
}
