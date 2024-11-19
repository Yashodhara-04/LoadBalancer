package com.Server1.LoadBalancerServer1.repo;

import com.Server1.LoadBalancerServer1.dto.Server;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServerRepo {

    private  Server sever1;

    public ServerRepo()
    {
        sever1 = new Server();
    }

    public void addServer(Server server)
    {
        sever1 = server;
    }

    public Server getServer()
    {
        return sever1;
    }

    public boolean getServerHealth()
    {
        return sever1.isHealthy();
    }

}
