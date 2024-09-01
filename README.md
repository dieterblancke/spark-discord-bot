# Spark Discord bot

This project is a small demo from Dieter (discord name: dieter) as was requested by Spark.

## Setup
To set up this application, you will first need to make sure you have Java installed on your machine. You can find the Java JDK [here](https://www.oracle.com/java/technologies/downloads/).

After that, there are two ways to run this application:

### Using a pre-packaged jar
You can download the pre-packaged jar I compiled from [my CDN](https://storage-api.endoy.dev/static-data/spark-discord-bot.jar).

Once you have downloaded the jar, create a file called `.env` in the same directory as the jar. In this file, you will need to add the following lines:
```properties
DISCORD_TOKEN=YOUR_DISCORD_TOKEN
```
With `YOUR_DISCORD_TOKEN` being a token you can get from the Discord developer portal.



After that, you can run the jar by executing the following command in the directory where you downloaded the jar:
```bash
java -jar spark-discord-bot.jar
```

### Using the source code
You can checkout this project by running the following command:
```bash
git clone https://github.com/dieterblancke/spark-discord-bot.git
```

You'll need to have Maven installed on your machine to build the project. You can find Maven [here](https://maven.apache.org/download.cgi).

Afterwards, you can run the application by starting it's development server with the following command:
```bash
mvn exec:java
```

For this, similarly as in the step above, you will need to have a `.env` file in the folder the program runs in.
In this case, it will likely be in the `target/classes` folder (first run the command above to generate this folder, then create the file and then run the command again).

The file should look as follows:
```properties
DISCORD_TOKEN=YOUR_DISCORD_TOKEN
```
With `YOUR_DISCORD_TOKEN` being a token you can get from the Discord developer portal.


