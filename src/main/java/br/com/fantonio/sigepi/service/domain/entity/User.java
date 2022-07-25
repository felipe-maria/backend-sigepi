package br.com.fantonio.sigepi.service.domain.entity;

import br.com.fantonio.sigepi.service.domain.entity.type.IssuerFederateUnit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(generator = "s_user")
    private Long id;
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "cpf_number")
    private String cpfNumber;

    @Column(name = "rg_number")
    private String rgNumber;

    @Column(name = "rg_issuer_code")
    private String rgIssuerCode;

    @Column(name = "rg_issuer_fed_unit")
    @Enumerated(EnumType.STRING)
    private IssuerFederateUnit rgIssuerIssuerFederateUnit;

    @Column(name= "birth_date")
    private LocalDate birthDate;

    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    private String comments;
    private String login;

    private String password;

    @Column(name = "user_type")
    private String userType;

    private Boolean active;

}
