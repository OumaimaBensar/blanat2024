package Ensak.Blanat.Blanat.services;

import Ensak.Blanat.Blanat.entities.client;

import java.util.List;

public interface clientservice {
    client saveClient(client client);
    public List<client> listClients ();

}
