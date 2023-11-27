package Ensak.Blanat.Blanat.mappers;

import Ensak.Blanat.Blanat.DTOs.clientDTO;
import Ensak.Blanat.Blanat.entities.client;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class blanatmapper {

    public clientDTO fromClient(client client) {
        clientDTO ClientDTO = new clientDTO();
        BeanUtils.copyProperties(client, ClientDTO);
        return ClientDTO;
    }

    public client fromClientDTO(clientDTO clientDTO) {
        client client = new client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }


}