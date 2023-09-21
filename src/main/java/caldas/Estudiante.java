package caldas;

public class Estudiante {
    String id;
    String nombre;
    String apellido;

    public Estudiante(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String toString(){
        return "-Id: "+id+"  -Nombre: "+ nombre+ "  -Apellido: "+apellido;
    }

    
    
}
