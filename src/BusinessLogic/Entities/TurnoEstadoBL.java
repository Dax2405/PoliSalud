package BusinessLogic.Entities;
package BusinessLogic;

import java.util.List;
import DataAccess.DAO.SexoDAO;
import DataAccess.DTO.SexoDTO;

public class TurnoEstadoBL {
    private TurnoEstadoDTO turnoestado;       
    private TurnoEstadoDAO teDAO = new TurnoEstadoDAO();

    public TurnoEstadoBL(){}

    public List<TurnoEstadoDTO> getAll() throws Exception{
        return teDAO.readAll();
    }
    public TurnoEstadoDTO getByIdTurnoEstado(int idTurnoEstado) throws Exception{
        turnoestado = teDAO.readBy(idTurnoEstado);
        return turnoestado;
    }
    public boolean create(TurnoEstadoDTO turnoestadoDTO) throws Exception{   
        return teDAO.create(turnoestadoDTO);
    }
    public boolean update(TurnoEstadoDTO turnoestadoDTO) throws Exception{
        return teDAO.update(turnoestadoDTO);
    }
    public boolean delete(int idTurnoEstado) throws Exception{
        return teDAO.delete(idTurnoEstado);
    }
    public Integer getMaxRow() throws Exception{
        return teDAO.getMaxRow();
    }
}
