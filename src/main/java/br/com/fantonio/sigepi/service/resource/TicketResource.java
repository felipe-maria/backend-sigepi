package br.com.fantonio.sigepi.service.resource;

import br.com.fantonio.sigepi.service.api.TicketsApi;
import br.com.fantonio.sigepi.service.api.model.TicketTO;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class TicketResource implements TicketsApi {

    @Override
    public Response listAllTickets() {
        List<TicketTO> tos = new ArrayList<>();
        TicketTO to = new TicketTO();
        to.setId(1L);
        tos.add(to);
        to = new TicketTO();
        to.setId(2L);
        tos.add(to);

        return Response.ok().entity(tos).build();
    }

}
