package BusinessLogic.Entities;

import DataAccess.DAO.MedicamentoDAO;
import DataAccess.DTO.MedicamentoDTO;
import java.util.List;

public class MedicamentoBL {
    private MedicamentoDTO medicamento;       
    private MedicamentoDAO mDAO = new MedicamentoDAO();

    public MedicamentoBL(){}

    public List<MedicamentoDTO> getAll() throws Exception{
        return mDAO.readAll();
    }
    public MedicamentoDTO getByIdMedicamento(int idMedicamento) throws Exception{
        medicamento = mDAO.readBy(idMedicamento);
        return medicamento;
    }
    public boolean create(MedicamentoDTO medicamentoDTO) throws Exception{   
        return mDAO.create(medicamentoDTO);
    }
    public boolean update(MedicamentoDTO medicamentoDTO) throws Exception{
        return mDAO.update(medicamentoDTO);
    }
    public boolean delete(int idMedicamento) throws Exception{
        return mDAO.delete(idMedicamento);
    }
    public Integer getMaxRow() throws Exception{
        return mDAO.getMaxRow();
    }
}
