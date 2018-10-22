package api.apicontrollers;

import api.businesscontroller.CaptainBusinessController;
import api.dtos.CaptainDto;
import api.exceptions.ArgumentNotValidException;

public class CaptainApiController {

    public static final String CAPTAINS = "/captains";

    public static final String ID_ID = "/{id}";

    private CaptainBusinessController captainBusinessController = new CaptainBusinessController();

    public String create(CaptainDto captainDto) {
        this.validate(captainDto, "captainDto");
        this.validate(captainDto.getNick(), "CaptainDto Nick");
        return this.captainBusinessController.create(captainDto);
    }

    public void update(String id, CaptainDto captainDto) {
        this.validate(captainDto, "captainDto");
        this.validate(captainDto.getNick(), "CaptainDto Nick");
        this.captainBusinessController.update(id, captainDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + " is missing");
        }
    }
}
