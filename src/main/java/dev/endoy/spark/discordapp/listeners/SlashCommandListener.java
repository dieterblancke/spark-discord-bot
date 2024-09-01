package dev.endoy.spark.discordapp.listeners;

import dev.endoy.spark.discordapp.SparkDiscordBot;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class SlashCommandListener extends ListenerAdapter {

    private final SparkDiscordBot sparkDiscordBot;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        event.deferReply().queue();

        sparkDiscordBot.findCommandByName(event.getName()).ifPresent(command -> {
            command.execute(event);
        });
    }
}
