package com.csh.plugin;

import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

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

    public CSHPlugin(@Nonnull JavaPluginInit init) {
        super(init);
        LOGGER.at(Level.INFO).log("Hello from " + this.getName() + " version " + this.getManifest().getVersion().toString());
    }

    @Override
    protected void setup() {
        super.setup();
        this.getCommandRegistry().registerCommand(new CSHCommand("hello", "An example command", false));
        LOGGER.at(Level.INFO).log("Setting up plugin " + this.getName());
    }

    @Override
    protected void start() {
        super.start();
        LOGGER.at(Level.INFO).log("Plugin has started!");
    }
 
    @Override
    protected void shutdown() {
        super.shutdown();
        LOGGER.at(Level.INFO).log("Plugin has stopped!");
    }

}


