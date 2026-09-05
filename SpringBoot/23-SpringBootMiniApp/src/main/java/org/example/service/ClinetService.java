package org.example.service;

import org.example.entity.Client;

public interface ClinetService {
    public void saveClientDetails(Client client);
    public Client findByEmail(String email);
}
