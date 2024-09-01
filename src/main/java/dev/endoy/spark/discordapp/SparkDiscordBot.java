package dev.endoy.spark.discordapp;

import dev.endoy.spark.discordapp.commands.Command;
import dev.endoy.spark.discordapp.commands.HelloCommand;
import dev.endoy.spark.discordapp.commands.InfoCommand;
import dev.endoy.spark.discordapp.commands.RollCommand;
import dev.endoy.spark.discordapp.listeners.SlashCommandListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SparkDiscordBot {

    private final String discordToken;
    private final List<Command> commands = new ArrayList<>();
    @Getter
    private JDA jda;

    public void load() {
        this.jda = JDABuilder.createDefault(this.discordToken)
                .addEventListeners(new SlashCommandListener(this))
                .build();

        this.registerCommand(new HelloCommand());
        this.registerCommand(new RollCommand());
        this.registerCommand(new InfoCommand(this));
    }

    public Optional<Command> findCommandByName(String name) {
        return this.commands.stream()
                .filter(command -> command.getCommandNames().contains(name))
                .findFirst();
    }

    private void registerCommand(Command command) {
        this.commands.add(command);
        this.jda.upsertCommand(command.getCommandNames().get(0), command.getCommandNames().get(0))
                .addOptions(command.getCommandOptions())
                .queue();
    }
}
