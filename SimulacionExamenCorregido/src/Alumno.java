import java.util.Random;

public class Alumno extends Thread{
    //ATRIBUTOS
    private Examen examen;
    private int num;
    private boolean examen_acabado;

    //CONSTRUCTORES
    public Alumno(Examen examen, int num) {
        this.examen = examen;
        this.num = num;
    }

    //MÉTODOS
    public Examen getExamen() {
        return examen;
    }
    public int getNum() {
        return num;
    }
    public boolean isExamen_acabado() {
        return examen_acabado;
    }
    public void setExamen_acabado(boolean examen_acabado) {
        this.examen_acabado = examen_acabado;
    }

    @Override
    public void run(){
        //Comenzamos a recorrer cada ejercicio del examen.
        for(int i=0 ; i<examen.getPreguntas().size() ; i++) {
            System.out.println("El alumno " + num + " comienza la pregunta " + i + ".");
            int tiempo_tardado = examen.getPreguntas().get(i);
            //Establecemos la aleatoriedad sobre el tiempo que tarda en hacerlo.
            Random random = new Random();
            int numRandom = random.nextInt(3)+1;
            switch (numRandom){
                case 1:
                    Random randomRestarTiempo = new Random();
                    int restarTiempo = randomRestarTiempo.nextInt(tiempo_tardado/2)+1;
                    //Tarda menos en hacer el ejercicio.
                    tiempo_tardado-=restarTiempo;
                    break;
                case 2:
                    //Se mantiene el tiempo que tarda en hacer el ejercicio.
                    break;
                case 3:
                    Random randomSumarTiempo = new Random();
                    int sumarTiempo = randomSumarTiempo.nextInt(tiempo_tardado/2)+1;
                    //Tarda más en hacer el ejercicio.
                    tiempo_tardado+=sumarTiempo;
                    break;
            }
            //Dejamos pasar el tiempo que el alumno tardaría en hacer el examen.
            try {
                Thread.sleep(tiempo_tardado);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //El alumno indica que ha acabado la pregunta.
            System.out.println("El alumno " + num + " ha ACABADO la pregunta " + i + " en "+tiempo_tardado+" minutos.");
        }
        //Una vez finalizados los ejercicios se marca como finalizado el examen.
        System.out.println("Alumno "+num+" ha FINALIZADO.");
        setExamen_acabado(true);
    }



}
