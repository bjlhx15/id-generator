package com.github.bjlhx15.id.generator.service.impl.populater;

import com.github.bjlhx15.id.generator.bean.Id;
import com.github.bjlhx15.id.generator.bean.IdMeta;

public interface IdPopulator {
    void populateId(Id id, IdMeta idMeta);
}
