package com.Server1.LoadBalancerServer1.controller;

import com.Server1.LoadBalancerServer1.dto.Server;
import com.Server1.LoadBalancerServer1.service.ServerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ping/server1")
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class server1controller {

    @Autowired
    private ServerService serverService;

    @PostMapping("/add")
    public ResponseEntity<?> addServer(@RequestBody Server server)
    {
        try
        {
            serverService.addServer(server);
            log.info("Server Added" + server.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex)
        {
            log.info("Error occured " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Server> getServer()
    {
        try
        {
            return new ResponseEntity<>(serverService.getServer(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            log.info("Error occured ", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getHealth")
    public ResponseEntity<Boolean> getHealthServer(@RequestBody Server server)
    {
        try
        {
            return new ResponseEntity<>(serverService.getHealth(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            log.info("Error occured " , ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
