package org.Varrell.plugin;

import com.hypixel.hytale.builtin.hytalegenerator.assets.material.MaterialAsset;
import com.hypixel.hytale.builtin.hytalegenerator.assets.materialproviders.MaterialProviderAsset;
import com.hypixel.hytale.builtin.hytalegenerator.material.Material;
import com.hypixel.hytale.builtin.hytalegenerator.materialproviders.MaterialProvider;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

import javax.annotation.Nonnull;

public class CustomMaterialProviderAsset extends MaterialProviderAsset {
    public static final BuilderCodec<CustomMaterialProviderAsset> CODEC;
    private MaterialAsset materialAsset = new MaterialAsset();

    @Nonnull
    public MaterialProvider<Material> build(@Nonnull MaterialProviderAsset.Argument argument) {
        if (super.skip()) {
            return MaterialProvider.noMaterialProvider();
        } else if (this.materialAsset == null) {
            return new CustomMaterialProvider((Object)null);
        } else {
            Material material = this.materialAsset.build(argument.materialCache);
            return new CustomMaterialProvider(material);
        }
    }

    static {
        CODEC = ((BuilderCodec.Builder)BuilderCodec.builder(CustomMaterialProviderAsset.class, CustomMaterialProviderAsset::new, MaterialProviderAsset.ABSTRACT_CODEC).append(new KeyedCodec("Material", MaterialAsset.CODEC, true), (asset, value) -> asset.materialAsset = value, (asset) -> asset.materialAsset).add()).build();
    }
}