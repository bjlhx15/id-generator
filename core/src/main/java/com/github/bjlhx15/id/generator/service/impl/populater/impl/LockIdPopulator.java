package com.github.bjlhx15.id.generator.service.impl.populater.impl;

import com.github.bjlhx15.id.generator.bean.Id;
import com.github.bjlhx15.id.generator.bean.IdMeta;
import com.github.bjlhx15.id.generator.service.impl.populater.BasePopulator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockIdPopulator extends BasePopulator {

    private Lock lock = new ReentrantLock();

    public LockIdPopulator() {
        super();
    }

    public void populateId(Id id, IdMeta idMeta) {
        lock.lock();
        try {
            super.populateId(id, idMeta);
        } finally {
            lock.unlock();
        }
    }

}
