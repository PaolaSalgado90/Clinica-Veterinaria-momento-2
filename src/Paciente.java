public class Paciente {
    private String nombre;
    private double peso;
    private int edad;
    private String estado; // Ingresado-Cuarentena-Tratamiento
    private double factorDosis;
    private double dosisAcumiulada;
    private Jaula jaulaAsignada;

    public Paciente(String nombre, double peso, int edad, String estado,double factorDosis, double dosisAcumiulada, Jaula jaulaAsignada) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.estado = estado;
        this.factorDosis = factorDosis;
        this.dosisAcumiulada = 0.0;
        this.jaulaAsignada = null;

    }

    public Paciente(String nombre, double peso, int edad, String estado, double factorDosis) {
    }

    public String getNombre() {
        return nombre;
    }
    public double getPeso() {
        return peso;
    }
    public int getEdad() {
        return edad;
    }
    public String getEstado() {
        return estado;
    }
    public double getFactorDosis() {
        return factorDosis;
    }
    public double getDosisAcumiulada() {
        return dosisAcumiulada;
    }
    public Jaula getJaulaAsignada() {
        return jaulaAsignada;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setFactorDosis(double factorDosis) {
        this.factorDosis = factorDosis;
    }
    public void setDosisAcumiulada(double dosisAcumiulada) {
        this.dosisAcumiulada = dosisAcumiulada;
    }

}
