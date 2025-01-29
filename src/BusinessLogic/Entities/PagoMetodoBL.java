package BusinessLogic.Entities;
package BusinessLogic;

import java.util.List;

import DataAccess.DAO.PagoMetodoDAO;
import DataAccess.DTO.PagoMetodoDTO;

public class PagoMetodoBL {
    private PagoMetodoDTO pagometodo;       
    private PagoMetodoDAO pmDAO = new PagoMetodoDAO();

    public PagoMetodoBL(){}

    public List<PagoMetodoDTO> getAll() throws Exception{
        return pmDAO.readAll();
    }
    public PagoMetodoDTO getByIdPagoMetodo(int idPagoMetodo) throws Exception{
        pagometodo = pmDAO.readBy(idPagoMetodo);
        return pagometodo;
    }
    public boolean create(PagoMetodoDTO pagometodoDTO) throws Exception{   
        return pmDAO.create(pagometodoDTO);
    }
    public boolean update(PagoMetodoDTO pagometodoDTO) throws Exception{
        return pmDAO.update(pagometodoDTO);
    }
    public boolean delete(int idPagoMetodo) throws Exception{
        return pmDAO.delete(idPagoMetodo);
    }
    public Integer getMaxRow() throws Exception{
        return pmDAO.getMaxRow();
    }
}