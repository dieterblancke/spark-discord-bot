package dev.endoy.spark.discordapp.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;

public class HelloCommand implements Command {

    @Override
    public List<String> getCommandNames() {
        return List.of("hello");
    }

    @Override
    public List<OptionData> getCommandOptions() {
        return List.of();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (event.getMember() == null) {
            event.getHook().editOriginal("Hello, stranger!").queue();
            return;
        }

        event.getHook().editOriginal("Hello, <@%s>!".formatted(event.getMember().getId())).queue();
    }
}
