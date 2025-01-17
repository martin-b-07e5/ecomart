package com.aluracursos.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// https://docs.spring.io/spring-ai/reference/api/chatclient.html#_using_an_autoconfigured_chatclient_builder

@RestController
@RequestMapping("/generador")
public class GeneradorDeProductosController {

  private final ChatClient chatClient;

public GeneradorDeProductosController(ChatClient.Builder chatClientBuilder) {
  this.chatClient = chatClientBuilder
      .defaultOptions(ChatOptionsBuilder
          .builder()
          .withModel("gpt-4o-mini")
          .build())
      .build();
}

  @GetMapping
  String generadorProductos(String userInput) {
    var pregunta = "Genera 5 productos ecológicos";
    return this.chatClient.prompt()
        .user(pregunta)
        .options(ChatOptionsBuilder
            .builder()
            .withModel("gpt-4o-mini")
            .withTemperature(0.82)
            .build()
        )
        .call()
        .content();
  }

}
