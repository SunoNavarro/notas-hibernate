package Class;

public class Universidad {
    private double promedio;
    private double matematica;
    private double logica;
    private double prograJava;
    private double valorSemestre;
    private double valorPagar;
    private String nombre;

    public Universidad(double valorSemestre){
        this.valorSemestre = valorSemestre;
    }

    private double getPromedio() {
        return promedio;
    }

    private void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getMatematica() {
        return matematica;
    }

    public void setMatematica(double matematica) {
        this.matematica = matematica;
    }

    public double getLogica() {
        return logica;
    }

    public void setLogica(double logica) {
        this.logica = logica;
    }

    public double getPrograJava() {
        return prograJava;
    }

    public void setPrograJava(double prograJava) {
        this.prograJava = prograJava;
    }

    private double getValorSemestre() {
        return valorSemestre;
    }

    private void setValorSemestre(double valorSemestre) {
        this.valorSemestre = valorSemestre;
    }

    private double getValorPagar() {
        return valorPagar;
    }

    private void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void CalcularValorSemestre(){
        double prodioObtenido=0;
        prodioObtenido = (this.getMatematica()+this.getLogica()+this.getPrograJava())/3;

        //Cargar el promedio
        this.setPromedio(prodioObtenido);

        if(this.getPromedio()>=4.5){
            //Obtiene beca
            this.setValorPagar(this.getValorSemestre()*0.03);
        }else{
            //No obtiene la beca
            this.setValorPagar(this.getValorSemestre());
        }

        //Mostrar los datos
        System.out.println(this.getNombre()+" debe pagar €"+this.getValorPagar()+" debido a que su promedio fue de "+this.getPromedio()+".");
    }
}
