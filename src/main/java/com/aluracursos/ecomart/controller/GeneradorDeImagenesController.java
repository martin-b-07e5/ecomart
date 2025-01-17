package com.aluracursos.ecomart.controller;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// https://docs.spring.io/spring-ai/reference/api/imageclient.html
// https://docs.spring.io/spring-ai/reference/api/image/openai-image.html
// https://docs.spring.io/spring-ai/reference/api/image/openai-image.html#image-options


@RestController
@RequestMapping("/imagen")
public class GeneradorDeImagenesController {

  private final ImageModel imageModel;

  public GeneradorDeImagenesController(ImageModel imageModel) {
    this.imageModel = imageModel;
  }


// http://localhost:8080/imagen?prompt=cepillo
  @GetMapping
  public String generadorImagenes(String prompt) {
    // Implementación de la lógica para la generación de imágenes
    var options = ImageOptionsBuilder
        .builder()
        .withWidth(1024)
        .withHeight(1024)
        .build();
    var response = imageModel.call(new ImagePrompt(prompt, options));
    // Devolver la URL de la imagen generada
    return response.getResult().getOutput().getUrl();
  }

}
