package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.CaptainDao;

public class DaoMemoryFactory extends DaoFactory {

    private CaptainDao captainDao;

    @Override
    public CaptainDao getCaptainDao() {
        if (this.captainDao == null) {
            this.captainDao = new CaptainDaoMemory();
        }
        return this.captainDao;
    }
}
