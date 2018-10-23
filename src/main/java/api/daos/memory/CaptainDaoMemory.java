package api.daos.memory;

import api.daos.CaptainDao;
import api.entities.Captain;

public class CaptainDaoMemory extends GenericDaoMemory<Captain> implements CaptainDao {

    @Override
    public String getId(Captain captain) {
        return captain.getId();
    }

    @Override
    public void setId(Captain captain, String id) {
        captain.setId(id);
    }
}
