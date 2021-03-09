package com.github.bjlhx15.id.generator.service.impl.provider.impl;

import com.github.bjlhx15.id.generator.service.impl.provider.MachineIdsProvider;

public class PropertyMachineIdsProvider implements MachineIdsProvider {
    private long[] machineIds;
    private int currentIndex;

    public long getNextMachineId() {
        return getMachineId();
    }

    public long getMachineId() {
        return machineIds[currentIndex++%machineIds.length];
    }

    public void setMachineIds(long[] machineIds) {
        this.machineIds = machineIds;
    }
}
