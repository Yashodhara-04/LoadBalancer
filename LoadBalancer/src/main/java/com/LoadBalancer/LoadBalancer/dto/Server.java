package com.LoadBalancer.LoadBalancer.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Server {
    private int id;
    private String name;
    private boolean healthy;
    private int port;
    private String address;
}
