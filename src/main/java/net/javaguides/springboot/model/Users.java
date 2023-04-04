package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column(name = "loanbalance")
    private int loanbalance;

    @Column(name = "usedamount")
    private int usedamount;

    @Column(name = "installments")
    private int installments;

    @Column(name = "passowrd")
    private String passowrd;

    @Column(name = "isadmin")
    private String isadmin;

    @Column(name = "email")
    private String email;

}
