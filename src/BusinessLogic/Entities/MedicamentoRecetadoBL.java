package BusinessLogic.Entities;

import DataAccess.DAO.MedicamentoRecetadoDAO;
import DataAccess.DTO.MedicamentoRecetadoDTO;
import java.util.List;

public class MedicamentoRecetadoBL {

    private MedicamentoRecetadoDTO medicamentoRecetado;       
    private MedicamentoRecetadoDAO mrDAO = new MedicamentoRecetadoDAO();

    public MedicamentoRecetadoBL(){}

    public List<MedicamentoRecetadoDTO> getAll() throws Exception{
        return mrDAO.readAll();
    }
    public MedicamentoRecetadoDTO getByIdMedicamentoRecetado(int idMedicamentoRecetado) throws Exception{
        medicamentoRecetado = mrDAO.readBy(idMedicamentoRecetado);
        return medicamentoRecetado;
    }
    public boolean create(MedicamentoRecetadoDTO medicamentoRecetadoDTO) throws Exception{   
        return mrDAO.create(medicamentoRecetadoDTO);
    }
    public boolean update(MedicamentoRecetadoDTO medicamentoRecetadoDTO) throws Exception{
        return mrDAO.update(medicamentoRecetadoDTO);
    }
    public boolean delete(int idMedicamentoRecetado) throws Exception{
        return mrDAO.delete(idMedicamentoRecetado);
    }
    public Integer getMaxRow() throws Exception{
        return mrDAO.getMaxRow();
    }
    
}
