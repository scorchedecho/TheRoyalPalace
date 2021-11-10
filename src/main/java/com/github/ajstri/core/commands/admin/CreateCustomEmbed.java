/*
 *  Copyright 2020 scorchedE.C.H.O
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
package com.github.ajstri.core.commands.admin;

import com.github.ajstri.core.Main;
import com.github.ajstri.core.commands.Command;
import com.github.ajstri.core.commands.Modules;
import com.github.ajstri.utilities.Constants;
import com.github.ajstri.utilities.embeds.DefaultEmbeds;
import com.github.ajstri.utilities.embeds.RoleEmbeds;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 *  CreateCustomEmbed Class of The Royal Palace project
 *
 *  All methods are explained in {@link Command}
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class CreateCustomEmbed extends Command {

    @Override
    public void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("Custom Embed Command requested by " + mre.getAuthor().getAsTag());

        String roleMenu = args[1].toLowerCase();

        if (!mre.getChannel().getId().equals("")) {
            if (roleMenu.contains("rules")) {
                mre.getChannel().sendFile(Constants.RULES).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.rules()).queue();
            }
            else if (roleMenu.contains("events")) {
                mre.getChannel().sendFile(Constants.EVENTS).queue();
            }
            else if (roleMenu.contains("nitro")) {
                mre.getChannel().sendFile(Constants.NITRO).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.nitro()).queue();
            }
            else if (roleMenu.contains("info")) {
                mre.getChannel().sendFile(Constants.INFO).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.information()).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.moderationTeam()).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.donationInfo()).queue();
            }
            else if (roleMenu.contains("cosmetic")) {
                // Colors
                mre.getChannel().sendFile(Constants.ROLES).queue();
                handleColorRoles(mre);
                // Pronouns
                mre.getChannel().sendFile(Constants.PRONOUNS).queue();
                handlePronounRoles(mre);
            }
            else if (roleMenu.contains("server")) {
                mre.getChannel().sendFile(Constants.GAME_SERVER_ACCESS).queue();
                handleServerAccessRoles(mre);
            }
            else if (roleMenu.contains("minecraft")) {
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.vanillaInfo()).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.creativeInfo()).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.privateModdedInfo()).queue();
            }
            else if (roleMenu.contains("starbound")) {
                mre.getChannel().sendFile(Constants.STARBOUND).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.starboundInfo()).queue();
            }
            else if (roleMenu.contains("mcrule")) {
                mre.getChannel().sendFile(Constants.MINECRAFT).queue();
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.minecraftRules()).queue();
            }
            else if (roleMenu.contains("modreq")) {
                mre.getChannel().sendMessageEmbeds(DefaultEmbeds.moddedAccess()).queue();
            }
            else {
                mre.getChannel().sendMessage("Try again, Echo").queue();
            }

            mre.getMessage().delete().queue();
        }
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent sce) {

    }

    @Override
    public CommandData getSlashCommandData() {
        return new CommandData("info", "Get information about the bot");
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("embed", "cra");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Create a custom Embed from predefined embed types";
    }

    @Override
    public String getName() {
        return "Create Custom Embed Command";
    }

    @Override
    public List<String> getUsage() {
        return null;
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }

    /**
     * Send Reaction Role embed for Game Server Access and
     * handle post-sending.
     * @param mre Event of the Command Call
     */
    private static void handleServerAccessRoles(MessageReceivedEvent mre) {
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.gameServerRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setServerAccessID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_MINECRAFT).queue();
        });
    }

    /**
     * Send Reaction Role embed for Pronouns and
     * handle post-sending.
     * @param mre Event of the Command Call
     */
    private static void handlePronounRoles(MessageReceivedEvent mre) {
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.pronounRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setPronounsID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_NEUTRAL).queue();
            message.addReaction(Constants.EMOTE_BOY).queue();
            message.addReaction(Constants.EMOTE_GIRL).queue();
        });
    }

    /**
     * Send Reaction Role embed for Colors (all) and
     * handle post-sending.
     * @param mre Event of the Command Call
     */
    private static void handleColorRoles(MessageReceivedEvent mre) {
        // Reds
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.redRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setRedsID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_WINE).queue();
            message.addReaction(Constants.EMOTE_BLOOD).queue();
            message.addReaction(Constants.EMOTE_ROSE).queue();
            message.addReaction(Constants.EMOTE_CHERRY).queue();
            message.addReaction(Constants.EMOTE_RUBY).queue();
        });

        // Yellows
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.yellowRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setYellowsID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_SUMMERLOVE).queue();
            message.addReaction(Constants.EMOTE_HONEY).queue();
            message.addReaction(Constants.EMOTE_DAZE).queue();
            message.addReaction(Constants.EMOTE_BUZZ).queue();
        });

        // Greens
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.greenRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setGreensID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_LUSH).queue();
            message.addReaction(Constants.EMOTE_FERNY).queue();
            message.addReaction(Constants.EMOTE_CLOVER).queue();
        });

        // Blue
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.blueRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setBluesID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_SERPENT).queue();
            message.addReaction(Constants.EMOTE_STORM).queue();
            message.addReaction(Constants.EMOTE_PUDDLE).queue();
            message.addReaction(Constants.EMOTE_TSUNAMI).queue();
            message.addReaction(Constants.EMOTE_COSTAL).queue();
        });

        // Purple
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.purpleRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setPurplesID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_ECHO).queue();
            message.addReaction(Constants.EMOTE_FORTUNE).queue();
            message.addReaction(Constants.EMOTE_LAVENDER).queue();
        });

        // Pink
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.pinkRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setPinksID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_DUSTYROSE).queue();
            message.addReaction(Constants.EMOTE_BLOSSOM).queue();
            message.addReaction(Constants.EMOTE_BLUSH).queue();
            message.addReaction(Constants.EMOTE_PEACH).queue();
        });

        // Other
        mre.getChannel().sendMessageEmbeds(RoleEmbeds.otherRoles()).queue(message -> {
            // Set new message ID
            Main.getConfig().setOthersID(message.getId());

            // Add reactions
            message.addReaction(Constants.EMOTE_NORI).queue();
            message.addReaction(Constants.EMOTE_COFFEE).queue();
            message.addReaction(Constants.EMOTE_WARMTH).queue();
            message.addReaction(Constants.EMOTE_COLD).queue();
            message.addReaction(Constants.EMOTE_CANVAS).queue();
        });
    }
}
