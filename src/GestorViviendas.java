import java.util.*;

public class GestorViviendas {
    private List<Vivienda> listaViviendas = new ArrayList<>();

    public void registrarVivienda(Vivienda v) {
        listaViviendas.add(v);
        System.out.println("La vivienda fue registrada.");
    }

    public void buscarPorMatriculaLineal(int matricula) {
        for (Vivienda v : listaViviendas) {
            if (v.matricula == matricula) {
                v.mostrarDatos();
                return;
            }
        }
        System.out.println("La vivienda no esta en la lista.");
    }

    public void buscarPorApellido(String apellido) {
        for (Vivienda v : listaViviendas) {
            if (v.apellidoPropietario.equalsIgnoreCase(apellido)) {
                v.mostrarDatos();
                return;
            }
        }
        System.out.println("No se encontro la vivienda.");
    }

    public void ordenarPorBurbuja() {
        for (int i = 0; i < listaViviendas.size() - 1; i++) {
            for (int j = 0; j < listaViviendas.size() - i - 1; j++) {
                if (listaViviendas.get(j).matricula > listaViviendas.get(j + 1).matricula) {
                    Collections.swap(listaViviendas, j, j + 1);
                }
            }
        }
        System.out.println("La lista fue ordenada por burbuja.");
    }

    public void ordenarPorInsercion() {
        for (int i = 1; i < listaViviendas.size(); i++) {
            Vivienda key = listaViviendas.get(i);
            int j = i - 1;
            while (j >= 0 && listaViviendas.get(j).matricula > key.matricula) {
                listaViviendas.set(j + 1, listaViviendas.get(j));
                j--;
            }
            listaViviendas.set(j + 1, key);
        }
        System.out.println("La Lista fue ordenada por insercion.");
    }

    public void buscarBinaria(int matricula) {
        ordenarPorInsercion();  
        int izquierda = 0, derecha = listaViviendas.size() - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            int valor = listaViviendas.get(medio).matricula;
            if (valor == matricula) {
                listaViviendas.get(medio).mostrarDatos();
                return;
            } else if (valor < matricula) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        System.out.println("No se encontro la matricula (manera binaria).");
    }

    public void listarMatriculas() {
        System.out.println("Las matriculas que han sido registradas son:");
        for (Vivienda v : listaViviendas) {
            System.out.println("- Matrícula: " + v.matricula);
        }
    }
}
