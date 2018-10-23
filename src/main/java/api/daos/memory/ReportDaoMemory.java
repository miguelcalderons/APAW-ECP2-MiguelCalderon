package api.daos.memory;

import api.daos.ReportDao;
import api.entities.Report;

public class ReportDaoMemory extends GenericDaoMemory<Report> implements ReportDao {

    @Override
    public String getId(Report report) {
        return report.getId();
    }

    @Override
    public void setId(Report report, String id) {
        report.setId(id);
    }
}
