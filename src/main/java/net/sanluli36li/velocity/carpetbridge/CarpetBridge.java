package net.sanluli36li.velocity.carpetbridge;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Path;

/**
 * @author Sanluli36li
 * @date 2021/4/1
 */
@Plugin(
    id = "carpetbridge",
    name = "CarpetBridge",
    description = "Fixed the Carpet Mod cannot communicate between the client and the server through Velocity Proxy.",
    authors = {"Sanluli36li"},
    url = "https://github.com/Sanluli36li/CarpetBridge"
)
public class CarpetBridge {
    private static final ChannelIdentifier CARPET_CHANNEL = MinecraftChannelIdentifier.create("carpet", "hello");

    private final ProxyServer proxy;
    private final Logger logger;
    private final File dataDir;

    @Inject
    public CarpetBridge(ProxyServer proxy, Logger logger, @DataDirectory Path path) {
        this.proxy = proxy;
        this.logger = logger;
        this.dataDir = path.toFile();
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxy.getChannelRegistrar().register(CARPET_CHANNEL);
    }
}
