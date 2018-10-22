package api.apicontrollers;

import api.businesscontroller.ReportBusinessController;
import api.dtos.ReportDto;
import api.exceptions.ArgumentNotValidException;

public class ReportApiController {

    public static final String REPORT = "/reports";

    private ReportBusinessController reportBusinessController = new ReportBusinessController();

    public void create(ReportDto reportDto) {
        this.validate(reportDto, "reportDto");
        this.validate(reportDto.getSafeLanding(), "ReportDto safeLanding");
        this.validate(reportDto.getDescription(), "ReportDto description");
        this.reportBusinessController.create(reportDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }

}
