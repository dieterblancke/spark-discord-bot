package dev.endoy.spark.discordapp.commands;

import dev.endoy.spark.discordapp.utils.Utils;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.List;
import java.util.Optional;

public class RollCommand implements Command {

    @Override
    public List<String> getCommandNames() {
        return List.of("roll");
    }

    @Override
    public List<OptionData> getCommandOptions() {
        return List.of(
                new OptionData(OptionType.INTEGER, "min", "The minimum number that can be rolled").setRequired(false),
                new OptionData(OptionType.INTEGER, "max", "The maximum number that can be rolled").setRequired(false)
        );
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        int min = Optional.ofNullable(event.getOption("min")).map(OptionMapping::getAsInt).orElse(1);
        int max = Optional.ofNullable(event.getOption("max")).map(OptionMapping::getAsInt).orElse(100);
        int randomNumber = Utils.randomRangeInt(min, max);

        event.getHook().editOriginal("You rolled " + randomNumber + "!").queue();
    }
}
