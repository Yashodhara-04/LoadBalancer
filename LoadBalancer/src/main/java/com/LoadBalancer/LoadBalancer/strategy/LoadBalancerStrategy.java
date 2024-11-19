package com.LoadBalancer.LoadBalancer.strategy;

import com.LoadBalancer.LoadBalancer.dto.Server;

import java.util.List;

public interface LoadBalancerStrategy {

    Server getNextServer(List<Server> serverList);
}
