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
package com.github.ajstri.utilities;

import java.io.File;

/**
 * Constants used by the EchoedCore project
 */
@SuppressWarnings("unused")
public class Constants {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final int STATUS_FRIENDLY = 0;
    public static final int STATUS_NO_EVENT = -1;
    public static final int STATUS_NO_JDA = -2;
    public static final int STATUS_NO_CONFIG = -3;
    public static final int STATUS_CONFIG_UNUSABLE = -4;
    public static final int STATUS_UNABLE_TO_CONNECT = -5;

    /**
     * Keys for Config
     */
    // bot use
    public static final String DEBUG_KEY = "debug_mode";
    public static final String TOKEN_KEY = "token";
    public static final String PREFIX_KEY = "prefix";
    public static final String GAME_STATUS_KEY = "game_status";
    public static final String SHARDS_KEY = "shards";

    // math
    public static final String MATHMODE_KEY = "mathmode";

    // role embeds colors
    public static final String REDS_KEY = "red_roles";
    public static final String YELLOWS_KEY = "yellow_roles";
    public static final String GREENS_KEY = "green_roles";
    public static final String BLUES_KEY = "blue_roles";
    public static final String PURPLES_KEY = "purple_roles";
    public static final String PINKS_KEY = "pink_roles";
    public static final String OTHERS_KEY = "other_roles";
    public static final String GAME_SERVER_ACCESS_KEY = "game_server_access_roles";
    public static final String PRONOUNS_KEY = "pronoun_roles";

    /**
     * Default config values
     */
    // bot use
    public static final String DEBUG_VALUE = "true";
    public static final String TOKEN_VALUE = "Place your bot token here";
    public static final String PREFIX_VALUE = "/";
    public static final String GAME_STATUS_VALUE = "with my friends";
    public static final String SHARDS_VALUE = "0";

    // math
    public static final String MATHMODE_VALUE = "degrees";

    // role embeds colors
    public static final String REDS_VALUE = "000000";
    public static final String YELLOWS_VALUE = "000000";
    public static final String GREENS_VALUE = "000000";
    public static final String BLUES_VALUE = "000000";
    public static final String PURPLES_VALUE = "000000";
    public static final String PINKS_VALUE = "000000";
    public static final String OTHERS_VALUE = "000000";
    public static final String GAME_SERVER_ACCESS_VALUE = "000000";
    public static final String PRONOUNS_VALUE = "000000";

    // Bot info
    public static final String VERSION = "1";
    public static final String BUILD_NUMBER = "0.0";
    public static final String JVM = System.getProperty("java.version");

    // Stages
    public static final String stagePreInit = "PRE-INITIALIZATION";
    public static final String stageInit = "INITIALIZATION";
    public static final String stagePostInit = "POST-INITIALIZATION";
    public static final String stageShutdown = "SHUTDOWN";
    public static final String stageCommand = "COMMAND CALL";

    // Exit statuses
    public static final int WRITE_TO_FILE_SUCCESS = 1;
    public static final int WRITE_TO_FILE_FAIL = -1;

    public static final int VOICE_CONNECT_SUCCESS = 1;
    public static final int VOICE_CONNECT_NOT_IN_CHANNEL = -1;
    public static final int VOICE_CONNECT_NO_PERMS = -2;
    public static final int VOICE_CONNECT_FAIL_OTHER = -3;

    // scorchedE.C.H.O's ID
    public static final String OWNER_ID = "202422697173581824";

    // Server IPs
    public static final String MODDED_IP = "play.trpserver.com\nType `/server modded`";
    public static final String VANILLA_IP = "play.trpserver.com\nType `/server vanilla`";
    public static final String CREATIVE_IP = "play.trpserver.com\nType `/server creative`";
    public static final String SNAPSHOT_IP = "play.trpserver.com\nType `/server snapshot`";

    /**
     * Pronouns
     */

    // Emotes
    public static final String EMOTE_GIRL = "\uD83D\uDC69";
    public static final String EMOTE_BOY = "\uD83D\uDC68";
    public static final String EMOTE_NEUTRAL = "\uD83E\uDDD1";

    // Roles
    public static final String ROLEID_GIRL = "766110011482439740";
    public static final String ROLEID_BOY = "766110013827055627";
    public static final String ROLEID_NEUTRAL = "766110015538462761";
    public static final String ROLEID_ASKME = "902925009570373692";

    /**
     * Game server access
     */

    // Emotes
    public static final String EMOTE_MINECRAFT = "eatdirt:833495235995893769";
    public static final String EMOTE_STARBOUND = "Chucklefish:902565521441062962";

    // Roles
    public static final String ROLEID_MINECRAFT = "785588555832360970";
    public static final String ROLEID_STARBOUND = "785588577429225492";

    /**
     * Colors
     */

    public static final String EMOTE_WINE = "wine_661227:850143883010506773";
    public static final String EMOTE_BLOOD = "blood_88122c:850143872972619806";
    public static final String EMOTE_ROSE = "rose_aa1234:850143882976559145";
    public static final String EMOTE_CHERRY = "cherry_cc1234:850143883052187648";
    public static final String EMOTE_RUBY = "ruby_ee1234:850143883010506772";

    public static final String EMOTE_SUMMERLOVE = "summerlove_f77b10:850143882959257660";
    public static final String EMOTE_HONEY = "honey_ffc30b:850143882973020190";
    public static final String EMOTE_DAZE = "daze_fff476:850143883022434314";
    public static final String EMOTE_BUZZ = "buzz_fffac2:850143876399497246";

    public static final String EMOTE_LUSH = "lush_05542d:850143882964500490";
    public static final String EMOTE_FERNY = "ferny_207452:853366751849086976";
    public static final String EMOTE_CLOVER = "clover_339966:850143879981301790";

    public static final String EMOTE_SERPENT = "serpent_5fceae:850143880347123783";
    public static final String EMOTE_STORM = "storm_545588:850143880346337320";
    public static final String EMOTE_PUDDLE = "puddle_687c9e:850143880233222144";
    public static final String EMOTE_TSUNAMI = "tsunami_7dadba:850143880087339050";
    public static final String EMOTE_COSTAL = "costal_a4dddd:850143880044609576";

    public static final String EMOTE_ECHO = "echo_7d36ba:850143880023113758";
    public static final String EMOTE_FORTUNE = "fortune_9f87d5:850143879751270482";
    public static final String EMOTE_LAVENDER = "lavender_e4c7ff:850143880129151036";

    public static final String EMOTE_DUSTYROSE = "dustyrose_a22849:850143880023375962";
    public static final String EMOTE_BLOSSOM = "blossom_f92475:850143873068957697";
    public static final String EMOTE_BLUSH = "blush_f780a7:850143873068957698";
    public static final String EMOTE_PEACH = "peach_f9aec9:850143880045527081";

    public static final String EMOTE_NORI = "nori_020202:850143882183704576";
    public static final String EMOTE_COFFEE = "coffee_a27063:850143879566458911";
    public static final String EMOTE_WARMTH = "warmth_8f7f7f:850143880429961237";
    public static final String EMOTE_COLD = "cold_848394:850143879969112094";
    public static final String EMOTE_CANVAS = "canvas_fefefe:850143880174895154";

    // Roles
    public static final String ROLEID_WINE = "850153269074067508";
    public static final String ROLEID_BLOOD = "850153115135377418";
    public static final String ROLEID_ROSE = "850151972609982466";
    public static final String ROLEID_CHERRY = "850153340125184061";
    public static final String ROLEID_RUBY = "850153423860924466";

    public static final String ROLEID_SUMMERLOVE = "850441418236887060";
    public static final String ROLEID_HONEY = "850441430563291217";
    public static final String ROLEID_DAZE = "850441436368601118";
    public static final String ROLEID_BUZZ = "850441438504157214";

    public static final String ROLEID_LUSH = "850442615413276762";
    public static final String ROLEID_FERNY = "850442617602441237";
    public static final String ROLEID_CLOVER = "850442619162984508";

    public static final String ROLEID_SERPENT = "887796746309214268";
    public static final String ROLEID_STORM = "887796829679415347";
    public static final String ROLEID_PUDDLE = "887796857294696458";
    public static final String ROLEID_TSUNAMI = "887796898780561408";
    public static final String ROLEID_COSTAL = "887796929365426276";

    public static final String ROLEID_ECHO = "887796948906700820";
    public static final String ROLEID_FORTUNE = "887796975884451860";
    public static final String ROLEID_LAVENDER = "887796995127926825";

    public static final String ROLEID_DUSTYROSE = "887797029403762688";
    public static final String ROLEID_BLOSSOM = "887797055593009152";
    public static final String ROLEID_BLUSH = "887797087473897482";
    public static final String ROLEID_PEACH = "887797116183908363";

    public static final String ROLEID_NORI = "887797161926991914";
    public static final String ROLEID_COFFEE = "887797182030290984";
    public static final String ROLEID_WARMTH = "887797206831206410";
    public static final String ROLEID_COLD = "887797224212430937";
    public static final String ROLEID_CANVAS = "887797251714469939";

    /**
     * File constants
     */
    public static final File BANNER = new File("discord_assets/Banner.png");
    public static final File EVENTS = new File("discord_assets/Events.png");
    public static final File GAME_SERVER_ACCESS = new File("discord_assets/Game Server Access.png");
    public static final File INFO = new File("discord_assets/Info.png");
    public static final File INVITE_BANNER= new File("discord_assets/Invite Banner.png");
    public static final File LOGO = new File("discord_assets/Logo.png");
    public static final File LOGO_DARK = new File("discord_assets/Logo Dark.png");
    public static final File LOGO_DARK_GIF = new File("discord_assets/Logo_Dark.gif");
    public static final File LOGO_DARK_64PX= new File("discord_assets/Logo_Dark_64x64.png");
    public static final File MINECRAFT = new File("discord_assets/Minecraft.png");
    public static final File NITRO = new File("discord_assets/Nitro.png");
    public static final File PRONOUNS = new File("discord_assets/Pronouns.png");
    public static final File ROLES = new File("discord_assets/Roles.png");
    public static final File RULES = new File("discord_assets/Rules.png");
    public static final File STARBOUND = new File("discord_assets/Starbound.png");

    /**
     * Math Constants
     */
    public static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342;
}