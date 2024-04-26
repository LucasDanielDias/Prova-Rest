package com.example.Prova_Noticia.service;
import com.example.Prova_Noticia.model.NoticiaEntity;
import com.example.Prova_Noticia.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Service
public class NoticiasService {

    @Autowired
    private NoticiasRepository noticiasRepository;

    public String buscarNoticia() {
        String dadosNoticiarios = "";
      
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";
        

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosNoticiarios = responseEntity.getBody();
        } else {
            dadosNoticiarios = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        inserirDados(dadosNoticiarios);
        return dadosNoticiarios;
    }

    public void inserirDados(String dadosMeteorologicos) {
        try {
            JSONArray jsonArray = new JSONArray(dadosMeteorologicos);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                String titulo = jsonObj.getString("titulo");
                String introducao = jsonObj.getString("introducao");
                String data_publicacao = jsonObj.getString("data_publicacao");
                String  editoras = jsonObj.getString("editoras");

                NoticiaEntity noticia = new NoticiaEntity();

                noticia.setTitulo(titulo);
                noticia.setIntroducao(introducao);
                noticia.setData_publicacao(data_publicacao);
                noticia.setEditoras(editoras);

                noticiasRepository.save(noticia);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}