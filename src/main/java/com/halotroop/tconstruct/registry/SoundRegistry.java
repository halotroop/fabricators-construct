/*
 * MIT License
 *
 * Copyright (c) 2020 SlimeKnights, halotroop2288
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.halotroop.tconstruct.registry;

import com.halotroop.tconstruct.TConstruct;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;

public enum SoundRegistry {
    LITTLE_SAW(),
    FRYPAN_HIT(),
    TOY_SQUEAK(),
    SLIME_SLING(),
    CHARGED(),
    DISCHARGE(),
    STONE_HIT(),
    WOOD_HIT();
    
    private final SoundEvent sound;
    private final Identifier id;
    
    public SoundEvent getSound() {
        return this.sound;
    }
    public Identifier getID() { return this.id; }
    
    SoundRegistry() {
        this.id = TConstruct.makeID(name().toLowerCase());
        this.sound = new SoundEvent(this.id);
    }
    
    public static void registerAll() {
        for (final SoundRegistry sound : values()) {
            Registry.register(Registry.SOUND_EVENT, sound.getID(), sound.getSound());
        }
    }
}
