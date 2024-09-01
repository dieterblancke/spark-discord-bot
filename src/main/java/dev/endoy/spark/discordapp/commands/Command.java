package dev.endoy.spark.discordapp.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public interface Command {

    List<String> getCommandNames();

    List<OptionData> getCommandOptions();

    void execute(SlashCommandInteractionEvent event);

}
