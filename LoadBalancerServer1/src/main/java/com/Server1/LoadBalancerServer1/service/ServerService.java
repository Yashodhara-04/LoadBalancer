package com.Server1.LoadBalancerServer1.service;

import com.Server1.LoadBalancerServer1.dto.Server;
import com.Server1.LoadBalancerServer1.repo.ServerRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class ServerService {

    private Server server = new Server();
    private ServerRepo serverRepo = new ServerRepo();

    public void addServer(Server server)
    {
        Server.builder()
                .id(server.getId())
                .name(server.getName())
                .healthy(server.isHealthy())
                .build();
        serverRepo.addServer(server);
    }

    public boolean getHealth()
    {
        return serverRepo.getServerHealth();
    }

    public Server getServer()
    {
        log.info("server ", server);
        return serverRepo.getServer();
    }
}
