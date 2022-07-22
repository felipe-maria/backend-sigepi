package br.com.fantonio.sigepi.service.domain.entity;

import br.com.fantonio.sigepi.service.domain.entity.type.Certifier;
import br.com.fantonio.sigepi.service.domain.entity.type.DigitalCertificateCategory;
import br.com.fantonio.sigepi.service.domain.entity.type.DigitalCertificateSegment;
import br.com.fantonio.sigepi.service.domain.entity.type.MediaType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table (name="t_digital_certificate")
public class DigitalCertificate implements Serializable {
    
    @Id
    @GeneratedValue(generator="s_digital_certificate")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DigitalCertificateCategory category;

    @Enumerated(EnumType.STRING)
    private Certifier certifier;

    @Column(name="expedition_date")
    private LocalDate expeditionDate;

    @Column(name="media_type")
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Enumerated(EnumType.STRING)
    private DigitalCertificateSegment segment;

    private Boolean expired;

    @Column(name="expiry_date")
    private LocalDate expiry_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

}
