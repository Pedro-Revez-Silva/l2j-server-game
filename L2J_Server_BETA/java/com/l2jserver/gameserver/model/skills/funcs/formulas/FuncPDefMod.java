/*
 * Copyright (C) 2004-2013 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.model.skills.funcs.formulas;

import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;
import com.l2jserver.gameserver.model.itemcontainer.Inventory;
import com.l2jserver.gameserver.model.items.L2Item;
import com.l2jserver.gameserver.model.skills.funcs.Func;
import com.l2jserver.gameserver.model.stats.Env;
import com.l2jserver.gameserver.model.stats.Stats;

/**
 * @author UnAfraid
 */
public class FuncPDefMod extends Func
{
	private static final FuncPDefMod _fmm_instance = new FuncPDefMod();
	
	public static Func getInstance()
	{
		return _fmm_instance;
	}
	
	private FuncPDefMod()
	{
		super(Stats.POWER_DEFENCE, 0x20, null);
	}
	
	@Override
	public void calc(Env env)
	{
		if (env.getCharacter().isPlayer())
		{
			L2PcInstance p = env.getPlayer();
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_CHEST))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_CHEST));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_LEGS) || (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_CHEST) && (p.getInventory().getPaperdollItem(Inventory.PAPERDOLL_CHEST).getItem().getBodyPart() == L2Item.SLOT_FULL_ARMOR)))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_LEGS));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_HEAD))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_HEAD));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_FEET))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_FEET));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_GLOVES))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_GLOVES));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_UNDER))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_UNDER));
			}
			if (!p.getInventory().isPaperdollSlotEmpty(Inventory.PAPERDOLL_CLOAK))
			{
				env.subValue(p.getTemplate().getBaseDefBySlot(Inventory.PAPERDOLL_CLOAK));
			}
			env.mulValue(p.getLevelMod());
		}
		else
		{
			env.mulValue(env.getCharacter().getLevelMod());
		}
	}
}