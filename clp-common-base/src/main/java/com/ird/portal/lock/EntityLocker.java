package com.ird.portal.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Entity Row Lock
 * @author AugusChen
 */
public class EntityLocker <ID> {

    private static final Logger log = LoggerFactory.getLogger(EntityLocker.class);

    private ConcurrentMap<ID, ReentrantLock> locks = new ConcurrentHashMap<>();

    public void unlock(ID id) {
        ReentrantLock lock = locks.get(id);
        if (lock == null) {
            throw new RuntimeException("Entity id: " + id + " is not locked.");
        }
        lock.unlock();
        log.info("Successful unlock for {}", id);
    }

    public void lock(ID id) {
        lock(id, 0);
    }

    public void lock(ID id, long timeout) {
        ReentrantLock lock = locks.computeIfAbsent(id, (entityId) -> new ReentrantLock());
        if (timeout > 0) {
            try {
                if (lock.tryLock() || lock.tryLock(timeout, TimeUnit.MILLISECONDS)) {
                    log.info("Successful got lock for {}", id);
                    return;
                }
            } catch (Exception e) {
                throw new RuntimeException("Can't lock entity id: " + id);
            }
            throw new RuntimeException("Can't lock entity id: " + id + ". Timeout is reached.");
        }
        lock.lock();
        log.info("Successful got lock for {}", id);
    }
}
