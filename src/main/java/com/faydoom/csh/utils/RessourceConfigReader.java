package com.faydoom.csh.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.io.InputStream;


public final class RessourceConfigReader {
    private RessourceConfigReader() {}

    public static JsonObject load(String path) {
        try (InputStream stream = RessourceConfigReader.class.getResourceAsStream(path)) {
            if (stream == null) {
                throw new IllegalStateException("Fichier JSON introuvable pour le path : " + path);
            }
            return JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                             .getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du JSON (classpath)", e);
        }
    }
}