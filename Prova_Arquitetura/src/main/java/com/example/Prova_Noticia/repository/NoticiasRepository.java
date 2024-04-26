package com.example.Prova_Noticia.repository;

import com.example.Prova_Noticia.model.NoticiaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends MongoRepository<NoticiaEntity, String> {
}