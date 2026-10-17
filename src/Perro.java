public class Perro extends Paciente {
    private String raza;
    private boolean vacunado;
    public Perro( String nombre,double peso, int edad,String raza, boolean vacunado) {
        super(nombre, peso, edad,vacunado ? "Ingresado" : "Cuarentena", 10.0)
        this.raza = raza;
        this.vacunado = vacunado;
    }
    public String getRaza() {
        return raza;
    }
    public boolean getVacunado() {
        return vacunado;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }
}
