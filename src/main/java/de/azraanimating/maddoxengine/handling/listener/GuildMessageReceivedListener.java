/*
 * Zyonic Software - 2020 - Tobias Rempe
 * This File, its contents and by extention the corresponding project may be used freely in Compliance with the attached License.
 *
 * info@zyonicsoftware.com
 */

package de.azraanimating.maddoxengine.handling.listener;

import de.azraanimating.maddoxengine.main.MaddoxEngine;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildMessageReceivedListener extends ListenerAdapter {

    private final MaddoxEngine maddoxEngine;

    public GuildMessageReceivedListener(MaddoxEngine maddoxEngine) {
        this.maddoxEngine = maddoxEngine;
    }

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        this.maddoxEngine.getCommandHandler().handle(event, event.getMessage().getContentRaw(), this.maddoxEngine.getPrefix());
    }

}
