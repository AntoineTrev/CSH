package com.faydoom.csh.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.google.gson.JsonObject;

public class CSHConfig {

    public static final BuilderCodec<CSHConfig> CODEC =
        BuilderCodec.builder(CSHConfig.class, CSHConfig::new)
            .append(new KeyedCodec<>("Test1", Codec.STRING),
                    (config, value) -> config.setTest1(value),
                    config -> config.getTest1()).add()
            .append(new KeyedCodec<>("Test2", Codec.INTEGER),
                    (config, value) -> config.setTest2(value),
                    config -> config.getTest2()).add()
            .append(new KeyedCodec<>("Test3", Codec.BOOLEAN),
                    (config, value) -> config.setTest3(value),
                    config -> config.getTest3()).add()
            .build();

    private String test1 = null;
    private Integer test2 = null;
    private Boolean test3 = null;

    public CSHConfig() {
    }

    public void fillWithJson(JsonObject json) {
        if (json.has("test1")) {
            String val = json.get("test1").isJsonNull() ? null : json.get("test1").getAsString();
            if (this.test1 == null || this.test1.isEmpty()) this.test1 = val;
        }

        if (json.has("test2")) {
            Integer val = null;
            try {
                val = json.get("test2").isJsonNull() ? null : json.get("test2").getAsInt();
            } catch (NumberFormatException ignored) { }
            if (this.test2 == null) this.test2 = val;
        }

        if (json.has("test3")) {
            Boolean val = json.get("test3").isJsonNull() ? null : json.get("test3").getAsBoolean();
            if (this.test3 == null) this.test3 = val;
        }
    }

    // =========================
    // Getters
    // =========================
    public String getTest1() {
        return test1;
    }

    public int getTest2() {
        return test2 != null ? test2 : 0;
    }

    public boolean getTest3() {
        return test3 != null ? test3 : false;
    }

    // =========================
    // Setters
    // =========================
    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public void setTest3(boolean test3) {
        this.test3 = test3;
    }
}
