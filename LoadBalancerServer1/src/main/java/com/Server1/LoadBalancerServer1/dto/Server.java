package com.Server1.LoadBalancerServer1.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Server {
    private String id;
    private String name;
    private boolean healthy;
}
