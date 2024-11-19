package com.LoadBalancer.LoadBalancer.strategy;

import com.LoadBalancer.LoadBalancer.dto.Server;
import com.LoadBalancer.LoadBalancer.service.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancerStrategy {
    private int index = 0;
    @Autowired
    private LoadBalancerService loadBalancerService;

    @Override
    public Server getNextServer(List<Server> serverList) {
        try
        {
            if(serverList.isEmpty())
            {
                throw  new RuntimeException("Server not available");
            }
            loadBalancerService = new LoadBalancerService(serverList);
            synchronized (this)
            {
                Server selectedServer = serverList.get(index);
                index = (index+1)%serverList.size();
                return loadBalancerService.callServer(selectedServer);
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Server not available!!");
        }
    }
}
