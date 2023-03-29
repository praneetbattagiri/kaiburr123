package com.kaiburr.task1.service;

import java.util.Optional;
import java.util.List;


import com.kaiburr.task1.model.Server;

public interface ServerService {

    List<Server> findAll();

    Optional<Server> findById(String Id);

    void createOrUpdateServer(Server server);

    void deleteServerById(String Id);

    List<Server> findByName(String nm);
}
