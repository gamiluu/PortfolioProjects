import java.util.ArrayList;

public class Profesor extends Thread{
    //ATRIBUTOS
    private Examen examen;
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private int tiempo_examen;

    //CONSTRUCTORES
    public Profesor(Examen examen) {
        this.examen = examen;
        tiempo_examen = examen.getTiempo_total();
    }

    //MÉTODOS
    @Override
    public void run(){
        int num_estudiantes = 4;
        //El profesor reparte los exámenes a los alumnos.
        for(int i=0 ; i<num_estudiantes ; i++){
            alumnos.add(new Alumno(examen, i));
        }
        //El profesor pone a los estudiantes a hacer el examen.
        System.out.println("PROFESOR: ¡El examen ha comenzado y tendreis "+tiempo_examen+" MINUTOS para completarlo!\n");
        for(Alumno alumno : alumnos){
            alumno.start();
        }
        //El profesor espera el tiempo definido antes de corregir los exámenes.
        try {
            Thread.sleep(tiempo_examen);
        } catch (InterruptedException e) {throw new RuntimeException(e);}
        //El profesor para a los alumnos y recoge el exámen.
        for(Alumno alumno : alumnos){
            alumno.stop();
        }
        //El profesor comprueba quienes son los alumnos que han acabado el examen a tiempo.
        System.out.println("\nPROFESOR: ¡El examen ha FINALIZADO!");
        for(Alumno alumno : alumnos){
            if (!alumno.isExamen_acabado()) {
                System.out.println("El alumno "+alumno.getNum()+" NO ha acabado el examen.");
            }
        }
    }

}
