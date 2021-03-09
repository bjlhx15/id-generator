package com.github.bjlhx15.id.generator.service.impl.provider.impl;

import com.github.bjlhx15.id.generator.service.impl.provider.MachineIdProvider;

public class PropertyMachineIdProvider implements MachineIdProvider {
    private long machineId;

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
