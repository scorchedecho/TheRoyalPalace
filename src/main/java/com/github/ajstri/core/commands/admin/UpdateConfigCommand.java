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
import com.github.ajstri.utilities.Logger;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
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
public class UpdateConfigCommand extends Command {
    @Override
    protected void onCommand(MessageReceivedEvent mre, String[] args) {
        Main.getLog().info("UPDATE CONFIG (called by " + mre.getAuthor().getAsTag() + ")");

        // Check if owner. If not, quit
        String userID = mre.getAuthor().getId();
        if (!userID.equals(Constants.OWNER_ID)) {
            mre.getChannel().sendMessage("This command can only be used by the owner.").queue();
            return;
        }

        // If no argument, ask for one
        if (args.length < 2) {
            mre.getChannel().sendMessage("Please define a value to view or update.").queue();
        }
        else if (args.length < 3) {
            // Supported: Prefix and Debug and Log
            switch (args[1].toLowerCase()) {
                case "prefix":
                    mre.getChannel().sendMessage("Prefix is currently: " + Main.getConfig().getPrefix()).queue();
                    break;
                case "debug":
                    mre.getChannel().sendMessage("Debug is currently: " + Main.getConfig().getDebug()).queue();
                    break;
                case "log":
                    mre.getChannel().sendMessage("Logging is currently: " + Logger.isLogging()).queue();
                    break;
            }
        }
        else {
            switch (args[1].toLowerCase()) {
                case "prefix":
                    Main.getConfig().setPrefix(args[2]);
                    mre.getChannel().sendMessage("Prefix updated to: **" + args[2] + "**").queue();
                    break;
                case "debug":
                    if (args[2].equalsIgnoreCase("true")) {
                        Main.getConfig().setDebug(true);
                        mre.getChannel().sendMessage("Debug updated to: **" + args[2] + "**").queue();
                    }
                    else if (args[2].equalsIgnoreCase("false")) {
                        Main.getConfig().setDebug(false);
                        mre.getChannel().sendMessage("Debug updated to: **" + args[2] + "**").queue();
                    }
                    else {
                        mre.getChannel().sendMessage("Please only use **true** or **false**.").queue();
                    }
                    break;
                case "log":
                    if (args[2].equalsIgnoreCase("true")) {
                        Main.getLog().setLogging(true);
                        mre.getChannel().sendMessage("Logging updated to: **" + args[2] + "**").queue();
                    }
                    else if (args[2].equalsIgnoreCase("false")) {
                        Main.getLog().setLogging(false);
                        mre.getChannel().sendMessage("Logging updated to: **" + args[2] + "**").queue();
                    }
                    else {
                        mre.getChannel().sendMessage("Please only use **true** or **false**.").queue();
                    }
                    break;
            }
        }
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
        return Arrays.asList("uc", "updateconfig", "update");
    }

    @Override
    public String getModule() {
        return Modules.ADMIN;
    }

    @Override
    public String getDescription() {
        return "Sets a new prefix for the Bot.";
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
