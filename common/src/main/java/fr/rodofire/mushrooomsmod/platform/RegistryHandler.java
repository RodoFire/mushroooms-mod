package fr.rodofire.mushrooomsmod.platform;

import net.minecraft.core.Registry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class RegistryHandler<T> {
    private final Map<String, Supplier<T>> entries = new LinkedHashMap<>();

    private final Registry<T> type;
    private List<Supplier<T>> regitryList;

    public RegistryHandler(Registry<T> type, List<Supplier<T>> regitryList) {
        this.type = type;
        RegistriesKeeper.registries.add(this);
        this.regitryList = regitryList;
    }

    public Supplier<T> register(String name, Supplier<T> toSupply) {
        Supplier<T> supplier = Services.PLATFORM.register(type, toSupply, name);
        regitryList.add(supplier);
        return supplier;
    }

    public Registry<T> getType() {
        return type;
    }

    public Map<String, Supplier<T>> getEntries() {
        return entries;
    }

}