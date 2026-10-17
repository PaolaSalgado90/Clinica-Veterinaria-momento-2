public class Jaula {
    private int numero;
    private String tamaño;//s,m,l
    private String zona; //A - B
    private Paciente Ocupante;

    public Jaula( int numero, String tamaño, String zona){
        this.numero = numero;
        this.tamaño = tamaño;
        this.zona = zona;
        this.Ocupante = null;
    }
    public int getNumero() {
        return numero;
    }
    public String getTamaño() {
        return tamaño;
    }
    public String getZona() {
        return zona;
    }
    public Paciente getOcupante() {
        return Ocupante;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public void setOcupante(Paciente Ocupante) {
        this.Ocupante == null;
    }
}
