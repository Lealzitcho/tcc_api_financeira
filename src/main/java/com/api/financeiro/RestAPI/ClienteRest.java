package com.api.financeiro.RestAPI;

import com.api.financeiro.cliente.ClienteSaldo;
import com.api.financeiro.repository.ClienteRepository;
import com.api.financeiro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteRest {

    @Autowired private ClienteRepository clienteRepository;


    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ClienteSaldo>> listar() {

        List<ClienteSaldo> user = clienteRepository.findAll();

        return new ResponseEntity<List<ClienteSaldo>>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/entrada", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ClienteSaldo> entrada(@RequestBody ClienteSaldo cliente){

        ClienteSaldo entrada = ClienteService.salvarEntrada(cliente);
        ClienteSaldo user = clienteRepository.save(entrada);

        return new ResponseEntity<ClienteSaldo>(user, HttpStatus.CREATED);

    }

}
