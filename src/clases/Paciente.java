package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Persona {
    private String numeroHistoria;
    private String sexo;
    private String grupoSanguineo;
    private ArrayList<String> alergias;

    public Paciente() {
        alergias = new ArrayList<>();
    }

    @Override
    public void registrarDatos(Scanner sc) {
        super.registrarDatos(sc);
        System.out.print("Numero de historia clinica: ");
        this.numeroHistoria = sc.nextLine();
        System.out.print("Sexo: ");
        this.sexo = sc.nextLine();
        System.out.print("Grupo sanguineo: ");
        this.grupoSanguineo = sc.nextLine();

        // pedir alergias
        System.out.print("Tiene alergias? (s/n): ");
        String r = sc.nextLine();
        while (r.equalsIgnoreCase("s")) {
            System.out.print("Nombre del medicamento alergeno: ");
            String med = sc.nextLine();
            if (!med.trim().isEmpty()) alergias.add(med);
            System.out.print("Agregar otra alergia? (s/n): ");
            r = sc.nextLine();
        }
    }

    @Override
    public void imprimirDatosPersona(String datos) {
        super.imprimirDatosPersona(datos);
        System.out.println("-- Datos Paciente --");
        System.out.println("Numero historia: " + numeroHistoria);
        System.out.println("Sexo: " + sexo);
        System.out.println("Grupo sanguineo: " + grupoSanguineo);
        if (alergias.isEmpty()) {
            System.out.println("Alergias: Ninguna");
        } else {
            System.out.println("Alergias:");
            for (String a : alergias) {
                System.out.println(" - " + a);
            }
        }
    }

    // getters y setters
    public String getNumeroHistoria() { return numeroHistoria; }
    public void setNumeroHistoria(String numeroHistoria) { this.numeroHistoria = numeroHistoria; }
}
