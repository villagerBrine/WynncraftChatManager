package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.chatSendMessage;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.getMinecraftServer;

public class PartyLeaveChatCommand implements ICommand {
    @Override
    public String getName() {
        return "p leave";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "p leave";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("p leave");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        chatSendMessage.add("/party leave");
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
