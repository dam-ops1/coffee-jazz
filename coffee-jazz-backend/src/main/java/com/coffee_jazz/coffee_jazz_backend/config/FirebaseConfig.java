package com.coffee_jazz.coffee_jazz_backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @Value("${FIREBASE_JSON:}")
    private String firebaseConfig;

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        InputStream serviceAccount;

        String fbConfig = System.getenv("FIREBASE_JSON");

        if (fbConfig != null && !fbConfig.isEmpty()) {
            serviceAccount = new ByteArrayInputStream(fbConfig.getBytes(StandardCharsets.UTF_8));
        } else {
            ClassPathResource resource = new ClassPathResource("serviceAccountKey.json");

            if (!resource.exists()) {
                throw new FileNotFoundException("ERROR");
            }
            serviceAccount = resource.getInputStream();
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance();
        }
    }
}
