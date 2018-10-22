package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.CaptainDao;
import api.daos.ReportDao;
import  api.daos.FlightDao;

public class DaoMemoryFactory extends DaoFactory {

    private CaptainDao captainDao;

    private ReportDao reportDao;

    private FlightDao flightDao;

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

    @Override
    public FlightDao flightDao() {
        if (this.flightDao == null) {
            this.flightDao = new FlightDaoMemory();
        }
        return this.flightDao;
    }
}
