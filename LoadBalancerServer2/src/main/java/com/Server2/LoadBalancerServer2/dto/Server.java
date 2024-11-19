package com.Server2.LoadBalancerServer2.dto;

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
