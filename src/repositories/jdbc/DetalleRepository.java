package repositories.jdbc;
import connectors.Connector;
import entidades.Detalle;
import entidades.Pelicula;
import entidades.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import repositories.interfaces.I_DetalleRepository;
import repositories.interfaces.I_PeliculaRepository;
import repositories.interfaces.I_SalaRepository;
public class DetalleRepository implements I_DetalleRepository{
    private Connection conn;

    public DetalleRepository(Connection conn) {
        this.conn = conn;
    }
    
    public java.sql.Date LocalDateConverter(LocalDate ld){
        return java.sql.Date.valueOf(ld);
    }
    
    public java.sql.Time LocalTimeConverter(LocalTime lt){
        return java.sql.Time.valueOf(lt);
    }
    
    public int getCapacidadByNroSala(int nroSala){
        I_SalaRepository sr = new SalaRepository(Connector.getConnection());
        return sr.getByNumero(nroSala).getCapacidad();
    }
    
    @Override
    public void crear(Detalle detalle) {
        if(detalle == null) {System.out.println("sale por null"); return;}
        if (comprobarDuplicado(detalle)) {System.out.println("sale por duplicado"); return;}
        if (!comprobarDisponibilidad(detalle)){
            JOptionPane.showMessageDialog(null, "La sala no esta disponible en ese horario");
        } else {
            try(PreparedStatement ps = conn.prepareStatement("insert into detalles(codPelicula, nroSala, entradasDisponibles, fecha, horario) values(?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS)){

                ps.setInt(1, detalle.getCodPelicula());
                ps.setInt(2, detalle.getNroSala());
                ps.setInt(3, getCapacidadByNroSala(detalle.getNroSala()));
                ps.setDate(4, LocalDateConverter(detalle.getFecha()));
                ps.setTime(5, LocalTimeConverter(detalle.getHorario()));
                ps.execute();

                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    detalle.setCodDetalle(rs.getInt(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void borrar(Detalle detalle) {
        if(detalle == null) return;
        try(PreparedStatement ps = conn.prepareStatement("delete from detalles where codDetalle = ?")){
            ps.setInt(1, detalle.getCodDetalle());
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void actualizar(Detalle detalle) {
        if(detalle == null) {System.out.println("sale por null"); return;}
        if (comprobarDuplicado(detalle)) {System.out.println("sale por duplicado actualizar"); return;}
        if(!comprobarDisponibilidad(detalle)){
            JOptionPane.showMessageDialog(null, "La sala no esta disponible en ese horario");
        } else {
            try(PreparedStatement ps = conn.prepareStatement("update detalles set codPelicula = ?, nroSala = ?, entradasDisponibles = ?, fecha = ?, horario = ? where codDetalle = ?")){
                ps.setInt(1, detalle.getCodPelicula());
                ps.setInt(2, detalle.getNroSala());
                ps.setInt(3, detalle.getEntradasDisponibles());
                ps.setDate(4, LocalDateConverter(detalle.getFecha()));
                ps.setTime(5, LocalTimeConverter(detalle.getHorario()));
                ps.setInt(6, detalle.getCodDetalle());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Detalle> getAll() {
        List<Detalle> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from detalles")){
            while (rs.next()) {
                list.add(
                        new Detalle(
                                rs.getInt("codDetalle"), 
                                rs.getInt("codPelicula"), 
                                rs.getInt("nroSala"),
                                rs.getInt("entradasDisponibles"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("horario").toLocalTime()
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }   

    @Override
    public Detalle getByCodDetalle(int codDetalle) {
        Detalle de = new Detalle();
        for(Detalle d : getAll()){
            if (d.getCodDetalle() == codDetalle) {
                de = d;
            }
        }
        return de;        
    }
    
        private boolean comprobarDuplicado(Detalle detalle) {
        boolean yaExiste = false;
        for(Detalle d: getAll()){
            if (detalle.getCodPelicula() == d.getCodPelicula() &&
                detalle.getNroSala() == d.getNroSala() &&
                detalle.getEntradasDisponibles() == d.getEntradasDisponibles() &&
                d.getFecha().isEqual(detalle.getFecha()) &&
                detalle.getHorario().equals(d.getHorario())
                )
            {
                yaExiste = true;
                return true;
            }
        }
        return false;
    }  

    @Override
    public List<Detalle> getByPelicula(int codPelicula) {
        List<Detalle> lista = new ArrayList();
        
        for(Detalle d : getAll()){
            if (d.getCodPelicula() == codPelicula) {
                lista.add(d);
            }
        }
        
        return lista;
    }

    @Override
    public List<Detalle> getByFecha(LocalDate ld) {
        List<Detalle> lista = new ArrayList();
        
        for(Detalle d : getAll()){
            if (d.getFecha().equals(ld)) {
                lista.add(d);
            }
        }
        
        return lista;
    }
    
    @Override
    public List<Detalle> getByFechaYTitulo(LocalDate fecha, String titulo){
        List<Detalle> lista = new ArrayList();
        
        I_PeliculaRepository pr = new PeliculaRepository(Connector.getConnection());

        for(Detalle d: getByFecha(fecha)){
            //Obtengo la pelicula que tiene vinculado el detalle, si tiene el mismo titulo
            //que el pasado por parametro significa que el detalle cumple con que
            //Esa pelicula va a ser emitida el dia que preguntaba
            Pelicula pDetalle = pr.getByCodigo(d.getCodPelicula());
            
            if (pDetalle.getTitulo().equals(titulo)) {
                lista.add(d);
            }
        }
        
        return lista;
    }

    @Override
    public List<Detalle> getByFechaYHorario(LocalDate ld, LocalTime lt) {
        List<Detalle> lista = new ArrayList();
        
        for(Detalle d: getAll()){
            if (d.getFecha().equals(ld) && d.getHorario().equals(lt)) {
                lista.add(d);
            }
        }
        
        return lista;
    }
    
    @Override
    public Detalle getByFechaHorarioSala(LocalDate fecha, LocalTime horario, int nroSala){
        Detalle d = new Detalle();
        
        for(Detalle de : getAll()){
            if (de.getFecha().equals(fecha) && de.getHorario().equals(horario) && de.getNroSala() == nroSala) 
            {
                de = d;
            }
        }
        
        return d;
    }
    
    @Override
    public Detalle getByFechaTituloHorario(LocalDate fecha, LocalTime horario, String titulo){
        Detalle d = new Detalle();
        
        for(Detalle de: getByFechaYTitulo(fecha, titulo)){
            if (de.getHorario().equals(horario)) {
                d = de;
            }
        }
        
        return d;
    }
    
    public List<Detalle> getBySala(Sala sala){
        List<Detalle> list = new ArrayList();
        
        for(Detalle d: getAll()){
            if (d.getNroSala() == sala.getNumero()) {
                list.add(d);
            }
        }
        
        return list;
    }
    
    public List<Detalle> getBySalaFecha(Sala sala, LocalDate fecha){
        List<Detalle> list = new ArrayList();
        
        for(Detalle d: getBySala(sala)){
            if (d.getFecha().equals(fecha)) {
                list.add(d);
            }
        }
        
        return list;
    }
    
    @Override
    public boolean comprobarDisponibilidad(Detalle funcion){
        //Pregunto si hay funciones antes, si las hay necesito saber la hora de inicio
        //y duracion de la misma, si la hora en la que la sala va a estar disponible
        //es antes de la hora de inicio de la funcion recibida por parametros entonces esta ok
        //sino devuelve que la sala no va a estar disponible en ese momento        
        
        I_SalaRepository sr = new SalaRepository(conn);
        Sala sala = sr.getByNumero(funcion.getNroSala());
        
        I_PeliculaRepository pr = new PeliculaRepository(conn);
        Pelicula p = pr.getByCodigo(funcion.getCodPelicula());
        
        //Guardo la hora de inicio, duracion y hora de finalizacion de mi funcion
        LocalTime horaInicio = funcion.getHorario();
        int duracionFuncion = p.getDuracion();
        LocalTime horaTermina = horaInicio.plus(Duration.ofMinutes(duracionFuncion));
                
        List<Detalle> funcionesAnteriores = new ArrayList();
        List<Detalle> funcionesSiguientes = new ArrayList();
        
        if (getBySalaFecha(sala, funcion.getFecha()).isEmpty()) {
            return true;
        } else {
            for(Detalle d: getBySalaFecha(sala, funcion.getFecha())){
                //Tengo todas las funciones del dia de la que quiero consultar
                //Tengo que averiguar cuales empiezan antes que esta, estas las
                //añado a una lista
                if (d.getHorario().isBefore(horaInicio)) {
                    funcionesAnteriores.add(d);
                } else {
                    funcionesSiguientes.add(d);
                }
            }
            
            int duracionFuncionAnterior = 0;
            LocalTime horaTerminaFuncionAnterior = null;
            //long diffMinutosFunciones = 0;
            boolean checkAnteriores = false;
            
            for(Detalle d : funcionesAnteriores){
                //Recorro las funciones anteriores, necesito saber cual es la que
                //esta mas cerca de la funcion que quiero consultar disponibilidad
                
                //Tengo la duracion de la FuncionAnterior
                duracionFuncionAnterior = pr.getByCodigo(d.getCodPelicula()).getDuracion();
                
                //Tengo la hora a la que termina la FuncionAnterior
                horaTerminaFuncionAnterior = d.getHorario().plus(Duration.ofMinutes(duracionFuncionAnterior));
                
                //Otra forma de obtener la hora a la que termina la FuncionAnterior
                //horaTerminaFuncionAnterior = d.getHorario().plus(duracionFuncionAnterior, ChronoUnit.MINUTES);
                
                //Con esta hora puedo saber desde el inicio de esta funcion a que hora va a estar disponible
                //la sala, si esa hora es antes de mi funcion entonces puedo crear el Detalle sino no.
                
                //Esta seria otra forma de saber si la funcion pasada por parametro
                //empieza antes de que termine alguna funcion:
                
                //Obtengo la cantidad de minutos de distancia entre la hora de finalizacion de
                //la funcion anterior y la hora de inicio de la mia
                //diffMinutosFunciones = Duration.between(horaTerminaFuncionAnterior, horaInicio).toMinutes();
                
                //Si la diferencia entre las funciones es menor a 0 minutos, es decir que 
                //la hora de 
                if (horaInicio.isBefore(horaTerminaFuncionAnterior)) {
                    checkAnteriores = false;
                } else {
                    checkAnteriores = true;
                }                
            }
            
            LocalTime horaInicioFuncionSiguiente = null;
            boolean checkSiguientes = false;
            
            for(Detalle d: funcionesSiguientes){
                //Obtengo la hora de inicio de las funciones que empiezan
                //despues que la que quiero consultar
                horaInicioFuncionSiguiente = d.getHorario();
                
                checkSiguientes = horaTermina.isBefore(horaInicioFuncionSiguiente);
            }
            
            return checkAnteriores || checkSiguientes;
        }
    }
}
