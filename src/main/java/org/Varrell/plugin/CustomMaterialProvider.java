package org.Varrell.plugin;


import com.hypixel.hytale.builtin.hytalegenerator.materialproviders.MaterialProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CustomMaterialProvider<V> extends MaterialProvider<V> {
    @Nullable
    private final V material;

    public CustomMaterialProvider(@Nullable V material) {
        this.material = material;
    }

    @Nullable
    public V getVoxelTypeAt(@Nonnull MaterialProvider.Context context) {
        return this.material;
    }
}
