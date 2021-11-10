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
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  ShutdownCommand class of The Royal Palace project
 *
 *  All methods are explained in {@link Command}
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class ShutdownCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("SHUTDOWN (called by " + mre.getAuthor().getAsTag() + ")");

        // Determine if the message came from the Owner, scorchedE.C.H.O#1840
        String id = mre.getAuthor().getId();
        if (id.contains(Constants.OWNER_ID)) {
            // Shutdown
            mre.getChannel().sendMessage("Okay, AJ.").complete();
            Main.shutdown(Constants.STATUS_FRIENDLY);
        }
        else {
            // Be offended, it's not AJ
            mre.getChannel().sendMessage("How dare you?").queue();
        }
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent sce) {

    }

    @Override
    public CommandData getSlashCommandData() {
        CommandData commandData = new CommandData("shutdown", "Get information about the bot");
        commandData.setDefaultEnabled(false);
        return commandData;
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("shutdown", "sd", "rest");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Shuts down the Bot.";
    }

    @Override
    public String getName() {
        return "Shutdown Command";
    }

    @Override
    public List<String> getUsage() {
        return Collections.singletonList("`" + Main.getConfig().getPrefix() + "sd`");
    }

    @Override
    public boolean getDefaultPermission() {
        return false;
    }
}