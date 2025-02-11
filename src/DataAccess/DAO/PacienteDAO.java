package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.SQLiteDataHelper;
import DataAccess.DTO.PacienteDTO;
import Framework.PoliSaludException;

public class PacienteDAO extends SQLiteDataHelper implements IDAO<PacienteDTO> {
    @Override
    public PacienteDTO readBy(Integer id) throws Exception {
        PacienteDTO oS = new PacienteDTO();
        String query = " SELECT "
                + "  id_paciente    "
                + " ,nombre        "
                + " ,apellido      "
                + " ,codigo_unico  "
                + " ,email         "
                + " ,telefono      "
                + " ,fecha_nacimiento "
                + " ,direccion     "
                + " ,estado        "
                + " ,fecha_crea    "
                + " ,fecha_modifica"
                + " FROM paciente "
                + " WHERE estado='A' AND id_paciente = " + id.toString();

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la consulta
            while (rs.next()) {
                oS = new PacienteDTO(
                        rs.getInt(1), // id_paciente
                        rs.getString(2), // nombre
                        rs.getString(3), // apellido
                        rs.getString(4), // codigo_unico
                        rs.getString(5), // email
                        rs.getString(6), // telefono
                        rs.getString(7), // fecha_nacimiento
                        rs.getString(8), // direccion
                        rs.getString(9), // estado
                        rs.getString(10), // fecha_crea
                        rs.getString(11) // fecha_modifica
                );
            }
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oS;
    }

    @Override
    public List<PacienteDTO> readAll() throws Exception {
        List<PacienteDTO> lst = new ArrayList<>();
        String query = " SELECT "
                + "  id_paciente    "
                + " ,nombre        "
                + " ,apellido      "
                + " ,codigo_unico  "
                + " ,email         "
                + " ,telefono      "
                + " ,fecha_nacimiento "
                + " ,direccion     "
                + " ,estado        "
                + " ,fecha_crea    "
                + " ,fecha_modifica"
                + " FROM paciente "
                + " WHERE estado='A' ";

        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                PacienteDTO s = new PacienteDTO(
                        rs.getInt(1), // id_paciente
                        rs.getString(2), // nombre
                        rs.getString(3), // apellido
                        rs.getString(4), // codigo_unico
                        rs.getString(5), // email
                        rs.getString(6), // telefono
                        rs.getString(7), // fecha_nacimiento
                        rs.getString(8), // direccion
                        rs.getString(9), // estado
                        rs.getString(10), // fecha_crea
                        rs.getString(11) // fecha_modifica
                );
                lst.add(s);
            }
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean create(PacienteDTO entity) throws Exception {
        String query = " INSERT INTO paciente ("
                + "nombre, "
                + "apellido, "
                + "codigo_unico, "
                + "email, "
                + "telefono, "
                + "fecha_nacimiento, "
                + "direccion"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getCodigoUnico());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getTelefono());
            pstmt.setString(6, entity.getFechaNacimiento());
            pstmt.setString(7, entity.getDireccion());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public boolean update(PacienteDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " UPDATE paciente SET nombre = ?, apellido = ?, codigo_unico = ?, email = ?, telefono = ?, fecha_nacimiento = ?, direccion = ?, fecha_modifica = ? WHERE id_paciente = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getApellido());
            pstmt.setString(3, entity.getCodigoUnico());
            pstmt.setString(4, entity.getEmail());
            pstmt.setString(5, entity.getTelefono());
            pstmt.setString(6, entity.getFechaNacimiento());
            pstmt.setString(7, entity.getDireccion());
            pstmt.setString(8, dtf.format(now).toString());
            pstmt.setInt(9, entity.getIdPaciente());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        String query = " UPDATE paciente SET estado = ? WHERE id_paciente = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    public Integer getMaxRow() throws Exception {
        String query = " SELECT COUNT(*) TotalReg FROM  "
                + " WHERE   Estado ='A' ";
        try {
            Connection conn = openConnection(); // conectar a DB
            Statement stmt = conn.createStatement(); // CRUD : select * ...
            ResultSet rs = stmt.executeQuery(query); // ejecutar la
            while (rs.next()) {
                return rs.getInt(1); // TotalReg
            }
        } catch (SQLException e) {
            throw new PoliSaludException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
}
