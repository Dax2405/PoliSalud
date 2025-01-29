package BusinessLogic.Entities;

import DataAccess.DAO.MedicoDAO;
import DataAccess.DTO.MedicoDTO;
import java.util.List;

public class MedicoBL {
private MedicoDTO medico;       
    private MedicoDAO mdDAO = new MedicoDAO();

    public MedicoBL(){}

    public List<MedicoDTO> getAll() throws Exception{
        return mdDAO.readAll();
    }
    public MedicoDTO getByIdMedico(int idMedico) throws Exception{
        medico = mdDAO.readBy(idMedico);
        return medico;
    }
    public boolean create(MedicoDTO medicoDTO) throws Exception{   
        return mdDAO.create(medicoDTO);
    }
    public boolean update(MedicoDTO medicoDTO) throws Exception{
        return mdDAO.update(medicoDTO);
    }
    public boolean delete(int idMedico) throws Exception{
        return mdDAO.delete(idMedico);
    }
    public Integer getMaxRow() throws Exception{
        return mdDAO.getMaxRow();
    }    
}
