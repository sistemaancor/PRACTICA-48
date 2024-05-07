// Clase Animal
class Animal {
    // Variable de instancia
    protected String nombre;

    // Constructor
    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // Método Nacer
    public void Nacer() {
        System.out.println(nombre + " ha nacido.");
    }

    // Método HacerSonido (sin implementación específica)
    public void HacerSonido() {
        System.out.println("El animal hace un sonido.");
    }
}

// Clase Perro que hereda de Animal
class Perro extends Animal {
    // Constructor
    public Perro(String nombre) {
        super(nombre);
    }

    // Sobrescritura del método HacerSonido (sin @Override)
    public void HacerSonido() {
        System.out.println("El perro hace guau.");
    }

    // Sobrescritura del método HacerSonido (con @Override)
    @Override
    public void Sonido() {
        System.out.println("El perro hace guau.");
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Animal
        Animal animal = new Animal("Animal");
        animal.Nacer();
        animal.HacerSonido();

        System.out.println();

        // Crear una instancia de Perro
        Perro perro = new Perro("Bobby");
        perro.Nacer();
        perro.HacerSonido();
    }
}