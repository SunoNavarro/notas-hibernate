package View;
import Class.Universidad;
public class ValorMatricula {

    public static void main(String[] arg){
        Universidad universidad = new Universidad(100);
        universidad.setNombre("Pepito Peréz");
        universidad.setLogica(4.2);
        universidad.setMatematica(3.0);
        universidad.setPrograJava(4.8);
        universidad.CalcularValorSemestre();
    }
}
