public class Hospital {
    private Paciente [] pacientes;
    private int ContadorPacientes;
    private Jaula[] Jaulas;

    public Hospital() {
        this.pacientes = new Paciente[10];
        this.ContadorPacientes = 0;
        this.Jaulas = new Jaula[6];
        cargarDatosIniciales();
    }
    public void cargarDatosIniciales() {
        Jaulas[0]=new Jaula(1, "s", "A");
        Jaulas[1]=new Jaula(2, "m", "A");
        Jaulas[2]=new Jaula(3, "m", "A");
        Jaulas[3]=new Jaula(4, "l", "A");
        Jaulas[4]=new Jaula(5, "s", "B");
        Jaulas[5]=new Jaula(6, "m", "B");
        //Pacientes ingresados
        pacientes[0]=new Perro("Rocky"  , 30.0, 4, "Labrador", true);
        pacientes[1]=new Gato("Misifu"  , 4.0, 4, 0);
        pacientes[2]=new AveExotica("Kiwi"  , 0.8, 2, 70.0);
        ContadorPacientes=3;
    }
}
