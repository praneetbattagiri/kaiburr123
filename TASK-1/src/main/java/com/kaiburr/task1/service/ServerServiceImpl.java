package com.kaiburr.task1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiburr.task1.model.Server;
import com.kaiburr.task1.repository.ServerRepository;



@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public List<Server> findAll() {
        return serverRepository.findAll();
    }

    @Override
    public Optional<Server> findById(String Id) {
        return serverRepository.findById(Id);
    }

    @Override
    public void createOrUpdateServer(Server server) {
        serverRepository.save(server);
    }

    @Override
    public void deleteServerById(String Id) {
        serverRepository.deleteById(Id);
    }

    @Override
    public List<Server> findByName(String nm) {
        return serverRepository.findByName(nm);
    }

    public boolean existsServerById(String idser) {
        return serverRepository.existsById(idserv);
    }

}