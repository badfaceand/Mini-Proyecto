public class Vivienda {
    int matricula;
    String direccion;
    String nombrePropietario;
    String apellidoPropietario;
    String barrio;

    public Vivienda(int matricula, String direccion, String nombrePropietario, String apellidoPropietario, String barrio) {
        this.matricula = matricula;
        this.direccion = direccion;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.barrio = barrio;
    }

    public void mostrarDatos() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Dirección: " + direccion);
        System.out.println("Nombre propietario: " + nombrePropietario);
        System.out.println("Apellido propietario: " + apellidoPropietario);
        System.out.println("Barrio: " + barrio);
    }
}
