package clases;

import java.util.*;

public class ModeloDatos {
    private Map<String, Paciente> pacientes;
    private Map<String, EmpleadoEventual> eventuales;
    private Map<String, EmpleadoPlanilla> planilla; 
    private Map<String, Medico> medicos;
    private List<CitaMedica> citas;

    public ModeloDatos() {
        pacientes = new HashMap<>();
        eventuales = new HashMap<>();
        planilla = new HashMap<>();
        medicos = new HashMap<>();
        citas = new ArrayList<>();
    }

    public void registrarPaciente(Paciente p) {
        if (p == null || p.getDni() == null || p.getDni().isEmpty()) {
            throw new RuntimeException("Paciente invalido");
        }
        if (pacientes.containsKey(p.getDni())) {
            throw new RuntimeException("Paciente con DNI ya registrado: " + p.getDni());
        }
        pacientes.put(p.getDni(), p);
    }

    public void registrarEmpleadoEventual(EmpleadoEventual e) {
        if (e == null || e.getDni() == null || e.getDni().isEmpty()) {
            throw new RuntimeException("Empleado invalido");
        }
        if (eventuales.containsKey(e.getDni()) || planilla.containsKey(e.getDni())) {
            throw new RuntimeException("Empleado ya registrado con ese DNI: " + e.getDni());
        }
        eventuales.put(e.getDni(), e);
    }

    public void registrarEmpleadoPlanilla(EmpleadoPlanilla e) {
        if (e == null || e.getDni() == null || e.getDni().isEmpty()) {
            throw new RuntimeException("Empleado invalido");
        }
        if (planilla.containsKey(e.getDni()) || eventuales.containsKey(e.getDni())) {
            throw new RuntimeException("Empleado ya registrado con ese DNI: " + e.getDni());
        }
        planilla.put(e.getDni(), e);
    }

    public void registrarMedico(Medico m) {
        if (m == null || m.getDni() == null || m.getDni().isEmpty()) {
            throw new RuntimeException("Medico invalido");
        }
        if (medicos.containsKey(m.getDni()) || planilla.containsKey(m.getDni()) || eventuales.containsKey(m.getDni())) {
            throw new RuntimeException("Medico ya registrado con ese DNI: " + m.getDni());
        }
        medicos.put(m.getDni(), m);
        planilla.put(m.getDni(), m);
    }

    public Paciente consultarPacientePorDni(String dni) {
        return pacientes.get(dni);
    }

    public Medico consultarMedicoPorNombre(String nombre) {
        for (Medico m : medicos.values()) {
            String full = (m.getNombre() + " " + m.getApellido()).trim();
            if (full.equalsIgnoreCase(nombre) || m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    public void registrarCita(CitaMedica c) {
        if (c == null) throw new RuntimeException("Cita invalida");
        citas.add(c);
    }

    public void imprimirPacientes() {
        System.out.println("\n--- LISTA PACIENTES ---");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        for (Paciente p : pacientes.values()) {
            p.imprimirDatosPersona("");
        }
    }

    public void imprimirEmpleadosEventuales() {
        System.out.println("\n--- EMPLEADOS EVENTUALES ---");
        if (eventuales.isEmpty()) {
            System.out.println("No hay empleados eventuales.");
            return;
        }
        for (EmpleadoEventual e : eventuales.values()) {
            e.imprimirDatosPersona("");
        }
    }

    public void imprimirEmpleadosPlanilla() {
        System.out.println("\n--- EMPLEADOS POR PLANILLA (incluye medicos) ---");
        if (planilla.isEmpty()) {
            System.out.println("No hay empleados por planilla.");
            return;
        }
        for (EmpleadoPlanilla e : planilla.values()) {
            e.imprimirDatosPersona("");
        }
    }

    public void imprimirMedicos() {
        System.out.println("\n--- MEDICOS ---");
        if (medicos.isEmpty()) {
            System.out.println("No hay medicos registrados.");
            return;
        }
        for (Medico m : medicos.values()) {
            m.imprimirDatosPersona("");
        }
    }

    public void imprimirCitas() {
        System.out.println("\n--- CITAS MEDICAS ---");
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        for (CitaMedica c : citas) {
            c.imprimirCita();
        }
    }
}
