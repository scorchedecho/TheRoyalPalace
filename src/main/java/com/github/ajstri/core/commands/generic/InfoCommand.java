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
package com.github.ajstri.core.commands.generic;

import com.github.ajstri.core.Main;
import com.github.ajstri.core.commands.Command;
import com.github.ajstri.core.commands.Modules;
import com.github.ajstri.utilities.MessageUtilities;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 *  InfoCommand class of the The Royal Palace project
 *
 *  All methods are explained in {@link Command}
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class InfoCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("INFO (called by " + mre.getAuthor().getAsTag() + ")");

        mre.getChannel().sendMessageEmbeds(MessageUtilities.embedCoreInfo().build()).queue();
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent sce) {
        if (sce.getName().equals("info")) {
            sce.reply("Hello! This is a WIP").queue();
        }
    }

    @Override
    public CommandData getSlashCommandData() {
        return new CommandData("info", "Get information about the bot");
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("info");
    }

    @Override
    public String getModule() {
        return Modules.GENERIC;
    }

    @Override
    public String getDescription() {
        return "Returns information about the Bot.";
    }

    @Override
    public String getName() {
        return "Information Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "info`");
    }

    @Override
    public boolean getDefaultPermission() {
        return true;
    }
}
