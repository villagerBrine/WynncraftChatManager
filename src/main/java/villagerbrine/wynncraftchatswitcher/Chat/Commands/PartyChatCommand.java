package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import com.mojang.authlib.BaseUserAuthentication;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import scala.collection.parallel.ParIterableLike;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.chatSendMessage;
import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.chatShowMessage;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.getMinecraftServer;

public class PartyChatCommand implements ICommand {
    @Override
    public String getName() {
        return "pc";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "pc";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("pc");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (getMinecraftServer("wynncraft")) {
            String string = "/p ";
            for (String arg : args) {
                string = string + " " + arg;
            }
            chatSendMessage.add(string);
        } else {
            String string = "/party chat ";
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
