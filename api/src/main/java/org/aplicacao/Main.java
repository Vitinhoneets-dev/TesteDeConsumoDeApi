package org.aplicacao;
//import jdk.swing.interop.SwingInterOpUtils;
import org.aplicacao.dto.EnderecoDto;
import org.aplicacao.servico.ApiServico;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.http.HttpClient;


import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.json.JsonMapper;

public class Main {
    public static void main(String[] args) {

        ApiServico apiServico = new ApiServico();

        try {

            EnderecoDto enderecoDto = apiServico.getEnderecoDto("31070140");

            System.out.println(enderecoDto.getLogradouro());
//            System.out.println(apiServico.getEnderecoDto("35738000"));

        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);

        } catch (InterruptedException e) {
            throw  new RuntimeException(e);

        }



    }
}