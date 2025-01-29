package BusinessLogic.Entities;

import java.util.List;
import DataAccess.DAO.SalaDAO;
import DataAccess.DTO.SalaDTO;

public class SalaBL {
    private SalaDTO sala;       
    private SalaDAO saDAO = new SalaDAO();

    public SalaBL(){}

    public List<SalaDTO> getAll() throws Exception{
        return saDAO.readAll();
    }
    public SalaDTO getByIdSala(int idSala) throws Exception{
        sala = saDAO.readBy(idSala);
        return sala;
    }
    public boolean create(SalaDTO salaDTO) throws Exception{   
        return saDAO.create(salaDTO);
    }
    public boolean update(SalaDTO salaDTO) throws Exception{
        return saDAO.update(salaDTO);
    }
    public boolean delete(int idSala) throws Exception{
        return saDAO.delete(idSala);
    }
    public Integer getMaxRow() throws Exception{
        return saDAO.getMaxRow();
    }
}
