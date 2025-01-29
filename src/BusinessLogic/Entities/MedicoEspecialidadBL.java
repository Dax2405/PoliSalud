package BusinessLogic.Entities;

import DataAccess.DAO.MedicoEspecialidadDAO;
import DataAccess.DTO.MedicoEspecialidadDTO;
import java.util.List;

public class MedicoEspecialidadBL {
    private MedicoEspecialidadDTO medicoEspecialidad;       
    private MedicoEspecialidadDAO mdeDAO = new MedicoEspecialidadDAO();

    public MedicoEspecialidadBL(){}

    public List<MedicoEspecialidadDTO> getAll() throws Exception{
        return mdeDAO.readAll();
    }
    public MedicoEspecialidadDTO getByIdMedicoEspecialidad(int idMedicoEspecialidad) throws Exception{
        medicoEspecialidad = mdeDAO.readBy(idMedicoEspecialidad);
        return medicoEspecialidad;
    }
    public boolean create(MedicoEspecialidadDTO medicoEspecialidadDTO) throws Exception{   
        return mdeDAO.create(medicoEspecialidadDTO);
    }
    public boolean update(MedicoEspecialidadDTO medicoEspecialidadDTO) throws Exception{
        return mdeDAO.update(medicoEspecialidadDTO);
    }
    public boolean delete(int idMedicoEspecialidad) throws Exception{
        return mdeDAO.delete(idMedicoEspecialidad);
    }
    public Integer getMaxRow() throws Exception{
        return mdeDAO.getMaxRow();
    }
}