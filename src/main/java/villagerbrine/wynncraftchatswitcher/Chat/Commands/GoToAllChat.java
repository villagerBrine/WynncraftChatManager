package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.*;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.getMinecraftServer;

public class GoToAllChat implements ICommand {
    @Override
    public String getName() {
        return "ac";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "ac";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("ac");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (getMinecraftServer("wynncraft")) {
            String string = "";
            if (args.length > 0) {
                for (String arg : args) {
                    string = string + " " + arg;
                }
                chatSendMessage.add(string);
            } else {
                chatMessageStarter = "";
                chatShowMessage(ChatFormatting.GREEN + "You have switched to " + ChatFormatting.AQUA + "Normal Chat" + ChatFormatting.GREEN + ".");
            }
        } else {
            String string = "";
            for (String arg : args) {
                string = string + " " + arg;
            }
            chatSendMessage.add(string);
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
