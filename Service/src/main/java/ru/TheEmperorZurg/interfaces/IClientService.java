package ru.TheEmperorZurg.interfaces;

import ru.TheEmperorZurg.entities.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    ClientEntity createClient(String name, String surname);

    Optional<ClientEntity> findById(Long clientId);

    List<ClientEntity> findByNameAndSurname(String name, String surname);

    IClientService updateClientPassport(Long clientId, Integer passport);

    IClientService updateClientAddress(Long clientId, String address);

    boolean isSuspicious(Long clientId);

    IClientService deleteClient(Long clientId);
}
