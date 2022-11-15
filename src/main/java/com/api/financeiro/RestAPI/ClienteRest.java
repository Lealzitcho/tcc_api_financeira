package com.api.financeiro.RestAPI;

import com.api.financeiro.cliente.ClienteFinanceiro;
import com.api.financeiro.cliente.ClienteRelatorio;
import com.api.financeiro.cliente.ClienteSaldo;
import com.api.financeiro.cliente.RestData;
import com.api.financeiro.repository.ClienteCustomRepository;
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
    @Autowired private ClienteCustomRepository clienteCustomRepository;


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
    public @ResponseBody ResponseEntity<List<ClienteSaldo>> filter(@RequestBody RestData cliente) {

        Date inicio = cliente.getInicio();
        Date fim = cliente.getFim();

        List<ClienteSaldo> listar = clienteRepository.findByDataRecebimentoBetween(inicio, fim);

        return new ResponseEntity<List<ClienteSaldo>>(listar, HttpStatus.OK);
    }

    @RequestMapping(value="/financeiro", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ClienteFinanceiro> financeiro(@RequestBody RestData cliente) {

        Date inicio = cliente.getInicio();
        Date fim = cliente.getFim();

        List<ClienteSaldo> listar = clienteRepository.findByDataRecebimentoBetween(inicio, fim);
        ClienteFinanceiro relatorio = ClienteService.financeiro(listar);


        return new ResponseEntity<ClienteFinanceiro>(relatorio, HttpStatus.OK);
    }

    @RequestMapping(value="/relatorio", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ClienteRelatorio> relatorio(@RequestBody RestData data) {

        Date inicio = data.getInicio();
        Date fim = data.getFim();

        List<ClienteSaldo> listar = clienteRepository.findByDataRecebimentoBetween(inicio, fim);
        List<String> categoria = clienteCustomRepository.find(inicio, fim);
        String tipoCategoria = categoria.get(0);
        ClienteRelatorio relatorio = ClienteService.relatorio(listar, tipoCategoria);


        return new ResponseEntity<ClienteRelatorio>(relatorio, HttpStatus.OK);
    }
}
