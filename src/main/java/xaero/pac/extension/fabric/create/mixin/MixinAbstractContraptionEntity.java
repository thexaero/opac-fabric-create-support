/*
 * Open Parties and Claims Create Support - adds Create mod support to OPAC
 * Copyright (C) 2024, Xaero <xaero1996@gmail.com> and contributors
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

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.Contraption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import xaero.pac.common.server.core.accessor.ICreateContraption;
import xaero.pac.common.server.core.accessor.ICreateContraptionEntity;

@Mixin(AbstractContraptionEntity.class)
public class MixinAbstractContraptionEntity implements ICreateContraptionEntity {

	@Shadow
	private Contraption contraption;

	@Override
	public ICreateContraption getXaero_OPAC_contraption() {
		return (ICreateContraption) contraption;
	}

}
