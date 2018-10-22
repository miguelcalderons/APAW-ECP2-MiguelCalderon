package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.CaptainDao;
import api.daos.ReportDao;

public class DaoMemoryFactory extends DaoFactory {

    private CaptainDao captainDao;

    private ReportDao reportDao;

    @Override
    public CaptainDao getCaptainDao() {
        if (this.captainDao == null) {
            this.captainDao = new CaptainDaoMemory();
        }
        return this.captainDao;
    }

    @Override
    public ReportDao getReportDao() {
        if (this.reportDao == null) {
            this.reportDao = new ReportDaoMemory();
        }
        return this.reportDao;
    }
}
