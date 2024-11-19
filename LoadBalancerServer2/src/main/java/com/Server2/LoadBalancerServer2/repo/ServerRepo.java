package com.Server2.LoadBalancerServer2.repo;

import com.Server2.LoadBalancerServer2.dto.Server;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServerRepo {

    private  Server sever2;

    public ServerRepo()
    {
        sever2 = new Server();
    }

    public void addServer(Server server)
    {
        sever2 = server;
    }

    public Server getServer()
    {
        return sever2;
    }

    public boolean getServerHealth()
    {
        return sever2.isHealthy();
    }

}
