import java.util.*;

public class GestorViviendas {
    private List<Vivienda> listaViviendas = new ArrayList<>();

    public void registrarVivienda(Vivienda v) {
        listaViviendas.add(v);
        System.out.println("✅ Vivienda registrada.");
    }

    public void buscarPorMatriculaLineal(int matricula) {
        for (Vivienda v : listaViviendas) {
            if (v.matricula == matricula) {
                v.mostrarDatos();
                return;
            }
        }
        System.out.println("❌ No se encontró la vivienda.");
    }

    public void buscarPorApellido(String apellido) {
        for (Vivienda v : listaViviendas) {
            if (v.apellidoPropietario.equalsIgnoreCase(apellido)) {
                v.mostrarDatos();
                return;
            }
        }
        System.out.println("❌ No se encontró la vivienda.");
    }

    public void ordenarPorBurbuja() {
        for (int i = 0; i < listaViviendas.size() - 1; i++) {
            for (int j = 0; j < listaViviendas.size() - i - 1; j++) {
                if (listaViviendas.get(j).matricula > listaViviendas.get(j + 1).matricula) {
                    Collections.swap(listaViviendas, j, j + 1);
                }
            }
        }
        System.out.println("✅ Lista ordenada por burbuja.");
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
        System.out.println("✅ Lista ordenada por inserción.");
    }

    public void buscarBinaria(int matricula) {
        ordenarPorInsercion();  // ordenar antes de buscar
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
        System.out.println("❌ No se encontró la matrícula (binaria).");
    }

    public void listarMatriculas() {
        System.out.println("📋 Matrículas registradas:");
        for (Vivienda v : listaViviendas) {
            System.out.println("- Matrícula: " + v.matricula);
        }
    }
}
