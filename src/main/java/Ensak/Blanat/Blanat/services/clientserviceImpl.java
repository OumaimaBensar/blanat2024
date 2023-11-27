package Ensak.Blanat.Blanat.services;

import Ensak.Blanat.Blanat.entities.client;
import Ensak.Blanat.Blanat.repositories.clientrepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class clientserviceImpl implements clientservice {

    private final clientrepository clientRepo;

    @Autowired
    public clientserviceImpl(clientrepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public client saveClient(client client) {
        client createdClient = clientRepo.save(client); // Fix here
        log.info("Client Created");
        return createdClient;
    }

    public List<client> listClients (){
        return clientRepo.findAll();
    }
}
