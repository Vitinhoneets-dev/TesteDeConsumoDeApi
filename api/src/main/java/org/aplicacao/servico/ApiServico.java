package org.aplicacao.servico;

import org.aplicacao.dto.EnderecoDto;
import tools.jackson.databind.ObjectMapper;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServico {

    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEnderecoDto(String cep) throws IOException, InterruptedException{
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/"+cep+"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);

//          imprime o que a api entrega de forma crua
//              System.out.println(response.statusCode());
//              System.out.println(response.body());

        } catch (IOException e){

            System.out.println(e.getMessage());

        }

       return enderecoDto;
    }
}
