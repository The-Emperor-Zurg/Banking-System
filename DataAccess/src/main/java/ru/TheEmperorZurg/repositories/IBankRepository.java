package ru.TheEmperorZurg.repositories;

import ru.TheEmperorZurg.entities.BankEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findByName(String name);

    boolean existsByName(String name);
}
