package com.github.ajstri.core.listeners;

import com.github.ajstri.core.Main;
import com.github.ajstri.utilities.Constants;
import com.github.ajstri.utilities.exceptions.NoConfigurationFileException;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 *  ReactionRoles Class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class ReactionRoles extends ListenerAdapter {

    private static final String cosmeticChannelID = "766108555022958603";
    private static final String serverAccessChannelID = "902584757492281367";

    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        String emoji = event.getReactionEmote().getAsReactionCode();
        Member member = event.getMember();

        // Check message IDs
        if (Main.getConfig().getRedsID().equals("000000") ||
            Main.getConfig().getYellowsID().equals("000000") ||
            Main.getConfig().getGreensID().equals("000000") ||
            Main.getConfig().getBluesID().equals("000000") ||
            Main.getConfig().getPurplesID().equals("000000") ||
            Main.getConfig().getPinksID().equals("000000") ||
            Main.getConfig().getOthersID().equals("000000")) {
            // Quit if any ID is default value
            Main.getLog().error("Reaction Role Message IDs (at least one) is default value. Cannot check reactions.",
                    new NoConfigurationFileException("Reaction Roles are default value."));
        }
        else if (!member.getUser().isBot()) {
            /* ----- HANDLE COSMETIC ADD REACT ROLES HERE ----- */
            if (event.getChannel().getId().equals(cosmeticChannelID)) {
                // Event was in cosmetic roles channel. Get specific menu
                if (event.getMessageId().equals(Main.getConfig().getPronounsID())) {
                    // Pronouns menu
                    switch (emoji) {
                        case Constants.EMOTE_NEUTRAL:
                            addRole(member, Constants.ROLEID_NEUTRAL);
                            break;
                        case Constants.EMOTE_GIRL:
                            addRole(member, Constants.ROLEID_GIRL);
                            break;
                        case Constants.EMOTE_BOY:
                            addRole(member, Constants.ROLEID_BOY);
                            break;
                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }

                // TODO HANDLE COLORS
                else if (event.getMessageId().equals(Main.getConfig().getRedsID())) {
                    // Reds menu
                    switch (emoji) {
                        case Constants.EMOTE_WINE:
                            addRole(member, Constants.ROLEID_WINE);
                            removeOtherColorRoles(member, Constants.ROLEID_WINE);
                            break;
                        case Constants.EMOTE_BLOOD:
                            addRole(member, Constants.ROLEID_BLOOD);
                            removeOtherColorRoles(member, Constants.ROLEID_BLOOD);
                            break;
                        case Constants.EMOTE_ROSE:
                            addRole(member, Constants.ROLEID_ROSE);
                            removeOtherColorRoles(member, Constants.ROLEID_ROSE);
                            break;
                        case Constants.EMOTE_CHERRY:
                            addRole(member, Constants.ROLEID_CHERRY);
                            removeOtherColorRoles(member, Constants.ROLEID_CHERRY);
                            break;
                        case Constants.EMOTE_RUBY:
                            addRole(member, Constants.ROLEID_RUBY);
                            removeOtherColorRoles(member, Constants.ROLEID_RUBY);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getYellowsID())) {
                    // Yellow menu
                    switch (emoji) {
                        case Constants.EMOTE_SUMMERLOVE:
                            addRole(member, Constants.ROLEID_SUMMERLOVE);
                            break;
                        case Constants.EMOTE_HONEY:
                            addRole(member, Constants.ROLEID_HONEY);
                            break;
                        case Constants.EMOTE_DAZE:
                            addRole(member, Constants.ROLEID_DAZE);
                            break;
                        case Constants.EMOTE_BUZZ:
                            addRole(member, Constants.ROLEID_BUZZ);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getRedsID())) {
                    // Greens menu
                    switch (emoji) {
                        case Constants.EMOTE_LUSH:
                            addRole(member, Constants.ROLEID_LUSH);
                            break;
                        case Constants.EMOTE_FERNY:
                            addRole(member, Constants.ROLEID_FERNY);
                            break;
                        case Constants.EMOTE_CLOVER:
                            addRole(member, Constants.ROLEID_CLOVER);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getBluesID())) {
                    // Blues menu
                    switch (emoji) {
                        case Constants.EMOTE_SERPENT:
                            addRole(member, Constants.ROLEID_SERPENT);
                            break;
                        case Constants.EMOTE_STORM:
                            addRole(member, Constants.ROLEID_STORM);
                            break;
                        case Constants.EMOTE_PUDDLE:
                            addRole(member, Constants.ROLEID_PUDDLE);
                            break;
                        case Constants.EMOTE_TSUNAMI:
                            addRole(member, Constants.ROLEID_TSUNAMI);
                            break;
                        case Constants.EMOTE_COSTAL:
                            addRole(member, Constants.ROLEID_COSTAL);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getPurplesID())) {
                    // Purple menu
                    switch (emoji) {
                        case Constants.EMOTE_ECHO:
                            addRole(member, Constants.ROLEID_ECHO);
                            break;
                        case Constants.EMOTE_FORTUNE:
                            addRole(member, Constants.ROLEID_FORTUNE);
                            break;
                        case Constants.EMOTE_LAVENDER:
                            addRole(member, Constants.ROLEID_LAVENDER);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getPinksID())) {
                    // Pink menu
                    switch (emoji) {
                        case Constants.EMOTE_DUSTYROSE:
                            addRole(member, Constants.ROLEID_DUSTYROSE);
                            break;
                        case Constants.EMOTE_BLOSSOM:
                            addRole(member, Constants.ROLEID_BLOSSOM);
                            break;
                        case Constants.EMOTE_BLUSH:
                            addRole(member, Constants.ROLEID_BLUSH);
                            break;
                        case Constants.EMOTE_PEACH:
                            addRole(member, Constants.ROLEID_PEACH);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getOthersID())) {
                    // Others menu
                    switch (emoji) {
                        case Constants.EMOTE_NORI:
                            addRole(member, Constants.ROLEID_NORI);
                            break;
                        case Constants.EMOTE_COFFEE:
                            addRole(member, Constants.ROLEID_COFFEE);
                            break;
                        case Constants.EMOTE_WARMTH:
                            addRole(member, Constants.ROLEID_WARMTH);
                            break;
                        case Constants.EMOTE_COLD:
                            addRole(member, Constants.ROLEID_COLD);
                            break;
                        case Constants.EMOTE_CANVAS:
                            addRole(member, Constants.ROLEID_CANVAS);
                            break;

                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
            }

            /* ----- HANDLE SERVER REACT ADD ROLES HERE ----- */
            if (event.getChannel().getId().equals(serverAccessChannelID)) {
                // Server roles channel
                if (event.getMessageId().equals(Main.getConfig().getServerAccessID())) {
                    // Game Server Access menu
                    switch (emoji) {
                        case Constants.EMOTE_MINECRAFT:
                            addRole(member, Constants.ROLEID_MINECRAFT);
                            break;
                        case Constants.EMOTE_STARBOUND:
                            addRole(member, Constants.ROLEID_STARBOUND);
                            break;
                        default:
                            // Not recognized as a reaction, delete
                            event.getReaction().removeReaction().queue();
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void onGuildMessageReactionRemove(@Nonnull GuildMessageReactionRemoveEvent event) {
        String emoji = event.getReactionEmote().getAsReactionCode();
        Member member = event.getMember();

        // Check message IDs
        if (Main.getConfig().getRedsID().equals("000000") ||
                Main.getConfig().getYellowsID().equals("000000") ||
                Main.getConfig().getGreensID().equals("000000") ||
                Main.getConfig().getBluesID().equals("000000") ||
                Main.getConfig().getPurplesID().equals("000000") ||
                Main.getConfig().getPinksID().equals("000000") ||
                Main.getConfig().getOthersID().equals("000000")) {
            // Quit if any ID is default value
            Main.getLog().error("Reaction Role Message IDs (at least one) is default value. Cannot check reactions.",
                    new NoConfigurationFileException("Reaction Roles are default value."));
        }
        else if (member != null && !member.getUser().isBot()) {
            /* ----- HANDLE COSMETIC REMOVE REACTS ROLES HERE ----- */
            if (event.getChannel().getId().equals(cosmeticChannelID)) {
                // Event was in cosmetic roles channel. Get specific menu
                if (event.getMessageId().equals(Main.getConfig().getPronounsID())) {
                    // Pronouns menu
                    switch (emoji) {
                        case Constants.EMOTE_NEUTRAL:
                            removeRole(member, Constants.ROLEID_NEUTRAL);
                            break;
                        case Constants.EMOTE_GIRL:
                            removeRole(member, Constants.ROLEID_GIRL);
                            break;
                        case Constants.EMOTE_BOY:
                            removeRole(member, Constants.ROLEID_BOY);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getRedsID())) {
                    // Reds menu
                    switch (emoji) {
                        case Constants.EMOTE_WINE:
                            removeRole(member, Constants.ROLEID_WINE);
                            break;
                        case Constants.EMOTE_BLOOD:
                            removeRole(member, Constants.ROLEID_BLOOD);
                            break;
                        case Constants.EMOTE_ROSE:
                            removeRole(member, Constants.ROLEID_ROSE);
                            break;
                        case Constants.EMOTE_CHERRY:
                            removeRole(member, Constants.ROLEID_CHERRY);
                            break;
                        case Constants.EMOTE_RUBY:
                            removeRole(member, Constants.ROLEID_RUBY);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getYellowsID())) {
                    // Yellow menu
                    switch (emoji) {
                        case Constants.EMOTE_SUMMERLOVE:
                            removeRole(member, Constants.ROLEID_SUMMERLOVE);
                            break;
                        case Constants.EMOTE_HONEY:
                            removeRole(member, Constants.ROLEID_HONEY);
                            break;
                        case Constants.EMOTE_DAZE:
                            removeRole(member, Constants.ROLEID_DAZE);
                            break;
                        case Constants.EMOTE_BUZZ:
                            removeRole(member, Constants.ROLEID_BUZZ);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getRedsID())) {
                    // Greens menu
                    switch (emoji) {
                        case Constants.EMOTE_LUSH:
                            removeRole(member, Constants.ROLEID_LUSH);
                            break;
                        case Constants.EMOTE_FERNY:
                            removeRole(member, Constants.ROLEID_FERNY);
                            break;
                        case Constants.EMOTE_CLOVER:
                            removeRole(member, Constants.ROLEID_CLOVER);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getBluesID())) {
                    // Blues menu
                    switch (emoji) {
                        case Constants.EMOTE_SERPENT:
                            removeRole(member, Constants.ROLEID_SERPENT);
                            break;
                        case Constants.EMOTE_STORM:
                            removeRole(member, Constants.ROLEID_STORM);
                            break;
                        case Constants.EMOTE_PUDDLE:
                            removeRole(member, Constants.ROLEID_PUDDLE);
                            break;
                        case Constants.EMOTE_TSUNAMI:
                            removeRole(member, Constants.ROLEID_TSUNAMI);
                            break;
                        case Constants.EMOTE_COSTAL:
                            removeRole(member, Constants.ROLEID_COSTAL);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getPurplesID())) {
                    // Purple menu
                    switch (emoji) {
                        case Constants.EMOTE_ECHO:
                            removeRole(member, Constants.ROLEID_ECHO);
                            break;
                        case Constants.EMOTE_FORTUNE:
                            removeRole(member, Constants.ROLEID_FORTUNE);
                            break;
                        case Constants.EMOTE_LAVENDER:
                            removeRole(member, Constants.ROLEID_LAVENDER);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getPinksID())) {
                    // Pink menu
                    switch (emoji) {
                        case Constants.EMOTE_DUSTYROSE:
                            removeRole(member, Constants.ROLEID_DUSTYROSE);
                            break;
                        case Constants.EMOTE_BLOSSOM:
                            removeRole(member, Constants.ROLEID_BLOSSOM);
                            break;
                        case Constants.EMOTE_BLUSH:
                            removeRole(member, Constants.ROLEID_BLUSH);
                            break;
                        case Constants.EMOTE_PEACH:
                            removeRole(member, Constants.ROLEID_PEACH);
                            break;
                    }
                }
                else if (event.getMessageId().equals(Main.getConfig().getOthersID())) {
                    // Others menu
                    switch (emoji) {
                        case Constants.EMOTE_NORI:
                            removeRole(member, Constants.ROLEID_NORI);
                            break;
                        case Constants.EMOTE_COFFEE:
                            removeRole(member, Constants.ROLEID_COFFEE);
                            break;
                        case Constants.EMOTE_WARMTH:
                            removeRole(member, Constants.ROLEID_WARMTH);
                            break;
                        case Constants.EMOTE_COLD:
                            removeRole(member, Constants.ROLEID_COLD);
                            break;
                        case Constants.EMOTE_CANVAS:
                            removeRole(member, Constants.ROLEID_CANVAS);
                            break;
                    }
                }
            }

            /* ----- HANDLE SERVER REACT REMOVE ROLES HERE ----- */
            if (event.getChannel().getId().equals(serverAccessChannelID) && !member.getUser().isBot()) {
                if (event.getMessageId().equals(Main.getConfig().getServerAccessID())) {
                    // Games menu
                    switch (emoji) {
                        case Constants.EMOTE_MINECRAFT:
                            removeRole(member, Constants.ROLEID_MINECRAFT);
                            break;
                        case Constants.EMOTE_STARBOUND:
                            removeRole(member, Constants.ROLEID_STARBOUND);
                            break;
                    }
                }
            }
        }
    }

    /**
     * Removes all Color Roles except the newest.
     *
     * @param member Member to remove role from
     * @param roleIDToIgnore ID of the role to ignore
     */
    private static void removeOtherColorRoles(Member member, String roleIDToIgnore) {
        String[] roleColorIDs = new String[]{
                // reds
                Constants.ROLEID_WINE, Constants.ROLEID_BLOOD, Constants.ROLEID_ROSE, Constants.ROLEID_CHERRY, Constants.ROLEID_RUBY,
                // yellows
                Constants.ROLEID_SUMMERLOVE, Constants.ROLEID_HONEY, Constants.ROLEID_DAZE, Constants.ROLEID_BUZZ,
                // green
                Constants.ROLEID_LUSH, Constants.ROLEID_FERNY, Constants.ROLEID_CLOVER,
                // blue
                Constants.ROLEID_SERPENT, Constants.ROLEID_STORM, Constants.ROLEID_PUDDLE, Constants.ROLEID_TSUNAMI, Constants.ROLEID_COSTAL,
                // purple
                Constants.ROLEID_ECHO, Constants.ROLEID_FORTUNE, Constants.ROLEID_LAVENDER,
                // pinks
                Constants.ROLEID_DUSTYROSE, Constants.ROLEID_BLOSSOM, Constants.ROLEID_BLUSH, Constants.ROLEID_PEACH,
                // others
                Constants.ROLEID_NORI, Constants.ROLEID_COFFEE, Constants.ROLEID_WARMTH, Constants.ROLEID_COLD, Constants.ROLEID_CANVAS
        };

        // Remove other roles
        for (String role : roleColorIDs) {
            Role color = member.getGuild().getRoleById(role);
            if (color != null && member.getRoles().contains(color) && !color.getId().equals(roleIDToIgnore)) {
                member.getGuild().removeRoleFromMember(member, color).queue();
            }
        }
    }

    /**
     * Adds a new role to a user
     *
     * @param member member to add role to
     * @param roleID ID of the role to add
     */
    private static void addRole (Member member, String roleID) {
        Main.getLog().debug("Adding " + roleID + " to user " + member.getUser().getAsTag(), "Role React");
        Role role = member.getGuild().getRoleById(roleID);
        if (role != null) {
            member.getGuild().addRoleToMember(member, role).queue();
        }
        else {
            Main.getLog().error("Role from ID Array is null. Did you delete a role?", new NullPointerException());
        }
    }

    /**
     * Removes a role from a user
     *
     * @param member member to remove role from
     * @param roleID ID of the role to remove
     */
    private static void removeRole (Member member, String roleID) {
        Main.getLog().debug("Removing " + roleID + " from user " + member.getUser().getAsTag(), "Role React");
        Role role = member.getGuild().getRoleById(roleID);

        if (role != null) {
            if (member.getRoles().contains(role)) {
                member.getGuild().removeRoleFromMember(member, role).queue();
            }
        }
        else {
            Main.getLog().error("Role from ID Array is null. Did you delete a role?", new NullPointerException());
        }
    }
}
