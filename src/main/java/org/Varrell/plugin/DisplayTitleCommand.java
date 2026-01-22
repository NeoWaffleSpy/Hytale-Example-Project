package org.Varrell.plugin;

import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.EventTitleUtil;

import javax.annotation.Nonnull;
import java.awt.*;

/**
 * This is an example command that will simply print the name of the plugin in chat when used.
 */
public class DisplayTitleCommand extends CommandBase {
    public DisplayTitleCommand() {
        super("ShowTitleCard", "Show a titleCard to the player", false);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        Store<EntityStore> store = Universe.get().getWorld("default").getEntityStore().getStore();
        Message m1 = Message.raw("Finally Awake").bold(true).color(Color.CYAN);
        Message m2 = Message.raw("Got caught at the border").bold(true).color(Color.CYAN);
        PlayerRef pr = Universe.get().getPlayer(ctx.sender().getUuid());
        assert pr != null;
        EventTitleUtil.showEventTitleToPlayer(pr, m1, m2, true);
    }
}