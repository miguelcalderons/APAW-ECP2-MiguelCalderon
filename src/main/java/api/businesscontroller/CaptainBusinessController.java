package api.businesscontroller;

import api.daos.DaoFactory;
import api.dtos.CaptainDto;
import api.entities.Captain;
import api.exceptions.NotFoundException;

public class CaptainBusinessController {

    public String create(CaptainDto captainDto) {
        Captain captain = new Captain(captainDto.getNick(), captainDto.getEmail());
        DaoFactory.getFactory().getCaptainDao().save(captain);
        return captain.getId();
    }

    public void update(String id, CaptainDto captainDto) {
        Captain captain = DaoFactory.getFactory().getCaptainDao().read(id)
                .orElseThrow(() -> new NotFoundException("Captain id: " + id));
        captain.setName(captainDto.getNick()).setEmail(captainDto.getEmail());
        DaoFactory.getFactory().getCaptainDao().save(captain);
    }

}
