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
package com.github.ajstri.core.listeners;

import com.github.ajstri.core.Main;
import com.github.ajstri.utilities.Constants;
import com.github.ajstri.utilities.embeds.DefaultEmbeds;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *  JoinListener Class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class JoinListener extends ListenerAdapter {

    // TODO fix this shit bro!
    @Override
    public void onGuildMemberJoin (GuildMemberJoinEvent event) {
        Member member = event.getMember();
        String welcomeChannelID = "826266790899220530";
        TextChannel channel = event.getGuild().getTextChannelById(welcomeChannelID);

        // Send welcome if channel is not null
        if (channel != null) {
            Main.getLog().debug("Welcoming user" + member.getAsMention(), Constants.stageCommand);
            channel.sendMessageEmbeds(DefaultEmbeds.welcome(member)).queue();
        }
        else {
            Main.getLog().warning("Welcome Channel is null. Did you delete something?");
        }
    }

}
