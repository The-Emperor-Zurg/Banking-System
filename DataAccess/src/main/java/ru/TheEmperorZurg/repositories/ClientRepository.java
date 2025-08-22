package ru.TheEmperorZurg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.ClientEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByPassport(Integer passport);

    List<ClientEntity> findByNameAndSurName(String name, String surName);

    @Query("SELECT c FROM ClientEntity c WHERE c.passport IS NULL OR c.address IS NULL")
    List<ClientEntity> findSuspiciousClients();

    boolean existsByPassport(Integer passport);
}
