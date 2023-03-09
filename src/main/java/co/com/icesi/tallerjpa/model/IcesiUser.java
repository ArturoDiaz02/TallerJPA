package co.com.icesi.tallerjpa.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class IcesiUser {
    @Id
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_role_id")
    private Role role;

}