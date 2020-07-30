/*
 * Zyonic Software - 2020 - Tobias Rempe
 * This File, its contents and by extention the corresponding project may be used freely in Compliance with the attached License.
 *
 * info@zyonicsoftware.com
 */

package de.azraanimating.maddoxengine.main;

import de.azraanimating.maddoxengine.handling.command.CommandHandler;
import de.azraanimating.maddoxengine.handling.listener.GuildMessageReceivedListener;
import de.azraanimating.maddoxengine.handling.listener.GuildMessageUpdateListener;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.ShardManager;

public class MaddoxEngine {

    private final DefaultShardManager shardManager;
    private final CommandHandler commandHandler;
    private String prefix = "!";

    public MaddoxEngine(DefaultShardManager shardManager) {
        this.shardManager = shardManager;

        this.commandHandler = new CommandHandler();

        this.registerEvents(shardManager);
    }

    public CommandHandler getCommandHandler() {
        return this.commandHandler;
    }

    public DefaultShardManager getShardManager() {
        return shardManager;
    }

    private void registerEvents(ShardManager shardManager) {
        shardManager.addEventListener(
                new GuildMessageReceivedListener(this),
                new GuildMessageUpdateListener(this)
        );
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
