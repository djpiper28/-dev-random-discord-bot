/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.random.discord.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class App {
    public static void main(String[] args) throws LoginException, InterruptedException {
        //Start
        JDABuilder builder = JDABuilder.createDefault(args[0]);

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(true);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.playing("rm -rf /"));

        JDA jda = builder.build();
        jda.setAutoReconnect(true);
        jda.awaitReady();

        jda.addEventListener(new ListenerAdapter() {
            @Override
            public void onMessageReceived(MessageReceivedEvent event) {
                if (!event.getAuthor().isBot()) {
                    String msg = event.getMessage().getContentRaw();
                }
            }
        });
    }

}
