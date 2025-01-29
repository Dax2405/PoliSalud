package BusinessLogic.Entities;
package BusinessLogic;

import java.util.List;
import DataAccess.DAO.TurnoDAO;
import DataAccess.DTO.TurnoDTO;

public class TurnoBL {
    private TurnoDTO turno;       
    private TurnoDAO tDAO = new TurnoDAO();

    public TurnoBL(){}

    public List<TurnoDTO> getAll() throws Exception{
        return tDAO.readAll();
    }
    public TurnoDTO getByIdTurno(int idTurno) throws Exception{
        turno = tDAO.readBy(idTurno);
        return turno;
    }
    public boolean create(TurnoDTO turnoDTO) throws Exception{   
        return tDAO.create(turnoDTO);
    }
    public boolean update(TurnoDTO turnoDTO) throws Exception{
        return tDAO.update(turnoDTO);
    }
    public boolean delete(int idTurno) throws Exception{
        return tDAO.delete(idTurno);
    }
    public Integer getMaxRow() throws Exception{
        return tDAO.getMaxRow();
    }
}
