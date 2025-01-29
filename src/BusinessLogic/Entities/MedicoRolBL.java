package BusinessLogic.Entities;

import DataAccess.DAO.MedicoRolDAO;
import DataAccess.DTO.MedicoRolDTO;
import java.util.List;

public class MedicoRolBL {
    private MedicoRolDTO medicoRol;       
    private MedicoRolDAO mdrDAO = new MedicoRolDAO();

    public MedicoRolBL(){}

    public List<MedicoRolDTO> getAll() throws Exception{
        return mdrDAO.readAll();
    }
    public MedicoRolDTO getByIdMedicoRol(int idMedicoRol) throws Exception{
        medicoRol = mdrDAO.readBy(idMedicoRol);
        return medicoRol;
    }
    public boolean create(MedicoRolDTO medicoRolDTO) throws Exception{   
        return mdrDAO.create(medicoRolDTO);
    }
    public boolean update(MedicoRolDTO medicoRolDTO) throws Exception{
        return mdrDAO.update(medicoRolDTO);
    }
    public boolean delete(int idMedicoRol) throws Exception{
        return mdrDAO.delete(idMedicoRol);
    }
    public Integer getMaxRow() throws Exception{
        return mdrDAO.getMaxRow();
    }  
}