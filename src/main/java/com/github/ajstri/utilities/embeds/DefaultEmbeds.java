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
package com.github.ajstri.utilities.embeds;

import com.github.ajstri.utilities.MessageUtilities;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 *  DefaultEmbeds class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class DefaultEmbeds {
    /* ----- BEGIN VARIABLES FOR EASY ACCESS ----- */

    // Channel IDs
    private static final String rulesChannel = "<#766109905685708810>";
    private static final String serverAccessChannel = "<#902584757492281367>";
    private static final String cosmeticRolesChannel = "<#766108555022958603>";

    // Moderation Team IDs
    private static final String scorched_echo = "<@202422697173581824>";
    private static final String paradox = "<@238361470792892417>";
    private static final String god_ferny = "<@270673291411324929>";
    private static final String dragonmasster = "<@287244707535519744>";
    private static final String justie1220 = "<@109693681803481088>";

    // Links
    private static final String discordApplications = "https://trpserver.com/discord-applications";
    private static final String minecraftApplications = "https://trpserver.com/minecraft-applications/";
    private static final String starboundApplications = "https://trpserver.com/starbound-applications/";

    private static final String donations = "https://paypal.me/ajstri";
    private static final String serverUpkeep = "https://trpserver.com/go/upkeep-costs";

    /**
     * Welcomes a user to the Server
     * @param member User to welcome
     * @return embed of welcome message
     */
    public static MessageEmbed welcome(Member member) {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setThumbnail(member.getUser().getAvatarUrl());
        embed.setTitle("Welcome to The Royal Palace!");
        embed.addBlankField(false);

        embed.addField("Read our rules", rulesChannel, false);
        embed.addField("Get access to our Game Servers", serverAccessChannel, true);
        embed.addField("", "Remember to read the new channels you get access to after getting your roles!", true);
        embed.addField("Choose cosmetic roles", cosmeticRolesChannel, false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Server Rules
     * @return custom embed for Server Rules
     */
    public static MessageEmbed rules () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("❧ | No harmful material.",
                "Any harmful material (including, but not limited to: viruses, scams, disturbing imagery) should not be posted in the server.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | Hate speech will **not** be tolerated.",
                "Any attacks towards any group of people, server member, etc. (even in meme form) is absolutely not allowed. " +
                        "Be respectful of other members. Inappropriate language (slurs, etc.) is not okay.\n" +
                        "➾ `1st offense` will result in a kick\n" +
                        "➾ `2nd offense` will result in a ban\n",
                false);

        embed.addField("❧ | No self-promotion or advertising.",
                "This includes, but is not limited to: Discord servers, self-hosted game servers, personal YouTube/Twitch content, etc.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | No spamming and no personal drama or disputes.",
                "Please take disputes to private messages. If it relates to the server, tag someone in the Moderation team to resolve the issue." +
                        "Please do not attempt to moderate the issue yourself.\nSpamming will not be tolerated. Just don't do it.\n" +
                        "➾ `1st offense` will result in a 24hr mute\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban",
                false);

        embed.addField("❧ | Use common sense.",
                "This list does not constitute a full list of rules. At all times, use common sense and good judgement for any action you're about to take." +
                        " The Moderation team will always have the final decision in any situation.\n" +
                        "The Moderation team is around to take care of making sure these rules are enforced. If someone is breaking the rules, " +
                        "please ping someone in the team and do not attempt to moderate the conversation yourself.",
                false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Server Information
     * @return custom embed for Server Information
     */
    public static MessageEmbed information () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Welcome to The Royal Palace!");

        embed.addField("Minecraft Servers", "We have **three** Minecraft Servers!\n" +
                "❧ | Vanilla\n❧ | Creative Plots\n❧ | Modded" +
                "\nYou can view more information on these once you get your role" +
                "\nThe Modded server is by approval only, the other two are public", false);


        embed.addField("Starbound Server", "We run a modded Starbound server!" +
                "\nYou can view more information on these once you get your role", false);

        embed.addField("Access to these servers are given through roles", "You can get your roles in <#902584757492281367>!", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Moderation Team
     * @return custom embed for Moderation Team
     */
    public static MessageEmbed moderationTeam () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Meet our Moderation Team");

        embed.addField("Owners", "❧ | " + scorched_echo + "\n❧ | " + paradox, false);

        embed.addField("Court Officials", "Our moderation team is managed by our Court Officials.", false);
        embed.addField("Discord Administrator", "N/A See our applications below!", true);
        embed.addField("Minecraft Administrator", dragonmasster, true);
        embed.addField("Starbound Administrator", god_ferny, true);

        embed.addField("Royal Court", "The Royal Court is a collection of moderators with different roles within our community. They are maintained by our Court Officials.", false);
        embed.addField("Discord Moderators", "❧ | " + god_ferny + "\n❧ | " + dragonmasster + "\n❧ | N/A OPEN", true);
        embed.addField("Minecraft Moderators", "❧ | " + god_ferny + "\n❧ | " + justie1220 + "\n❧ | N/A OPEN", true);
        embed.addField("Starbound Moderators", "❧ | N/A OPEN\n❧ | N/A OPEN\n❧ | N/A OPEN", true);

        embed.addBlankField(false);

        embed.addField("Want to join our team?", "", false);
        embed.addField("Discord Application", discordApplications, true);
        embed.addField("Minecraft Application", minecraftApplications, true);
        embed.addField("Starbound Application", starboundApplications, true);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Donation Information
     * @return custom embed for Donation Information
     */
    public static MessageEmbed donationInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Donations");

        embed.addField("Donations are always optional.", "Please *only* donate if you like what we do here and are able to do so.\n" +
                "In exchange for your generosity, you will be given a Discord role and in-game ranks to show off and access to our Nitro rewards.", false);

        embed.addField("Donation link", donations, false);

        embed.addField("Server Upkeep Cost Breakdowns", serverUpkeep, false);

        // Return embed
        return embed.build();
    }

    public static MessageEmbed nitro () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // TODO set up Nitro Rewards

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Minecraft Rules
     * @return custom embed for Minecraft Rules
     */
    public static MessageEmbed minecraftRules () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Minecraft Server Rules");

        embed.addField("❧ | -100 to 100 on both the X and Z axis are reserved for Spawn Town.",
                "Shops, Community Builds, etc. are here. No personal builds (bases, etc.) should be built here.", false);

        embed.addField("❧ | No cheating, hacking, or griefing",
                "Pranks are okay, but be prepared to help with clean up if requested.\n" +
                        "Vanilla plus type mods are okay(Minimaps, Optifine, etc.). Hacking will not be tolerated\n" +
                        "➾ `1st offense` will result in a warning\n" +
                        "➾ `2nd offense` will result in a kick\n" +
                        "➾ `3rd offense` will result in a ban\n",
                false);
        embed.addField("Server Archives", "https://trpserver.com/go/archives", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Vanilla Server Information
     * @return custom embed for Vanilla Server Information
     */
    public static MessageEmbed vanillaInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Vanilla Server");

        embed.addField("Server Map", "https://dynmap.trpserver.com", false);
        embed.addField("IP", "play.trpserver.com\nType `/server vanilla` or use the portal", true);
        embed.addField("Version", "1.17.1", true);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Private Modded Server Information
     * @return custom embed for Private Modded Server Information
     */
    public static MessageEmbed privateModdedInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Private Modded Server");

        embed.addField("Our Modded Server is currently whitelist only", "To gain access to Modded, see pinned message in <#901646689155297332>", false);
        embed.addBlankField(false);

        embed.addField("Modpack", "Enigmatica 2: Expert (Version **1.82a**)\nhttps://www.curseforge.com/minecraft/modpacks/enigmatica2expert", false);
        embed.addField("IP", "play.trpserver.com\nType `/server modded` or use the portal", true);
        embed.addField("Version", "1.12.2", true);

        // Return embed
        return embed.build();
    }

    public static MessageEmbed publicModdedInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // TODO set up Public Modded Server info

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Creative Server Information
     * @return custom embed for Creative Server Information
     */
    public static MessageEmbed creativeInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.setTitle("Creative Plots Server");

        embed.addField("IP", "play.trpserver.com\nType `/server creative` or use the portal", true);
        embed.addField("Version", "1.17.1", true);

        // Return embed
        return embed.build();
    }

    public static MessageEmbed snapshotInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // TODO Snapshot server info

        return embed.build();
    }

    /**
     * Create custom embed for Modded Access Information
     * @return custom embed for Modded Access Information
     */
    public static MessageEmbed moddedAccess () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("Request access to our Modded Server below", "Generally, we only accept people we personally know, people who have contacts with those people, or people from specific partnered servers.", false);
        embed.addField("Just because you open a ticket does NOT mean you will gain access.", "We do not accept everyone who applies.", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom embed for Starbound Server Information
     * @return custom embed for Starbound Server Information
     */
    public static MessageEmbed starboundInfo () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("Mod List", "https://trpserver.com/go/starbound-mods", false);
        embed.addField("IP", "starbound.trpserver.com\nIf this doesn't work, use 192.99.63.190", false);

        embed.addField("", "Please be sure to enable **Allow Asset Mismatch** in settings.", false);

        // Return embed
        return embed.build();
    }

}
