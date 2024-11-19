package com.LoadBalancer.LoadBalancer.Client;

import com.LoadBalancer.LoadBalancer.dto.Server;
import com.LoadBalancer.LoadBalancer.service.LoadBalancerService;
import com.LoadBalancer.LoadBalancer.strategy.LoadBalancerStrategy;
import com.LoadBalancer.LoadBalancer.strategy.RandomStrategy;
import com.LoadBalancer.LoadBalancer.strategy.RoundRobinStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Client {

    LoadBalancerService loadBalancerService = null;


    public void runApplication()
    {
        addServer();
        routeRequest(new RoundRobinStrategy());
        routeRequest(new RandomStrategy());
    }

    public void addServer()
    {
        try {
            Server server1 = new Server(1, "SERVER1", true, 8081, "/ping/server1");
            Server server2 = new Server(2, "SERVER2", true, 8082, "/ping/server2");
            List<Server> serverList = Arrays.asList(server1, server2);
            loadBalancerService = new LoadBalancerService(serverList);
            loadBalancerService.checkHealth();
            loadBalancerService.addServer(serverList);
        }
        catch (Exception ex)
        {
            log.error("Error Occured  " + ex);
        }
    }

    public void routeRequest(LoadBalancerStrategy strategy)
    {
        try {
            System.out.println("Using strategy " + strategy.getClass().getName().substring(39) + "\n\n");
            for(int request = 1; request < 100; request++)
            {
                loadBalancerService.routeRequestToLB(strategy);
            }
        }
        catch (Exception ex)
        {
            log.error("Error Occured  " + ex);
        }
    }



}
