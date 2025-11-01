package clases;

public class CitaMedica {
    private Paciente paciente;
    private Medico medico;
    private String fecha;
    private String hora;
    private String servicio;

    public CitaMedica(Paciente paciente, Medico medico, String fecha, String hora, String servicio) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }

    public void imprimirCita() {
        System.out.println("--- CITA MEDICA ---");
        System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());
        System.out.println("DNI: " + paciente.getDni());
        System.out.println("Medico: " + medico.getNombre() + " " + medico.getApellido());
        System.out.println("Consultorio: " + medico.getNumeroConsultorio());
        System.out.println("Servicio: " + servicio);
        System.out.println("Fecha: " + fecha + " Hora: " + hora);
    }
}
