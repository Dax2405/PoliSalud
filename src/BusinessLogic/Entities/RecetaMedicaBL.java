package BusinessLogic.Entities;

import java.util.List;
import DataAccess.DAO.RecetaMedicaDAO;
import DataAccess.DTO.RecetaMedicaDTO;

public class RecetaMedicaBL {
    private RecetaMedicaDTO recetamedica;       
    private RecetaMedicaDAO rmDAO = new RecetaMedicaDAO();

    public RecetaMedicaBL(){}

    public List<RecetaMedicaDTO> getAll() throws Exception{
        return rmDAO.readAll();
    }
    public RecetaMedicaDTO getByIdRecetaMedica(int idRecetaMedica) throws Exception{
        recetamedica = rmDAO.readBy(idRecetaMedica);
        return recetamedica;
    }
    public boolean create(RecetaMedicaDTO recetamedicaDTO) throws Exception{   
        return rmDAO.create(recetamedicaDTO);
    }
    public boolean update(RecetaMedicaDTO recetamedicaDTO) throws Exception{
        return rmDAO.update(recetamedicaDTO);
    }
    public boolean delete(int idRecetaMedica) throws Exception{
        return rmDAO.delete(idRecetaMedica);
    }
    public Integer getMaxRow() throws Exception{
        return rmDAO.getMaxRow();
    }
}
