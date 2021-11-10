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
package com.github.ajstri.configuration;

import com.github.ajstri.core.Main;
import com.github.ajstri.utilities.Constants;
import com.github.ajstri.utilities.FileUtilities;
import com.github.ajstri.utilities.exceptions.NoConfigurationFileException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

/**
 *  Config class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since April 2020
 */
@SuppressWarnings("unused")
public class Configuration {

    /**
     * File name constants
     */
    private final static String fileName = "config.json";
    private final static String arrayName = "bot";

    /**
     * Constructor for the Config Class
     */
    public Configuration() {
        // Check if Configuration File exists.
        File f = new File(getFileName());
        if (!f.exists() || f.isDirectory()) {
            // Create file.
            createConfigurationFile();
        }

        // Check if Configuration File is usable.
        if (!checkConfigurationUsability()) {
            Main.getLog().error(
                    "Configuration File is not usable.",
                    new NoConfigurationFileException("Unusable configuration file. Please check the file at " + getFileName())
            );
            Main.shutdown(Constants.STATUS_CONFIG_UNUSABLE);
        }
    }

    /**
     * Create the Configuration File from default keys and values.
     */
    private void createConfigurationFile() {
        // Create Bot config options.
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();

        // Put default keys and values into the object.

        // bot specific
        object.put(Constants.TOKEN_KEY, Constants.TOKEN_VALUE);
        object.put(Constants.PREFIX_KEY, Constants.PREFIX_VALUE);
        object.put(Constants.DEBUG_KEY, Constants.DEBUG_VALUE);
        object.put(Constants.GAME_STATUS_KEY, Constants.GAME_STATUS_VALUE);
        object.put(Constants.SHARDS_KEY, Constants.SHARDS_VALUE);

        // colors
        object.put(Constants.REDS_KEY, Constants.REDS_VALUE);
        object.put(Constants.YELLOWS_KEY, Constants.YELLOWS_VALUE);
        object.put(Constants.GREENS_KEY, Constants.GREENS_VALUE);
        object.put(Constants.BLUES_KEY, Constants.BLUES_VALUE);
        object.put(Constants.PURPLES_KEY, Constants.PURPLES_VALUE);
        object.put(Constants.PINKS_KEY, Constants.PINKS_VALUE);
        object.put(Constants.OTHERS_KEY, Constants.OTHERS_VALUE);

        // other roles
        object.put(Constants.GAME_SERVER_ACCESS_KEY, Constants.GAME_SERVER_ACCESS_VALUE);
        object.put(Constants.PRONOUNS_KEY, Constants.PRONOUNS_VALUE);

        array.put(object);

        JSONObject obj2 = new JSONObject();
        obj2.put(getArrayName(), object);

        // Write to the file.
        if (writeToFile(obj2) < 0) {
            Main.getLog().error("Unable to create configuration file.", new NoConfigurationFileException("Unusable configuration file."));
            Main.shutdown(Constants.STATUS_NO_CONFIG);
        }
    }

    /**
     * Checks usability of Configuration file.
     *
     * @return true if usable, false if not.
     */
    private boolean checkConfigurationUsability() {
        // Check critical values

        // If it's null, the method returns default
        // If it isn't the default, it was changed
        // This is the only code-breaking config.
        // Everything else can be the default value,
        // and it will run fine.
        return !getToken().contains(Constants.TOKEN_VALUE);
    }

    /**
     * Adds a JSON Array to the Configuration File.
     *
     * @param obj JSONObject to add to file.
     */
    @SuppressWarnings("unused")
    private int writeToFile(JSONArray obj) {
        // Write to the file.
        return FileUtilities.writeToFile(obj, getFileName());
    }

    /**
     * Adds a JSON Object to the Configuration File.
     *
     * @param obj JSONObject to add to file.
     */
    protected int writeToFile(JSONObject obj) {
        // Write to the file.
        return FileUtilities.writeToFile(obj, getFileName());
    }

    /**
     * Retrieves the JSONObject to read the JSON File.
     *
     * @return JSONObject
     */
    @SuppressWarnings("unused")
    private JSONArray getJSONFile() {
        return FileUtilities.getJSONFileArray(fileName);
    }

    /**
     * Retrieves prefix for the Bot.
     *
     * @return prefix from Configuration.
     */
    public String getPrefix() {
        String prefix = FileUtilities.getValueByKey(getFileName(), Constants.PREFIX_KEY, getArrayName());

        if (prefix.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("No need for a shutdown. Failed to grab prefix. Using default.");
            return Constants.PREFIX_VALUE;
        }

        return prefix;
    }

    /**
     * Sets a new prefix for the Bot to use.
     * @param newPrefix new prefix for the Bot to use
     */
    public void setPrefix(String newPrefix) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.PREFIX_KEY, newPrefix);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves token for the Bot.
     *
     * @return token from Configuration.
     */
    public String getToken() {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.TOKEN_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No token found. Calling for shut down.");
            Main.getLog().error("No Token in Configuration File.", new NoConfigurationFileException("Unusable configuration file. No Token provided."));
            Main.shutdown(Constants.STATUS_NO_CONFIG);
            //return Constants.TOKEN_VALUE; // no actual use
        }

        return token;
    }

    /**
     * Retrieves debug status for the Bot.
     *
     * @return debug status from Configuration.
     */
    public boolean getDebug() {
        String debug = FileUtilities.getValueByKey(getFileName(), Constants.DEBUG_KEY, getArrayName());

        if (debug.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("Failed to grab debug. Using default.");
            return Constants.DEBUG_VALUE.toLowerCase().contains("true");
        }

        return debug.toLowerCase().contains("true");
    }

    /**
     * Sets a new debug value for the Bot.
     * @param debug true if debug is on, false if not
     */
    public void setDebug(boolean debug) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.DEBUG_KEY, debug);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves shards for the Bot.
     *
     * @return number of shards from Configuration.
     */
    public int getShards() {
        String shards = FileUtilities.getValueByKey(getFileName(), Constants.SHARDS_KEY, getArrayName());

        if (shards.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().warning("Failed to grab Shards. Using default.");
            shards = Constants.SHARDS_VALUE;
        }

        try {
            return Integer.parseInt(shards);
        }
        catch (NumberFormatException nfe) {
            Main.getLog().error("Could not parse Shard Count as an integer. Returning 0, regardless of default.", nfe);
            return 0;
        }
    }

    /**
     * Returns if the math mode is degrees or radians.
     * @return true if degrees, false if radians
     */
    public boolean getDegrees() {
        String debug = FileUtilities.getValueByKey(getFileName(), Constants.MATHMODE_KEY, getArrayName());

        if (debug.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("Failed to grab degrees. Using default.");
            return Constants.MATHMODE_VALUE.toLowerCase().contains("degrees");
        }

        return debug.toLowerCase().contains("degrees");
    }

    /**
     * Sets a new math mode value for the Bot.
     * @param degrees true if degrees, false if not
     */
    public void setDegrees(boolean degrees) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(getFileName());
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(getArrayName());

        String degreesString;
        if (degrees) degreesString = "degrees";
        else degreesString = "radians";

        object.put(Constants.MATHMODE_KEY, degreesString);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(getArrayName(), array);
        writeToFile(bot);
    }

    /**
     * Retrieves Game Server Access embed message ID for the Bot.
     *
     * @return Game Server Access embed message ID from Configuration.
     */
    public String getServerAccessID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.GAME_SERVER_ACCESS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Server Access Message ID found. Reaction Roles will not work.");
            return Constants.GAME_SERVER_ACCESS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Game Server Access embed message ID for the Bot.
     * @param serverAccess ID of Game Server Access embed message
     */
    public void setServerAccessID (String serverAccess) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.GAME_SERVER_ACCESS_KEY, serverAccess);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Pronouns embed message ID for the Bot.
     *
     * @return Pronouns embed message ID from Configuration.
     */
    public String getPronounsID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.PRONOUNS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.PRONOUNS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Pronouns embed message ID for the Bot.
     * @param pronouns ID of Pronouns embed message
     */
    public void setPronounsID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.PRONOUNS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Reds embed message ID for the Bot.
     *
     * @return Reds embed message ID from Configuration.
     */
    public String getRedsID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.REDS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.REDS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Reds embed message ID for the Bot.
     * @param pronouns ID of Reds embed message
     */
    public void setRedsID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.REDS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Yellow embed message ID for the Bot.
     *
     * @return Yellow embed message ID from Configuration.
     */
    public String getYellowsID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.YELLOWS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.YELLOWS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Yellow embed message ID for the Bot.
     * @param pronouns ID of Yellow embed message
     */
    public void setYellowsID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.YELLOWS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Green embed message ID for the Bot.
     *
     * @return Green embed message ID from Configuration.
     */
    public String getGreensID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.GREENS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.GREENS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Green embed message ID for the Bot.
     * @param pronouns ID of Green embed message
     */
    public void setGreensID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.GREENS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Blue embed message ID for the Bot.
     *
     * @return Blue embed message ID from Configuration.
     */
    public String getBluesID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.BLUES_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.BLUES_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Blue embed message ID for the Bot.
     * @param pronouns ID of Blue embed message
     */
    public void setBluesID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.BLUES_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Purple embed message ID for the Bot.
     *
     * @return Purple embed message ID from Configuration.
     */
    public String getPurplesID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.PURPLES_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.PURPLES_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Purples embed message ID for the Bot.
     * @param pronouns ID of Purples embed message
     */
    public void setPurplesID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.PURPLES_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Pink embed message ID for the Bot.
     *
     * @return Pink embed message ID from Configuration.
     */
    public String getPinksID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.PINKS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.PINKS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Pink embed message ID for the Bot.
     * @param pronouns ID of Pink embed message
     */
    public void setPinksID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.PINKS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves Pink embed message ID for the Bot.
     *
     * @return Pink embed message ID from Configuration.
     */
    public String getOthersID () {
        String token = FileUtilities.getValueByKey(getFileName(), Constants.OTHERS_KEY, getArrayName());

        if (token.contains("" + Constants.STATUS_NO_CONFIG)) {
            Main.getLog().info("No Pronouns Message ID found. Reaction Roles will not work.");
            return Constants.OTHERS_VALUE;
        }
        else {
            return token;
        }
    }

    /**
     * Sets a new Other embed message ID for the Bot.
     * @param pronouns ID of Other embed message
     */
    public void setOthersID (String pronouns) {
        JSONArray jsonArray = FileUtilities.getJSONFileArray(fileName);
        JSONObject object =  jsonArray.getJSONObject(0).getJSONObject(arrayName);
        object.put(Constants.OTHERS_KEY, pronouns);

        JSONArray array = new JSONArray().put(object);

        JSONObject bot = new JSONObject().put(arrayName, array);
        writeToFile(bot);
    }

    /**
     * Retrieves file name of the Configuration
     *
     * @return file name
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     * Retrieves array name of the Configuration
     *
     * @return array name
     */
    public static String getArrayName() {
        return arrayName;
    }
}