package br.com.fantonio.sigepi.service.domain.entity;

import br.com.fantonio.sigepi.service.domain.entity.type.TicketStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "t_ticket")
public class Ticket {

    @Id
    @GeneratedValue(generator = "s_ticket")
    private Long id;
    private String description;

    @Column(name = "creation_date")
    private LocalTime creationDate;

    @Column(name = "closed_date")
    private LocalTime closedDate;
    private String title;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private User responsible;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private User requester_id;

    @ManyToOne
    @JoinColumn(name = "last_responsible_id")
    private User last_responsible_id;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;


}
