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

package xaero.pac.common.server.core;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import xaero.pac.common.server.core.accessor.ICreateArmInteractionPoint;
import xaero.pac.common.server.core.accessor.ICreateContraption;

import java.util.List;
import java.util.Map;

/**
 * Simulates the presence of OPAC
 */
public class ServerCore {

	public static boolean isCreateModAllowed(Level level, BlockPos pos, ICreateContraption contraption){
		return true;
	}

	public static BlockPos CAPTURED_TARGET_POS;
	public static BlockState replaceBlockFetchOnCreateModBreak(BlockState actual, Level level, BlockPos sourceOrAnchor){
		return actual;
	}

	public static BlockState replaceBlockFetchOnCreateModBreak(BlockState actual, Level level, ICreateContraption contraption){
		return actual;
	}

	public static Map<BlockPos, BlockState> CAPTURED_POS_STATE_MAP;
	public static void onCreateModSymmetryProcessed(Level level, Player player){
	}

	public static boolean canCreateCannonPlaceBlock(BlockEntity placer, BlockPos pos){
		return true;
	}

	public static void onCreateCollideEntities(List<Entity> entities, Entity contraptionEntity, ICreateContraption contraption){
	}

	public static boolean isCreateMechanicalArmValid(BlockEntity arm, List<ICreateArmInteractionPoint> points){
		return true;
	}

	public static boolean isCreateTileEntityPacketAllowed(BlockPos pos, ServerPlayer player){
		return true;
	}

	public static boolean isCreateContraptionInteractionPacketAllowed(int contraptionId, InteractionHand interactionHand, BlockPos localPos, ServerPlayer player){
		return true;
	}

	public static boolean isCreateContraptionControlsPacketAllowed(int contraptionId, ServerPlayer player){
		return true;
	}

	public static boolean isCreateTrainRelocationPacketAllowed(int contraptionId, BlockPos pos, ServerPlayer player) {
		return true;
	}

	public static boolean isCreateTrainControlsPacketAllowed(int contraptionId, ServerPlayer player) {
		return true;
	}

	public static boolean isCreateDeployerBlockInteractionAllowed(Level level, ICreateContraption contraption, BlockPos pos){
		return true;
	}

	public static boolean isCreateTileDeployerBlockInteractionAllowed(BlockEntity tileEntity){
		return true;
	}

	public static boolean isCreateGlueSelectionAllowed(BlockPos from, BlockPos to, ServerPlayer player) {
		return true;
	}

	public static boolean isCreateGlueRemovalAllowed(int entityId, ServerPlayer player) {
		return true;
	}

	public static boolean isProjectileHitAllowed(Projectile entity, EntityHitResult hitResult){
		return true;
	}

	public static void preCreateDisassembleSuperGlue(Level level, ICreateContraption contraption){
	}

	public static void postCreateDisassembleSuperGlue(){
	}

	public static boolean canCreatePipeAffectBlock(Level level, BlockPos from, BlockPos to, boolean simulate){
		return true;
	}

	public static boolean canCreatePloughPos(Level level, ICreateContraption contraption, BlockPos pos){
		return true;
	}

	public static void preMinecartContraptionPlaced(UseOnContext context){
	}

	public static void postMinecartContraptionPlaced(){
	}

	public static boolean canCreateAddCoupling(Player player, Level world, int cartId1, int cartId2){
		return true;
	}

}
