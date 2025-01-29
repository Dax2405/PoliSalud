package BusinessLogic.Entities;
package BusinessLogic;

import java.util.List;
import DataAccess.DAO.PacienteDAO;
import DataAccess.DTO.PacienteDTO;

public class PacienteBL {
    private PacienteDTO paciente;       
    private PacienteDAO pacDAO = new PacienteDAO();

    public PacienteBL(){}

    public List<PacienteDTO> getAll() throws Exception{
        return pacDAO.readAll();
    }
    public PacienteDTO getByIdPaciente(int idPaciente) throws Exception{
        paciente = pacDAO.readBy(idPaciente);
        return paciente;
    }
    public boolean create(PacienteDTO pacienteDTO) throws Exception{   
        return pacDAO.create(pacienteDTO);
    }
    public boolean update(PacienteDTO pacienteDTO) throws Exception{
        return pacDAO.update(pacienteDTO);
    }
    public boolean delete(int idPaciente) throws Exception{
        return pacDAO.delete(idPaciente);
    }
    public Integer getMaxRow() throws Exception{
        return pacDAO.getMaxRow();
    }
}