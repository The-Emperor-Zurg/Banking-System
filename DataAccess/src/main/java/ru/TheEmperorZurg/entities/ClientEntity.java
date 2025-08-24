package ru.TheEmperorZurg.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;

import java.util.List;


@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "passport")
    private Integer passport;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaseAccount> accounts;

    public boolean isSuspicious() {
        return passport == null || address == null;
    }
}
