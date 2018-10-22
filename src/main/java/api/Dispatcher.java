package api;

import api.apiControllers.ReportApiController;
import api.apiControllers.FlightApiController;
import api.apiControllers.CaptainApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.CaptainDto;
import api.dtos.ReportDto;
import api.dtos.FlightCreationDto;
import api.exceptions.ArgumentNotValidException;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private CaptainApiController captainApiController = new CaptainApiController();

    private ReportApiController reportApiController = new ReportApiController();

    private FlightApiController flightApiController = new FlightApiController();

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(CaptainApiController.CAPTAINS)) {
            response.setBody(this.captainApiController.create((CaptainDto) request.getBody()));
        } else if (request.isEqualsPath(ReportApiController.REPORT)) {
            this.reportApiController.create((ReportDto) request.getBody());
        } else if (request.isEqualsPath(FlightApiController.FLIGHTS)) {
            response.setBody(this.flightApiController.create((FlightCreationDto) request.getBody()));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(CaptainApiController.CAPTAINS + CaptainApiController.ID_ID)) {
            this.captainApiController.update(request.getPath(1), (CaptainDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
}
