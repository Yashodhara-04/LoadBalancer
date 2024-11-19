package com.LoadBalancer.LoadBalancer.strategy;

import com.LoadBalancer.LoadBalancer.dto.Server;
import com.LoadBalancer.LoadBalancer.service.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements LoadBalancerStrategy{

    private Random random = new Random();
    @Autowired
    private LoadBalancerService loadBalancerService;

    @Override
    public Server getNextServer(List<Server> serverList) {
        try
        {
            if(serverList.isEmpty())
            {
                throw new RuntimeException("Servers are not available");
            }
            loadBalancerService = new LoadBalancerService(serverList);
            Server server = serverList.get(random.nextInt(serverList.size()));
            return loadBalancerService.callServer(server);
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Server Not Available!!");
        }
    }
}
