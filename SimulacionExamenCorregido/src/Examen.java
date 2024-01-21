import java.util.ArrayList;

public class Examen {
    //ATRIBUTOS
    private ArrayList<Integer> preguntas = new ArrayList<>();
    private int tiempo_total;

    //CONSTRUCTORES
    public Examen (){
        preguntas.add(1000);
        preguntas.add(3000);
        preguntas.add(5000);
        tiempo_total = 0;
        //Guardamos el tiempo total que se tarda en hacer el examen.
        for (int pregunta:preguntas) {
            tiempo_total+=pregunta;
        }
    }

    //MÉTODOS
    public ArrayList<Integer> getPreguntas() {
        return preguntas;
    }
    public int getTiempo_total() {
        return tiempo_total;
    }
}
