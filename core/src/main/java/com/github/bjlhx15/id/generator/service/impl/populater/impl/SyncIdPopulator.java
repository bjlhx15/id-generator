package com.github.bjlhx15.id.generator.service.impl.populater.impl;

import com.github.bjlhx15.id.generator.bean.Id;
import com.github.bjlhx15.id.generator.bean.IdMeta;
import com.github.bjlhx15.id.generator.service.impl.populater.BasePopulator;

public class SyncIdPopulator extends BasePopulator {

    public SyncIdPopulator() {
        super();
    }

    public synchronized void populateId(Id id, IdMeta idMeta) {
        super.populateId(id, idMeta);
    }

}
