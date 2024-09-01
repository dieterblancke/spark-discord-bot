package dev.endoy.spark.discordapp;

import io.github.cdimascio.dotenv.Dotenv;

public class Bootstrap {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String discordToken = dotenv.get("DISCORD_TOKEN");

        new SparkDiscordBot(discordToken).load();
    }
}
