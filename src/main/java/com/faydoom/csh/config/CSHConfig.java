package com.faydoom.csh.config;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class CSHConfig {
    public static final BuilderCodec<CSHConfig> CODEC = BuilderCodec.builder(CSHConfig.class, CSHConfig::new)
        .append(new KeyedCodec<Integer>("SomeValue", Codec.INTEGER),
                (config, value) -> config.setSomeValue(value),
                (config) -> config.getSomeValue()).add()
        .append(new KeyedCodec<String>("SomeString", Codec.STRING),
                (config, value) -> config.setSomeString(value),
                (config) -> config.getSomeString()).add()
        .build();
    private int someValue = 12;
    private String someString = "My default string";
    public CSHConfig() {
    }
    // Getters
    public int getSomeValue() {
        return someValue;
    }
    public String getSomeString() {
        return someString;
    }
    // Setters
    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }
    public void setSomeString(String someString) {
        this.someString = someString;
    }
}