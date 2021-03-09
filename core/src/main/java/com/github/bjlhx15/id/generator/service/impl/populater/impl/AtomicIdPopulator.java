package com.github.bjlhx15.id.generator.service.impl.populater.impl;

import com.github.bjlhx15.id.generator.bean.Id;
import com.github.bjlhx15.id.generator.bean.IdMeta;
import com.github.bjlhx15.id.generator.bean.IdType;
import com.github.bjlhx15.id.generator.service.impl.populater.IdPopulator;
import com.github.bjlhx15.id.generator.service.impl.populater.ResetPopulator;
import com.github.bjlhx15.id.generator.util.TimeUtils;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicIdPopulator implements IdPopulator, ResetPopulator {

    class Variant {

        private long sequence = 0;
        private long lastTimestamp = -1;

    }

    private AtomicReference<Variant> variant = new AtomicReference<Variant>(new Variant());

    public AtomicIdPopulator() {
        super();
    }

    public void populateId(Id id, IdMeta idMeta) {
        Variant varOld, varNew;
        long timestamp, sequence;

        while (true) {

            // Save the old variant
            varOld = variant.get();

            // populate the current variant
            timestamp = TimeUtils.genTime(IdType.parse(id.getType()));
            TimeUtils.validateTimestamp(varOld.lastTimestamp, timestamp);

            sequence = varOld.sequence;

            if (timestamp == varOld.lastTimestamp) {
                sequence++;
                sequence &= idMeta.getSeqBitsMask();
                if (sequence == 0) {
                    timestamp = TimeUtils.tillNextTimeUnit(varOld.lastTimestamp, IdType.parse(id.getType()));
                }
            } else {
                sequence = 0;
            }

            // Assign the current variant by the atomic tools
            varNew = new Variant();
            varNew.sequence = sequence;
            varNew.lastTimestamp = timestamp;

            if (variant.compareAndSet(varOld, varNew)) {
                id.setSeq(sequence);
                id.setTime(timestamp);

                break;
            }

        }
    }

    public void reset() {
        variant = new AtomicReference<Variant>(new Variant());
    }

}
