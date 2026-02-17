package com.faydoom.csh;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;

import com.faydoom.csh.config.CSHConfig;

import javax.annotation.Nonnull;
import java.util.logging.Level;

/**
 * Main CSH plugin class.
 *
 * TODO: Implement your plugin logic here.
 *
 * @author AntoineTrev
 * @version 1.0.0
 */
public class CSHPlugin extends JavaPlugin {
    private static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();
    private final Config<CSHConfig> config = this.withConfig("config", CSHConfig.CODEC);

    public CSHPlugin(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.at(Level.INFO).log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        super.setup();
        this.getCommandRegistry().registerCommand(new CSHCommand("hello", "An example command", false));
        LOGGER.at(Level.INFO).log("Setting up plugin " + this.getName());
        config.save();
    }

    @Override
    protected void start() {
        super.start();
        CSHConfig cshconfig = this.config.get();
        LOGGER.at(Level.INFO).log("Plugin has started!" + cshconfig.getSomeString());
        cshconfig.setSomeValue(999);
        this.config.save();
    }
 
    @Override
    protected void shutdown() {
        super.shutdown();
        LOGGER.at(Level.INFO).log("Plugin has stopped!");
    }

}


