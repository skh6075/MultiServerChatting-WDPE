package org.skh6075.multiserverchat;

import dev.waterdog.waterdogpe.event.EventPriority;
import dev.waterdog.waterdogpe.event.defaults.PlayerChatEvent;
import dev.waterdog.waterdogpe.logger.Color;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class Loader extends Plugin{
    @Override
    public void onEnable() {
        this.getProxy().getEventManager().subscribe(PlayerChatEvent.class, this::onPlayerChatEvent, EventPriority.HIGHEST);
    }

    public void onPlayerChatEvent(PlayerChatEvent event){
        event.setCancelled(true);

        getProxy().getPlayers().forEach((uuid, proxiedPlayer) -> {
            proxiedPlayer.sendMessage(Color.GRAY + "[" + Color.WHITE + proxiedPlayer.getName() + Color.GRAY + "] | " + event.getMessage());
        });
    }
}
