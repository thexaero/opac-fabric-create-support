/*
 * Open Parties and Claims Create Support - adds Create mod support to OPAC
 * Copyright (C) 2022-2023, Xaero <xaero1996@gmail.com> and contributors
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

import com.simibubi.create.content.logistics.block.mechanicalArm.ArmInteractionPoint;
import com.simibubi.create.content.logistics.block.mechanicalArm.ArmTileEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.pac.common.server.core.ServerCore;
import xaero.pac.common.server.core.accessor.ICreateArmInteractionPoint;

import java.util.List;

@Mixin(ArmTileEntity.class)
public class MixinCreateArmTileEntity {

	@Shadow(remap = false)
	private List<ArmInteractionPoint> inputs;

	@Shadow(remap = false)
	private List<ArmInteractionPoint> outputs;

	@Inject(method = "searchForItem", remap = false, at = @At("HEAD"), cancellable = true)
	public void onSearchForItem(CallbackInfo ci){
		if(!ServerCore.isCreateMechanicalArmValid((BlockEntity) (Object)this, (List<ICreateArmInteractionPoint>)(Object)inputs))
			ci.cancel();
	}

	@Inject(method = "searchForDestination", remap = false, at = @At("HEAD"), cancellable = true)
	public void onSearchForDestination(CallbackInfo ci){
		if(!ServerCore.isCreateMechanicalArmValid((BlockEntity) (Object)this, (List<ICreateArmInteractionPoint>)(Object)outputs))
			ci.cancel();
	}

}
