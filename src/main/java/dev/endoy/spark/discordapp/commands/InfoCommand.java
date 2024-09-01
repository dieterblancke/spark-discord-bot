package dev.endoy.spark.discordapp.commands;

import dev.endoy.spark.discordapp.SparkDiscordBot;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
public class InfoCommand implements Command {

    private final SparkDiscordBot sparkDiscordBot;

    @Override
    public List<String> getCommandNames() {
        return List.of("info");
    }

    @Override
    public List<OptionData> getCommandOptions() {
        return List.of();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        try {
            event.getHook().editOriginalEmbeds(
                    new EmbedBuilder()
                            .setTitle("Server and bot info")
                            .addField("Bot name", event.getJDA().getSelfUser().getName(), false)
                            .addField("Guild name", event.getGuild().getName(), false)
                            .addField("Guild ID", event.getGuild().getId(), false)
                            .addField("Guild Owner", event.getGuild().getOwner().getUser().getAsTag(), false)
                            .addField("Members", String.valueOf(event.getGuild().getMemberCount()), false)
                            .addField("Gateway ping", sparkDiscordBot.getJda().getGatewayPing() + " ms", false)
                            .addField("Rest ping", sparkDiscordBot.getJda().getRestPing().complete() + " ms", false)
                            .setColor(0x8000ff)
                            .setFooter("Requested by " + event.getUser().getAsTag(), event.getUser().getAvatarUrl())
                            .setTimestamp(Instant.now())
                            .build()
            ).queue();
        } catch (Exception e) {
            event.getHook().editOriginal("An error occurred while fetching the server info, please try again later.").queue();
            e.printStackTrace();
        }
    }
}
