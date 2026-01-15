package org.example.plugin;

import com.hypixel.hytale.protocol.FormattedMessage;
import com.hypixel.hytale.protocol.GameMode;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.NameMatching;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.util.EventTitleUtil;

import javax.annotation.Nonnull;
import java.awt.*;

import static com.hypixel.hytale.builtin.hytalegenerator.LoggerUtil.getLogger;

/**
 * This is an example command that will simply print the name of the plugin in chat when used.
 */
public class DisplayTitleCommand extends CommandBase {
    public DisplayTitleCommand() {
        super("ShowTitleCard", "Show a titleCard to the player", false);
    }

    @Override
    protected void executeSync(@Nonnull CommandContext ctx) {
        Message m1 = Message.raw("Finally Awake").bold(true).color(Color.CYAN);
        Message m2 = Message.raw("Got caught at the border").bold(true).color(Color.CYAN);
        PlayerRef pr = Universe.get().getPlayer(ctx.senderAs(Player.class).getDisplayName(), NameMatching.EXACT);
        assert pr != null;
        EventTitleUtil.showEventTitleToPlayer(pr, m1, m2, true);
    }
}