package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ReportDto;
import api.entities.Report;

public class ReportBusinessController {

    public void create(ReportDto reportDto) {
        Report report = new Report(reportDto.getSafeLanding(), reportDto.getDescription());
        DaoFactory.getFactory().getReportDao().save(report);
    }

}
