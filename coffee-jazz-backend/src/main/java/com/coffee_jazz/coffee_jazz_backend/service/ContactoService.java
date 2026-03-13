package com.coffee_jazz.coffee_jazz_backend.service;

import com.coffee_jazz.coffee_jazz_backend.model.Contacto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ContactoService {

    private static final String COLLECTION_NAME = "Contacto";

    public String saveContacto(Contacto contacto) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();


       ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(contacto.getNombre()).set(contacto);

       return collectionApiFuture.get().getUpdateTime().toString();
    }
}
