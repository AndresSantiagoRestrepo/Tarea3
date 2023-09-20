package caldas;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ControlEstudiante {
    //En este array list se guardaran los estudiantes que están en el CSV
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    //Este buffered reader permitirá leer el CSV
    private BufferedReader lectorArchivo;
    //Este string me sirve como un temporal para agarral una linea del csv
    private String line;
    //y aqui se guardaran separados los atributos de cada estudiante, teniendo en cuenta que la posicion 0 tiene id, 1 el nombre y 2 el apellido
    private String atributos[] = null;

    public void leerCSV(String ruta) {
        try {
            //Aqui abrimos la ruta especificada
            lectorArchivo = new BufferedReader(new FileReader(ruta));
            //Mientras el archivo no se haya terminado de leer, entonces:
            while ((line = lectorArchivo.readLine()) != null) {
                //Declaro un eobjeto estudiante 
                Estudiante estudent;
                //Aqui consigo los atributos y lo que hago es crear el estudiante con esos atributos
                atributos = line.split(",");
                estudent = new Estudiante(Integer.parseInt(atributos[0]), atributos[1], atributos[2]);
                //Agrego el estudiante actual en el arraylist de tipo estudiante
                estudiantes.add(estudent);

            }
            //Cierro el buffered reader
            lectorArchivo.close();
            //Declaro nulos tanto line como atributos para evitar basura
            line = null;
            atributos = null;
        } catch (Exception e) {
            System.out.println("Error aqui: " + e);
        }

    }

    public void escribirJSON() {
        

        // Este tipo de Json array me permite agregar varios Json Objects, de esta forma
        // puedo mandarlos a escribir todos los estudiantes que meta aqui directo al
        // json
        JsonArray estudianteRecorrido = new JsonArray();

        for (Estudiante estud : estudiantes) {
            //Aqui creo un objeto de tipo JsonObjecto con los atributos de un estudiante, luego este jsonObjecto lo envio al array para que esté con otros estudiantes
            JsonObject temp = new JsonObject();
            temp.addProperty("id", estud.id);
            temp.addProperty("nombre", estud.nombre);
            temp.addProperty("apellido", estud.apellido);
            estudianteRecorrido.add(temp);
        }

        //Aqui se convierten los jsonObject del array en una cadena String para que sea escrita en el JSON
        String jsonStr = estudianteRecorrido.toString();

        //Luego aqui se efectua la escritura del archivo estudiantes.json, en el caso de que el archivo no exista, entonces se creará 
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Stokker\\Documents\\Software 1\\tarea3\\src\\main\\resources\\estudiantes.json")) {
            fileWriter.write(jsonStr);
            System.out.println("JSON escrito correctamente en la ruta del CSV");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));

        }
    }

}
