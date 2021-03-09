package com.github.bjlhx15.id.generator.service.impl.converter;

import com.github.bjlhx15.id.generator.bean.Id;

public interface IdConverter {

    public long convert(Id id);

    public Id convert(long id);

}
