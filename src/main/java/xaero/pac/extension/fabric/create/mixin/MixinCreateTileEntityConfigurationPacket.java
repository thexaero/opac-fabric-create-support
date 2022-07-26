/*
 * Open Parties and Claims Create Support - adds Create mod support to OPAC
 * Copyright (C) 2022, Xaero <xaero1996@gmail.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of version 3 of the GNU Lesser General Public License
 * (LGPL-3.0-only) as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received copies of the GNU Lesser General Public License
 * and the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package xaero.pac.extension.fabric.create.mixin;

import com.simibubi.create.foundation.networking.SimplePacketBase;
import com.simibubi.create.foundation.networking.TileEntityConfigurationPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.pac.common.server.core.ServerCore;
import xaero.pac.extension.fabric.create.accessor.ISimplePacketBaseContext;

import java.util.function.Supplier;

@Mixin(TileEntityConfigurationPacket.class)
public class MixinCreateTileEntityConfigurationPacket {

	@Shadow
	protected BlockPos pos;

	@Inject(method = "handle", remap = false, at = @At("HEAD"), cancellable = true)
	public void onApplySettings(Supplier<SimplePacketBase.Context> context, CallbackInfo ci){
		context.get()
				.enqueueWork(() -> {
					ServerPlayer player = context.get().getSender();
					if (player == null)
						return;
					Level level = player.level;
					if (level == null || !level.isLoaded(pos))
						return;
					BlockEntity te = level.getBlockEntity(pos);
					if(!ServerCore.isCreateTileEntityPacketAllowed(te, player))
						((ISimplePacketBaseContext)(Object)context.get()).cancelSender();
				});
	}

}
