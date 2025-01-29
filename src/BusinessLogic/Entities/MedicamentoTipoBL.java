package BusinessLogic.Entities;

import DataAccess.DAO.MedicamentoTipoDAO;
import DataAccess.DTO.MedicamentoTipoDTO;
import java.util.List;

public class MedicamentoTipoBL {
    private MedicamentoTipoDTO medicamentoTipo;       
    private MedicamentoTipoDAO mtDAO = new MedicamentoTipoDAO();

    public MedicamentoTipoBL(){}

    public List<MedicamentoTipoDTO> getAll() throws Exception{
        return mtDAO.readAll();
    }
    public MedicamentoTipoDTO getByIdMedicamentoTipo(int idMedicamentoTipo) throws Exception{
        medicamentoTipo = mtDAO.readBy(idMedicamentoTipo);
        return medicamentoTipo;
    }
    public boolean create(MedicamentoTipoDTO medicamentoTipoDTO) throws Exception{   
        return mtDAO.create(medicamentoTipoDTO);
    }
    public boolean update(MedicamentoTipoDTO medicamentoTipoDTO) throws Exception{
        return mtDAO.update(medicamentoTipoDTO);
    }
    public boolean delete(int idMedicamentoTipo) throws Exception{
        return mtDAO.delete(idMedicamentoTipo);
    }
    public Integer getMaxRow() throws Exception{
        return mtDAO.getMaxRow();
    }    
}