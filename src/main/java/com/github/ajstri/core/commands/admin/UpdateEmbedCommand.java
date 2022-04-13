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
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  UpdateConfigCommand class of The Royal Palace project
 *
 *  All methods are explained in {@link Command}
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class UpdateEmbedCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("UPDATE EMBED (called by " + mre.getAuthor().getAsTag() + ")");

        // Check if owner. If not, quit
        String userID = mre.getAuthor().getId();
        if (!userID.equals(Constants.OWNER_ID)) {
            mre.getChannel().sendMessage("This command can only be used by the owner.").queue();
            return;
        }

        // If no argument, ask for one
        if (args.length < 3) {
            mre.getChannel().sendMessage("Please define a message link to update and the embed type.").queue();
        }

        if (!args[1].contains("https://discord.com/channels/")) {
            mre.getChannel().sendMessage("Please use a valid message URL.").queue();
            return;
        }

        String url = args[1].replace("https://discord.com/channels/", "");
        String[] ids = url.split("/");

        String channelID = ids[1];
        String messageID = ids[2];
        String messageType = args[2];

        RestAction<Message> message = mre.getGuild().getTextChannelById(channelID).retrieveMessageById(messageID);

        if (messageType.contains("rules")) {
        }
        else if (messageType.contains("events")) {
        }
        else if (messageType.contains("nitro")) {
        }
        else if (messageType.contains("information")) {
        }
        else if (messageType.contains("cosmeticroles")) {
        }
        else if (messageType.contains("serverroles")) {
        }
        else if (messageType.contains("minecraft")) {
        }
        else if (messageType.contains("starbound")) {
        }
        else if (messageType.contains("minecraftrules")) {
        }
        else if (messageType.contains("moddedapplications")) {
        }
        else {
            mre.getChannel().sendMessage("Try again, Echo").queue();
        }

        mre.getMessage().delete().queue();
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent sce) {

    }

    @Override
    public CommandData getSlashCommandData() { // TODO command data
        return new CommandData("updateconfig", "Get information about the bot");
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("umsg", "updatemsg", "editmsg");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Updates an embed.";
    }

    @Override
    public String getName() {
        return "Prefix Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "update [key] [newValue]`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}
