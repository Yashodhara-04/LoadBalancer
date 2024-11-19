package com.LoadBalancer.LoadBalancer.service;

import com.LoadBalancer.LoadBalancer.dto.Server;
import com.LoadBalancer.LoadBalancer.strategy.LoadBalancerStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LoadBalancerService {

    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();
    private List<Server> servers = new ArrayList<>();
    private LoadBalancerStrategy strategy;

    public LoadBalancerService(List<Server> serverList)
    {
        this.servers = serverList;
    }

    public void addServer() throws Exception
    {
        try {
            for(Server server : servers)
            {
                String url = "http://localhost:" + server.getPort() + server.getAddress() + "/add";
                restTemplate.postForObject(url, server, Server.class);
            }
        }
        catch (Exception ex)
        {
            log.error("Error occured "+  ex);
            throw new Exception(ex);
        }
    }

    public Server callServer(Server server) throws Exception
    {
        try {
            String url = "http://localhost:" + server.getPort() + server.getAddress() + "/get";
            Server currServer = restTemplate.getForObject(url, Server.class);
            return currServer;
        }
        catch (Exception ex)
        {
            log.error("Error occured "+  ex);
            throw new Exception(ex);
        }
    }

    public void checkHealth()
    {
        servers.removeIf(server ->
        {
            if(!server.isHealthy())
            {
                System.out.println("Removing "+ server.getName() + " as it is not healthy!!");
                return true;
            }
            return false;
        });
    }

    public void routeRequestToLB(LoadBalancerStrategy strategy)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Server nextServer = strategy.getNextServer(servers);
        System.out.println("Request is sent to " + nextServer.getName() + "\n");
    }

}
