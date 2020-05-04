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
