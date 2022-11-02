package com.api.financeiro.RestAPI;

import com.api.financeiro.cliente.ClienteSaldo;
import com.api.financeiro.repository.ClienteRepository;
import com.api.financeiro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteRest {

    @Autowired private ClienteRepository clienteRepository;


    @RequestMapping(value="/listar", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ClienteSaldo>> listar() {

        List<ClienteSaldo> listar = clienteRepository.findAll();

        return new ResponseEntity<List<ClienteSaldo>>(listar, HttpStatus.OK);
    }

    @RequestMapping(value="/entrada", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ClienteSaldo> entrada(@RequestBody ClienteSaldo cliente){

        ClienteSaldo entrada = ClienteService.salvarEntrada(cliente);
        ClienteSaldo save = clienteRepository.save(entrada);

        return new ResponseEntity<ClienteSaldo>(save, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<String> deletar(@RequestBody ClienteSaldo cliente){

        Long id = cliente.getId();
        clienteRepository.deleteById(id);

        return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value="/atualizar", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> atualizar(@RequestBody ClienteSaldo cliente){

        if(cliente.getId() == null){
            return new ResponseEntity<String>("Favor informar ID para Atualizar", HttpStatus.OK);
        }

        ClienteSaldo atualizar = clienteRepository.saveAndFlush(cliente);

        return new ResponseEntity<ClienteSaldo>(atualizar, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ClienteSaldo>> filter(@RequestBody ClienteSaldo cliente) {

        Date inicio = cliente.getDataRecebimento();
        Date fim = cliente.getDataCadastro();

        List<ClienteSaldo> listar = clienteRepository.findByDataRecebimentoBetween(inicio, fim);

        return new ResponseEntity<List<ClienteSaldo>>(listar, HttpStatus.OK);
    }
}
