package villagerbrine.wynncraftchatswitcher;

import net.minecraftforge.common.config.Configuration;

import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.config;

public class Config {
    public static boolean toggleHypixelCommands = true;
    public static boolean toggleChat = true;
    public static void loadConfig() {
        config.get(Configuration.CATEGORY_GENERAL,"toggleHypixelChatCommands", toggleHypixelCommands);
        config.get(Configuration.CATEGORY_GENERAL,"toggleCustomGuildAndPartyChat", toggleChat);
    }

}
