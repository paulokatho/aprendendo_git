package com.dbServer.tratoFeito.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dbServer.tratoFeito.service.CadastroVotacaoService;

@Configuration
@ComponentScan(basePackageClasses = CadastroVotacaoService.class)
public class ServiceConfig {

}
