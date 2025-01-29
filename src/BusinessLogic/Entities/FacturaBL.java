package BusinessLogic.Entities;

import DataAccess.DAO.FacturaDAO;
import DataAccess.DTO.FacturaDTO;
import java.util.List;

public class FacturaBL {
    
    private FacturaDTO factura;       
    private FacturaDAO fDAO = new FacturaDAO();

    public FacturaBL(){}

    public List<FacturaDTO> getAll() throws Exception{
        return fDAO.readAll();
    }
    public FacturaDTO getByIdFactura(int idFactura) throws Exception{
        factura = fDAO.readBy(idFactura);
        return factura;
    }
    public boolean create(FacturaDTO facturaDTO) throws Exception{   
        return fDAO.create(facturaDTO);
    }
    public boolean update(FacturaDTO facturaDTO) throws Exception{
        return fDAO.update(facturaDTO);
    }
    public boolean delete(int idFactura) throws Exception{
        return fDAO.delete(idFactura);
    }
    public Integer getMaxRow() throws Exception{
        return fDAO.getMaxRow();
    }
}
