public class Hospital {
    private Paciente[] pacientes;
    private int ContadorPacientes;
    private Jaula[] Jaulas;

    public Hospital() {
        this.pacientes = new Paciente[10];
        this.ContadorPacientes = 0;
        this.Jaulas = new Jaula[6];
        cargarDatosIniciales();
    }

    public void cargarDatosIniciales() {
        Jaulas[0] = new Jaula(1, "s", "A");
        Jaulas[1] = new Jaula(2, "m", "A");
        Jaulas[2] = new Jaula(3, "m", "A");
        Jaulas[3] = new Jaula(4, "l", "A");
        Jaulas[4] = new Jaula(5, "s", "B");
        Jaulas[5] = new Jaula(6, "m", "B");
        //Pacientes ingresados
        pacientes[0] = new Perro("Rocky", 30.0, 4, "Labrador", true);
        pacientes[1] = new Gato("Misifu", 4.0, 4, 0);
        pacientes[2] = new AveExotica("Kiwi", 0.8, 2, 70.0);
        ContadorPacientes = 3;
    }

    public Paciente buscarPaciente(String nombre) {
        for (int i = 0; i < ContadorPacientes; i++) {
            if (pacientes[i].getNombre().equalsIgnoreCase(nombre)) {
                return pacientes[i];
            }
        }
        return null;
    }

    public String ingresarPerro(String nombre, double peso, int edad, String raza, boolean vacunado) {
        if (nombre == null || nombre.trim().isEmpty() || peso <= 0 || peso > 80 || edad < 0 || edad > 30) {
            return "ERROR: datos invalidos";
        }
        if (buscarPaciente(nombre) != null) {
            return "ERROR: nombre duplicado";
        }
        if (ContadorPacientes >= 10) {
            return "ERROR: hospital lleno";
        }

        Perro perro = new Perro(nombre, peso, edad, raza, vacunado);
        pacientes[ContadorPacientes++] = perro;

        if (!vacunado) {
            return "OK: " + nombre + " ingresado en Cuarentena";
        }
        return "OK: " + nombre + " ingresado";
    }

    public String ingresarGato(String nombre, double peso, int edad) {
        if (nombre == null || nombre.trim().isEmpty() || peso <= 0 || peso > 15 || edad < 0 || edad > 30) {
            return "ERROR: datos invalidos";
        }
        if (buscarPaciente(nombre) != null) {
            return "ERROR: nombre duplicado";
        }
        if (ContadorPacientes >= 10) {
            return "ERROR: hospital lleno";
        }

        Gato gato = new Gato(nombre, peso, edad, 0);
        pacientes[ContadorPacientes++] = gato;
        return "OK: " + nombre + " ingresado";
    }

    public String ingresarAve(String nombre, double peso, int edad, double envergadura) {
        if (nombre == null || nombre.trim().isEmpty() || peso <= 0 || peso > 15 || edad < 0 || edad > 30 || envergadura <= 0) {
            return "ERROR: datos invalidos";
        }
        if (buscarPaciente(nombre) != null) {
            return "ERROR: nombre duplicado";
        }
        if (ContadorPacientes >= 10) {
            return "ERROR: hospital lleno";
        }

        AveExotica ave = new AveExotica(nombre, peso, edad, envergadura);
        pacientes[ContadorPacientes++] = ave;
        return "OK: " + nombre + " ingresado";
    }

    public String vacunar(String nombre) {
        Paciente p = buscarPaciente(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if (!(p instanceof Perro)) {
            return "ERROR: solo aplica a perros";
        }
        Perro perro = (Perro) p;
        if (perro.getVacunado()) {
            return "ERROR: ya vacunado";
        }
        perro.setVacunado(true);
        return "OK: " + nombre + " vacunado (pasa a INGRESADO)";
    }

    private int obtenerValorTamano(char t) {
        if (t == 'S') return 1;
        if (t == 'M') return 2;
        if (t == 'L') return 3;
        return 0;
    }

    public String asignar(String nombre) {
        Paciente p = buscarPaciente(nombre);
        if (p == null) {
            return "ERROR: paciente no encontrado";
        }
        if ("CUARENTENA".equals(p.getEstado())) {
            return "ERROR: paciente en cuarentena";
        }
        if (p.getJaulaAsignada() != null) {
            return "ERROR: paciente ya tiene jaula";
        }
        char zonaRequerida = 'A';
        char tamanoRequerido = 'S';

        if (p instanceof AveExotica) {
            zonaRequerida = 'B';
            AveExotica ave = (AveExotica) p;
            if (ave.getPeso() < 5) {
                tamanoRequerido = 'S';
            } else if (ave.getPeso() <= 25) {
                tamanoRequerido = 'M';
            } else {
                tamanoRequerido = 'L';
            }
            if (ave.getEnvergadura() > 60 && tamanoRequerido == 'S') {
                tamanoRequerido = 'M';
            }
        } else {
            zonaRequerida = 'A';
            if (p.getPeso() < 5) {
                tamanoRequerido = 'S';
            } else if (p.getPeso() <= 25) {
                tamanoRequerido = 'M';
            } else {
                tamanoRequerido = 'L';
            }
        }
    int valReq = obtenerValorTamano(tamanoRequerido);
    Jaula jaulaSeleccionada = null;

        for (Jaula j : Jaulas) {
        if (j.estalibre() && j.getZona() == zonaRequerida) {
            if (obtenerValorTamano(j.getTamaño()) >= valReq) {
                jaulaSeleccionada = j;
                break;
            }
        }
    }
}