package caldas;

public class Estudiante {
    int id;
    String nombre;
    String apellido;

    public Estudiante(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String toString(){
        return "-Id: "+id+"  -Nombre: "+ nombre+ "  -Apellido: "+apellido;
    }

    
    
}
