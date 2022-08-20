package br.com.fantonio.sigepi.service.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_ticket_answer")
@Data
public class TicketAnswer {

    @Id
    @GeneratedValue(generator = "s_ticket_answer")
    private Long id;

    private String answer;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private User responsible;

}
