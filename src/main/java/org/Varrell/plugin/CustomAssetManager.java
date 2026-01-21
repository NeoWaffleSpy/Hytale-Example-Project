package org.Varrell.plugin;

import com.hypixel.hytale.builtin.hytalegenerator.assets.AssetManager;
import com.hypixel.hytale.builtin.hytalegenerator.assets.materialproviders.MaterialProviderAsset;
import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.logger.HytaleLogger;

import javax.annotation.Nonnull;

public class CustomAssetManager extends AssetManager {
    public CustomAssetManager(@Nonnull EventRegistry eventRegistry, @Nonnull HytaleLogger logger) {
        super(eventRegistry, logger);
    }

    static {
        MaterialProviderAsset.CODEC.register("CustomMaterialVarrell", CustomMaterialProviderAsset.class, CustomMaterialProviderAsset.CODEC);
    }
}
