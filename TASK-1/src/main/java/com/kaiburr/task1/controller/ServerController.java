package com.kaiburr.task1.controller;

import java.util.List;
import java.util.Optional;

import com.kaiburr.task1.model.Server;
import com.kaiburr.task1.service.ServerServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerServiceImpl serverServiceImpl;

    @GetMapping(value = "/getServ")
    public List<Server> getAllServers() {
        return serverServiceImpl.findAll();
    }

    @GetMapping(value = "/getServ", params = "idserv")
    public ResponseEntity<?> getServerById(@RequestParam String idserv) {
        Optional<Server> server = serverServiceImpl.findById(idserv);
        if (server.isPresent()) {
            return new ResponseEntity<Server>(server.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Cound not find Server", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getServ", params = "nm")
    public ResponseEntity<?> getServerByName(@RequestParam String nm) {
        List<Server> servers = serverServiceImpl.findByName(nm);
        if (servers.isEmpty()) {
            return new ResponseEntity<String>("Cound not find server", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Server>>(servers, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/createServ")
    public ResponseEntity<?> createOrUpdateServer(@RequestBody Server server) {
        serverServiceImpl.createOrUpdateServer(server);
        return new ResponseEntity<String>("Server has been added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteServ")
    public ResponseEntity<?> deleteServer(@RequestParam String idserv) {
        if (serverServiceImpl.existsServerById(idserv)) {
            serverServiceImpl.deleteServerById(idserv);
            return new ResponseEntity<String>("Server has been deleted", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Server does not exist", HttpStatus.OK);
    }

}