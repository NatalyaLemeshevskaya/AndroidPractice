package com.natallialemiasheuskaya.domain.executor;

import io.reactivex.Scheduler;

//этот интерфейс нужно реализовать в презентеншн слои
public interface PostExecutionThread {
     Scheduler getScheduler();
}
