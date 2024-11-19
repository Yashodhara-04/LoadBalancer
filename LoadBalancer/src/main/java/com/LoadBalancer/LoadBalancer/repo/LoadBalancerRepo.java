package com.LoadBalancer.LoadBalancer.repo;

import com.LoadBalancer.LoadBalancer.dto.Server;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class LoadBalancerRepo {

    List<Server> serverList;

    public LoadBalancerRepo()
    {
        serverList = new ArrayList<>();
    }

    public void addServer(List<Server> servers)
    {
        serverList.addAll(servers);
    }



}
