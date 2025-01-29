package BusinessLogic.Entities;

import java.util.List;
import DataAccess.DAO.PacienteHistoriaClinicaDAO;
import DataAccess.DTO.PacienteHistoriaClinicaDTO;

public class PacienteHistoriaClinicaBL {
    private PacienteHistoriaClinicaDTO pacientehistoriaclinica;       
    private PacienteHistoriaClinicaDAO phcDAO = new PacienteHistoriaClinicaDAO();

    public PacienteHistoriaClinicaBL(){}

    public List<PacienteHistoriaClinicaDTO> getAll() throws Exception{
        return phcDAO.readAll();
    }
    public PacienteHistoriaClinicaDTO getByIdPacienteHistoriaClinica(int idPacienteHistoriaClinica) throws Exception{
        pacientehistoriaclinica = phcDAO.readBy(idPacienteHistoriaClinica);
        return pacientehistoriaclinica;
    }
    public boolean create(PacienteHistoriaClinicaDTO pacientehistoriaclinicaDTO) throws Exception{   
        return phcDAO.create(pacientehistoriaclinicaDTO);
    }
    public boolean update(PacienteHistoriaClinicaDTO pacientehistoriaclinicaDTO) throws Exception{
        return phcDAO.update(pacientehistoriaclinicaDTO);
    }
    public boolean delete(int idPacienteHistoriaClinica) throws Exception{
        return phcDAO.delete(idPacienteHistoriaClinica);
    }
    public Integer getMaxRow() throws Exception{
        return phcDAO.getMaxRow();
    }
}
