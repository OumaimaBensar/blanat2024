package Ensak.Blanat.Blanat.web;


        import Ensak.Blanat.Blanat.DTOs.clientDTO;
        import Ensak.Blanat.Blanat.entities.client;
        import Ensak.Blanat.Blanat.services.clientservice;
        import Ensak.Blanat.Blanat.mappers.blanatmapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class clientController {

    private final clientservice clientService;
    private final blanatmapper mapper;

    @Autowired
    public clientController(clientservice clientService, blanatmapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<clientDTO> createClient(@RequestBody clientDTO clientDTO) {
        client client = mapper.fromClientDTO(clientDTO);
        client createdClient = clientService.saveClient(client);
        clientDTO createdClientDTO = mapper.fromClient(createdClient);
        return new ResponseEntity<>(createdClientDTO, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<clientDTO>> listClients() {
        List<client> clients = clientService.listClients();
        List<clientDTO> clientDTOs = clients.stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
        return new ResponseEntity<>(clientDTOs, HttpStatus.OK);
    }
}
