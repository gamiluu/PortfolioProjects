public class Main {
    public static void main(String[] args) {
        //Creamos el examen.
        Examen examen = new Examen();

        //Creamos el profesor y lo ponemos a trabajar.
        Profesor profesor = new Profesor(examen);
        profesor.start();
    }
}