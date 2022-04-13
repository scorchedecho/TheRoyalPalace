/*
 *  Copyright 2021 scorchedE.C.H.O
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.ajstri.core;

import com.github.ajstri.configuration.*;
import com.github.ajstri.core.commands.Command;
import com.github.ajstri.core.commands.admin.*;
import com.github.ajstri.core.commands.generic.*;
import com.github.ajstri.core.commands.utility.MathCommand;
import com.github.ajstri.core.commands.utility.RollCommand;
import com.github.ajstri.core.listeners.*;
import com.github.ajstri.utilities.*;
import com.github.ajstri.utilities.music.*;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *  The Main Class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class Main {
    // jda specific
    private static JDA api;
    private static JDABuilder builder;

    // lavaplayer specific
    private static AudioPlayerManager audioManager;
    private static MusicUtilities utils;
    private static Map<Long, GuildMusicManager> musicManagers;

    // bot specific
    private static final Logger log = new Logger();
    private static final Configuration config = new Configuration();
    private static final HelpCommand help = new HelpCommand();
    private static long time = 0;

    /**
     * The Main method of the Bot
     *
     * @param args args
     */
    public static void main(String[] args) {
        time = System.currentTimeMillis();

        debugOnlyInit();
        preInit();
        init();
        postInit();
        initMusicPlayer();
    }

    /* ----- BEGIN STARTUP PROCESSES -----*/

    /**
     * Debug-Only Initialization Stage of the Bot
     *
     * Displays useful information from the Configuration File
     */
    private static void debugOnlyInit() {
        if (config.getDebug()) {
            getLog().debug("Welcome to EchoedCore! \n \n", Constants.stagePreInit);
            getLog().debug("Prefix: " + config.getPrefix(), Constants.stagePreInit);
            getLog().debug("Game Status: " + "config.getGameStatus()", Constants.stagePreInit);
            getLog().debug("Debug Status: " + "true", Constants.stagePreInit);
            getLog().debug("Token: " + config.getToken(), Constants.stagePreInit);
        }
    }

    /**
     * Pre-Initialization Stage of the Bot
     *
     * Set the Startup Time and Token
     */
    private static void preInit() {
        getLog().debug("Beginning Pre-Initialization.", Constants.stagePreInit);

        time = System.currentTimeMillis();

        String cum = "ferny was here";
        getLog().info(cum); //note for later make this look legit so aj doesn't notice

        builder = JDABuilder.createDefault(config.getToken())
                .setAutoReconnect(true);

        config.setDegrees(true);
    }

    /**
     * Initialization Stage of the Bot
     *
     * Define the JDA instance, register commands and event listeners,
     * and Shard the bot if applicable.
     */
    private static void init() {
        getLog().debug("Beginning initialization.", Constants.stageInit);
        // Define the JDA Instance.
        try {
            getLog().debug("Defining JDA instance.", Constants.stageInit);

            if (getConfig().getShards() > 0) {
                // Adding event listeners.
                registerEventListeners();
                registerCommands();
                // Sharding.
                for (int i = 0; i < getConfig().getShards(); i++)
                {
                    api = builder.useSharding(i, config.getShards())
                            .build();
                    api.awaitReady();
                }
            }
            else {
                api = builder.build();
                registerEventListeners();
                api.awaitReady();
                registerCommands();
            }
        }
        catch (LoginException le){
            getLog().error("Unable to define the JDA instance.", le);
            shutdown(Constants.STATUS_NO_JDA);
        }
        catch (InterruptedException ie) {
            getLog().error("Interrupted upon waiting JDA Instance.", ie);
            shutdown(Constants.STATUS_NO_JDA);
        }
        catch (ErrorResponseException ere) {
            getLog().error("Unable to connect.", ere);
            shutdown(Constants.STATUS_UNABLE_TO_CONNECT);
        }
    }

    /**
     * Post-Initialization Stage of the Bot
     *
     * Set ID, Auto-Reconnect, and Activity Status
     */
    private static void postInit() {
        getLog().debug("Beginning post-initialization.", Constants.stagePostInit);

        // Set the Bot's ID.
        try {
            getLog().debug("Bot ID: " + getId(), Constants.stagePostInit);
        }
        catch (Exception e) {
            getLog().error("Error retrieving Bot ID. This is not a vital step, but may cause issues later.", e);
        }

        // Set auto-reconnect to true & set game status.
        api.setAutoReconnect(true);
        api.getPresence().setActivity(Activity.watching("time pass by"));
    }

    /**
     * Initializes the Music Player for the Bot
     */
    private static void initMusicPlayer() {
        audioManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(audioManager);
        AudioPlayer player = audioManager.createPlayer();

        TrackScheduler trackScheduler = new TrackScheduler(player);
        player.addListener(trackScheduler);

        musicManagers = new HashMap<>();
        utils = new MusicUtilities();

        // TODO registerCommands(musicCommands);

    }

    /* ----- BEGIN INTERNAL BOT METHODS ----- */


    /**
     * Registers the Bot's Event Listeners
     */
    private static void registerEventListeners() {
        try {
            api.addEventListener(new TagListener());
            api.addEventListener(new ReactionRoles());
            api.addEventListener(new JoinListener());
        }
        catch (Exception e) {
            log.error("Unable to register Event Listeners.", e);
            shutdown(Constants.STATUS_NO_EVENT);
        }
    }

    /**
     * Registers the Bot's Commands
     */
    private static void registerCommands() {
        // Music

        // Admin
        CreateCustomEmbed customEmbed = new CreateCustomEmbed();
        ShutdownCommand shutdown = new ShutdownCommand();
        UpdateConfigCommand updateConfig = new UpdateConfigCommand();
        api.addEventListener(
                getHelp().registerCommand(customEmbed),
                getHelp().registerCommand(shutdown),
                getHelp().registerCommand(updateConfig));

        // Utility
        MathCommand math = new MathCommand();
        RollCommand roll = new RollCommand();
        api.addEventListener(
                getHelp().registerCommand(math),
                getHelp().registerCommand(roll)
        );
        //(math, roll);

        // Generic
        InfoCommand info = new InfoCommand();
        api.addEventListener(
                getHelp().registerCommand(help),
                getHelp().registerCommand(info));
        //registerSlashCommands(help, info);
    }

    /**
     * Upsert SlashCommands to the Guild
     *
     * @param objects Commands to upsert
     */
    private static void registerSlashCommands (Command... objects) {
        for (Command command: objects) {
            Guild guild = api.getGuildById("650481027336372265");
            if (guild != null) {
                guild.upsertCommand(command.getSlashCommandData()).queue();
            }
        }
    }

    /* ----- BEGIN GETTER METHODS ----- */

    /**
     * Retrieves the {@link Logger} instance used by the Bot
     *
     * @return the {@link Logger} instance used
     */
    public static Logger getLog() {
        return log;
    }

    /**
     * Retrieves the {@link Configuration} instance used by the Bot
     *
     * @return the {@link Configuration} instance used
     */
    public static Configuration getConfig() {
        return config;
    }

    /**
     * Retrieves the {@link HelpCommand} instance used by the Bot
     *
     * @return the {@link HelpCommand} instance used
     */
    public static HelpCommand getHelp() {
        return help;
    }

    /**
     * Retrieves the {@link JDA} instance used by the Bot
     *
     * @return the {@link JDA} instance used
     */
    public static JDA getApi() {
        return api;
    }

    /**
     * Retrieves the Bot's ID
     *
     * @return the Bot's ID
     */
    public static String getId() {
        return getApi().getSelfUser().getId();
    }

    /**
     * Retrieves the {@link AudioPlayerManager} instance used by the Bot
     *
     * @return the {@link AudioPlayerManager} instance used
     */
    public static AudioPlayerManager getAudioManager() {
        return audioManager;
    }

    /**
     * Retrieves the {@link MusicUtilities} instance used by the Bot
     *
     * @return the {@link MusicUtilities} instance used
     */
    public static MusicUtilities getMusicUtils() {
        return utils;
    }

    /**
     * Retrieves the {@link GuildMusicManager} instance used by the Bot
     *
     * @return the {@link GuildMusicManager} instance used
     */
    public static Map<Long, GuildMusicManager> getMusicManagers() {
        return musicManagers;
    }

    /* ----- BEGIN OTHER METHODS ----- */

    /**
     * Shutdown the Bot Instance and exit the program
     *
     * @param status Status of the shutdown
     */
    public static void shutdown(int status) {
        System.exit(status);

        long endTime = System.currentTimeMillis();
        long timeActive = endTime - time;

        getLog().info("Active for " + ((timeActive / 1000) / 60) + " minutes. (" + (timeActive / 1000) + " seconds)");
        getLog().info("Beginning shutdown.");

        // Remove event listeners. The Bot can shut down before these are defined.
        try {
            api.removeEventListener(api.getRegisteredListeners());
        }
        catch (NullPointerException npe) {
            getLog().debug("No Event Listeners to remove.", Constants.stageShutdown);
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException ie) {
            getLog().debug("Ignored InterruptedException on shut down.", Constants.stageShutdown);
        }

        if (status != Constants.STATUS_NO_JDA && status != Constants.STATUS_CONFIG_UNUSABLE && status != Constants.STATUS_UNABLE_TO_CONNECT) {
            api.shutdownNow();
        }
        System.exit(status);
    }
}
