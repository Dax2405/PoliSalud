package BusinessLogic.Entities;

import java.util.List;
import DataAccess.DAO.PagoDAO;
import DataAccess.DTO.PagoDTO;

public class PagoBL {
    private PagoDTO pago;       
    private PagoDAO pagDAO = new PagoDAO();

    public PagoBL(){}

    public List<PagoDTO> getAll() throws Exception{
        return pagDAO.readAll();
    }
    public PagoDTO getByIdSexo(int idPago) throws Exception{
        pago = pagDAO.readBy(idPago);
        return pago;
    }
    public boolean create(PagoDTO pagoDTO) throws Exception{   
        return pagDAO.create(pagoDTO);
    }
    public boolean update(PagoDTO pagoDTO) throws Exception{
        return pagDAO.update(pagoDTO);
    }
    public boolean delete(int idPago) throws Exception{
        return pagDAO.delete(idPago);
    }
    public Integer getMaxRow() throws Exception{
        return pagDAO.getMaxRow();
    }
}
