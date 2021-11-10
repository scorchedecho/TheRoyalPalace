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

import com.github.ajstri.utilities.Constants;
import com.github.ajstri.utilities.MessageUtilities;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

/**
 *  RoleEmbeds Class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class RoleEmbeds {

    /**
     * Create custom Reaction Embed for pronouns
     * @return custom Reaction Embed for pronouns
     */
    public static MessageEmbed pronounRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with " + Constants.EMOTE_NEUTRAL + " for `they/them`", false);
        embed.addField("", "React with " + Constants.EMOTE_BOY + " for `he/him`", false);
        embed.addField("", "React with " + Constants.EMOTE_GIRL + " for `she/her`", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for game server roles
     * @return custom Reaction Embed for game server roles
     */
    public static MessageEmbed gameServerRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_MINECRAFT + "> to gain access to `Minecraft`", false);

        // Return embed
        return embed.build();
    }

    /* ----- COLORS BEGIN HERE ----- */
    /**
     * Create custom Reaction Embed for red color roles
     * @return custom Reaction Embed for red color roles
     */
    public static MessageEmbed redRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_WINE + "> for <@&" + Constants.ROLEID_WINE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLOOD + "> for <@&" + Constants.ROLEID_BLOOD + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_ROSE + "> for <@&" + Constants.ROLEID_ROSE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CHERRY + "> for <@&" + Constants.ROLEID_CHERRY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_RUBY + "> for <@&" + Constants.ROLEID_RUBY + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for yellow color roles
     * @return custom Reaction Embed for yellow color roles
     */
    public static MessageEmbed yellowRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_SUMMERLOVE + "> for <@&" + Constants.ROLEID_SUMMERLOVE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_HONEY + "> for <@&" + Constants.ROLEID_HONEY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_DAZE + "> for <@&" + Constants.ROLEID_DAZE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BUZZ + "> for <@&" + Constants.ROLEID_BUZZ + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for blue color roles
     * @return custom Reaction Embed for blue color roles
     */
    public static MessageEmbed greenRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_LUSH + "> for <@&" + Constants.ROLEID_LUSH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_FERNY + "> for <@&" + Constants.ROLEID_FERNY + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CLOVER + "> for <@&" + Constants.ROLEID_CLOVER + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for blue color roles
     * @return custom Reaction Embed for blue color roles
     */
    public static MessageEmbed blueRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_SERPENT + "> for <@&" + Constants.ROLEID_SERPENT + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_STORM + "> for <@&" + Constants.ROLEID_STORM + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_PUDDLE + "> for <@&" + Constants.ROLEID_PUDDLE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_TSUNAMI + "> for <@&" + Constants.ROLEID_TSUNAMI + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COSTAL + "> for <@&" + Constants.ROLEID_COSTAL + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for purple color roles
     * @return custom Reaction Embed for purple color roles
     */
    public static MessageEmbed purpleRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_ECHO + "> for <@&" + Constants.ROLEID_ECHO + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_FORTUNE + "> for <@&" + Constants.ROLEID_FORTUNE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_LAVENDER + "> for <@&" + Constants.ROLEID_LAVENDER + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for pink color roles
     * @return custom Reaction Embed for pink color roles
     */
    public static MessageEmbed pinkRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_DUSTYROSE + "> for <@&" + Constants.ROLEID_DUSTYROSE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLOSSOM + "> for <@&" + Constants.ROLEID_BLOSSOM + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_BLUSH + "> for <@&" + Constants.ROLEID_BLUSH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_PEACH + "> for <@&" + Constants.ROLEID_PEACH + ">", false);

        // Return embed
        return embed.build();
    }

    /**
     * Create custom Reaction Embed for other color roles
     * @return custom Reaction Embed for other color roles
     */
    public static MessageEmbed otherRoles () {
        // Prepare embed
        EmbedBuilder embed = new EmbedBuilder();
        MessageUtilities.addEmbedDefaults(embed);
        embed.setColor(new Color(158, 118, 130));

        // Populate embed
        embed.addField("", "React with <:" + Constants.EMOTE_NORI + "> for <@&" + Constants.ROLEID_NORI + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COFFEE + "> for <@&" + Constants.ROLEID_COFFEE + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_WARMTH + "> for <@&" + Constants.ROLEID_WARMTH + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_COLD + "> for <@&" + Constants.ROLEID_COLD + ">", false);
        embed.addField("", "React with <:" + Constants.EMOTE_CANVAS + "> for <@&" + Constants.ROLEID_CANVAS + ">", false);

        // Return embed
        return embed.build();
    }
}
