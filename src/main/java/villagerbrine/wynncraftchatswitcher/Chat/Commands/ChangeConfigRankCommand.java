package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.chatconfig;

public class ChangeConfigRankCommand implements ICommand {
    @Override
    public String getName() {
        return "ChangeChatConfig";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "ccc";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("ccc");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        for (Property property: chatconfig.getCategory(Configuration.CATEGORY_GENERAL).getOrderedValues()) {
            String name = property.getName();
            if (args[0].equals(name)) {
                args[0] = "";
                String message = "";
                for (String arg : args) {
                    message = message + arg;
                }

                chatconfig.get(Configuration.CATEGORY_GENERAL, name, property.getString()).set(message);
            }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
