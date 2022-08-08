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

import com.simibubi.create.content.curiosities.symmetry.SymmetryWandItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.pac.common.server.core.ServerCore;

import java.util.Map;

@Mixin(value = SymmetryWandItem.class, priority = 1000001)
public class MixinCreateSymmetryWandItem {

	@ModifyArg(method = "apply", remap = false, at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/curiosities/symmetry/mirror/SymmetryMirror;process(Ljava/util/Map;)V"))
	private static Map<BlockPos, BlockState> onApply(Map<BlockPos, BlockState> mapToCapture){
		return onRemove(mapToCapture);
	}

	@Inject(method = "apply", remap = false, at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lcom/simibubi/create/content/curiosities/symmetry/mirror/SymmetryMirror;process(Ljava/util/Map;)V"))
	private static void onApply(Level world, ItemStack wand, Player player, BlockPos pos, BlockState block, CallbackInfo ci){
		onRemove(world, wand, player, pos, block, ci);
	}

	@ModifyArg(method = "remove", remap = false, at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/curiosities/symmetry/mirror/SymmetryMirror;process(Ljava/util/Map;)V"))
	private static Map<BlockPos, BlockState> onRemove(Map<BlockPos, BlockState> mapToCapture){
		ServerCore.CAPTURED_POS_STATE_MAP = mapToCapture;
		return mapToCapture;
	}

	@Inject(method = "remove", remap = false, at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lcom/simibubi/create/content/curiosities/symmetry/mirror/SymmetryMirror;process(Ljava/util/Map;)V"))
	private static void onRemove(Level world, ItemStack wand, Player player, BlockPos pos, BlockState ogBlock, CallbackInfo ci){
		ServerCore.onCreateModSymmetryProcessed(world, player);
	}

}
